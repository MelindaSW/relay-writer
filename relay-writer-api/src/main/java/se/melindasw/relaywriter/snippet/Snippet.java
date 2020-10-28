package se.melindasw.relaywriter.snippet;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import se.melindasw.relaywriter.story.Story;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "snippets")
public class Snippet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime createdAt;

  private String snippet;
  private String author;

  @ManyToOne
  @JoinColumn(name = "story_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Story story;
}
