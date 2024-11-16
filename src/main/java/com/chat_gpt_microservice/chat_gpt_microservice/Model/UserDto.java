package com.chat_gpt_microservice.chat_gpt_microservice.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {
    private Long id;
    @Size(min = 3, message = "Name should be min 3 character")
    private String name;
    @Email
    private String email;
    @Min(value = 1, message = "Age must be at least 1")
    private int age;
}
