package com.jeff.observer.service.impl;

import java.util.ArrayList;

import com.jeff.observer.Auxiliaryservice;

import org.springframework.stereotype.Service;

@Service
public class ServiceManager {
    ArrayList<Auxiliaryservice> observados;

    public ServiceManager(){
        this.observados = new ArrayList<>();
    }

    public void subscribe(Auxiliaryservice... servicos){
        for(Auxiliaryservice servico : servicos){
            observados.add(servico);
        }
    }

    public void rollBacks(Auxiliaryservice servico){
        int index = observados.indexOf(servico);
        for(int i = index; i >= 0; i--){
            observados.get(i).rollback();
        }
    }

    // public void saveAll() {
    //     for(Auxiliaryservice servico : observados){
    //         servico.save(payload)
    //     }
    // }
}
