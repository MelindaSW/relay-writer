package se.melindasw.relaywriter.users;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsersDTO {
  private Long id;
  private String userName;
  private String email;
  private LocalDateTime createdAt;

  public UsersDTO(Long id, String userName, String email, LocalDateTime createdAt) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.createdAt = createdAt;
  }
}
