/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.una.estructura.controller.libro;

import com.una.model.libro.Libro;



public interface LibroInterface {
  
    
    String add(String[] data);
    String update(String id, String[] newData);
    Libro find(String id);
    String delete(String id);
    String[][] getAll();
    
  
}
