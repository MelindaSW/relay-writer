package se.melindasw.relaywriter.story;

import se.melindasw.relaywriter.snippet.SnippetDTO;

import java.util.List;

public interface StoryService {
  List<StoryDTO> getAllStories();

  StoryDTO addStory();

  StoryDTO updateStory(StoryDTO dto);

  String deleteStory(Long storyId);

  String addSnippetToStory(SnippetDTO newSnippet);
}
