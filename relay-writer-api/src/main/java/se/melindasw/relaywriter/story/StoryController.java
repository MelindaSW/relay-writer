package se.melindasw.relaywriter.story;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.melindasw.relaywriter.snippet.SnippetDTO;

import java.util.List;

@RestController
@RequestMapping("/story")
public class StoryController {

  private StoryService storyService;

  @Autowired
  public StoryController(StoryService storyService) {
    this.storyService = storyService;
  }

  @ApiOperation(value = "Add new snippet to story", response = ResponseEntity.class)
  @GetMapping("/all")
  public ResponseEntity<List<StoryDTO>> getAllStories() {
    return null;
  }

  @ApiOperation(value = "Add new story", response = ResponseEntity.class)
  @PostMapping("/add")
  public ResponseEntity<StoryDTO> addNewStory(@RequestBody SnippetDTO storyDTO) {
    return null;
  }

  @ApiOperation(value = "Delete a story", response = ResponseEntity.class)
  @DeleteMapping("/delete/{storyId}")
  public ResponseEntity<SnippetDTO> deleteStory(@PathVariable Long storyId) {
    return null;
  }

  @ApiOperation(value = "Add new snippet to story", response = ResponseEntity.class)
  @PostMapping("/add-snippet")
  public ResponseEntity<SnippetDTO> addNewSnippet(@RequestBody SnippetDTO snippetDTO) {
    return null;
  }
}
