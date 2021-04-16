package com.assisjrs.samples.mongo.repository;

import com.assisjrs.samples.mongo.Entity.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends MongoRepository<Livro, String> {
}
