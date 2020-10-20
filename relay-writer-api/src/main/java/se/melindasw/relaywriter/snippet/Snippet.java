package se.melindasw.relaywriter.snippet;

import lombok.Getter;
import lombok.Setter;
import se.melindasw.relaywriter.story.Story;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "snippets")
public class Snippet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Date createdAt;
  private String snippet;
  private String author;

  @ManyToOne
  @JoinColumn(name = "story_id")
  private Story story;
}
