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
import com.mycompany.javasalessystem.Utils.Encrypt;
import com.mycompany.javasalessystem.Utils.Verifications;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class SellerRepository implements Repository{
    private static final String FILE_NAME = "sellers.json";

    private static ArrayList<Seller> sellers = new ArrayList<>();
    
    public SellerRepository() {
    }
    
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
    
    public static Seller create(String name, String email, String password, String occupation, String cpf) throws Exception {
        if (!Verifications.verifyName(name)) {
            throw new Exception("Nome invalido");
        }
        
        if (!Verifications.verifyEmail(email)) {
            throw new Exception("Email invalido");
        }
        
        if (password.length() < 8) {
            throw new Exception("Senha deve ter no minimo 8 caracteres");
        }
        
        if (!Verifications.verifyCPF(cpf)) {
            throw new Exception("CPF invalido");
        }
        
        String sellerId = UUID.randomUUID().toString();
        
        Seller seller = new Seller(sellerId, name, email, password, occupation, cpf);
        
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
            System.out.println("CPF: "+seller.getCpf());
            System.out.println("-- ** --");
        }
    }
    
    public static void find(String id) throws Exception{
        Seller seller = findById(id);
        
        if(seller == null){
            throw new Exception("Funcionario nao encontrado no sistema");
        }
        
        System.out.println("ID seller: "+seller.getId());
        System.out.println("Nome: "+seller.getName());
        System.out.println("Email: "+seller.getEmail());
        System.out.println("Senha: "+seller.getPassword()); 
        System.out.println("Occupation: "+seller.getOccupation());
        System.out.println("CPF: "+seller.getCpf());
        System.out.println("");
    }
    
    public static Seller update(String id, String name, String email, String password, String occupation, String cpf) throws Exception{
        Seller seller = findById(id);
        
        if(seller == null){
            throw new Exception("Funcionario nao encontrado no sistema");
        }
        
        if (!Verifications.verifyName(name)) {
            throw new Exception("Nome invalido");
        }
        
        if (!Verifications.verifyEmail(email)) {
            throw new Exception("Email invalido");
        }
        
        if (password.length() < 8) {
            throw new Exception("Senha deve ter no minimo 8 caracteres");
        }
        
        if (!Verifications.verifyCPF(cpf)) {
            throw new Exception("CPF invalido");
        }
        
        String encryptPassword = Encrypt.hashMD5(password);
        
        seller.setName(name);
        seller.setEmail(email);
        seller.setPassword(encryptPassword); 
        seller.setOccupation(occupation);
        seller.setCpf(cpf);
        
        new SellerRepository().save();
        
        return seller;
    }

    public static void delete(String id) throws Exception{
        Seller seller = findById(id);
        
        if(seller == null){
            throw new Exception("Funcionario nao encontrado no sistema");
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