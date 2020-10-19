package se.melindasw.relaywriter.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
  private Long id;
  private String userName;
  private String email;
  private LocalDateTime createdAt;
}
