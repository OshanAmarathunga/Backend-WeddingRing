package com.weddingring.controller;

import com.weddingring.dto.ProfileDto;
import com.weddingring.service.ProfileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/save-profile")
    public ResponseEntity<ProfileDto> saveProfile(@RequestBody ProfileDto dto){
        ProfileDto profileDto = profileService.saveProfile(dto);
        return profileDto==null?ResponseEntity.status(400).body(null):ResponseEntity.status(200).body(profileDto);
    }

    @GetMapping("/get-all-profiles")
    public ResponseEntity<Object> getAllProfiles(HttpServletRequest request){
        log.info("Session ID: {}",request.getSession().getId());
        List<ProfileDto> allProfiles = profileService.getAllProfiles();

        if (allProfiles.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "No profiles found");
            response.put("status", "error");

            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(allProfiles);

    }

    @PutMapping("/update-profile")
    public ResponseEntity<Object> updateProfile(@RequestBody ProfileDto dto){
        log.info("dto {}",dto);
        ProfileDto profileDto = profileService.updateProfile(dto);
        if(profileDto==null){
            Map<String,String> response=new HashMap<>();
            response.put("message","Update Error");
            response.put("status","error");

            return ResponseEntity.status(404).body(response);
        }

        return ResponseEntity.status(200).body(profileDto);
    }
}
