package se.melindasw.relaywriter.snippet;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateSnippetDTO {
  Long id;
  LocalDateTime createdAt;
  String snippet;
  String author;
}
