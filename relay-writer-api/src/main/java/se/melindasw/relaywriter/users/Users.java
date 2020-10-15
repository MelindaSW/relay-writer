package se.melindasw.relaywriter.users;

import lombok.Data;
import se.melindasw.relaywriter.auth.Roles;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, unique = true)
  private String userName;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private Date createdAt;

  @ManyToMany @JoinTable
  //          (
  //      name = "APP_USER_ROLE",
  //      joinColumns = {@JoinColumn(name = "USER_ID")},
  //      inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
  private Set<Roles> role;

  {
    role = new HashSet<>();
  }
}
