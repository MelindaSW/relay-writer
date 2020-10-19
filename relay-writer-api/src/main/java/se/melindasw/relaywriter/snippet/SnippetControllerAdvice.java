package se.melindasw.relaywriter.snippet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import se.melindasw.relaywriter.exceptions.SnippetNotFoundException;

@ControllerAdvice
public class SnippetControllerAdvice {
  @ResponseBody
  @ExceptionHandler(SnippetNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String snippetNotFoundHandler(SnippetNotFoundException e) {
    return e.getMessage();
  }
}
