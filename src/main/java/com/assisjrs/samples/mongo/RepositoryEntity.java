package com.assisjrs.samples.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface RepositoryEntity extends MongoRepository<Entity, String> {

}
