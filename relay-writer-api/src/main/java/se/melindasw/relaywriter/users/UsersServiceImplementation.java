package se.melindasw.relaywriter.users;

import org.springframework.stereotype.Service;

@Service
public class UsersServiceImplementation implements UsersService {
  private final UsersRepo userRepo;

  public UsersServiceImplementation(UsersRepo repo) {
    this.userRepo = repo;
  }
}
