package se.melindasw.relaywriter.story;

import lombok.Getter;
import lombok.Setter;
import se.melindasw.relaywriter.snippet.Snippet;
import se.melindasw.relaywriter.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@Table(name = "stories")
public class Story {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime createdAt;
  private String title;
  private String description;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User creator;

  @OneToMany(cascade = ALL, mappedBy = "story")
  private Set<Snippet> snippets;

  public Story() {}

  public Story(LocalDateTime createdAt, String title, String description, User creator) {
    this.createdAt = createdAt;
    this.title = title;
    this.description = description;
    this.creator = creator;
    snippets = new HashSet<>();
  }

  public void addSnippet(Snippet newSnippet) {
    snippets.add(newSnippet);
  }
}
