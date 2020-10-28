package se.melindasw.relaywriter.snippet;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import se.melindasw.relaywriter.story.StoryDTO;

import java.time.LocalDateTime;

@Data
public class SnippetDTO {
  Long id;
  String snippet;
  String author;
  StoryDTO story;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  LocalDateTime createdAt;
}
