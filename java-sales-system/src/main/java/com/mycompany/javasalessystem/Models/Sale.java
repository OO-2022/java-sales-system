/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

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
    private float finalPrice;

    public Sale(String id, Date date, String idClient) {
        this.id = id;
        this.date = date;
        this.idClient = idClient;
        this.finalPrice = 0;
        this.products = new ArrayList<>();
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

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }
    
    public void addProduct(String id, int quantity) throws CloneNotSupportedException, Exception {
        Product product = (Product)ProductRepository.findById(id).clone();
                
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
                
        stockQuantity = stockQuantity - quantity;
        
        ProductRepository.update(id, product.getName(), product.getPrice(), stockQuantity);
                
        new SaleRepository().save();
        
    }
    
    public void removeProduct(int position, int quantity){
        Product productSale = products.get(position-1);
        
        Product productStock = (Product)ProductRepository.findById(productSale.getId());
        
        if(productStock == null){
            System.out.println("Produto inexistente");
            return;
        }
        
        productStock.setQuantity(productStock.getQuantity() + quantity);
        new ProductRepository().save();
        
        if(productSale.getQuantity() - quantity > 0){
            productSale.setQuantity(productSale.getQuantity() - quantity);
            
            this.finalPrice -= (float)(productSale.getPrice() * quantity);
        } else {
            this.finalPrice -= (float)(productSale.getPrice() * quantity);
            products.remove(productSale);
        }

        new SaleRepository().save();
    }
}
