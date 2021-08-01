package se.melindasw.relaywriter.mapping;

import se.melindasw.relaywriter.role.Role;
import se.melindasw.relaywriter.role.RoleDTO;
import se.melindasw.relaywriter.snippet.Snippet;
import se.melindasw.relaywriter.snippet.SnippetDTO;
import se.melindasw.relaywriter.story.Story;
import se.melindasw.relaywriter.story.StoryDTO;
import se.melindasw.relaywriter.user.User;
import se.melindasw.relaywriter.user.UserDTO;

public class DTOMapper {

  public UserDTO mapToUserDTO(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setCreatedAt(user.getCreatedAt());
    dto.setEmail(user.getEmail());
    dto.setUserName(user.getUserName());
    return dto;
  }

  public RoleDTO mapToRoleDTO(Role role) {
    RoleDTO dto = new RoleDTO();
    dto.setId(role.getId());
    dto.setRole(role.getRole());
    dto.setDescription(role.getDescription());
    return dto;
  }

  public StoryDTO mapToStoryDTO(Story story) {
    StoryDTO dto = new StoryDTO();
    dto.setId(story.getId());
    dto.setCreatedAt(story.getCreatedAt());
    dto.setTitle(story.getTitle());
    dto.setDescription(story.getDescription());
    dto.setCharacterName(story.getCharacterName());
    dto.setCharacterRace(story.getCharacterRace());
    dto.setCharacterClass(story.getCharacterClass());
    UserDTO creator = mapToUserDTO(story.getCreator());
    dto.setCreator(creator);
    return dto;
  }

  public SnippetDTO mapToSnippetDTO(Snippet s) {
    SnippetDTO dto = new SnippetDTO();
    dto.setAuthor(s.getAuthor());
    dto.setCreatedAt(s.getCreatedAt());
    dto.setId(s.getId());
    dto.setSnippet(s.getSnippet());
    StoryDTO story = mapToStoryDTO(s.getStory());
    dto.setStory(story);
    return dto;
  }
}
