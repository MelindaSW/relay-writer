package se.melindasw.relaywriter.users;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewUserDTO {
  private Long id;
  private String userName;
  private String email;
  private String password;
  private LocalDateTime createdAt;
}
