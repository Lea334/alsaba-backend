package com.alsaba.backend.repository;

import com.alsaba.backend.model.Responsable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponsableRepository extends MongoRepository<Responsable,String> {
}
