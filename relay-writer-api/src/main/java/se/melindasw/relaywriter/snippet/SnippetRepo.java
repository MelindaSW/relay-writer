package se.melindasw.relaywriter.snippet;

import org.springframework.data.jpa.repository.JpaRepository;
import se.melindasw.relaywriter.story.Story;

import java.util.List;

public interface SnippetRepo extends JpaRepository<Snippet, Long> {
  List<Snippet> findAllByStory(Story story);

  List<Snippet> findByStoryOrderByIdAsc(Story story);
}
