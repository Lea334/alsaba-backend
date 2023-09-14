package com.alsaba.backend.service;

import com.alsaba.backend.model.Pays;
import com.alsaba.backend.repository.PaysRepository;
import com.alsaba.backend.service.interfaces.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PaysServiceImpl implements PaysService {
    @Autowired
    private PaysRepository paysRepository;

    @Override
    public Pays create(Pays pays)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        pays.setDateCreation_pays(LocalDateTime.now());
        pays.setDateModification_pays(LocalDateTime.now());
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
            paysToUpdate.setNom_pays(pays.getNom_pays());
            paysToUpdate.setCode_pays(pays.getCode_pays());
            paysToUpdate.setDevise_pays(pays.getDevise_pays());
            paysToUpdate.setCapitale_pays(pays.getCapitale_pays());
            paysToUpdate.setDateModification_pays(LocalDateTime.now());
            //paysToUpdate.setDateCreation_pays(pays.getDateCreation_pays());

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
    public void deleteByIdS(List<String> ids){
        ids.forEach((id)->{
            paysRepository.deleteById(id);
        });
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
