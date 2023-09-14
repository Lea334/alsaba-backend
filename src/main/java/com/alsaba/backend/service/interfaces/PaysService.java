package com.alsaba.backend.service.interfaces;

import com.alsaba.backend.model.Pays;

import java.util.List;
import java.util.Optional;

public interface PaysService {
    Pays create(Pays pays);

    Pays update(Pays pays);

    void deleteByIdS(List<String> ids);

    void deleteById(String id);

    List<Pays> getAll();

    Optional<Pays> getById(String id);

}
