package com.alsaba.backend.repository;

import com.alsaba.backend.model.Pays;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PaysRepository extends MongoRepository<Pays,String>{
    @Query(value="{}",
            fields="{_id : 1, " +
                    "nom_pays : 1  , " +
                    "code_pays :1 , " +
                    "devise_pays : 1 , " +
                    "designation_pays : 1 ," +
                    "capitale_pays : 1 , "+
                    "dateCreation_pays : 1 , "+
                    "dateModification_pays : 1}")
    List<Pays> findAll() ;
}
