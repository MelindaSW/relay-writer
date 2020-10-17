package se.melindasw.relaywriter.users;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

  private final UsersService service;

  @Autowired
  public UsersController(UsersService service) {
    this.service = service;
  }

  @ApiOperation(value = "Adds one new user", response = ResponseEntity.class)
  @PostMapping("/add")
  public ResponseEntity<UsersDTO> addUser(@RequestBody final NewUserDTO newUser) {
    ResponseEntity<UsersDTO> response =
        new ResponseEntity(service.addUser(newUser), HttpStatus.CREATED);
    return response;
  }

  @ApiOperation(value = "Returns a list of all users", response = ResponseEntity.class)
  @GetMapping("/get-all")
  public ResponseEntity<List<UsersDTO>> getAllUsers() {
    List<UsersDTO> allUsers = service.getAllUsers();
    return new ResponseEntity<>(allUsers, HttpStatus.OK);
  }

  @ApiOperation(value = "Returns one user", response = ResponseEntity.class)
  @GetMapping("/get-one/{id}")
  public ResponseEntity<UsersDTO> getOneUser(@PathVariable Long id) {
    UsersDTO user = service.getUserByID(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @ApiOperation(value = "Delete one user", response = ResponseEntity.class)
  @DeleteMapping("/delete/{userId}")
  public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
    String result = service.deleteUser(userId);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ApiOperation(value = "Update one user", response = ResponseEntity.class)
  @PutMapping("/update")
  public ResponseEntity<UsersDTO> updateUser(@RequestBody UsersDTO user) {
    UsersDTO updatedUser = service.updateUser(user);
    return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Change password for one user", response = ResponseEntity.class)
  @PutMapping("/change-password")
  public ResponseEntity<String> changePassword(
      @RequestBody Long userId, String oldPassword, String newPassword) {
    // TODO: change password
    String response = service.changePassword(oldPassword, newPassword);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Check if the username already exists.", response = ResponseEntity.class)
  @GetMapping("/check-username")
  public ResponseEntity<Boolean> checkUsername(@RequestBody String userName) {
    // TODO: validate username
    boolean nameExists = service.checkIfUserNameExists(userName);
    return new ResponseEntity<>(nameExists, HttpStatus.OK);
  }

  @ApiOperation(value = "Check if the email already exists.", response = ResponseEntity.class)
  @GetMapping("/check-email")
  public ResponseEntity<Boolean> checkEmail(@RequestBody String email) {
    // TODO: validate email - only one user can exist per email
    boolean emailExists = service.checkIfEmailExists(email);
    return new ResponseEntity<>(emailExists, HttpStatus.OK);
  }
}
