package com.mycompany.javasalessystem.Repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.javasalessystem.Database.Database;
import com.mycompany.javasalessystem.Models.Client;
import com.mycompany.javasalessystem.Utils.Verifications;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class ClientRepository {

    private static final String FILE_NAME = "clients.json";

    private static ArrayList<Client> clients = new ArrayList<>();

    public static Client findById(String id) {
        for (Client client : clients) {
            if (client.getId().compareTo(id) == 0) {
                return client;
            }
        }

        return null;
    }
    
    public static Client findByCpf(String cpf) {
        for (Client client : clients) {
            if (client.getCpf().compareTo(cpf) == 0) {
                return client;
            }
        }

        return null;
    }

    public static Client create(String name, String cpf, String email, String phone, String cep) {
        if (Verifications.verifyName(name) == false) {
            System.out.println("Nome invalido");
            return null;
        }
        
        if (Verifications.verifyEmail(email) == false) {
            System.out.println("Email invalido");
            return null;
        }
        
        if (Verifications.verifyCPF(cpf) == false) {
            System.out.println("CPF invalido");
            return null;
        }
        
        String clientId = UUID.randomUUID().toString();

        Client client = new Client(clientId, name, cpf, email, phone, cep);

        clients.add(client);

        new ClientRepository().save();

        return client;
    }

    public static void read() {
        if (clients.isEmpty()){
            System.out.println("Ainda nao ha cliente cadastrado");
            System.out.println("-- ** --");
            return;
        }
        
        for (Client client : clients) {
            System.out.println("ID cliente: " + client.getId());
            System.out.println("Nome: " + client.getName());
            System.out.println("CPF: " + client.getCpf());
            System.out.println("Email: " + client.getEmail());
            System.out.println("Telefone: " + client.getPhone());
            System.out.println("Cep: " + client.getCep());
            System.out.println("-- ** --");
        }
    }

    public static Client update(String id, String name, String cpf, String email, String phone, String cep) {
        if (Verifications.verifyName(name) == false) {
            System.out.println("Nome invalido");
            return null;
        }
        
        if (Verifications.verifyEmail(email) == false) {
            System.out.println("Email invalido");
            return null;
        }
        
        Client client = findById(id);

        if (client == null) {
            return null;
        }

        client.setName(name);
        client.setCpf(cpf);
        client.setEmail(email);
        client.setPhone(phone);
        client.setCep(cep);

        new ClientRepository().save();

        return client;
    }
    
    public static void delete(String id) {
        Client client = findById(id);

        if (client == null) {
            System.out.println("Client nao encontrado no sistema");
        }

        clients.remove(client);

        new ClientRepository().save();
    }


    public void save() {
        Gson gson = new Gson();

        String json = gson.toJson(clients);

        Database.write(FILE_NAME, json);
    }

    public void load() {
        Gson gson = new Gson();

        String stringFile = Database.read(FILE_NAME);

        Type type = new TypeToken<ArrayList<Client>>() {
        }.getType();

        ArrayList<Client> clientsArray = gson.fromJson(stringFile, type);

        if (clientsArray != null) {
            clients = clientsArray;
        }
    }
}
