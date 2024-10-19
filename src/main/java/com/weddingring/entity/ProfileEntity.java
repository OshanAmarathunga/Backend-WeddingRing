package com.weddingring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity {
    @Id
    private String profileId;
    private String firstName;
    private String lastName;
    private String fullName;
    private String ethnicity;
    private String religion;
}
