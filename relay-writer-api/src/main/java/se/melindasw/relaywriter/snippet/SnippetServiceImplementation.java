package se.melindasw.relaywriter.snippet;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnippetServiceImplementation implements SnippetService {
  @Override
  public List<SnippetDTO> getAllSnippets() {
    return null;
  }

  @Override
  public SnippetDTO updateSnippet(SnippetDTO snippetDTO) {
    return null;
  }

  @Override
  public String deleteSnippet(Long snippetId) {
    return null;
  }
}
