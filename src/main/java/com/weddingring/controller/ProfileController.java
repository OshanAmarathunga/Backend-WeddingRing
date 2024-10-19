package com.weddingring.controller;

import com.weddingring.dto.ProfileDto;
import com.weddingring.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @PostMapping("/save-profile")
    public ResponseEntity<ProfileDto> saveProfile(@RequestBody ProfileDto dto){
        ProfileDto profileDto = profileService.saveProfile(dto);
        return profileDto==null?ResponseEntity.status(400).body(null):ResponseEntity.status(200).body(profileDto);
    }
}
