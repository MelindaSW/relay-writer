package se.melindasw.relaywriter.stories;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Snippets {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private Date createdAt;
  private String snippet;

  @ManyToOne private Stories story;
}
