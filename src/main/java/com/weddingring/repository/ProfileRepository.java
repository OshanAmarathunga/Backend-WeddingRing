package com.weddingring.repository;

import com.weddingring.entity.ProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<ProfileEntity,String> {
}
