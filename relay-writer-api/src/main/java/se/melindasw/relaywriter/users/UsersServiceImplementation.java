package se.melindasw.relaywriter.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.auth.Roles;
import se.melindasw.relaywriter.auth.RolesDTO;
import se.melindasw.relaywriter.auth.RolesRepo;
import se.melindasw.relaywriter.exceptions.RoleNotFoundException;
import se.melindasw.relaywriter.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImplementation implements UsersService {
  private final UsersRepo usersRepo;
  private final RolesRepo rolesRepo;

  @Autowired
  public UsersServiceImplementation(UsersRepo usersRepo, RolesRepo rolesRepo) {
    this.usersRepo = usersRepo;
    this.rolesRepo = rolesRepo;
  }

  @Override
  public UsersDTO addUser(NewUserDTO newUser) {
    Users user = new Users();
    user.setUserName(newUser.getUserName());
    user.setPassword(newUser.getPassword());
    user.setEmail(newUser.getEmail());
    user.setCreatedAt(newUser.getCreatedAt());
    usersRepo.save(user);
    return convertToUserDTO(user);
  }

  @Override
  public List<UsersDTO> getAllUsers() {
    List<Users> allUsers = usersRepo.findAll();
    List<UsersDTO> allUsersDTO = new ArrayList<>();
    for (Users user : allUsers) {
      allUsersDTO.add(convertToUserDTO(user));
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
  public UsersDTO getUserByID(Long userID) {
    Users user;
    if (usersRepo.findById(userID).isPresent()) {
      user = usersRepo.getOne(userID);
      return convertToUserDTO(user);
    } else {
      throw new UserNotFoundException(userID);
    }
  }

  @Override
  public UsersDTO updateUser(UsersDTO user) {
    if (usersRepo.findById(user.getId()).isPresent()) {
      Users userToUpdate = usersRepo.findById(user.getId()).get();
      userToUpdate.setEmail(user.getEmail());
      userToUpdate.setUserName(user.getUserName());
      usersRepo.save(userToUpdate);
      return convertToUserDTO(userToUpdate);
    } else {
      throw new UserNotFoundException(user.getId());
    }
  }

  @Override
  public String changePassword(Long userId, String oldPassword, String newPassword) {
    if (usersRepo.findById(userId).isPresent()) {
      if (usersRepo.findById(userId).get().getPassword().equals(oldPassword)) {
        Users userToUpdate = usersRepo.findById(userId).get();
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
    List<Users> u = usersRepo.findByUserName(userName);
    return !u.isEmpty();
  }

  @Override
  public boolean checkEmailExists(String email) {
    List<Users> u = usersRepo.findByEmail(email);
    return !u.isEmpty();
  }

  @Override
  public String assignRoleToUser(Long userId, Long roleId) {
    if (rolesRepo.findById(roleId).isEmpty()) {
      throw new RoleNotFoundException(roleId);
    }
    if (usersRepo.findById(userId).isEmpty()) {
      throw new RoleNotFoundException("The user with id " + userId + " was not found.");
    }
    Roles role = rolesRepo.getOne(roleId);
    Users user = usersRepo.getOne(userId);
    user.addRole(role);
    usersRepo.save(user);
    return "Role with id " + roleId + " was assigned to user with id " + userId;
  }

  @Override
  public String removeRoleFromUser(Long userId, Long roleId) {
    if (rolesRepo.findById(roleId).isEmpty()) {
      throw new RoleNotFoundException(roleId);
    }
    if (usersRepo.findById(userId).isEmpty()) {
      throw new RoleNotFoundException(
          "The roles could not be removed. User with id " + userId + " does not exist.");
    }
    Users user = usersRepo.findById(userId).get();
    Roles roleToRemove = rolesRepo.getOne(roleId);
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
  public List<RolesDTO> getRolesForUser(Long userId) {
    List<RolesDTO> rolesForUser = new ArrayList<>();
    if (usersRepo.findById(userId).isEmpty()) {
      throw new RoleNotFoundException(
          "Roles for the user could not be found. User " + userId + " does not exist.");
    }
    Set<Roles> roles = usersRepo.getOne(userId).getRoles();
    for (Roles role : roles) {
      rolesForUser.add(convertToRolesDTO(role));
    }
    return rolesForUser;
  }

  private UsersDTO convertToUserDTO(Users user) {
    UsersDTO dto = new UsersDTO();
    dto.setId(user.getId());
    dto.setUserName(user.getUserName());
    dto.setEmail(user.getEmail());
    dto.setCreatedAt(user.getCreatedAt());
    return dto;
  }

  private RolesDTO convertToRolesDTO(Roles role) {
    RolesDTO dto = new RolesDTO();
    dto.setId(role.getId());
    dto.setRole(role.getRole());
    dto.setDescription(role.getDescription());
    return dto;
  }
}
