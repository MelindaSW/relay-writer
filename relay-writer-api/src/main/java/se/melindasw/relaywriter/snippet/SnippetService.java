package se.melindasw.relaywriter.snippet;

import java.util.List;

public interface SnippetService {

  SnippetDTO addSnippet(NewSnippetDTO newSnippetDTO);

  List<SnippetDTO> getAllSnippets();

  SnippetDTO updateSnippet(UpdateSnippetDTO snippetDTO);

  String deleteSnippet(Long snippetId);

  List<SnippetDTO> getAllSnippetsForStory(Long storyId);
}
