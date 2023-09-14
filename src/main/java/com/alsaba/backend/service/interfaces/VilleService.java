package com.alsaba.backend.service.interfaces;

import com.alsaba.backend.model.Ville;

import java.util.List;
import java.util.Optional;

public interface VilleService {
    Ville create(Ville ville);

    Ville update(Ville ville);

    void deleteByIdS(List<String> ids);

    void deleteById(String id);

    List<Ville> getAll();

    Optional<Ville> getById(String id);
}
