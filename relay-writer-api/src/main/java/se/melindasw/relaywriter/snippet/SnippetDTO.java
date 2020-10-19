package se.melindasw.relaywriter.snippet;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SnippetDTO {
  Long id;
  LocalDateTime createdAt;
  String snippet;
}
