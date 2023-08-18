package com.alsaba.backend.controller;


import com.alsaba.backend.model.Pays;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

import java.util.Map;

public class RealTimeEvent {
    public  static  void dispatcher(Pays newPays){
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

    public static SseEmitter init(String UserID){
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
        try {
            //add new subscriber if it's not existe
            if(!SubscribeController.emmittersSubscribed.containsKey(UserID)){
                emitter.send(SseEmitter.event().name("INIT").data("subscribed successfully"));
                SubscribeController.emmittersSubscribed.put(UserID , emitter);
                System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
            }else{
                //close connexion if the emitter is not added
                if(!SubscribeController.emmittersSubscribed.containsValue(emitter)){
                    SseEmitter oldEmitter = SubscribeController.emmittersSubscribed.get(UserID);
                    System.out.println("old value  : "+oldEmitter);
                    System.out.println("new value : "+emitter);
                    oldEmitter.complete();
                    SubscribeController.emmittersSubscribed.put(UserID , emitter);
                    emitter.send(SseEmitter.event().name("REINIT").data("re-subscription  successfully"));
                }else{
                    System.out.println("value existe : "+emitter);
                    emitter.send(SseEmitter.event().name("REINIT").data("re-subscription  successfully"));
                }
            }
        }catch (IOException e){
            SubscribeController.emmittersSubscribed.remove(emitter);
            emitter.completeWithError(e);
        }

        //remove subscriber if connexion is closed | timout | error
        emitter.onCompletion(()->{
            System.out.println("connexion closed : "+emitter);
            SubscribeController.emmittersSubscribed.remove(emitter);
            System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        });
        emitter.onTimeout(()->{
            SubscribeController.emmittersSubscribed.remove(emitter);
            System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        });
        emitter.onError((e)->{
            SubscribeController.emmittersSubscribed.remove(emitter);
            System.out.println("list of subscriber : "+SubscribeController.emmittersSubscribed);
        });

        return  emitter ;
    }

    public  static SseEmitter unSubscribe(String UserID){
        SseEmitter emiiterRemoved = SubscribeController.emmittersSubscribed.remove(UserID) ;
        emiiterRemoved.complete();
        return emiiterRemoved ;
    }
}
