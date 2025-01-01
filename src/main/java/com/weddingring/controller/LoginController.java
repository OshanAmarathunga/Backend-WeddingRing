package com.weddingring.controller;

import com.weddingring.dto.UserDto;
import com.weddingring.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserService userService;
    @GetMapping("/get-data")
    public String getData(){
        return "Hi";
    }

    @PostMapping("/save-user")
    public ResponseEntity<UserDto> saveuser(@RequestBody UserDto dto){
        UserDto userDto = userService.saveUser(dto);
        return ResponseEntity.status(200).body(userDto);
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
