package se.melindasw.relaywriter.story;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewStoryDTO {
  LocalDateTime createdAt;
  String title;
  String description;
  Long creatorId;
  String characterName;
  String characterRace;
}
