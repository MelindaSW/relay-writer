package se.melindasw.relaywriter.user;

import lombok.Data;

@Data
public class NewPasswordDTO {
  private Long userId;
  private String oldPassword;
  private String newPassword;
}
