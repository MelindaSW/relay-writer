package se.melindasw.relaywriter.story;

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

  private LocalDateTime createdAt;
  private String title;
  private String description;
  private String characterName;
  private String characterRace;
  private String characterClass;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private User creator;

  public Story() {}

  //  public Story(LocalDateTime createdAt, String title, String description, User creator) {
  //    this.createdAt = createdAt;
  //    this.title = title;
  //    this.description = description;
  //    this.creator = creator;
  //  }
}
