package com.weddingring.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weddingring.dto.ProfileDto;
import com.weddingring.entity.ProfileEntity;
import com.weddingring.repository.ProfileRepository;
import com.weddingring.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public ProfileDto saveProfile(ProfileDto dto) {
        System.out.println("hi");

        Long dbID=profileRepository.count();
        String profileNumber=""+1000+dbID;
        dto.setProfileId("P-ID-"+profileNumber);

        ProfileEntity entity= profileRepository.save(mapper.convertValue(dto, ProfileEntity.class));
        return mapper.convertValue(entity,ProfileDto.class);

    }

    @Override
    public List<ProfileDto> getAllProfiles() {
        List<ProfileEntity> allProfiles = profileRepository.findAll();
        List<ProfileDto> dtoList=new ArrayList<>();
        allProfiles.forEach(each->
            dtoList.add(mapper.convertValue(each,ProfileDto.class))
        );

        return dtoList;

    }

    @Override
    public ProfileDto updateProfile(ProfileDto dto) {
        ProfileEntity entity = profileRepository.findById(dto.getProfileId()).orElse(null);
        if(entity==null){
            return null;
        }else {
            try {
                ProfileEntity savedEntity = profileRepository.save(mapper.convertValue(dto, ProfileEntity.class));
                return mapper.convertValue(savedEntity, ProfileDto.class);
            } catch (Exception e) {
                return null;
            }
        }



    }
}
