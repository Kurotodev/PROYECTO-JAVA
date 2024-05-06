/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.una.estructura.controller.user;

/**
 *
 * @author Eddier Lopez
 */
public interface UserInterface {
    public String add(String []data);
    public String update(String []data);
    public String[] find(String id);
    public String delete(String id);
    public String[][] getAll();
    public String[] getListOfClients(String id);

    public String[] getAdditionalData(String id);
}
