package se.melindasw.relaywriter.users;

import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.auth.Roles;

import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImplementation implements UsersService {
  private final UsersRepo userRepo;

  public UsersServiceImplementation(UsersRepo repo) {
    this.userRepo = repo;
  }

  @Override
  public UsersDTO addUser(Users user) {
    return null;
  }

  @Override
  public String deleteUser(Long userID) {
    return null;
  }

  @Override
  public List<Users> getAllUsers() {
    return null;
  }

  @Override
  public UsersDTO getUserByID(Long userID) {
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
  public boolean checkIfUserNameExists(String userName) {
    return false;
  }

  @Override
  public boolean checkIfEmailExists(String email) {
    return false;
  }
}
