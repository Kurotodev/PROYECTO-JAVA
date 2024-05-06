package com.una.estructura.controller.libro;

import com.una.model.libro.*;
import com.una.model.libro.LibroContainer;

public abstract class LibroController implements LibroInterface {

    @Override
    public String add(String[] data) {
        String response = "Error: libro ya existe";
        if (!LibroContainer.exist(data[0])) {
            Libro libro = new Libro(data);
            if (LibroContainer.add(libro)) {
                response = "Libro agregado correctamente";
            } else {
                response = "Error: No se pudo agregar el Libro";
            }
        }
        return response;
    }

    
    public String update(String[] data) {
        if (data.length < 1) {
            return "Error: Datos insuficientes para la actualización";
        }
        String libroId = data[0];
        if (LibroContainer.exist(libroId)) {
            Libro libro = LibroContainer.find(libroId);
            libro.setTitulo(data[1]);
            libro.setAutor(data[2]);
            libro.setGenero(data[3]);
            libro.setEditorial(data[4]);
            boolean disponible = Boolean.parseBoolean(data[5]);
        libro.setDisponible(disponible);
            
            return "Libro actualizado correctamente";
        } else {
            return "Error: El libro no existe";
        }
    }

    @Override
    public String delete(String id) {
        if (LibroContainer.exist(id)) {
            LibroContainer.delete(id);
            return "Libro eliminado correctamente";
        } else {
            return "Error: El libro no existe";
        }
    }

    // Método find ajustado según la estructura actual de LibroContainer
    public static Libro find(String tipo, String query) {
    switch (tipo.toLowerCase()) {
        case "autor":
            return LibroContainer.findByAutor(query).get(0); // Suponiendo que deseas devolver el primer libro encontrado por autor
        case "nombre":
            return LibroContainer.findByTitulo(query);
        case "género":
            return LibroContainer.findByGenero(query).get(0); // Suponiendo que deseas devolver el primer libro encontrado por género
        default:
            return null;
    }
}

}
