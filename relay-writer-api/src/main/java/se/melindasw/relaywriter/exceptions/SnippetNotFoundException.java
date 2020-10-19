package se.melindasw.relaywriter.exceptions;

public class SnippetNotFoundException extends RuntimeException {
  public SnippetNotFoundException(String customMessage) {
    super(customMessage);
  }

  public SnippetNotFoundException(Long id) {
    super("Snippet with id " + id + " was not found.");
  }
}
