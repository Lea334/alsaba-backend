package com.alsaba.backend.controller;

import com.alsaba.backend.model.Pays;
import com.alsaba.backend.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@CrossOrigin(origins = "http://localhost:5173" )
@RestController()
public class PaysController {
    @Autowired
    private PaysService paysService;


    @PostMapping("/pays")
    public ResponseEntity<Pays> createNewPays(@RequestBody Pays pays)
    {
        Pays newPays = this.paysService.create(pays);
        System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        RealTimeEvent.dispatcher(newPays);
        return ResponseEntity.ok().body(newPays);
    }

    @GetMapping("/pays")
    public ResponseEntity<List<Pays>> getAllPays() {
        return ResponseEntity.ok().body(paysService.getAll());
    }

    @GetMapping("/pays/{id}")
    public ResponseEntity<Optional<Pays>> getPaysById(@PathVariable String id) {
        return ResponseEntity.ok().body(paysService.getById(id));
    }


    @PutMapping("/pays")
    public  ResponseEntity<Pays> updatePays(@RequestBody Pays pays){
            System.out.println(pays);
        return ResponseEntity.ok().body(this.paysService.update(pays));
    }

    @DeleteMapping("/pays/{id}")
    public HttpStatus deletePays(@PathVariable String id)
    {
       this.paysService.deleteById(id);
       return HttpStatus.OK;
    }
}
