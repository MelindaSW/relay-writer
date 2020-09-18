package se.melindasw.relaywriter.stories;

import lombok.Data;
import se.melindasw.relaywriter.users.Users;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Stories {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private Date createdAt;
  private String title;
  private String description;

  @ManyToOne private Users creator;
}
