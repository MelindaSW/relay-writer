package se.melindasw.relaywriter.exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String customMessage) {
    super(customMessage);
  }

  public UserNotFoundException(Long id) {
    super("User with id " + id + " was not found.");
  }
}
