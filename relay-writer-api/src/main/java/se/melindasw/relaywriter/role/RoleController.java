package se.melindasw.relaywriter.role;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

  private RoleService service;

  @Autowired
  public RoleController(RoleService service) {
    this.service = service;
  }

  @ApiOperation(value = "Get a list of all roles", response = ResponseEntity.class)
  @GetMapping("/all")
  public ResponseEntity<List<RoleDTO>> getRoles() {
    return new ResponseEntity<>(service.getAllRoles(), HttpStatus.OK);
  }

  @ApiOperation(value = "Add new role", response = ResponseEntity.class)
  @PutMapping("/add")
  public ResponseEntity<String> addRole(@RequestBody NewRoleDTO newRole) {
    String response = service.addNewRole(newRole);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Delete one role", response = ResponseEntity.class)
  @DeleteMapping("/delete/{roleId}")
  public ResponseEntity<String> deleteRole(@PathVariable Long roleId) {
    String response = service.deleteRole(roleId);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @ApiOperation(value = "Update one role", response = ResponseEntity.class)
  @PutMapping("/update")
  public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO roleDTO) {
    RoleDTO updateRole = service.updateRole(roleDTO);
    return new ResponseEntity<>(updateRole, HttpStatus.CREATED);
  }
}
