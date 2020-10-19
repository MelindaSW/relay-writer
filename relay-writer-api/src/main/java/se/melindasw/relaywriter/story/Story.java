package se.melindasw.relaywriter.story;

import lombok.Getter;
import lombok.Setter;
import se.melindasw.relaywriter.snippet.Snippets;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Stories {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime createdAt;
  private String title;
  private String description;

  @OneToMany
  @JoinColumn(name = "story_fk")
  private Set<Snippets> snippets;

  public Stories() {}

  public Stories(LocalDateTime createdAt, String title, String description) {
    this.createdAt = createdAt;
    this.title = title;
    this.description = description;
    snippets = new HashSet<>();
  }
}
