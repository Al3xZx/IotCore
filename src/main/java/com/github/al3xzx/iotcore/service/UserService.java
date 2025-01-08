package com.github.al3xzx.iotcore.service;

import com.github.al3xzx.iotcore.exception.NotFoundException;
import com.github.al3xzx.iotcore.model.dto.UserDTO;
import com.github.al3xzx.iotcore.model.entity.User;
import com.github.al3xzx.iotcore.model.mapper.UserMapper;
import com.github.al3xzx.iotcore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setCreationDate(LocalDate.now());
        User saved = userRepository.save(user);
        return userMapper.toDTO(saved);
    }

    public UserDTO findById(String id) throws NotFoundException {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
