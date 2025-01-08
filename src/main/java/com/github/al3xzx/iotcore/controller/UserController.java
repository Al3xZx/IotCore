package com.github.al3xzx.iotcore.controller;

import com.github.al3xzx.iotcore.exception.NotFoundException;
import com.github.al3xzx.iotcore.model.dto.UserDTO;
import com.github.al3xzx.iotcore.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    UserService userService;

    @PostMapping
    public ResponseEntity registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(userService.createUser(userDTO).getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable String id) {
        try {
            return ResponseEntity.ok(userService.findById(id));
        } catch (NotFoundException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
