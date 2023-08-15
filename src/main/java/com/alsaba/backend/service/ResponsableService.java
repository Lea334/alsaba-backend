package com.alsaba.backend.service;

import com.alsaba.backend.model.Responsable;

import java.util.List;
import java.util.Optional;

public interface ResponsableService {

    Responsable create(Responsable responsable);

    Responsable update(Responsable responsable);

    void deleteById(String id);

    List<Responsable> getAll();

    Optional<Responsable> getById(String id);
}
