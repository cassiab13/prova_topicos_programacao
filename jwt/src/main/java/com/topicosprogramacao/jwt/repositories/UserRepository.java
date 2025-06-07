package com.topicosprogramacao.jwt.repositories;

import com.topicosprogramacao.jwt.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
