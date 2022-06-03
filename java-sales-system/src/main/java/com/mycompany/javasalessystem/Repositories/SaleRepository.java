package com.mycompany.salessystem.Repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.salessystem.Database.Database;
import com.mycompany.salessystem.Models.Client;
import com.mycompany.salessystem.Models.Product;
import com.mycompany.salessystem.Models.Sale;
import com.mycompany.salessystem.Utils.ConversionToDate;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class SaleRepository {

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

    public static Sale create(String idClient, String date) throws ParseException {
        Client client = ClientRepository.findById(idClient);
        
        if(client == null){
            System.err.println("Cliente nao cadastrado no sistema");
            return null;
        }
        
        String saleId = UUID.randomUUID().toString();
        
        Date formattedDate = ConversionToDate.conversionToDate(date);
        
        Sale sale = new Sale(saleId, formattedDate, idClient);

        sales.add(sale);

        new SaleRepository().save();

        return sale;
    }

    
    public static void list() throws ParseException {
        for (Sale sale : sales) {
            ArrayList<Product> products = sale.getProducts();
            
            System.out.println("ID: " + sale.getId());
            System.out.println("Data: " + ConversionToDate.conversionToString(sale.getDate()));
            System.out.println("Produtos: ");
            
            for(int i = 0; i < products.size(); i++){
                Product product = products.get(i);
                
                System.out.println(i+1 + " - " + product.getQuantity() + " * " + product.getName() + " = " + product.getPrice() + " (por unidade)");
            }
            System.out.println("Preco final = "+sale.getFinalPrice());
            System.out.println("");
        }
    }
    
    public static void find(String id) throws ParseException {
        Sale sale = findById(id);
        ArrayList<Product> products = sale.getProducts();

        if (sale == null) {
            System.out.println("Venda nao encontrada no sistema");
            return;
        }
        
        System.out.println("ID: " + sale.getId());
        System.out.println("Data: " + ConversionToDate.conversionToString(sale.getDate()));
        System.out.println("Produtos: ");
            
        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
                
            System.out.println(i+1 + " - " + product.getQuantity() + " * " + product.getName() + " = " + product.getPrice() + " (por unidade)");
        }
        System.out.println("Preco final = "+sale.getFinalPrice());
        System.out.println("");
    }

    public static Sale update(String id, String idClient, String date) throws ParseException {
        Sale sale = SaleRepository.findById(id);
        
        if(sale == null){
            System.err.println("Venda nao cadastrada no sistema");
            return null;
        }
        
        Client client = ClientRepository.findById(idClient);
        
        if(client == null){
            System.err.println("Cliente nao cadastrado no sistema");
            return null;
        }
        
        Date formattedDate = ConversionToDate.conversionToDate(date);
        
        sale.setDate(formattedDate);
        sale.setIdClient(idClient);

        new SaleRepository().save();

        return sale;
    }

    public static void delete(String id) {
        Sale sale = findById(id);

        if (sale == null) {
            System.out.println("Venda nao encontrada na sistema");
            return;
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