package se.melindasw.relaywriter.users;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.melindasw.relaywriter.exceptions.IncorrectRequestException;

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
    if (newUser.getUserName() == null
        || newUser.getEmail() == null
        || newUser.getPassword() == null) {
      throw new IncorrectRequestException();
    }
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
  @GetMapping("/get-one/{userId}")
  public ResponseEntity<UsersDTO> getOneUser(@PathVariable Long userId) {
    UsersDTO user = service.getUserByID(userId);
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
  public ResponseEntity<String> changePassword(@RequestBody NewPasswordDTO newPwd) {
    if (newPwd.getUserId() == null
        || newPwd.getOldPassword() == null
        || newPwd.getNewPassword() == null) {
      throw new IncorrectRequestException();
    }
    String response =
        service.changePassword(
            newPwd.getUserId(), newPwd.getOldPassword(), newPwd.getNewPassword());
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Check if the username exists.", response = ResponseEntity.class)
  @GetMapping("/check-username/{username}")
  public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
    if (username == null) {
      throw new IncorrectRequestException();
    }
    boolean nameExists = service.checkUserNameExists(username);
    return new ResponseEntity<>(nameExists, HttpStatus.OK);
  }

  @ApiOperation(value = "Check if the email exists.", response = ResponseEntity.class)
  @GetMapping("/check-email/{email}")
  public ResponseEntity<Boolean> checkEmail(@PathVariable String email) {
    if (email == null) {
      throw new IncorrectRequestException();
    }
    boolean emailExists = service.checkEmailExists(email);
    return new ResponseEntity<>(emailExists, HttpStatus.OK);
  }
}
