package com.andile.youtube.clone.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video,String> {
}
