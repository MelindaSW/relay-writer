package se.melindasw.relaywriter.users;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersDTO {
  private Long id;
  private String userName;
  private String email;
  private LocalDateTime createdAt;
}
