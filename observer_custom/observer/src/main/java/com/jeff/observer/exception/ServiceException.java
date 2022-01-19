package com.jeff.observer.exception;

import com.jeff.observer.Auxiliaryservice;

public class ServiceException extends RuntimeException{
    Auxiliaryservice servico;

    public ServiceException(Auxiliaryservice servico){
        this.servico = servico;
    }

    public Auxiliaryservice getService(){
        return this.servico;
    }
}
