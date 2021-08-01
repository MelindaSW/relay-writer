package se.melindasw.relaywriter.story;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import se.melindasw.relaywriter.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "stories")
public class Story {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private String characterName;
  private String characterRace;
  private String characterClass;

  @Column(columnDefinition = "boolean default false")
  private boolean isFinished;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private User creator;

  public Story() {}

  public Story(
      Long id,
      LocalDateTime createdAt,
      String title,
      String description,
      String characterName,
      String characterRace,
      String characterClass,
      User creator) {
    this.id = id;
    this.createdAt = createdAt;
    this.title = title;
    this.description = description;
    this.characterName = characterName;
    this.characterRace = characterRace;
    this.characterClass = characterClass;
    this.creator = creator;
  }

  public void setIsFinished(boolean finished) {
    this.isFinished = finished;
  }
}
