package com.alsaba.backend.controller;

import com.alsaba.backend.model.Responsable;
import com.alsaba.backend.service.interfaces.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ResponsableController
{
    @Autowired
    ResponsableService responsableService;


    @PostMapping("/responsable")
    public ResponseEntity<Responsable> createNewResponsable(@RequestBody Responsable responsable)
    {
        return ResponseEntity.ok().body(this.responsableService.create(responsable));
    }

    @GetMapping("/responsable")
    public ResponseEntity<List<Responsable>> getAllResponsable() {
        return ResponseEntity.ok().body(responsableService.getAll());
    }

    @GetMapping("/responsable/{id}")
    public ResponseEntity<Optional<Responsable>> getResponsableById(@PathVariable String id) {
        return ResponseEntity.ok().body(responsableService.getById(id));
    }


    @PutMapping("/responsable")
    public  ResponseEntity<Responsable> updateResponsable(@RequestBody Responsable responsable){
        return ResponseEntity.ok().body(this.responsableService.update(responsable));
    }

    @DeleteMapping("/responsable/{id}")
    public HttpStatus deleteResponsable(@PathVariable String id)
    {
        this.responsableService.deleteById(id);
        return HttpStatus.OK;
    }
}
