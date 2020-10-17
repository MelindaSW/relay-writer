package se.melindasw.relaywriter.auth;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

  private RolesService service;

  @Autowired
  public RolesController(RolesService service) {
    this.service = service;
  }

  @ApiOperation(value = "Get a list of all roles", response = ResponseEntity.class)
  @GetMapping("/all")
  public ResponseEntity<List<Roles>> getRoles() {
    // TODO
    return null;
  }

  @ApiOperation(value = "Add new role", response = ResponseEntity.class)
  @PutMapping("/add")
  public ResponseEntity<String> addRole(@RequestBody Long roleId, Long userId) {
    // TODO
    return new ResponseEntity<>("Role added", HttpStatus.OK);
  }

  @ApiOperation(value = "Delete one role", response = ResponseEntity.class)
  @DeleteMapping("/delete/{roleId}")
  public ResponseEntity<String> deleteRole(@PathVariable Long roleId) {
    // TODO
    return new ResponseEntity<>("Role removed from user", HttpStatus.OK);
  }

  @ApiOperation(value = "Add role to one user", response = ResponseEntity.class)
  @PutMapping("/add-to-user")
  public ResponseEntity<String> addRoleToUser(@RequestBody Long userId, Long roleId) {
    // TODO
    return new ResponseEntity<>("Role added to user", HttpStatus.OK);
  }

  @ApiOperation(value = "Get a list of all roles for one user", response = ResponseEntity.class)
  @GetMapping("/user-roles/{userId}")
  public ResponseEntity<List<Roles>> getRolesForUser(@PathVariable Long userId) {
    // TODO
    return null;
  }
}
