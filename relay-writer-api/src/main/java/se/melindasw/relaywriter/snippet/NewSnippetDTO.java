package se.melindasw.relaywriter.snippet;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewSnippetDTO {
  LocalDateTime createdAt;
  String snippet;
  String author;
  Long storyId;
}
