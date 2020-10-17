package se.melindasw.relaywriter.exceptions;

public class RoleNotFoundException extends RuntimeException {
  public RoleNotFoundException(String customMessage) {
    super(customMessage);
  }

  public RoleNotFoundException(Long id) {
    super("Role with id " + id + " was not found.");
  }

  public RoleNotFoundException(String role, Long id) {
    super("The role " + role + " with id " + id + " was not found.");
  }
}
