package com.jeff.observer.service.impl;

import java.util.Random;

import com.jeff.observer.Auxiliaryservice;
import com.jeff.observer.Payload.Serv1Pay;
import com.jeff.observer.exception.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service1 implements Auxiliaryservice {


    @Override
    public Serv1Pay save(Object payload) {
        if(new Random().nextInt(10) > 7){
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