package com.jeff.observer.service.impl;

import java.util.Random;

import com.jeff.observer.Auxiliaryservice;
import com.jeff.observer.Payload.Serv1Pay;
import com.jeff.observer.exception.ServiceException;

import org.springframework.stereotype.Service;

@Service
public class Service2 implements Auxiliaryservice {


    @Override
    public Serv1Pay save(Object payload) {
        if(new Random().nextInt(10) > 2){
            throw new ServiceException(this);
        }else{
            return new Serv1Pay();
        }
    }

    @Override
    public void rollback() {
        System.out.println(this.getClass().getSimpleName() + "DEI ROLLBACK");
    }
    
}