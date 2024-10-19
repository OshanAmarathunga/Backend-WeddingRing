package com.weddingring.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weddingring.dto.ProfileDto;
import com.weddingring.entity.ProfileEntity;
import com.weddingring.repository.ProfileRepository;
import com.weddingring.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public ProfileDto saveProfile(ProfileDto dto) {

        Long dbID=profileRepository.count();
        String ProfileNumber=""+1000+dbID;
        dto.setProfileId("P-ID-"+ProfileNumber);
       ProfileEntity entity= profileRepository.save(mapper.convertValue(dto, ProfileEntity.class));
       return mapper.convertValue(entity,ProfileDto.class);


    }

    @Override
    public List<ProfileDto> getAllProfiles() {
        List<ProfileEntity> allProfiles = profileRepository.findAll();
        List<ProfileDto> dtoList=new ArrayList<>();
        allProfiles.forEach((each)->{
            dtoList.add(mapper.convertValue(each,ProfileDto.class));
        });

        return dtoList;

    }
}
