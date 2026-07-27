package com.basics.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//Passager: passager
@Component("passager")
public class Passager {
    private Vehicle vehicle;

    //push model; spring container
    @Autowired
    public Passager(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void travel(){
        vehicle.move();
        System.out.println("Passager is traveling");
    }
}
