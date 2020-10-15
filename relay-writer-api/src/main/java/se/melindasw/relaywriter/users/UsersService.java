package se.melindasw.relaywriter.users;

import se.melindasw.relaywriter.auth.Roles;

import java.util.List;
import java.util.Set;

public interface UsersService {
  UsersDTO addUser(Users user);

  String deleteUser(Long userID);

  List<Users> getAllUsers();

  UsersDTO getUserByID(Long userID);

  Set<Roles> addRoleToUser(Long userID, String role);

  Set<Roles> removeRoleFromUser(Long userID, String role);

  boolean checkIfUserNameExists(String userName);

  boolean checkIfEmailExists(String email);
}
