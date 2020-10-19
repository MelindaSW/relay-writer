package se.melindasw.relaywriter.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesRepo extends JpaRepository<Roles, Long> {
  List<Roles> findByRole(String role);
}
