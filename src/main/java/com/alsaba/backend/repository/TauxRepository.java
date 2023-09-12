package com.alsaba.backend.repository;

import com.alsaba.backend.model.Taux;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TauxRepository extends MongoRepository<Taux , String> {

}
