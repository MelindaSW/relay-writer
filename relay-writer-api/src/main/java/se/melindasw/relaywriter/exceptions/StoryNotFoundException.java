package se.melindasw.relaywriter.exceptions;

public class StoryNotFoundException extends RuntimeException {
  public StoryNotFoundException(String customMessage) {
    super(customMessage);
  }

  public StoryNotFoundException(Long id) {
    super("Story with id " + id + " was not found.");
  }
}
