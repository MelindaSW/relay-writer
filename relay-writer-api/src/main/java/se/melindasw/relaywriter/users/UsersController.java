package se.melindasw.relaywriter.users;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class UsersController {

  private final UsersService service;

  @Autowired
  public UsersController(UsersService service) {
    this.service = service;
  }

  @ApiOperation(value = "Adds one new user", response = ResponseEntity.class)
  @PostMapping("user/add")
  public ResponseEntity<UsersDTO> addUser(@RequestBody final NewUserDTO newUser) {
    //    TODO: should return error when username or email is already registered in database
    ResponseEntity<UsersDTO> response =
        new ResponseEntity(service.addUser(newUser), HttpStatus.CREATED);
    return response;
  }

  @ApiOperation(value = "Returns a list of all users", response = ResponseEntity.class)
  @GetMapping("user/get-all")
  public ResponseEntity<Set<UsersDTO>> getAllUsers() {
    //    TODO: return list of all users
    Set<UsersDTO> allUsers = new HashSet<>();
    return new ResponseEntity<>(allUsers, HttpStatus.OK);
  }

  @ApiOperation(value = "Returns roles connected to one user", response = ResponseEntity.class)
  @GetMapping("user/get-roles")
  public ResponseEntity<String> getRolesForUser() {
    //    TODO: return list of roles for one user
    return new ResponseEntity<>("TODO", HttpStatus.OK);
  }

  @ApiOperation(
      value = "Searches for user by name and returns true or false whether it already exists",
      response = ResponseEntity.class)
  @GetMapping("user/validate-username")
  public ResponseEntity<Boolean> validateUsername(@RequestBody String userName) {
    // TODO: validate username
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @ApiOperation(
      value = "Searches for email and returns true or false whether it already exists",
      response = ResponseEntity.class)
  @GetMapping("user/validate-email")
  public ResponseEntity<Boolean> validateEmail(@RequestBody String email) {
    // TODO: validate email - only one user can exist per email
    return new ResponseEntity<>(true, HttpStatus.OK);
  }

  @ApiOperation(
      value = "Deletes one user based on id in path variable",
      response = ResponseEntity.class)
  @DeleteMapping("user/delete/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    // TODO: delete user
    return new ResponseEntity<>("User with ID " + id + " deleted.", HttpStatus.OK);
  }

  @ApiOperation(value = "Change password for one user", response = ResponseEntity.class)
  @PutMapping("user/change-password")
  public ResponseEntity<String> changePassword(
      @RequestBody Long userId, String oldPassword, String newPassword) {
    // TODO: change password
    return new ResponseEntity<>(
        "Password for user with id " + userId + " changed.", HttpStatus.CREATED);
  }

  @ApiOperation(value = "Change username for one user", response = ResponseEntity.class)
  @PutMapping("user/change-username")
  public ResponseEntity<String> changeUsername(@RequestBody Long userId, String userName) {
    // TODO: change userName
    return new ResponseEntity<>(
        "Username for user with id " + userId + " changed to " + userName, HttpStatus.CREATED);
  }
}
