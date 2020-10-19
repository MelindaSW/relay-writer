package se.melindasw.relaywriter.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.exceptions.RoleNotFoundException;
import se.melindasw.relaywriter.users.UsersRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImplementation implements RolesService {

  private final RolesRepo rolesRepo;
  private final UsersRepo usersRepo;

  @Autowired
  public RolesServiceImplementation(RolesRepo rolesRepo, UsersRepo usersRepo) {
    this.rolesRepo = rolesRepo;
    this.usersRepo = usersRepo;
  }

  @Override
  public List<RolesDTO> getAllRoles() {
    List<Roles> roles = rolesRepo.findAll();
    List<RolesDTO> rolesDTOS = new ArrayList<>();
    for (Roles role : roles) {
      rolesDTOS.add(convertToRolesDTO(role));
    }
    return rolesDTOS;
  }

  @Override
  public String addNewRole(NewRolesDTO role) {
    Roles roleToSave = new Roles(role.getRole().toUpperCase(), role.getDescription());
    rolesRepo.save(roleToSave);
    return "Role: " + role.getRole() + " was added.";
  }

  @Override
  public String deleteRole(Long roleId) {
    if (rolesRepo.findById(roleId).isEmpty()) {
      throw new RoleNotFoundException(roleId);
    }
    rolesRepo.deleteById(roleId);
    return "Role with id " + roleId + " was deleted.";
  }

  @Override
  public RolesDTO updateRole(RolesDTO rolesDTO) {
    Roles role = rolesRepo.getOne(rolesDTO.getId());
    role.setRole(rolesDTO.getRole().toUpperCase());
    role.setDescription(rolesDTO.getDescription());
    rolesRepo.save(role);
    return convertToRolesDTO(role);
  }

  private RolesDTO convertToRolesDTO(Roles role) {
    RolesDTO dto = new RolesDTO();
    dto.setId(role.getId());
    dto.setRole(role.getRole());
    dto.setDescription(role.getDescription());
    return dto;
  }
}
