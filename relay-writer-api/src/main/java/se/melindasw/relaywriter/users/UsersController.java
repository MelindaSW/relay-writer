package se.melindasw.relaywriter.users;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiResponses(
    value = {
      @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(
          code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach were not found")
    })
@RestController("/user")
public class UsersController {

  @GetMapping("/helloworld")
  public String helloWorld() {
    return "Hello world";
  }
  //  @PostMapping
  //  public ResponseEntity<String> addUser(@RequestBody final UserDTO user) {
  //    return new ResponseEntity<String>("User created", HttpStatus.CREATED);
  //  }
  //
  //  @GetMapping("/getallusers")
  //  public ResponseEntity<String> getAllUsers() {
  //    return new ResponseEntity<String>("All users", HttpStatus.OK);
  //  }
  //
  //  @DeleteMapping
  //  public ResponseEntity<String> deleteUser(@PathVariable Long id) {
  //    return new ResponseEntity<String>("User deleted", HttpStatus.OK);
  //  }
}
