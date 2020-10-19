package se.melindasw.relaywriter.auth;

import lombok.Getter;
import lombok.Setter;
import se.melindasw.relaywriter.users.Users;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Roles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String role;

  private String description;

  @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
  private Set<Users> users;

  public Roles() {}

  public Roles(String role, String description) {
    this.role = role;
    this.description = description;
    instantiateSets();
  }

  private void instantiateSets() {
    users = new HashSet<>();
  }
}
