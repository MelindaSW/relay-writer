package se.melindasw.relaywriter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.exceptions.RoleNotFoundException;
import se.melindasw.relaywriter.exceptions.UserNotFoundException;
import se.melindasw.relaywriter.helpers.DTOConverter;
import se.melindasw.relaywriter.role.Role;
import se.melindasw.relaywriter.role.RoleDTO;
import se.melindasw.relaywriter.role.RoleRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {

  DTOConverter converter = new DTOConverter();

  private final UserRepo usersRepo;
  private final RoleRepo roleRepo;

  @Autowired
  public UserServiceImplementation(UserRepo usersRepo, RoleRepo roleRepo) {
    this.usersRepo = usersRepo;
    this.roleRepo = roleRepo;
  }

  @Override
  public UserDTO addUser(NewUserDTO newUser) {
    User user = new User();
    user.setUserName(newUser.getUserName());
    user.setPassword(newUser.getPassword());
    user.setEmail(newUser.getEmail());
    user.setCreatedAt(newUser.getCreatedAt());
    usersRepo.save(user);
    return converter.convertToUserDTO(user);
  }

  @Override
  public List<UserDTO> getAllUsers() {
    List<User> allUsers = usersRepo.findAll();
    List<UserDTO> allUsersDTO = new ArrayList<>();
    for (User user : allUsers) {
      allUsersDTO.add(converter.convertToUserDTO(user));
    }
    return allUsersDTO;
  }

  @Override
  public String deleteUser(Long userID) {
    if (usersRepo.findById(userID).isPresent()) {
      usersRepo.deleteById(userID);
      return "User with id " + userID + " deleted.";
    } else {
      throw new UserNotFoundException(userID);
    }
  }

  @Override
  public UserDTO getUserByID(Long userID) {
    User user;
    if (usersRepo.findById(userID).isPresent()) {
      user = usersRepo.getOne(userID);
      return converter.convertToUserDTO(user);
    } else {
      throw new UserNotFoundException(userID);
    }
  }

  @Override
  public UserDTO updateUser(UserDTO user) {
    if (usersRepo.findById(user.getId()).isPresent()) {
      User userToUpdate = usersRepo.findById(user.getId()).get();
      userToUpdate.setEmail(user.getEmail());
      userToUpdate.setUserName(user.getUserName());
      usersRepo.save(userToUpdate);
      return converter.convertToUserDTO(userToUpdate);
    } else {
      throw new UserNotFoundException(user.getId());
    }
  }

  @Override
  public String changePassword(Long userId, String oldPassword, String newPassword) {
    if (usersRepo.findById(userId).isPresent()) {
      if (usersRepo.findById(userId).get().getPassword().equals(oldPassword)) {
        User userToUpdate = usersRepo.findById(userId).get();
        userToUpdate.setPassword(newPassword);
        usersRepo.save(userToUpdate);
        return "Password updated";
      }
      return "The provided password is not matching the old";
    } else {
      throw new UserNotFoundException(userId);
    }
  }

  @Override
  public boolean checkUserNameExists(String userName) {
    List<User> u = usersRepo.findByUserName(userName);
    return !u.isEmpty();
  }

  @Override
  public boolean checkEmailExists(String email) {
    List<User> u = usersRepo.findByEmail(email);
    return !u.isEmpty();
  }

  @Override
  public String assignRoleToUser(Long userId, Long roleId) {
    if (roleRepo.findById(roleId).isEmpty()) {
      throw new RoleNotFoundException(roleId);
    }
    if (usersRepo.findById(userId).isEmpty()) {
      throw new RoleNotFoundException("The user with id " + userId + " was not found.");
    }
    Role role = roleRepo.getOne(roleId);
    User user = usersRepo.getOne(userId);
    user.addRole(role);
    usersRepo.save(user);
    return "Role with id " + roleId + " was assigned to user with id " + userId;
  }

  @Override
  public String removeRoleFromUser(Long userId, Long roleId) {
    if (roleRepo.findById(roleId).isEmpty()) {
      throw new RoleNotFoundException(roleId);
    }
    if (usersRepo.findById(userId).isEmpty()) {
      throw new RoleNotFoundException(
          "The roles could not be removed. User with id " + userId + " does not exist.");
    }
    User user = usersRepo.findById(userId).get();
    Role roleToRemove = roleRepo.getOne(roleId);
    if (user.getRoles().contains(roleToRemove)) {
      user.removeRole(roleToRemove);
      usersRepo.save(user);
      return "Role with id " + roleId + " was removed from user with id " + userId;
    } else {
      throw new RoleNotFoundException(
          "The user with id " + userId + " was not assigned to the role with id " + roleId);
    }
  }

  @Override
  public List<RoleDTO> getRolesForUser(Long userId) {
    List<RoleDTO> rolesForUser = new ArrayList<>();
    if (usersRepo.findById(userId).isEmpty()) {
      throw new RoleNotFoundException(
          "Roles for the user could not be found. User " + userId + " does not exist.");
    }
    Set<Role> roles = usersRepo.getOne(userId).getRoles();
    for (Role role : roles) {
      rolesForUser.add(converter.convertToRoleDTO(role));
    }
    return rolesForUser;
  }
}
