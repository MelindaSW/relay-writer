package se.melindasw.relaywriter.auth;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolesController {

  @ApiOperation(value = "Get a list of all roles", response = ResponseEntity.class)
  @GetMapping("role/get-all")
  public ResponseEntity<List<Roles>> getRoles() {
    return null;
  }

  @ApiOperation(value = "Add a role to a user", response = ResponseEntity.class)
  @PutMapping("role/add")
  public ResponseEntity<String> addRole(@RequestBody String role) {
    return new ResponseEntity<>(role + " Role added", HttpStatus.OK);
  }

  @ApiOperation(value = "Remove role from database", response = ResponseEntity.class)
  @DeleteMapping("role/delete-role")
  public ResponseEntity<String> deleteRole(@RequestBody Long roleId) {
    return new ResponseEntity<>("Role removed from user", HttpStatus.OK);
  }

  @ApiOperation(value = "Add role to one user", response = ResponseEntity.class)
  @PutMapping("role/add-role-to-user")
  public ResponseEntity<String> addRoleToUser(@RequestBody Long userId, Long roleId) {
    return new ResponseEntity<>("Role added to user", HttpStatus.OK);
  }

  @ApiOperation(value = "Get a list of all roles for one user", response = ResponseEntity.class)
  @GetMapping("role/get-roles-for-user")
  public ResponseEntity<List<Roles>> getRolesForUser(@RequestBody Long id) {
    return null;
  }
}
