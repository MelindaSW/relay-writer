package se.melindasw.relaywriter.auth;

import java.util.List;

public interface RolesService {

  List<RolesDTO> getAllRoles();

  String addNewRole(NewRolesDTO role);

  String deleteRole(Long roleId);

  RolesDTO updateRole(RolesDTO rolesDTO);
}
