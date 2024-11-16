package com.chat_gpt_microservice.chat_gpt_microservice.Repository;

import com.chat_gpt_microservice.chat_gpt_microservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
