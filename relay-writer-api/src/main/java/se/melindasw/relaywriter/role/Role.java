package se.melindasw.relaywriter.role;

import lombok.Getter;
import lombok.Setter;
import se.melindasw.relaywriter.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String role;

  private String description;

  @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
  private Set<User> users;

  public Role() {}

  public Role(String role, String description) {
    this.role = role;
    this.description = description;
    instantiateSets();
  }

  private void instantiateSets() {
    users = new HashSet<>();
  }
}
