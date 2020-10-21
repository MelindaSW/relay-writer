package se.melindasw.relaywriter.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.exceptions.RoleNotFoundException;
import se.melindasw.relaywriter.helpers.DTOConverter;
import se.melindasw.relaywriter.user.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImplementation implements RoleService {

  DTOConverter converter = new DTOConverter();

  private final RoleRepo roleRepo;
  private final UserRepo userRepo;

  @Autowired
  public RoleServiceImplementation(RoleRepo roleRepo, UserRepo userRepo) {
    this.roleRepo = roleRepo;
    this.userRepo = userRepo;
  }

  @Override
  public List<RoleDTO> getAllRoles() {
    List<Role> roles = roleRepo.findAll();
    List<RoleDTO> roleDTOS = new ArrayList<>();
    for (Role role : roles) {
      roleDTOS.add(converter.convertToRoleDTO(role));
    }
    return roleDTOS;
  }

  @Override
  public String addNewRole(NewRoleDTO role) {
    Role roleToSave = new Role(role.getRole().toUpperCase(), role.getDescription());
    roleRepo.save(roleToSave);
    return "Role: " + role.getRole() + " was added.";
  }

  @Override
  public String deleteRole(Long roleId) {
    if (roleRepo.findById(roleId).isEmpty()) {
      throw new RoleNotFoundException(roleId);
    }
    roleRepo.deleteById(roleId);
    return "Role with id " + roleId + " was deleted.";
  }

  @Override
  public RoleDTO updateRole(RoleDTO roleDTO) {
    Role role = roleRepo.getOne(roleDTO.getId());
    role.setRole(roleDTO.getRole().toUpperCase());
    role.setDescription(roleDTO.getDescription());
    roleRepo.save(role);
    return converter.convertToRoleDTO(role);
  }
}
