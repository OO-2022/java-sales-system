package com.mycompany.javasalessystem.Mocks;

import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Models.Sale;
import com.mycompany.javasalessystem.Repositories.ProductRepository;
import com.mycompany.javasalessystem.Repositories.SaleRepository;
import java.text.ParseException;
import java.util.ArrayList;

public class SaleMock {
    public static void createSale() throws ParseException, CloneNotSupportedException {
        Sale sale = SaleRepository.create("e1c33395-ad77-4bab-9d52-413bdf6a1b12", "27/01/2005");
        
        sale.addProduct("ba1c4eb2-9fa3-4be7-9d2e-f19491e14eaf", 10);
        sale.addProduct("251e10d2-538c-43b0-9a20-6752f90ee095", 15);
    }
    
    /*
    public static void updateProduct() {
        Product product = ProductRepository.update("bd44f3bd-d2df-483a-9c2f-5fa899ace665","Lápis", 6.50, 50);
    }
    */
    
    public static void listSale() throws ParseException {
        SaleRepository.list();
    }
    
    public static void findSale() throws ParseException {
        SaleRepository.find("c24826bf-e406-4b6a-a1dc-f5f01e2dabe5");
    }
    
    /*
    public static void deleteProduct() {
        ProductRepository.delete("957de3b8-ef1c-44f2-8f1b-c75abf2de8c8");
    }
    */
}