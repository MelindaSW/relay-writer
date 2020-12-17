package se.melindasw.relaywriter.story;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewStoryDTO {
  String title;
  String description;
  Long creatorId;
  String characterName;
  String characterRace;
  String characterClass;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  LocalDateTime createdAt;

  public NewStoryDTO(
      LocalDateTime createdAt,
      String title,
      String description,
      Long creatorId,
      String characterName,
      String characterRace,
      String characterClass) {

    this.createdAt = createdAt;
    this.title = title;
    this.description = description;
    this.creatorId = creatorId;
    this.characterName = characterName;
    this.characterRace = characterRace;
    this.characterClass = characterClass;
  }
}
