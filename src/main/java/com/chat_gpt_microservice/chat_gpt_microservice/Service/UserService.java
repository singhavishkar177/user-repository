package com.chat_gpt_microservice.chat_gpt_microservice.Service;

import com.chat_gpt_microservice.chat_gpt_microservice.Model.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Long id);
    void deleteUser(Long id);
}
