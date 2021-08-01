package se.melindasw.relaywriter.mapping;

import se.melindasw.relaywriter.story.Story;
import se.melindasw.relaywriter.story.StoryDTO;

public class EntityMapper {

  public Story convertToStory(StoryDTO dto) {
    Story story = new Story();
    story.setCreatedAt(dto.getCreatedAt());
    story.setDescription(dto.getDescription());
    story.setTitle(dto.getTitle());
    return story;
  }
}
