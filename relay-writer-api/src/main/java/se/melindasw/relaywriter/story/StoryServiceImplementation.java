package se.melindasw.relaywriter.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.snippet.SnippetDTO;

import java.util.List;

@Service
public class StoryServiceImplementation implements StoryService {

  private StoryRepo storyRepo;

  @Autowired
  public StoryServiceImplementation(StoryRepo storyRepo) {
    this.storyRepo = storyRepo;
  }

  @Override
  public StoryDTO addStory() {
    return null;
  }

  @Override
  public StoryDTO updateStory(StoryDTO dto) {
    return null;
  }

  @Override
  public String deleteStory(Long storyId) {
    return null;
  }

  @Override
  public List<StoryDTO> getAllStories() {
    return null;
  }

  @Override
  public String addSnippetToStory(SnippetDTO newSnippet) {
    return null;
  }
}
