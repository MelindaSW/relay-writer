package se.melindasw.relaywriter.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.melindasw.relaywriter.role.RoleRepo;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTests {

  @Autowired private MockMvc mockMvc;
  @Autowired private UserController controller;

  @MockBean UserService service;
  @MockBean UserRepo userRepo;
  @MockBean RoleRepo roleRepo;

  public UserControllerTests() {}

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  @Test
  public void testAddUser() throws Exception {
    LocalDateTime createTime = LocalDateTime.now();
    NewUserDTO newUser = new NewUserDTO(0L, "Username", "mail@mail.com", "pwdpwd", createTime);
    UserDTO returnDto = new UserDTO(1L, "Username", "mail@mail.com", createTime);
    System.out.println("createTime:: " + createTime.toString());
    doReturn(returnDto).when(service).addUser(any());
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

  static String asJsonString(final Object obj) {
    try {
      String json = new ObjectMapper().writeValueAsString(obj);
      System.out.println("jsonstring:: " + json);
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
