package se.melindasw.relaywriter.user;

import lombok.Getter;
import lombok.Setter;
import se.melindasw.relaywriter.role.Role;
import se.melindasw.relaywriter.story.Story;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

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

  @ManyToMany(cascade = ALL)
  @JoinTable(
      name = "users_roles",
      joinColumns = {@JoinColumn(name = "users_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "roles_id", referencedColumnName = "id")})
  private Set<Role> roles;

  @OneToMany(mappedBy = "creator")
  private Set<Story> stories;

  public User() {}

  public User(String userName, String email, String password, LocalDateTime createdAt) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;
    roles = new HashSet<>();
    stories = new HashSet<>();
  }

  public void addRole(Role role) {
    roles.add(role);
    role.getUsers().add(this);
  }

  public void removeRole(Role role) {
    roles.remove(role);
    role.getUsers().remove(this);
  }
}
