package se.melindasw.relaywriter.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  List<User> findByUserName(String name);

  List<User> findByEmail(String email);
}
