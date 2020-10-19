package se.melindasw.relaywriter.user;

import se.melindasw.relaywriter.role.RoleDTO;

import java.util.List;

public interface UserService {
  UserDTO addUser(NewUserDTO user);

  String deleteUser(Long userID);

  List<UserDTO> getAllUsers();

  UserDTO getUserByID(Long userID);

  UserDTO updateUser(UserDTO user);

  String changePassword(Long userId, String oldPassword, String newPassword);

  boolean checkUserNameExists(String userName);

  boolean checkEmailExists(String email);

  String assignRoleToUser(Long userId, Long roleId);

  String removeRoleFromUser(Long userId, Long roleId);

  List<RoleDTO> getRolesForUser(Long userId);
}
