package se.melindasw.relaywriter.snippet;

import java.util.List;

public interface SnippetService {
  List<SnippetDTO> getAllSnippets();

  SnippetDTO updateSnippet(SnippetDTO snippetDTO);

  String deleteSnippet(Long snippetId);
}
