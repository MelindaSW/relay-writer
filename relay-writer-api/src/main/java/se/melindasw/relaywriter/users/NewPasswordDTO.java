package se.melindasw.relaywriter.users;

import lombok.Data;

@Data
public class NewPasswordDTO {
  private Long userId;
  private String oldPassword;
  private String newPassword;
}
