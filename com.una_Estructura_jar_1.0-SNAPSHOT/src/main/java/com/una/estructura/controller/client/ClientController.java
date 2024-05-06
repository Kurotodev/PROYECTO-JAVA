package com.una.estructura.controller.client;

import com.una.estructura.model.client.*;
import com.una.estructura.model.user.UserContainer;

public abstract class ClientController implements ClientInterface {

    @Override
    public String add(String[] data) {
        String response = "Error: Cliente ya existe";
        if (!ClientContainer.exist(data[0])) {
            Client client = new Client(data);
            if (ClientContainer.add(client)) {
                response = "Cliente agregado correctamente";
            } else {
                response = "Error: No se pudo agregar el cliente";
            }
        }
        return response;
    }

    @Override
    public String update(String[] data) {
        if (data.length < 1) {
            return "Error: Datos insuficientes para la actualización";
        }
        String clientId = data[0]; // Suponiendo que el primer elemento del array es el ID del cliente
        if (ClientContainer.exist(clientId)) {
            Client client = ClientContainer.find(clientId);
            client.setName(data[1]);
            client.setLastName(data[2]);
            client.setEmail(data[3]);
            // Verificar si hay datos adicionales para actualizar (carrera y año de ingreso)
            if (data.length >= 6) {
                client.setCarrera(data[4]);
                client.setAyoIngreso(Integer.parseInt(data[5]));
            }
            return "Cliente actualizado correctamente";
        } else {
            return "Error: El cliente no existe";
        }
    }

    @Override
    public String[] find(String id) {
        if (ClientContainer.exist(id)) {
            Client client = ClientContainer.find(id);
            String user;
            if (client.getUser() == null) {
                user = "NO ASIGNADO";
            } else {
                user = client.getUser().getName() + " " + client.getUser().getLastName();
            }

            String[] data = {
                client.getId(),
                client.getName(),
                client.getLastName(),
                client.getEmail(),
                user
            };
            return data;
        }
        return null;
    }

    @Override
    public String delete(String id) {
        if (ClientContainer.exist(id)) {
            Client.delete(id);
            return "Cliente eliminado correctamente";
        } else {
            return "Error: El cliente no existe";
        }
    }

    @Override
    public String addUserToClient(String idClient, String idUser) {
        String response = "Error al asignar el usuario";
        if (ClientContainer.exist(idClient)) {
            if (UserContainer.exist(idUser)) {
                ClientContainer.addUserToClient(idClient,
                        UserContainer.find(idUser));
                response = "Asignación satisfactoria";
            }
        }
        return response;
    }
}
