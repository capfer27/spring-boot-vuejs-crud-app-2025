package com.capfer.spring_boot_vue_crud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

   @GetMapping
   public ResponseEntity<String> hello() {
       return ResponseEntity.status(HttpStatus.OK).body("Hello, gentleman!");
   }
}
