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
import com.mycompany.javasalessystem.Models.Seller;
import com.mycompany.javasalessystem.Utils.Verifications;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class SellerRepository {
    private static final String FILE_NAME = "sellers.json";

    private static ArrayList<Seller> sellers = new ArrayList<>();
    
    public static ArrayList<Seller> getSellers() {
        return sellers;
    }
    
    public static Seller findById(String id){
        for(Seller seller: sellers){
            if(seller.getId().compareTo(id) == 0){
                return seller;
            }
        }
        
        return null;
    }
    
    public static Seller create(String name, String email, String password, String occupation) {
        if (Verifications.verifyName(name) == false) {
            System.out.println("Nome invalido");
            return null;
        }
        
        if (Verifications.verifyEmail(email) == false) {
            System.out.println("Email invalido");
            return null;
        }
        
        if (password.length() < 8) {
            System.out.println("Senha deve ter no minimo 8 caracteres");
            return null;
        }
        
        String sellerId = UUID.randomUUID().toString();
        
        Seller seller = new Seller(sellerId, name, email, password, occupation);
        
        sellers.add(seller);
        
        new SellerRepository().save();
        
        return seller;
    }
    
    public static void list(){
        if (sellers.isEmpty()){
            System.out.println("Ainda nao ha funcionario cadastrado");
            System.out.println("-- ** --");
        }
        
        for(Seller seller: sellers){
            System.out.println("ID seller: "+seller.getId());
            System.out.println("Nome: "+seller.getName());
            System.out.println("Email: "+seller.getEmail());
            System.out.println("Senha: "+seller.getPassword()); 
            System.out.println("Occupation: "+seller.getOccupation());
            System.out.println("-- ** --");
        }
    }
    
    public static void find(String id){
        Seller seller = findById(id);
        
        if(seller == null){
            System.out.println("Funcionario nao encontrado no sistema");
            return;
        }
        
        System.out.println("ID seller: "+seller.getId());
        System.out.println("Nome: "+seller.getName());
        System.out.println("Email: "+seller.getEmail());
        System.out.println("Senha: "+seller.getPassword()); 
        System.out.println("Occupation: "+seller.getOccupation());
        System.out.println("");
    }
    
    public static Seller update(String id, String name, String email, String password, String occupation){
        if (Verifications.verifyEmail(email) == false) {
            System.out.println("Email invalido");
            return null;
        }
        
        if (password.length() < 8) {
            System.out.println("Senha deve ter no minimo 8 caracteres");
            return null;
        }
        
        Seller seller = findById(id);
        
        if (seller == null) {
            return null;
        }
        
        seller.setName(name);
        seller.setEmail(email);
        seller.setPassword(password); 
        seller.setOccupation(occupation);
        
        new SellerRepository().save();
        
        return seller;
    }

    public static void delete(String id){
        Seller seller = findById(id);
        
        if(seller == null){
            System.out.println("Funcionario nao encontrado no sistema");
            return;
        }
        
        sellers.remove(seller);
        
        new SellerRepository().save();
    }
    
    public void save() {
        Gson gson = new Gson();

        String json = gson.toJson(sellers);

        Database.write(FILE_NAME, json);
    }

    public void load() {
        Gson gson = new Gson();

        String stringFile = Database.read(FILE_NAME);

        Type type = new TypeToken<ArrayList<Seller>>() {
        }.getType();

        ArrayList<Seller> sellersArray = gson.fromJson(stringFile, type);

        if (sellersArray != null) {
            sellers = sellersArray;
        }
    }
}