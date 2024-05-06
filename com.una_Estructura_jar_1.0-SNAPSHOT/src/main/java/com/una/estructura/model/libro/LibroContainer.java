/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.una.model.libro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibroContainer extends Libro{
    private static final  Map<String ,Libro> libros =
                  new HashMap<>();
    
    public static boolean exist(String id){
        if(libros.containsKey(id)){
        return true;
    }
    return false;
    }

    public static boolean add(Libro c){
        if(!libros.containsKey(c.getId())){
            libros.put(c.getId(), c);
            return true;
        }
        return false;
    }
    
     public static List<Libro> findByAutor(String autor) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros.values()) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    // Método para buscar libros por título
    public static Libro findByTitulo(String titulo) {
        for (Libro libro : libros.values()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null; // Si no se encuentra ningún libro con el título dado
    }

    // Método para buscar libros por género
    public static List<Libro> findByGenero(String genero) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : libros.values()) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }
    public static Libro find(String tipo, String query) {
        switch (tipo.toLowerCase()) {
            case "autor":
                for (Libro libro : libros.values()) {
                    if (libro.getAutor().equalsIgnoreCase(query)) {
                        return libro;
                    }
                }
                break;
            case "nombre":
                return libros.get(query); // Búsqueda por título
            case "género":
                for (Libro libro : libros.values()) {
                    if (libro.getGenero().equalsIgnoreCase(query)) {
                        return libro;
                    }
                }
                break;
            default:
                // Tipo de búsqueda no válido
                return null;
        }
        return null; // No se encontró ningún libro que coincida con el criterio de búsqueda
    }
    
   public static Libro find(String id) {
    if (libros.containsKey(id)) {
        return libros.get(id);
    }
    return null;   
}

    
    
    
    public static boolean update(String id, Libro newData) {
        // Implementar lógica para actualizar un libro en la lista
        return false;
    }
    
    public static boolean delete(String id) {
        // Implementar lógica para eliminar un libro de la lista
        return false;
    }
    
    public static List<Libro> getAll() {
        // Implementar lógica para obtener todos los libros en la lista
        return (List<Libro>) libros;
    }

    public LibroContainer(String id, String titulo, String autor, int ayoPublicacion, String genero, String editorial, boolean disponible) {
        super(id, titulo, autor, ayoPublicacion, genero, editorial, disponible);
    }
}

