package se.melindasw.relaywriter.users;

import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImplementation implements UsersService {
  private final UsersRepo usersRepo;

  public UsersServiceImplementation(UsersRepo repo) {
    this.usersRepo = repo;
  }

  @Override
  public UsersDTO addUser(NewUserDTO newUser) {
    Users user =
        new Users(
            newUser.getUserName(),
            newUser.getEmail(),
            newUser.getPassword(),
            newUser.getCreatedAt());
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

  private UsersDTO convertToUserDTO(Users user) {
    return new UsersDTO(user.getId(), user.getUserName(), user.getEmail(), user.getCreatedAt());
  }
}
