package com.alsaba.backend.controller;

import com.alsaba.backend.model.Pays;
import org.apache.catalina.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;


@RestController()
@CrossOrigin(origins = "*" )
public class SubscribeController {

    static Map<String , SseEmitter> emmittersSubscribed = new HashMap<>();
    @RequestMapping( value = "/subscribe/" , consumes = MediaType.ALL_VALUE)
    public SseEmitter SubscribeToUpdate(@RequestParam String UserID){
        SseEmitter emitter =  RealTimeEvent.init(UserID) ;
        ResponseEntity.ok().body("success");
        return emitter ;
    }

    @RequestMapping(value = "/unsbubscribe/" , consumes = MediaType.ALL_VALUE)
    public void unSubscribe(@RequestParam String UserID){
        SseEmitter emitter = RealTimeEvent.unSubscribe(UserID);
        System.out.println("list of subscribed : "+emmittersSubscribed);
    }

}

