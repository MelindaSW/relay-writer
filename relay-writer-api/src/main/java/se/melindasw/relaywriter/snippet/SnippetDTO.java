package se.melindasw.relaywriter.snippet;

import lombok.Data;
import se.melindasw.relaywriter.story.StoryDTO;

import java.time.LocalDateTime;

@Data
public class SnippetDTO {
  Long id;
  LocalDateTime createdAt;
  String snippet;
  String author;
  StoryDTO story;
}
