package com.weddingring.service;

import com.weddingring.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto saveUser(UserDto dto);
}
