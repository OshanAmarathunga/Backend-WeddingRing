package com.weddingring.service;

import com.weddingring.dto.ProfileDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfileService {
    ProfileDto saveProfile(ProfileDto dto);
    List<ProfileDto> getAllProfiles();
}
