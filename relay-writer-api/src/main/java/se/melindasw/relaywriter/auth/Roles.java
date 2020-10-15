package se.melindasw.relaywriter.auth;

import lombok.Data;
import se.melindasw.relaywriter.users.Users;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Roles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(unique = true)
  private String role;

  @ManyToMany(mappedBy = "role")
  private Set<Users> users = new HashSet<>();
}
