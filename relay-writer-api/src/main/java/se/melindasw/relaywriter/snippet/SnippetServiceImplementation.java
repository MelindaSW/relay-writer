package se.melindasw.relaywriter.snippet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import se.melindasw.relaywriter.exceptions.SnippetNotFoundException;
import se.melindasw.relaywriter.mapping.DTOMapper;
import se.melindasw.relaywriter.story.Story;
import se.melindasw.relaywriter.story.StoryRepo;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SnippetServiceImplementation implements SnippetService {
  DTOMapper converter = new DTOMapper();

  private final SnippetRepo snippetRepo;
  private final StoryRepo storyRepo;

  @Autowired
  public SnippetServiceImplementation(SnippetRepo snippetRepo, StoryRepo storyRepo) {
    this.snippetRepo = snippetRepo;
    this.storyRepo = storyRepo;
  }

  @Override
  public SnippetDTO addSnippet(NewSnippetDTO newSnippetDTO) {
    Optional<Story> owningStory = storyRepo.findById(newSnippetDTO.getStoryId());
    if (owningStory.isEmpty()) {
      throw new EntityNotFoundException(
          "Story with id " + newSnippetDTO.getStoryId() + " was not found.");
    }
    Snippet snippet = new Snippet();
    Story story = owningStory.get();
    snippet.setStory(story);
    snippet.setAuthor(newSnippetDTO.getAuthor());
    snippet.setSnippet(newSnippetDTO.getSnippet());
    snippet.setCreatedAt(newSnippetDTO.getCreatedAt());
    snippetRepo.save(snippet);
    // TODO - make story finished if the number of total snippets equals the amount of snippets set in the database. Make sure to send a warning that no more entries are allowed.
    return converter.mapToSnippetDTO(snippet);
  }

  @Override
  public List<SnippetDTO> getAllSnippets() {
    List<Snippet> snippets = snippetRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    List<SnippetDTO> dtos = new ArrayList<>();
    for (Snippet snippet : snippets) {
      dtos.add(converter.mapToSnippetDTO(snippet));
    }
    return dtos;
  }

  @Override
  public SnippetDTO updateSnippet(UpdateSnippetDTO updateSnippetDTO) {
    Long id = updateSnippetDTO.getId();
    if (snippetRepo.findById(id).isEmpty()) {
      throw new SnippetNotFoundException(updateSnippetDTO.getId());
    }
    Snippet snippet = snippetRepo.getOne(id);
    snippet.setCreatedAt(updateSnippetDTO.getCreatedAt());
    snippet.setSnippet(updateSnippetDTO.getSnippet());
    snippet.setAuthor(updateSnippetDTO.getAuthor());
    snippetRepo.save(snippet);
    return converter.mapToSnippetDTO(snippet);
  }

  @Override
  public String deleteSnippet(Long snippetId) {
    if (snippetRepo.findById(snippetId).isEmpty()) {
      throw new SnippetNotFoundException(snippetId);
    }
    snippetRepo.deleteById(snippetId);
    return "Snippet with id " + snippetId + " was deleted.";
  }

  @Override
  public List<SnippetDTO> getAllSnippetsForStory(Long storyId) {
    if (!storyRepo.existsById(storyId)) {
      throw new EntityNotFoundException("Story with the id " + storyId + " was not found.");
    }
    Story story = storyRepo.getOne(storyId);
    List<Snippet> allSnippetsForStory = snippetRepo.findByStoryOrderByIdAsc(story);
    List<SnippetDTO> response = new ArrayList<>();
    for (Snippet snippet : allSnippetsForStory) {
      response.add(converter.mapToSnippetDTO(snippet));
    }
    return response;
  }
}
