package se.melindasw.relaywriter.story;

import lombok.Data;
import se.melindasw.relaywriter.user.UserDTO;

import java.time.LocalDateTime;

@Data
public class StoryDTO {
  Long id;
  LocalDateTime createdAt;
  String title;
  String description;
  String characterName;
  String characterRace;
  String characterClass;
  UserDTO creator;
}
