package se.melindasw.relaywriter.role;

import java.util.List;

public interface RoleService {

  List<RoleDTO> getAllRoles();

  String addNewRole(NewRoleDTO role);

  String deleteRole(Long roleId);

  RoleDTO updateRole(RoleDTO rolesDTO);
}
