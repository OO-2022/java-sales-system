package com.mycompany.javasalessystem.Models;

import java.util.ArrayList;
import java.util.Date;

import com.mycompany.javasalessystem.Repositories.ProductRepository;
import com.mycompany.javasalessystem.Repositories.SaleRepository;

public class Sale {
    private String id;
    private Date date;
    private String idClient;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;
    private float price;
    private float finalPrice;

    public Sale(String id, Date date, String idClient, ArrayList products, ArrayList quantities) {
        this.id = id;
        this.date = date;
        this.idClient = idClient;
        this.products = products;
        this.quantities = quantities;
    }

    public Sale(String saleId, Date formattedDate, String idClient) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(ArrayList<Integer> quantities) {
        this.quantities = quantities;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void addProduct(String id, int quantity) throws CloneNotSupportedException {
        var product = (Product)ProductRepository.findById(id).clone();
                
        if(product == null){
            System.out.println("Produto não encontrado no sistema");
            return;
        }
        
        int stockQuantity = product.getQuantity();
        
        if(stockQuantity < quantity){
            System.out.println("Quantidade insuficiente de "+product.getName()+"no estoque: Ha apenas " + stockQuantity + " unidades");
            return;
        } 
        
        this.finalPrice += (float)(product.getPrice() * quantity);
        
        product.setQuantity(quantity);
        
        products.add(product);
        
        ProductRepository.update(id, product.getName(), product.getPrice(), stockQuantity - quantity);
        
        new SaleRepository().save();        
    }
}
