package com.topicosprogramacao.jwt.dtos;

import lombok.Data;

@Data
public class UserUpdateDTO {
    private String email;
    private String password;
}
