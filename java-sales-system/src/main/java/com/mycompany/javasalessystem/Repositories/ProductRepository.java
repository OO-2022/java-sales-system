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
import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Utils.Verifications;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class ProductRepository implements Repository {

    private static final String FILE_NAME = "products.json";

    private static ArrayList<Product> products = new ArrayList<>();

    public ProductRepository() {
    }
    
    public static ArrayList<Product> getProducts() {
        return products;
    }
    
     public static String[] getListOfProducts() {
        int size = products.size();
        String[] listOfProducts = new String[size];
        int cont = 0;
       
        for(Product product: products){
            listOfProducts[cont] = product.getId() + " - " + product.getName();
            System.out.println(product.getId() + " - " + product.getName());
            cont++;
        }
        
        return listOfProducts;
    }
    
    public static Product findById(String id){
        for(Product product: products){
            if(product.getId().compareTo(id) == 0){
                return product;
            }
        }

        return null;
    }

    public static Product create(String name, double price, int quantity) throws Exception {
        if (!Verifications.verifyName(name)) {
            throw new Exception("Nome invalido");
        }
        
        if (quantity < 0) {
            throw new Exception("Quantidade invalida");
        }
        
        if (price < 0) {
            throw new Exception("Preco invalido");
        }

        String productId = UUID.randomUUID().toString();
        Product product = new Product(productId, name, price, quantity);

        products.add(product);

        new ProductRepository().save();

        return product;
    }

    public static void list(){
        if (products.isEmpty()){
            System.out.println("Ainda nao ha produtos cadastrados");
            System.out.println("-- ** --");
        }
        else{
            for(Product product: products){
                System.out.println("Produto de ID: "+product.getId());
                System.out.println("Nome: "+product.getName());
                System.out.println("Quantidade em estoque: "+product.getQuantity());
                System.out.println("Preco por unidade: "+product.getPrice());
                System.out.println("");
            }
        }
    }

    public static Product update(String id, String name, double price, int quantity) throws Exception{
        if (!Verifications.verifyName(name)) {
            throw new Exception("Nome invalido");
        }
        
        if (quantity < 0) {
            throw new Exception("Quantidade invalida");
        }
        
        if (price < 0) {
            throw new Exception("Preco invalido");
        }

        Product product = findById(id);

        if(product == null){
            throw new Exception("Produto nao encontrado no sistema");
        }

        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        new ProductRepository().save();

        return product;
    }

    public static void delete(String id) throws Exception{
        Product product = findById(id);

        if(product == null){
            throw new Exception("Produto nao encontrado no sistema");
        }

        products.remove(product);
        new ProductRepository().save();
    }

    public void save() {
        Gson gson = new Gson();

        String json = gson.toJson(products);

        Database.write(FILE_NAME, json);
    }

    public void load() {
        Gson gson = new Gson();

        String stringFile = Database.read(FILE_NAME);

        Type type = new TypeToken<ArrayList<Product>>() {
        }.getType();

        ArrayList<Product> productsArray = gson.fromJson(stringFile, type);

        if (productsArray != null) {
            products = productsArray;
        }
    }

}
