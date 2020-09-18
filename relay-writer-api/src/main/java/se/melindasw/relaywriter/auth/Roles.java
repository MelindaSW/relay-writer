package se.melindasw.relaywriter.auth;

import lombok.Data;
import se.melindasw.relaywriter.users.Users;

import javax.persistence.*;

@Entity
@Data
public class Roles {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String role;

  @ManyToOne @JoinColumn private Users users;
}
