package se.melindasw.relaywriter.story;

import org.springframework.data.jpa.repository.JpaRepository;
import se.melindasw.relaywriter.user.User;

import java.util.List;

public interface StoryRepo extends JpaRepository<Story, Long> {
  List<Story> findAllByCreator(User creator);
}
