package com.weddingring.service;

import com.weddingring.dto.ProfileDto;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService {
    ProfileDto saveProfile(ProfileDto dto);
}
