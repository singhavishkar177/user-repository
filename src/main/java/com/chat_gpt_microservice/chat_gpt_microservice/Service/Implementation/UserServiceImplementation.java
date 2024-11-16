package com.chat_gpt_microservice.chat_gpt_microservice.Service.Implementation;

import com.chat_gpt_microservice.chat_gpt_microservice.Entity.User;
import com.chat_gpt_microservice.chat_gpt_microservice.Exception.ResourceNotFoundException;
import com.chat_gpt_microservice.chat_gpt_microservice.Model.UserDto;
import com.chat_gpt_microservice.chat_gpt_microservice.Repository.UserRepository;
import com.chat_gpt_microservice.chat_gpt_microservice.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository repository;

    ModelMapper modelMapper = new ModelMapper();
    @Override
    public UserDto getUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        return mapToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return repository.findAll().stream().map(p -> mapToDto(p)).collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.getEmail().contains("@");
        User User = repository.save(mapToEntity(userDto));
        return mapToDto(User);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User User = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        User.setName(userDto.getName());
        User.setEmail(userDto.getEmail());
        User.setAge(userDto.getAge());
        UserDto UserDtoResult = mapToDto(repository.save(User));
        return UserDtoResult;
    }

    @Override
    public void deleteUser(Long id) {
        User User = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        repository.deleteById(id);
    }
    public UserDto mapToDto(User User){
        UserDto UserDto = modelMapper.map(User,UserDto.class);
        return UserDto;
    }
    public User mapToEntity(UserDto UserDto){
        User User = modelMapper.map(UserDto,User.class);
        return  User;
    }
}
