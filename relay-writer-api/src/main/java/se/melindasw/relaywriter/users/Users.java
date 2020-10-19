package se.melindasw.relaywriter.users;

import lombok.Getter;
import lombok.Setter;
import se.melindasw.relaywriter.auth.Roles;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String userName;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "users_roles",
      joinColumns = {@JoinColumn(name = "users_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "roles_id", referencedColumnName = "id")})
  private Set<Roles> roles;

  public Users() {}

  public Users(String userName, String email, String password, LocalDateTime createdAt) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;
    instantiateSets();
  }

  public void instantiateSets() {
    roles = new HashSet<>();
  }

  public void addRole(Roles role) {
    roles.add(role);
    role.getUsers().add(this);
  }

  public void removeRole(Roles role) {
    roles.remove(role);
    role.getUsers().remove(this);
  }
}
