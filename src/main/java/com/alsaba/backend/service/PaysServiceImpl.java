package com.alsaba.backend.service;

import com.alsaba.backend.model.Pays;
import com.alsaba.backend.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaysServiceImpl implements PaysService{
    @Autowired
    private PaysRepository paysRepository;

    @Override
    public Pays create(Pays pays)
    {
        return paysRepository.save(pays);
    }

    @Override
    public Pays update(Pays pays)
    {
        Optional<Pays> foundedPays = paysRepository.findById(pays.getId());
        if(foundedPays.isPresent())
        {
            Pays paysToUpdate = foundedPays.get();

            paysToUpdate.setId(pays.getId());
            paysToUpdate.setNom(pays.getNom());
            paysToUpdate.setCode(pays.getCode());
            paysToUpdate.setDevise(pays.getDevise());
            paysToUpdate.setCapitale(pays.getCapitale());
            paysToUpdate.setFrais(pays.getFrais());
            paysToUpdate.setTaux_echange(pays.getTaux_echange());
            paysToUpdate.setResponsable(pays.getResponsable());

            return  paysRepository.save(paysToUpdate);

        }
        else
        {
            return null;
        }

    }

    @Override
    public void deleteById(String id)
    {
        paysRepository.deleteById(id);
    }

    @Override
    public List<Pays> getAll() {
        return paysRepository.findAll();
    }

    @Override
    public Optional<Pays> getById(String id) {
        return paysRepository.findById(id);
    }

}
