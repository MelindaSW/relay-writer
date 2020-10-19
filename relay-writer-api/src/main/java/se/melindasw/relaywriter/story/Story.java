package se.melindasw.relaywriter.story;

import lombok.Getter;
import lombok.Setter;
import se.melindasw.relaywriter.snippet.Snippet;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Story {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime createdAt;
  private String title;
  private String description;

  @OneToMany
  @JoinColumn(name = "story_fk")
  private Set<Snippet> snippets;

  public Story() {}

  public Story(LocalDateTime createdAt, String title, String description) {
    this.createdAt = createdAt;
    this.title = title;
    this.description = description;
    snippets = new HashSet<>();
  }

  public void addSnippet(Snippet newSnippet) {
    snippets.add(newSnippet);
  }
}
