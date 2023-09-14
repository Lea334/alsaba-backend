package com.alsaba.backend.controller;


import com.alsaba.backend.model.Pays;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

import java.util.List;
import java.util.Map;

public class PaysRealTimeEvent {
    public  static  void dispatcherNewAdd(Pays newPays){
        for(Map.Entry<String, SseEmitter> entry : SubscribeController.emmittersSubscribed.entrySet()){
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data(newPays)
                        .name("ADDED-COUNTRY");
                entry.getValue().send(event);
            } catch (Exception ex) {
                System.out.println("Error sending update to emitter: " + ex);
                entry.getValue().completeWithError(ex);
            }
        }
    }
    public  static  void dispatcherUpdate(Pays updatedPays){
        for(Map.Entry<String, SseEmitter> entry : SubscribeController.emmittersSubscribed.entrySet()){
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data(updatedPays)
                        .name("UPDATED-COUNTRY");
                entry.getValue().send(event);
            } catch (Exception ex) {
                System.out.println("Error whend sending update to emitter: " + ex);
                entry.getValue().completeWithError(ex);
            }
        }
    }
    public  static  void dispatcherDelete(String id){
        for(Map.Entry<String, SseEmitter> entry : SubscribeController.emmittersSubscribed.entrySet()){
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data(id)
                        .name("DELETED-COUNTRY");
                entry.getValue().send(event);
            } catch (Exception ex) {
                System.out.println("Error whend sending delete to emitter: " + ex);
                entry.getValue().completeWithError(ex);
            }
        }
    }

    public  static  void dispatcherDeleteMany(List<String> ids){
        for(Map.Entry<String, SseEmitter> entry : SubscribeController.emmittersSubscribed.entrySet()){
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data(ids)
                        .name("DELETED-MANY-COUNTRY");
                entry.getValue().send(event);
            } catch (Exception ex) {
                System.out.println("Error whend sending delete to emitter: " + ex);
                entry.getValue().completeWithError(ex);
            }
        }
    }
}
