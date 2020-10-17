package se.melindasw.relaywriter.users;

import java.util.List;

public interface UsersService {
  UsersDTO addUser(NewUserDTO user);

  String deleteUser(Long userID);

  List<UsersDTO> getAllUsers();

  UsersDTO getUserByID(Long userID);

  UsersDTO updateUser(UsersDTO user);

  String changePassword(String oldPassword, String newPassword);

  boolean checkIfUserNameExists(String userName);

  boolean checkIfEmailExists(String email);
}
