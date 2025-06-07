package com.topicosprogramacao.jwt.models;

import com.topicosprogramacao.jwt.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class Users {
    private Long id;
    private String email;
    private String password;
    private Role role;
}
