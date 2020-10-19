package se.melindasw.relaywriter.snippet;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snippet")
public class SnippetController {

  private SnippetService snippetService;

  @Autowired
  public SnippetController(SnippetService snippetService) {
    this.snippetService = snippetService;
  }

  @ApiOperation(value = "Get a list of all snippets", response = ResponseEntity.class)
  @GetMapping("/all")
  public ResponseEntity<List<SnippetDTO>> getSnippets() {
    return null;
  }

  @ApiOperation(value = "Delete one snippet", response = ResponseEntity.class)
  @DeleteMapping("/delete/{snippetId}")
  public ResponseEntity<String> deleteSnippet(@PathVariable Long snippetId) {
    return null;
  }

  @ApiOperation(value = "Update one snippet", response = ResponseEntity.class)
  @PutMapping("/update")
  public ResponseEntity<SnippetDTO> updateSnippet(@RequestBody SnippetDTO snippetDTO) {
    return null;
  }
}
