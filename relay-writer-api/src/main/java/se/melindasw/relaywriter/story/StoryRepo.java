package se.melindasw.relaywriter.story;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepo extends JpaRepository<Story, Long> {}
