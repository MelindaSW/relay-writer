package se.melindasw.relaywriter.snippet;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snippet")
public class SnippetController {

  private final SnippetService snippetService;

  @Autowired
  public SnippetController(SnippetService snippetService) {
    this.snippetService = snippetService;
  }

  @ApiOperation(value = "Add new snippet", response = ResponseEntity.class)
  @PostMapping("/add-snippet")
  public ResponseEntity<SnippetDTO> addNewSnippet(@RequestBody NewSnippetDTO newSnippetDTO) {
    SnippetDTO responseDTO = snippetService.addSnippet(newSnippetDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Get a list of all snippets", response = ResponseEntity.class)
  @GetMapping("/all")
  public ResponseEntity<List<SnippetDTO>> getSnippets() {
    List<SnippetDTO> responseList = snippetService.getAllSnippets();
    return new ResponseEntity<>(responseList, HttpStatus.OK);
  }

  @ApiOperation(value = "Update one snippet", response = ResponseEntity.class)
  @PutMapping("/update")
  public ResponseEntity<SnippetDTO> updateSnippet(@RequestBody UpdateSnippetDTO updateSnippetDTO) {
    SnippetDTO responseDTO = snippetService.updateSnippet(updateSnippetDTO);
    return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Delete one snippet", response = ResponseEntity.class)
  @DeleteMapping("/delete/{snippetId}")
  public ResponseEntity<String> deleteSnippet(@PathVariable Long snippetId) {
    String response = snippetService.deleteSnippet(snippetId);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @ApiOperation(value = "Get all snippets for one story", response = ResponseEntity.class)
  @GetMapping("/all/{storyId}")
  public ResponseEntity<List<SnippetDTO>> getAllSnippetsForStory(@PathVariable Long storyId) {
    List<SnippetDTO> response = snippetService.getAllSnippetsForStory(storyId);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
