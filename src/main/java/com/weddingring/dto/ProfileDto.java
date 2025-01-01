package com.weddingring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private String profileId;
    private String firstName;
    private String lastName;
    private String displayName;
    private String gender;
    private String contactNo;
    private String landLineNo;
    private String email;
    private String birthDay;
    private String religion;
    private String ethnicity;
    private double height;
    private String civilStatus;
    private String countryOfResidence;
    private String district;
    private String city;
    private String educationLevel;
    private String currentProfession;
    private String caste;
    private String description;
    private List<String> photos;
    private String fatherProfession;
    private String motherProfession;
    private boolean isHoroscopeMatchingRequired;
    private String timestamp;
    





}
