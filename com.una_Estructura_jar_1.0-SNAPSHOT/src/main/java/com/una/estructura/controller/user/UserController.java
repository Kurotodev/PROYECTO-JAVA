/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.estructura.controller.user;



import com.una.estructura.model.user.User;

import com.una.estructura.model.user.UserContainer;
import com.una.estructura.utilities.Validator;
import java.util.List;

/**
 *
 * @author Eddier Lopez
 */
public abstract class UserController implements LoginInterface,UserInterface{

    private Object ayoIngreso;
    private String carrera;

    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public boolean logout(String username) {
        return true;
    }

    @Override
    public String add(String[] data) {
        String response="Error: Usuario ya resgistrado previamente";
        if(Validator.isNumber(data[0])){
            if(!UserContainer.exist(data[0])){
                User user=new User(data);
                if(UserContainer.add(user)){
                    response="Usuario registrado exitosamente";
                }else{
                  response="Error: Error al registrar el usuario";  
                }
            }
        }else{
            response="Error: Tipos de datos incorrectos";
        }
        return response;
    }

    @Override
    public String update(String[] data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    

    public String[] getAdditionalData() {
        String[] additionalData = {this.carrera, String.valueOf(this.ayoIngreso)};
        return additionalData;
    }

    @Override
    public String[] find(String id) {
        User user=UserContainer.find(id);
        if(user!=null){
            String[] data={
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                
                
            };
            return data;
        }
        return null;
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[][] getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String[] getListOfClients(String id) {
        if(UserContainer.exist(id)){
            List clients=UserContainer.find(id).getListOfClients();
            String[] data=new String[clients.size()];
            int i=0;
            // for(Object c:clients){
                //Castear(convertir) a la clase cliente
                // Libro libro=(Libro)c;       
                // data[i]=libro.getName()+" "+libro.getLastName();
                data[i]= "hola";
                i++;
            // }
            return data;
        }
        return null;
    }
    
}
