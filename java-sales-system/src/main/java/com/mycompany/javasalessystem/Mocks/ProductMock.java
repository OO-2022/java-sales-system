package com.mycompany.javasalessystem.Mocks;

import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Repositories.ProductRepository;

public class ProductMock {
    public static void createProduct() {
        Product product = ProductRepository.create("Pasta", 2100.00, 20);
    }

    public static void updateProduct() {
        //Product product = ProductRepository.update("bd44f3bd-d2df-483a-9c2f-5fa899ace665","Lápis", 6.50, 50);
        //Product product = ProductRepository.update("ba1c4eb2-9fa3-4be7-9d2e-f19491e14eaf","Caneta",2.5, 60);
        Product product = ProductRepository.update("251e10d2-538c-43b0-9a20-6752f90ee095","Pasta",21.0,100);
    }

    public static void listProduct() {
        ProductRepository.list();
    }

    public static void deleteProduct() {
        ProductRepository.delete("957de3b8-ef1c-44f2-8f1b-c75abf2de8c8");
    }
}
