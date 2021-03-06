package se.melindasw.relaywriter.role;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.melindasw.relaywriter.exceptions.RoleNotFoundException;

@ControllerAdvice
public class RoleControllerAdvice {
  @ResponseBody
  @ExceptionHandler(RoleNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String userNotFoundHandler(RoleNotFoundException e) {
    return e.getMessage();
  }
}
