package com.weddingring.service.impl;

import com.weddingring.entity.UserPrinciple;
import com.weddingring.entity.Users;
import com.weddingring.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Primary
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user= userRepository.findByUsername(username);
       log.info("user : {}",user);

        if (user==null){
            log.info("User not found");
            throw new UsernameNotFoundException("User not Found!");
        }
        return new UserPrinciple(user);
    }
}
