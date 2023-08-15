package com.alsaba.backend.repository;

import com.alsaba.backend.model.Pays;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PaysRepository extends MongoRepository<Pays,String>{
    Pays findByCode(int code) ;
}
