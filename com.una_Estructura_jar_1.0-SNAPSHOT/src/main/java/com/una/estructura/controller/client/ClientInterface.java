/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.una.estructura.controller.client;

/**
 *
 * @author Eddier Lopez
 */
public interface ClientInterface {
    public String add(String data[]);
    public String update(String[] data);
    public String[] find(String id);
    public String delete(String id);
    public String addUserToClient(String idClient,String idUser);

    public String update(String idModificar, String[] newData);
}
