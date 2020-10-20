package se.melindasw.relaywriter.story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.exceptions.StoryNotFoundException;
import se.melindasw.relaywriter.snippet.SnippetRepo;
import se.melindasw.relaywriter.user.User;
import se.melindasw.relaywriter.user.UserDTO;
import se.melindasw.relaywriter.user.UserRepo;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoryServiceImplementation implements StoryService {

  private StoryRepo storyRepo;
  private UserRepo userRepo;
  private SnippetRepo snippetRepo;

  @Autowired
  public StoryServiceImplementation(
      StoryRepo storyRepo, UserRepo userRepo, SnippetRepo snippetRepo) {
    this.storyRepo = storyRepo;
    this.userRepo = userRepo;
    this.snippetRepo = snippetRepo;
  }

  @Override
  public StoryDTO addStory(NewStoryDTO dto) {
    if (userRepo.findById(dto.getCreatorId()).isEmpty()) {
      throw new EntityNotFoundException("User with id " + dto.getCreatorId() + " was not found");
    }
    Story story = new Story();
    User creator = userRepo.getOne(dto.getCreatorId());
    story.setCreator(creator);
    story.setTitle(dto.getTitle());
    story.setDescription(dto.getDescription());
    story.setCreatedAt(dto.getCreatedAt());
    storyRepo.save(story);
    return convertToStoryDTO(story);
  }

  @Override
  public StoryDTO updateStory(UpdateStoryDTO dto) {
    if (storyRepo.findById(dto.getId()).isEmpty()) {
      throw new StoryNotFoundException(dto.getId());
    }
    Story story = storyRepo.getOne(dto.getId());
    story.setCreatedAt(dto.getCreatedAt());
    story.setDescription(dto.getDescription());
    story.setTitle(dto.getTitle());
    storyRepo.save(story);
    return convertToStoryDTO(story);
  }

  @Override
  public String deleteStory(Long storyId) {
    if (storyRepo.findById(storyId).isEmpty()) {
      throw new StoryNotFoundException(storyId);
    }
    storyRepo.deleteById(storyId);
    return "Story with id " + storyId + " was deleted.";
  }

  @Override
  public List<StoryDTO> getAllStoriesForUser(Long userId) {
    if (userRepo.findById(userId).isEmpty()) {
      throw new EntityNotFoundException("User with id " + userId + " could not be found.");
    }
    User creator = userRepo.getOne(userId);
    List<Story> allStoriesForUser = storyRepo.findAllByCreator(creator);
    List<StoryDTO> response = new ArrayList<>();
    for (Story story : allStoriesForUser) {
      response.add(convertToStoryDTO(story));
    }
    return response;
  }

  @Override
  public List<StoryDTO> getAllStories() {
    List<StoryDTO> allStories = new ArrayList<>();
    List<Story> stories = storyRepo.findAll();
    for (Story story : stories) {
      allStories.add(convertToStoryDTO(story));
    }
    return allStories;
  }

  private Story convertToStory(StoryDTO dto) {
    Story story = new Story();
    story.setCreatedAt(dto.getCreatedAt());
    story.setDescription(dto.getDescription());
    story.setTitle(dto.getTitle());

    return story;
  }

  private StoryDTO convertToStoryDTO(Story story) {
    StoryDTO dto = new StoryDTO();
    dto.setId(story.getId());
    dto.setCreatedAt(story.getCreatedAt());
    dto.setTitle(story.getTitle());
    dto.setDescription(story.getDescription());
    UserDTO creator = convertToUserDTO(story.getCreator());
    dto.setCreator(creator);
    return dto;
  }

  private UserDTO convertToUserDTO(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setCreatedAt(user.getCreatedAt());
    dto.setEmail(user.getEmail());
    dto.setUserName(user.getUserName());
    return dto;
  }
}
