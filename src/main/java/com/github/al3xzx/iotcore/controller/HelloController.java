package com.github.al3xzx.iotcore.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@AllArgsConstructor
public class HelloController {

    @GetMapping
    public ResponseEntity test() {
        String helloWorld = "Hello World";
        return ResponseEntity.ok(helloWorld);
    }
}
