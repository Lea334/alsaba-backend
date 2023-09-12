package com.alsaba.backend.service;

import com.alsaba.backend.model.Responsable;
import com.alsaba.backend.repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsableServiceImpl implements ResponsableService{

    @Autowired
    ResponsableRepository responsableRepository;

    @Override
    public Responsable create(Responsable responsable)
    {
        return responsableRepository.save(responsable);
    }

    @Override
    public Responsable update(Responsable responsable)
    {
        Optional<Responsable> foundedResponsable = responsableRepository.findById(responsable.getId());
        if(foundedResponsable.isPresent())
        {
            Responsable responsableToUpdate = foundedResponsable.get();

            responsableToUpdate.setId(responsable.getId());
            responsableToUpdate.setNom(responsable.getNom());
            responsableToUpdate.setPrenom(responsable.getPrenom());
            responsableToUpdate.setEmail(responsable.getEmail());
            responsableToUpdate.setTelephone(responsable.getTelephone());
            responsableToUpdate.setAdresse(responsable.getAdresse());
            responsableToUpdate.setDocuments(responsable.getDocuments());


            return  responsableRepository.save(responsableToUpdate);

        }
        else
        {
            return null;
        }
    }

    @Override
    public void deleteById(String id)
    {
        responsableRepository.deleteById(id);
    }

    @Override
    public List<Responsable> getAll() {
        return responsableRepository.findAll();
    }

    @Override
    public Optional<Responsable> getById(String id) {
        return responsableRepository.findById(id);
    }
}
