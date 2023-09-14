package com.alsaba.backend.controller;

import com.alsaba.backend.model.Pays;
import com.alsaba.backend.requestsMappeurs.PaysRequestType;
import com.alsaba.backend.service.interfaces.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController()
@CrossOrigin(origins = "*" )
public class PaysController {
    @Autowired
    private PaysService paysService;


    @PostMapping("/pays")
    public ResponseEntity<Pays> createNewPays(@RequestBody Pays pays)
    {
        Pays newPays = this.paysService.create(pays);
        System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        PaysRealTimeEvent.dispatcherNewAdd(newPays);
        return ResponseEntity.ok().body(newPays);
    }

    @GetMapping("/pays")
    public ResponseEntity<List<Pays>> getAllPays() {
        System.out.println("hello");
        return ResponseEntity.ok().body(paysService.getAll());
    }

    @GetMapping("/pays/{id}")
    public ResponseEntity<Optional<Pays>> getPaysById(@PathVariable String id) {
        return ResponseEntity.ok().body(paysService.getById(id));
    }


    @PutMapping("/pays")
    public  ResponseEntity<Pays> updatePays(@RequestBody Pays pays){
        Pays updatedPays = this.paysService.update(pays);
        System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        PaysRealTimeEvent.dispatcherUpdate(updatedPays);
        return ResponseEntity.ok().body(updatedPays);
    }

    @DeleteMapping("/pays/{id}")
    public HttpStatus deletePays(@PathVariable String id)
    {
       this.paysService.deleteById(id);
        System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        PaysRealTimeEvent.dispatcherDelete(id);
       return HttpStatus.OK;
    }
    @PostMapping("/pays/deleteMany")
    public HttpStatus deletePays(@RequestBody PaysRequestType data)
    {
        System.out.println("ids here : "+data.getIds());
       this.paysService.deleteByIdS(data.getIds());
        System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        PaysRealTimeEvent.dispatcherDeleteMany(data.getIds());
       return HttpStatus.OK;
    }
}
