package se.melindasw.relaywriter.story;

import java.util.List;

public interface StoryService {

  StoryDTO addStory(NewStoryDTO newStoryDTO);

  List<StoryDTO> getAllStories();

  StoryDTO updateStory(UpdateStoryDTO storyDTO);

  String deleteStory(Long storyId);

  List<StoryDTO> getAllStoriesForUser(Long userId);
}
