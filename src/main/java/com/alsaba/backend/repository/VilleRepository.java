package com.alsaba.backend.repository;

import com.alsaba.backend.model.Pays;
import com.alsaba.backend.model.Taux;
import com.alsaba.backend.model.Ville;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VilleRepository extends MongoRepository<Ville, String> {
    @Query(value="{}",
            fields="{_id : 1, " +
                    "nom_ville : 1  , " +
                    "dateCreation_ville : 1 , "+
                    "pays_id : 1  , " +
                    "dateModification_ville : 1}")
    List<Ville> findAll() ;
}
