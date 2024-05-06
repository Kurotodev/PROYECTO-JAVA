/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.estructura.model.user;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Eddier Lopez
 */
public class UserContainer {
    private static Map<String,User> cUsers=new HashMap<>();
    public static boolean exist(String id){
       /* boolean flag=cUsers.containsKey(id);
        if(flag){
            return true;
        }else{
            return false;
        }*/
       return cUsers.containsKey(id);
    }
    public static User find(String id){
        User u=null;
        if(cUsers.containsKey(id)){
            u=cUsers.get(id);
        }
        return u;
    }
    /**
     Agregar usuario @param u -> Objeto de tipo User
     */
    public static boolean add(User u){
        if(!cUsers.containsKey(u.getId())){
            cUsers.put(u.getId(), u);
            return true;
        }
        return false;
    }
    public static boolean update(User u){
        return false;
    }
    public static boolean delete(String id){
        return false;
    }
}
