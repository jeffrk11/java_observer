package com.jeff.observer.controller;

import com.jeff.observer.Payload.Serv1Pay;
import com.jeff.observer.exception.ServiceException;
import com.jeff.observer.service.impl.Service1;
import com.jeff.observer.service.impl.Service2;
import com.jeff.observer.service.impl.ServiceManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    
    @Autowired
    Service1 serv1;
    @Autowired
    Service2 serv2;

    @Autowired
    ServiceManager manager;

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        manager.subscribe(  serv1,
                            serv2);
        try{
            Serv1Pay serv1Pay = serv1.save(null);
            Serv1Pay serv2Pay = serv2.save(null);
        }
        catch(ServiceException e){
            manager.rollBacks(e.getService());
        }

        return new ResponseEntity<String>("TOP",HttpStatus.ACCEPTED);
    }
}
