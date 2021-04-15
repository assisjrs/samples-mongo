package com.assisjrs.samples.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Entity {
    @Id
    public String codigoBarra;

    public String name;
}
