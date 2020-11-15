package se.melindasw.relaywriter.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.melindasw.relaywriter.role.RoleRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTests {

  @Autowired private MockMvc mockMvc;
  @Autowired private UserController controller;
  @Autowired ObjectMapper objectMapper;

  @MockBean UserService service;
  @MockBean UserRepo userRepo;
  @MockBean RoleRepo roleRepo;

  LocalDateTime timeStampNow = LocalDateTime.now();
  LocalDateTime stillTimeStamp = LocalDateTime.of(2000, 5, 11, 1, 2);

  public UserControllerTests() {}

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void testAddUser() throws Exception {
    NewUserDTO newUser = new NewUserDTO(0L, "Username", "mail@mail.com", "pwdpwd", timeStampNow);
    UserDTO expectedResponse = new UserDTO(1L, "Username", "mail@mail.com", timeStampNow);
    doReturn(expectedResponse).when(service).addUser(any());
    mockMvc
        .perform(
            post("/users/add")
                .content(asJsonString(newUser))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").exists())
        .andExpect(jsonPath("$.userName").exists())
        .andExpect(jsonPath("$.email").exists())
        .andExpect(jsonPath("$.createdAt").exists());
  }

  @Test
  public void testAddUserWithIncorrectRequest() throws Exception {
    // Any missing value in the new user should return status code 400
    NewUserDTO newIncorrectUserNullName =
        new NewUserDTO(0L, null, "mail@mail.com", "pwd", timeStampNow);
    NewUserDTO newIncorrectUserNullEmail =
        new NewUserDTO(0L, "username", null, "pwd", timeStampNow);
    NewUserDTO newIncorrectUserNullPassword =
        new NewUserDTO(0L, "username", "mail@mail.com", null, timeStampNow);

    mockMvc
        .perform(
            post("/users/add")
                .content(asJsonString(newIncorrectUserNullName))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());

    mockMvc
        .perform(
            post("/users/add")
                .content(asJsonString(newIncorrectUserNullEmail))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());

    mockMvc
        .perform(
            post("/users/add")
                .content(asJsonString(newIncorrectUserNullPassword))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  public void testGetAllUsers() throws Exception {
    List<UserDTO> expectedResponse = new ArrayList<>();
    UserDTO user1 = new UserDTO();
    UserDTO user2 = new UserDTO();
    expectedResponse.add(user1);
    expectedResponse.add(user2);

    doReturn(expectedResponse).when(service).getAllUsers();

    MockHttpServletResponse response =
        mockMvc.perform(get("/users/get-all")).andReturn().getResponse();
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(response.getContentAsString()).isEqualTo(asJsonString(expectedResponse));
  }

  @Test
  public void testGetOneUser() throws Exception {
    UserDTO expectedResponse = new UserDTO(1L, "useruser", "user@mail.com", null);
    when(service.getUserByID(1L)).thenReturn(expectedResponse);

    MockHttpServletResponse response =
        mockMvc.perform(get("/users/get-one/1")).andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(response.getContentAsString()).isEqualTo(asJsonString(expectedResponse));
  }

  @Test
  public void testDeleteOneUser() throws Exception {
    long userId = 1L;
    String responseMsg = "User with id " + userId + " was deleted";
    when(service.deleteUser(userId)).thenReturn(responseMsg);

    MockHttpServletResponse response =
        mockMvc.perform(delete("/users/delete/{id}", 1)).andReturn().getResponse();

    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    assertThat(response.getContentAsString()).isEqualTo(responseMsg);
  }

  @Test
  public void testUpdateUser() {}

  static String asJsonString(final Object obj) {
    try {
      String json = new ObjectMapper().writeValueAsString(obj);
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

//
//  @Test
//  public void testFooDelete() throws Exception {
//    this.mockMvc.perform(MockMvcRequestBuilders
//            .delete("/api/foo/{id}", "11")
//            .contentType(MediaType.APPLICATION_JSON))
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk());
//  }
