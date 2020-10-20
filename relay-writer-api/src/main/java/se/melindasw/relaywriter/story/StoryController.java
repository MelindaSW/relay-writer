package se.melindasw.relaywriter.story;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/story")
public class StoryController {

  private StoryService storyService;

  @Autowired
  public StoryController(StoryService storyService) {
    this.storyService = storyService;
  }

  @ApiOperation(value = "Get a list of all stories", response = ResponseEntity.class)
  @GetMapping("/all")
  public ResponseEntity<List<StoryDTO>> getAllStories() {
    return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
  }

  @ApiOperation(value = "Add a new story", response = ResponseEntity.class)
  @PostMapping("/add")
  public ResponseEntity<StoryDTO> addNewStory(@RequestBody NewStoryDTO storyDTO) {
    StoryDTO dtoResponse = storyService.addStory(storyDTO);
    return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
  }

  @ApiOperation(value = "Delete a story", response = ResponseEntity.class)
  @DeleteMapping("/delete/{storyId}")
  public ResponseEntity<String> deleteStory(@PathVariable Long storyId) {
    String response = storyService.deleteStory(storyId);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @ApiOperation(value = "Update a story", response = ResponseEntity.class)
  @PutMapping("/update")
  public ResponseEntity<StoryDTO> updateStory(@RequestBody UpdateStoryDTO updateStoryDTO) {
    StoryDTO dtoResponse = storyService.updateStory(updateStoryDTO);
    return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
  }

  @ApiOperation(value = "Get all stories for user", response = ResponseEntity.class)
  @PutMapping("/all/{userId}")
  public ResponseEntity<List<StoryDTO>> getStoriesForUser(@PathVariable Long userId) {
    List<StoryDTO> dtoResponse = storyService.getAllStoriesForUser(userId);
    return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
  }
}
