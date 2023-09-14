package com.alsaba.backend.controller;

import com.alsaba.backend.model.Ville;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.Map;

public class VilleRealtimeEvent {
    public  static  void dispatcherNewAdd(Ville newVille){
        for(Map.Entry<String, SseEmitter> entry : SubscribeController.emmittersSubscribed.entrySet()){
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data(newVille)
                        .name("ADDED-VILLE");
                entry.getValue().send(event);
            } catch (Exception ex) {
                System.out.println("Error sending update to emitter: " + ex);
                entry.getValue().completeWithError(ex);
            }
        }
    }
    public  static  void dispatcherUpdate(Ville updatedVille){
        for(Map.Entry<String, SseEmitter> entry : SubscribeController.emmittersSubscribed.entrySet()){
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data(updatedVille)
                        .name("UPDATED-VILLE");
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
                        .name("DELETED-VILLE");
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
                        .name("DELETED-MANY-VILLE");
                entry.getValue().send(event);
            } catch (Exception ex) {
                System.out.println("Error whend sending delete to emitter: " + ex);
                entry.getValue().completeWithError(ex);
            }
        }
    }

}
