package com.alsaba.backend.service;

import com.alsaba.backend.model.Pays;
import com.alsaba.backend.model.Ville;
import com.alsaba.backend.repository.PaysRepository;
import com.alsaba.backend.repository.VilleRepository;
import com.alsaba.backend.service.interfaces.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class VilleServiceImpl implements VilleService {
    @Autowired
    private VilleRepository villeRepository;

    @Override
    public Ville create(Ville ville)
    {
        ville.setDateCreation_ville(LocalDateTime.now());
        ville.setDateModification_ville(LocalDateTime.now());
        return villeRepository.save(ville);
    }

    @Override
    public Ville update(Ville ville)
    {
        Optional<Ville> foundedVille = villeRepository.findById(ville.getId());
        if(foundedVille.isPresent())
        {
            Ville villeToUpdate = foundedVille.get();
            villeToUpdate.setId(ville.getId());
            villeToUpdate.setNom_ville(ville.getNom_ville());
            villeToUpdate.setDateModification_ville(LocalDateTime.now());
            villeToUpdate.setPays_id(ville.getPays_id());

            return  villeRepository.save(villeToUpdate);

        }
        else
        {
            return null;
        }

    }

    @Override
    public void deleteById(String id)
    {
        villeRepository.deleteById(id);
    }
    @Override
    public void deleteByIdS(List<String> ids){
        ids.forEach((id)->{
            villeRepository.deleteById(id);
        });
    }

    @Override
    public List<Ville> getAll() {
        return villeRepository.findAll();
    }

    @Override
    public Optional<Ville> getById(String id) {
        return villeRepository.findById(id);
    }

}
