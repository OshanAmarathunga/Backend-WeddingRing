package com.weddingring.repository;

import com.weddingring.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users,Integer> {
    Users findByUsername(String username);
}
