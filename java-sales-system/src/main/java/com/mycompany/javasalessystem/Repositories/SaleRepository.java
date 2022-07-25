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
import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Models.Sale;
import com.mycompany.javasalessystem.Utils.ConversionToDate;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class SaleRepository implements Repository{

    private static final String FILE_NAME = "sales.json";

    private static ArrayList<Sale> sales = new ArrayList<>();

    public static Sale findById(String id) {
        for (Sale sale : sales) {
            if (sale.getId().compareTo(id) == 0) {
                return sale;
            }
        }

        return null;
    }

    public static Sale create(String cpf) throws ParseException, Exception {
        Client client = ClientRepository.findByCpf(cpf);
        
        if(client == null){
            throw new Exception("Cliente nao cadastrado no sistema");
        }
        
        String saleId = UUID.randomUUID().toString();
        
        //Date formattedDate = ConversionToDate.conversionToDate(date);
        
        //Data do sistema
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date formattedDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        
        Sale sale = new Sale(saleId, formattedDate, client.getId());

        sales.add(sale);

        new SaleRepository().save();

        return sale;
    }

    
    public static void list() throws ParseException {
        if (sales.isEmpty()){
            System.out.println("Ainda nao ha vendas cadastradas");
            System.out.println("-- ** --");
        }
        
        for (Sale sale : sales) {
            ArrayList<Product> products = sale.getProducts();
            
            System.out.println("ID: " + sale.getId());
            System.out.println("Data: " + ConversionToDate.conversionToString(sale.getDate()));
            System.out.println("Produtos: ");
            
            for(int i = 0; i < products.size(); i++){
                Product product = products.get(i);
                
                System.out.println(i+1 + ". " + product.getQuantity() + " * " + product.getName() + " = " + product.getPrice() + " (por unidade)");
            }
            System.out.println("Preco final = "+sale.getFinalPrice());
            System.out.println("");
        }
    }
    
    public static void find(String id) throws ParseException, Exception {
        Sale sale = findById(id);
        ArrayList<Product> products = sale.getProducts();

        if (sale == null) {
            throw new Exception("Venda nao encontrada no sistema");
        }
        
        System.out.println("ID: " + sale.getId());
        System.out.println("Data: " + ConversionToDate.conversionToString(sale.getDate()));
        System.out.println("Produtos: ");
            
        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
                
            System.out.println(i+1 + ". " + product.getQuantity() + " * " + product.getName() + " = " + product.getPrice() + " (por unidade)");
        }
        System.out.println("Preco final = "+sale.getFinalPrice());
        System.out.println("");
    }
    
    public static void listProducts(String id) throws ParseException, Exception {
        Sale sale = findById(id);
        ArrayList<Product> products = sale.getProducts();

        if (sale == null) {
            throw new Exception("Venda nao encontrada no sistema");
        }
            
        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
                
            System.out.println(i+1 + ". " + product.getQuantity() + " * " + product.getName() + " = " + product.getPrice() + " (por unidade)");
        }
        System.out.println("Preco final = "+sale.getFinalPrice());
        System.out.println("");
    }


    public static Sale update(String id, String idClient) throws ParseException, Exception {
        Sale sale = SaleRepository.findById(id);
        
        if (sale == null) {
            throw new Exception("Venda nao encontrada no sistema");
        }
        
        Client client = ClientRepository.findById(idClient);
        
        if(client == null){
            throw new Exception("Cliente nao cadastrado no sistema");
        }

        sale.setIdClient(idClient);

        new SaleRepository().save();

        return sale;
    }

    public static void delete(String id) throws Exception {
        Sale sale = findById(id);

        if (sale == null) {
            throw new Exception("Venda nao encontrada no sistema");
        }

        sales.remove(sale);
    }

    public void save() {
        Gson gson = new Gson();

        String json = gson.toJson(sales);

        Database.write(FILE_NAME, json);
    }

    public void load() {
        Gson gson = new Gson();

        String stringFile = Database.read(FILE_NAME);

        Type type = new TypeToken<ArrayList<Sale>>() {
        }.getType();

        ArrayList<Sale> salesArray = gson.fromJson(stringFile, type);

        if (salesArray != null) {
            sales = salesArray;
        }
    }

}