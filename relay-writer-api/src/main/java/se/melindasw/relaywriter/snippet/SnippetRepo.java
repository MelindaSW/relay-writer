package se.melindasw.relaywriter.snippet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SnippetRepo extends JpaRepository<Snippet, Long> {}
