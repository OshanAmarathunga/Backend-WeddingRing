package com.weddingring.repository;

import com.weddingring.entity.ProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProfileRepository extends MongoRepository<ProfileEntity,String> {
    boolean existsByEmail(String email);
}
