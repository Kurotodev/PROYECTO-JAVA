/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.estructura;

public class Estudiante {
    private String carrera;
    private int ayoIngreso;

    public Estudiante(String carrera, int ayoIngreso) {
        this.carrera = carrera;
        this.ayoIngreso = ayoIngreso;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getAyoIngreso() {
        return ayoIngreso;
    }

    public void setAyoIngreso(int ayoIngreso) {
        this.ayoIngreso = ayoIngreso;
       
    }
    
     public String[] getAdditionalData() {
        String[] additionalData = {this.carrera, String.valueOf(this.ayoIngreso)};
        return additionalData;
    }
}
