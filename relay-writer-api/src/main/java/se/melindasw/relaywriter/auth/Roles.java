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
  private Long id;

  @Column(unique = true)
  private String role;

  private String description;

  @ManyToMany(mappedBy = "roles", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private Set<Users> users = new HashSet<>();

  public Roles() {}

  public Roles(String role, String description) {
    this.role = role;
    this.description = description;
  }
}
