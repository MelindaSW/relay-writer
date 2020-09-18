package se.melindasw.relaywriter.users;

import lombok.Data;
import se.melindasw.relaywriter.auth.Roles;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String userName;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private Date createdAt;

  @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
  private Set<Roles> roles;
}
