/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.estructura.model.client;

import com.una.estructura.model.user.EstudianteInterface;
import com.una.estructura.model.Person;
import com.una.estructura.model.user.User;

/**
 *
 * @author Eddier Lopez
 */


public class Client extends Person implements EstudianteInterface {

    public static void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private User user;  // Relación unidireccional
    private String carrera;
    private int ayoIngreso;
    
    public Client(String[] data) {
        this.setId(data[0]);
        this.setName(data[1]);
        this.setLastName(data[2]);
        this.setEmail(data[3]);
        
        
        if (data.length >= 6) {
            this.carrera = data[4];
            this.ayoIngreso = Integer.parseInt(data[5]);
        }
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
     public String getCarrera() {
        return carrera;
    }

    
    public int getAyoIngreso() {
        return ayoIngreso;
    }

 public void setAyoIngreso(int ayoIngreso) {
    this.ayoIngreso = ayoIngreso;
}

@Override
public void setCarrera(String carrera) {
    this.carrera = carrera;
}

    
}
