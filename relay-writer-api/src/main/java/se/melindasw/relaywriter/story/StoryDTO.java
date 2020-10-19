package se.melindasw.relaywriter.story;

import lombok.Data;
import se.melindasw.relaywriter.snippet.Snippet;
import se.melindasw.relaywriter.user.User;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class StoryDTO {
  Long id;
  LocalDateTime createdAt;
  String title;
  String description;
  User creator;
  Set<Snippet> snippets;
}
