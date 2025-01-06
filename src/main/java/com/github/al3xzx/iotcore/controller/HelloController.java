package com.github.al3xzx.iotcore.controller;

import com.github.al3xzx.iotcore.model.entity.User;
import com.github.al3xzx.iotcore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/hello")
@AllArgsConstructor
public class HelloController {

    UserRepository userRepository;

    @GetMapping("/test")
    public ResponseEntity test() {
//        String helloWorld = "Hello World";
        User saved = userRepository.save(User.builder().id(UUID.randomUUID().toString()).build());
        return ResponseEntity.ok(saved);
    }
}
