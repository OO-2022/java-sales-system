package com.mycompany.javasalessystem.Models;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
    private String id;
    private Date date;
    private String idClient;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;
    private float price;

    public Sale(String id, Date date, String idClient, ArrayList products, ArrayList quantities) {
        this.id = id;
        this.date = date;
        this.idClient = idClient;
        this.products = products;
        this.quantities = quantities;
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
}
