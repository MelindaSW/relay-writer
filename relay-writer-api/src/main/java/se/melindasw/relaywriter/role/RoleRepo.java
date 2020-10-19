package se.melindasw.relaywriter.role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role, Long> {
  List<Role> findByRole(String role);
}
