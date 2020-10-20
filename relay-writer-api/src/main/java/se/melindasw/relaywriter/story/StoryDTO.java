package se.melindasw.relaywriter.story;

import lombok.Data;
import se.melindasw.relaywriter.snippet.SnippetDTO;
import se.melindasw.relaywriter.user.UserDTO;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class StoryDTO {
  Long id;
  LocalDateTime createdAt;
  String title;
  String description;
  UserDTO creator;
  Set<SnippetDTO> snippets;
}
