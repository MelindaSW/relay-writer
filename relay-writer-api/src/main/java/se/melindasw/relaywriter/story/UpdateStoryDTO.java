package se.melindasw.relaywriter.story;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateStoryDTO {
  Long id;
  String title;
  String description;
  String characterName;
  String characterRace;
  String characterClass;
  boolean isFinished;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  LocalDateTime createdAt;

  public UpdateStoryDTO() {}

  public UpdateStoryDTO(
      Long id,
      String title,
      String description,
      String characterName,
      String characterRace,
      String characterClass,
      boolean isFinished,
      LocalDateTime createdAt) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.characterName = characterName;
    this.characterRace = characterRace;
    this.characterClass = characterClass;
    this.isFinished = isFinished;
    this.createdAt = createdAt;
  }
}
