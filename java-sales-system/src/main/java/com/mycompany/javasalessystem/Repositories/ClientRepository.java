/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.javasalessystem.Database.Database;
import com.mycompany.javasalessystem.Models.Client;
import com.mycompany.javasalessystem.Utils.Verifications;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class ClientRepository implements Repository {

    private static final String FILE_NAME = "clients.json";

    private static ArrayList<Client> clients = new ArrayList<>();
    
    public ClientRepository() {
    }
    
    public static ArrayList<Client> getClients() {
        return clients;
    }
    
     public static String[] getListOfClients() {
        int size = clients.size();
        String[] listOfProducts = new String[size];
        int cont = 0;
       
        for(Client client: clients){
            listOfProducts[cont] = client.getId() + " - " + client.getName();
            System.out.println(client.getId() + " - " + client.getName());
            cont++;
        }
        
        return listOfProducts;
    }

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

    public static Client create(String name, String cpf, String email, String phone, String cep) throws Exception {
        if (!Verifications.verifyName(name)) {
            throw new Exception("Nome invalido");
        }
        
        if (!Verifications.verifyEmail(email)) {
            throw new Exception("Email invalido");
        }
        
        if (!Verifications.verifyCPF(cpf)) {
            throw new Exception("CPF invalido");
        }
        
        String clientId = UUID.randomUUID().toString();

        Client client = new Client(clientId, name, cpf, email, phone, cep);

        clients.add(client);

        new ClientRepository().save();

        return client;
    }
    
    public static void list() {
        if (clients.isEmpty()){
            System.out.println("Ainda nao ha clientes cadastrados");
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
    
    public static void find(String id) {
        Client client = findById(id);

        if(client == null){
            System.out.println("Cliente nao encontrado no sistema");
            return;
        }
        
        System.out.println("ID cliente: " + client.getId());
        System.out.println("Nome: " + client.getName());
        System.out.println("CPF: " + client.getCpf());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Telefone: " + client.getPhone());
        System.out.println("Cep: " + client.getCep());
        System.out.println("-- ** --");
    }

    public static Client update(String id, String name, String cpf, String email, String phone, String cep) throws Exception {
        if (!Verifications.verifyName(name)) {
            throw new Exception("Nome invalido");
        }
        
        if (!Verifications.verifyEmail(email)) {
            throw new Exception("Email invalido");
        }
        
        if (!Verifications.verifyCPF(cpf)) {
            throw new Exception("CPF invalido");
        }
        
        Client client = findById(id);

        if (client == null) {
            throw new Exception("Cliente nao encontrado no sistema");
        }

        client.setName(name);
        client.setCpf(cpf);
        client.setEmail(email);
        client.setPhone(phone);
        client.setCep(cep);

        new ClientRepository().save();

        return client;
    }
    
    public static void delete(String id) throws Exception {
        Client client = findById(id);

        if (client == null) {
            throw new Exception("Client nao encontrado no sistema");
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
