package se.melindasw.relaywriter.user;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
  private final UserRepo userRepo;

  public UserServiceImplementation(UserRepo repo) {
    this.userRepo = repo;
  }
}
