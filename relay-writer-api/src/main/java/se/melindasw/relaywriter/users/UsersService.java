package se.melindasw.relaywriter.users;

import se.melindasw.relaywriter.auth.RolesDTO;

import java.util.List;

public interface UsersService {
  UsersDTO addUser(NewUserDTO user);

  String deleteUser(Long userID);

  List<UsersDTO> getAllUsers();

  UsersDTO getUserByID(Long userID);

  UsersDTO updateUser(UsersDTO user);

  String changePassword(Long userId, String oldPassword, String newPassword);

  boolean checkUserNameExists(String userName);

  boolean checkEmailExists(String email);

  String assignRoleToUser(Long userId, Long roleId);

  String removeRoleFromUser(Long userId, Long roleId);

  List<RolesDTO> getRolesForUser(Long userId);
}
