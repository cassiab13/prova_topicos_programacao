package com.topicosprogramacao.jwt.dtos;

import com.topicosprogramacao.jwt.enums.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private Role role;
}
