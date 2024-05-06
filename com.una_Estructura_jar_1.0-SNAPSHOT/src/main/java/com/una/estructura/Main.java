package com.una.estructura;

import com.una.estructura.controller.client.ClientController;
import com.una.estructura.controller.client.ClientInterface;

import com.una.estructura.controller.libro.LibroController;
import com.una.estructura.controller.libro.LibroInterface;



import com.una.estructura.controller.user.LoginInterface;
import com.una.estructura.controller.user.UserController;
import com.una.estructura.controller.user.UserInterface;
import com.una.estructura.view.UI;
import com.una.model.libro.Libro;

public class Main {

    public static void main(String[] args) {
        if (login()) {
            runMenu();
        }
    }

    private static boolean login() {
        String user = UI.input("Usuario");
        String password = UI.input("Contraseña");
        LoginInterface login = new UserController() {
            @Override
            public String[] getAdditionalData(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        return login.login(user, password);
    }

    private static void runMenu() {
        int opt;
        String menuOptions[] = {
            "Módulo de usuarios",
            "Módulo de clientes",
            "Salir del sistema"
        };
        do {
            opt = UI.menu("Menu principal", menuOptions);
            switch (opt) {
                case 0:
                    userModule();
                    break;
                case 1:
                    clientModule();
                    break;
                case 2:
                    UI.println("Saliendo del sistema");
                    break;
                default:
                    UI.println("Opción no válida");
                    break;
            }
        } while (opt != 2);
    }

    private static void userModule() {
        UserInterface user = new UserController() {
            @Override
            public String[] getAdditionalData(String id) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        int opt;
     
        String menuOptions[] = {
            "Agregar",
            "Buscar",
            "Modificar",
            "Eliminar",
           // "Listar todos",
            //"Listar clientes por usuario",
            "Regresar al menu principal"
        };
        do {
            opt = UI.menu("Módulo de usuarios", menuOptions);
            switch (opt) {
                case 0:
                    addUser(user);
                    break;
                case 1:
                    searchUser(user);
                    break;
                default:
                    UI.println("Opción no válida");
                    break;
            }
        } while (opt != menuOptions.length - 1);
    }

    private static void addUser(UserInterface user) {
        String[] data = {
            "Cedula",
            "Nombre",
            "Apellidos",
            "Correo",
            "Nombre de usuario",
            "Contraseña"
        };
        data = UI.inputs("Datos del usuario", data);
        String userType = UI.input("Tipo de usuario (estudiante, profesor, administrativo)");
        String response;
        if (userType.equalsIgnoreCase("estudiante")) {
            String[] additionalData = {
                "Carrera",
                "Año de ingreso"
            };
            String[] studentData = UI.inputs("Datos adicionales del estudiante", additionalData);
            String[] combinedData = new String[data.length + studentData.length];
            System.arraycopy(data, 0, combinedData, 0, data.length);
            System.arraycopy(studentData, 0, combinedData, data.length, studentData.length);
            response = user.add(combinedData);
        } else {
            response = user.add(data);
        }
        UI.println(response);
    }
  


        

    private static void searchUser(UserInterface user) {
       String id = UI.input("Ingrese la cedula a buscar");
String[] result = user.find(id);
if (result != null) {
    UI.println("=====Datos del usuario=====");
    UI.println("Cedula: " + result[0]);
    UI.println("Nombre: " + result[1]);
    UI.println("Apellidos: " + result[2]);
    UI.println("Correo: " + result[3]);
    
    if (result[4].equalsIgnoreCase("estudiante")) {
        String[] additionalData = user.getAdditionalData(id);
        if (additionalData != null) {
            UI.println("Tipo: Estudiante");
            UI.println("Carrera: " + additionalData[0]);
            UI.println("Año de ingreso: " + additionalData[1]);
        }
    } else {
        UI.println("Tipo: " + result[4]); // Si no es estudiante, imprime el tipo de usuario
    }
} else {
    UI.println("Usuario no encontrado");
}

    }
    
    
    
    
    

    private static void clientModule() {
        ClientInterface client = new ClientController() {
            @Override
            public String update(String idModificar, String[] newData) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        int opt;
    
        String[] Menu = {
            "Agregar",
            "Buscar",
            "Modificar",
            "Eliminar",
            "Asignar usuario",
            "Volver al menú principal"
        };
        do {
            opt = UI.menu("Módulo de clientes", Menu);
            switch (opt) {
                case 0:
                    agregarCliente(client);
                    break;
                case 1:
                    buscarCliente(client);
                    break;
                default:
                    UI.println("Opción no válida");
                    break;
            }
        } while (opt != Menu.length - 1);
    }

    private static void agregarCliente(ClientInterface client) {
        String[] data = {
            "Cedula",
            "Nombre",
            "Apellidos",
            "Correo"
        };
        data = UI.inputs("Datos del cliente", data);
        String response = client.add(data);
        UI.println(response);
    }

    private static void buscarCliente(ClientInterface client) {
        String[] result = client.find(UI.input("Ingrese la cédula"));
        if (result != null) {
            UI.println("=====Datos del cliente=====");
            for (String c : result) {
                UI.println(c);
            }
        } else {
            UI.println("Cliente no existe");
        }
    }
    
    
    
    ////
  private static void LibroModule() {
    LibroInterface libroint = new LibroController();
    int opt;
    String response;
    String[] menuOptions = {
        "Agregar",
        "Buscar",
        "Modificar",
        "Eliminar",
        "Volver al menú principal"
    };
    do {
        opt = UI.menu("Módulo de libros", menuOptions);
        switch (opt) {
            case 0:
                agregarLibro(libroint);
                break;
            case 1:
                buscarLibro(libroint);
                break;
            // Agregar más casos según sea necesario para modificar, eliminar, etc.
            default:
                UI.println("Opción no válida");
                break;
        }
    } while (opt != menuOptions.length - 1);
}

private static void agregarLibro(LibroInterface libroInterface) {
    String[] data = {
        "Título",
        "Autor",
        "Año de publicación",
        "Género",
        "Editorial",
        "Disponibilidad (true/false)"
    };
    data = UI.inputs("Datos del libro", data);
    String response = libroInterface.add(data);
    UI.println(response);
}

private static void buscarLibro(LibroInterface libroInterface) {
    String id = UI.input("Ingrese el ID del libro a buscar");
    Libro libro = libroInterface.find(id);
    if (libro != null) {
        UI.println("=====Datos del libro=====");
        UI.println("ID: " + libro.getId());
        UI.println("Título: " + libro.getTitulo());
        UI.println("Autor: " + libro.getAutor());
        // Agregar más campos según sea necesario
    } else {
        UI.println("Libro no encontrado");
    }
}
}