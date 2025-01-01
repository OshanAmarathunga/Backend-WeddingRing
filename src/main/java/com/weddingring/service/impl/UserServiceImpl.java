package com.weddingring.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weddingring.dto.UserDto;
import com.weddingring.entity.Users;
import com.weddingring.repository.UserRepository;
import com.weddingring.service.UserService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper mapper;
    @Override
    public UserDto saveUser(UserDto dto) {
        Users saved = userRepository.save(mapper.convertValue(dto, Users.class));
        return mapper.convertValue(saved,UserDto.class);
    }
}
