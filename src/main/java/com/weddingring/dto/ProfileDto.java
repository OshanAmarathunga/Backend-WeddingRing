package com.weddingring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private String profileId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String ethnicity;
    private String religion;



}
