package se.melindasw.relaywriter.story;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.melindasw.relaywriter.exceptions.StoryNotFoundException;

@ControllerAdvice
public class StoryControllerAdvice {
  @ResponseBody
  @ExceptionHandler(StoryNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String storyNotFoundHandler(StoryNotFoundException e) {
    return e.getMessage();
  }
}
