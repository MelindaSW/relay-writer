package se.melindasw.relaywriter.exceptions;

public class IncorrectRequestException extends RuntimeException {
  public IncorrectRequestException() {
    super("The request did not contain the correct values. Please try again.");
  }
}
