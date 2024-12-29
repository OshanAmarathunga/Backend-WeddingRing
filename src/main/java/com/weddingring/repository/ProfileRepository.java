package com.weddingring.repository;

import com.weddingring.entity.ProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProfileRepository extends MongoRepository<ProfileEntity,String> {
    @Query("{'email':email}")
    boolean isEmailExist(String email);
}
