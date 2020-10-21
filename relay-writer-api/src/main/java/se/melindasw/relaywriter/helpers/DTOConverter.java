package se.melindasw.relaywriter.helpers;

import se.melindasw.relaywriter.role.Role;
import se.melindasw.relaywriter.role.RoleDTO;
import se.melindasw.relaywriter.snippet.Snippet;
import se.melindasw.relaywriter.snippet.SnippetDTO;
import se.melindasw.relaywriter.story.Story;
import se.melindasw.relaywriter.story.StoryDTO;
import se.melindasw.relaywriter.user.User;
import se.melindasw.relaywriter.user.UserDTO;

public class DTOConverter {

  public UserDTO convertToUserDTO(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setCreatedAt(user.getCreatedAt());
    dto.setEmail(user.getEmail());
    dto.setUserName(user.getUserName());
    return dto;
  }

  public RoleDTO convertToRoleDTO(Role role) {
    RoleDTO dto = new RoleDTO();
    dto.setId(role.getId());
    dto.setRole(role.getRole());
    dto.setDescription(role.getDescription());
    return dto;
  }

  public StoryDTO convertToStoryDTO(Story story) {
    StoryDTO dto = new StoryDTO();
    dto.setId(story.getId());
    dto.setCreatedAt(story.getCreatedAt());
    dto.setTitle(story.getTitle());
    dto.setDescription(story.getDescription());
    UserDTO creator = convertToUserDTO(story.getCreator());
    dto.setCreator(creator);
    return dto;
  }

  public SnippetDTO convertToSnippetDTO(Snippet s) {
    SnippetDTO dto = new SnippetDTO();
    dto.setAuthor(s.getAuthor());
    dto.setCreatedAt(s.getCreatedAt());
    dto.setId(s.getId());
    dto.setSnippet(s.getSnippet());
    StoryDTO story = convertToStoryDTO(s.getStory());
    dto.setStory(story);
    return dto;
  }
}
