package se.melindasw.relaywriter.users;

import org.springframework.stereotype.Service;

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
    usersRepo.deleteById(userID);
    return "User with id " + userID + " deleted.";
  }

  @Override
  public UsersDTO getUserByID(Long userID) {
    return convertToUserDTO(usersRepo.getOne(userID));
  }

  @Override
  public UsersDTO updateUser(UsersDTO user) {
    Users userToUpdate = null;
    if (usersRepo.findById(user.getId()).isPresent()) {
      userToUpdate = usersRepo.findById(user.getId()).get();
      userToUpdate.setEmail(user.getEmail());
      userToUpdate.setUserName(user.getUserName());
      return convertToUserDTO(userToUpdate);
    }
    return user;
  }

  @Override
  public String changePassword(String oldPassword, String newPassword) {
    return null;
  }

  @Override
  public boolean checkIfUserNameExists(String userName) {
    return false;
  }

  @Override
  public boolean checkIfEmailExists(String email) {
    return false;
  }

  private UsersDTO convertToUserDTO(Users user) {
    return new UsersDTO(user.getId(), user.getUserName(), user.getEmail(), user.getCreatedAt());
  }
}
