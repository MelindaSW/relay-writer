package se.melindasw.relaywriter.auth;

import se.melindasw.relaywriter.users.UsersDTO;

import java.util.List;
import java.util.Set;

public interface RolesService {

  String addNewRole(String role);

  String deleteRole(Long roleId);

  Set<Roles> addRoleToUser(Long userID, String role);

  Set<Roles> removeRoleFromUser(Long userID, String role);

  List<UsersDTO> getRolesForUser(Long userID);
}
