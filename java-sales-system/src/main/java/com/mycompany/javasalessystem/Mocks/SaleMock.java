package com.mycompany.javasalessystem.Mocks;

import com.mycompany.javasalessystem.Models.Sale;
import com.mycompany.javasalessystem.Repositories.SaleRepository;
import java.text.ParseException;

public class SaleMock {
    public static void createSale() throws ParseException, CloneNotSupportedException {
        Sale sale = SaleRepository.create("10301202699", "27/01/2005");
        
        sale.addProduct("281b30fb-aaf3-4f12-8aeb-ae9049fe8138", 2);
        sale.removeProduct(1, 1);
        //sale.addProduct("251e10d2-538c-43b0-9a20-6752f90ee095", 15);
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