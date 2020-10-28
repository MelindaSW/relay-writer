package se.melindasw.relaywriter.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
  private Long id;
  private String userName;
  private String email;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  private LocalDateTime createdAt;

  public UserDTO() {}

  public UserDTO(Long id, String userName, String email, LocalDateTime createdAt) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.createdAt = createdAt;
  }
}
