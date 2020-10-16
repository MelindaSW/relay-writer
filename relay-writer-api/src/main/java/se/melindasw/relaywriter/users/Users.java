package se.melindasw.relaywriter.users;

import lombok.Data;
import se.melindasw.relaywriter.auth.Roles;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
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

  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
      name = "users_roles",
      joinColumns = {@JoinColumn(name = "roles_id")},
      inverseJoinColumns = {@JoinColumn(name = "users_id")})
  private Set<Roles> roles = new HashSet<>();

  public Users() {}

  public Users(String userName, String email, String password, LocalDateTime createdAt) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;
  }

  public Users(Long id, String userName, String email, String password, LocalDateTime createdAt) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.createdAt = createdAt;
  }
}
