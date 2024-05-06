/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.estructura.model.user;

import com.una.estructura.model.Person;
import com.una.estructura.model.libro.Libro;
import java.util.ArrayList;



/**
 *
 * @author Eddier Lopez
 */
public class User extends Person{
    private String username;
    private String password;
    //ELEMENTO PARA RELACIÓN BI-DIRECCIONAL
    private ArrayList<Libro> listOfClients;
    private String tipoE;
    
    public User(String[] data){
        this.setId(tipoE);
        this.setId(data[0]);
        this.setName(data[1]);
        this.setLastName(data[2]);
        this.setEmail(data[3]);
        this.username=data[4];
        this.password=data[5];
        this.listOfClients=new ArrayList<>();
    }
    

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the listOfClients
     */
    public ArrayList<Libro> getListOfClients() {
        return listOfClients;
    }

    /**
     * @return the tipoE
     */
    public String getTipoE() {
        return tipoE;
    }

    /**
     * @param tipoE the tipoE to set
     */
    public void setTipoE(String tipoE) {
        this.tipoE = tipoE;
    }
    
    
    
}
