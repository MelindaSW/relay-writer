package se.melindasw.relaywriter.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/hello")
  public String helloWriter() {
    return "Hello writer";
  }
}
