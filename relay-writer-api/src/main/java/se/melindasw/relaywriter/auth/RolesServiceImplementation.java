package se.melindasw.relaywriter.auth;

import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.users.UsersDTO;

import java.util.List;
import java.util.Set;

@Service
public class RolesServiceImplementation implements RolesService {

  @Override
  public String addNewRole(String role) {
    return null;
  }

  @Override
  public Set<Roles> addRoleToUser(Long userID, String role) {
    return null;
  }

  @Override
  public Set<Roles> removeRoleFromUser(Long userID, String role) {
    return null;
  }

  @Override
  public List<UsersDTO> getRolesForUser(Long userID) {
    return null;
  }

  @Override
  public String deleteRole(Long roleId) {
    return null;
  }
}
