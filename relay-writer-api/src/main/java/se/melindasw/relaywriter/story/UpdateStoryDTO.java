package se.melindasw.relaywriter.story;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateStoryDTO {
  Long id;
  LocalDateTime createdAt;
  String title;
  String description;
}
