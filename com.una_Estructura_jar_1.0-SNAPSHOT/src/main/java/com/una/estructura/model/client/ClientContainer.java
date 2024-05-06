/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.estructura.model.client;

import com.una.estructura.model.user.User;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Eddier Lopez
 */
public class ClientContainer {
    private static final Map<String,Client> cClients=
            new HashMap<>();
    public static boolean exist(String id){
        if(cClients.containsKey(id)){
            return true;
        }
        return false;
    }
    public static boolean add(Client c){
        if(!cClients.containsKey(c.getId())){
            cClients.put(c.getId(), c);
            return true;
        }
        return false;
    }
    /**
     *Metodo para relacionar cliente con usuario     
     */
    public static boolean addUserToClient(String idClient,User user){
        if(cClients.containsKey(idClient)){
            cClients.get(idClient).setUser(user);
            return true;
        }
        return false;
    }
    public static Client find(String id){
        if(cClients.containsKey(id)){
            return cClients.get(id);
        }
        return null;  
        
        
    }

    
    public static void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
