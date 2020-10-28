package se.melindasw.relaywriter.story;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import se.melindasw.relaywriter.user.UserDTO;

import java.time.LocalDateTime;

@Data
public class StoryDTO {
  Long id;
  String title;
  String description;
  String characterName;
  String characterRace;
  String characterClass;
  UserDTO creator;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  LocalDateTime createdAt;

  public StoryDTO() {}

  public StoryDTO(
      Long id,
      LocalDateTime createdAt,
      String title,
      String description,
      String characterName,
      String characterRace,
      String characterClass,
      UserDTO creator) {
    this.id = id;
    this.createdAt = createdAt;
    this.title = title;
    this.description = description;
    this.characterName = characterName;
    this.characterRace = characterRace;
    this.characterClass = characterClass;
    this.creator = creator;
  }
}
