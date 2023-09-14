package com.alsaba.backend.controller;

import com.alsaba.backend.model.Ville;
import com.alsaba.backend.requestsMappeurs.PaysRequestType;
import com.alsaba.backend.service.interfaces.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@CrossOrigin(origins = "*" )
public class VilleController {

    @Autowired
    private VilleService villeService;

    @PostMapping("/ville")
    public ResponseEntity<Ville> createNewPays(@RequestBody Ville ville)
    {
        System.out.println("data : "+ville);
        Ville newVille = this.villeService.create(ville);
        System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        VilleRealtimeEvent.dispatcherNewAdd(newVille);
        return ResponseEntity.status(200).body(newVille);
    }

    @GetMapping("/ville")
    public ResponseEntity<List<Ville>> getAllPays() {
        return ResponseEntity.status(200).body(villeService.getAll());
    }

    @GetMapping("/ville/{id}")
    public ResponseEntity<Optional<Ville>> getPaysById(@PathVariable String id) {
        return ResponseEntity.status(200).body(villeService.getById(id));
    }


    @PutMapping("/ville")
    public  ResponseEntity<Ville> updatePays(@RequestBody Ville ville){
        Ville updatedVille = this.villeService.update(ville);
        System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        VilleRealtimeEvent.dispatcherUpdate(updatedVille);
        return ResponseEntity.status(200).body(updatedVille);
    }

    @DeleteMapping("/ville/{id}")
    public ResponseEntity<?> deletePays(@PathVariable String id)
    {
        this.villeService.deleteById(id);
        System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        VilleRealtimeEvent.dispatcherDelete(id);
        return ResponseEntity.status(200).body("");
    }
    @PostMapping("/ville/deleteMany")
    public ResponseEntity<?> deletePays(@RequestBody PaysRequestType data)
    {
        System.out.println("ids here : "+data.getIds());
        this.villeService.deleteByIdS(data.getIds());
        System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        VilleRealtimeEvent.dispatcherDeleteMany(data.getIds());
        return ResponseEntity.status(200).body("");
    }
}
