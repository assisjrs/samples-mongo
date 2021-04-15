package com.assisjrs.samples.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExempleMongo {
    @Autowired
    RepositoryEntity repositoryEntity;

    @Bean
    public Entity qualquerNome() {
        Entity entity = new Entity();
        entity.setName("Teste");
        return repositoryEntity.save(entity);
    }

}
