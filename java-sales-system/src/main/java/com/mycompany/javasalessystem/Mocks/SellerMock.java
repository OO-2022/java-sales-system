package com.mycompany.javasalessystem.Mocks;

import com.mycompany.javasalessystem.Models.Seller;
import com.mycompany.javasalessystem.Models.User;
import com.mycompany.javasalessystem.Repositories.SellerRepository;

public class SellerMock {
    public static void createSeller() {
        Seller seller = SellerRepository.create("Vilma Toledo", "vilma@gmail.com", "123456*", "Vendendora");
    }

    public static void updateSeller() {
        Seller seller = SellerRepository.update("db7cc371-1f4d-4a50-871e-b770bf07a343","Gabriella Carvalho Braga", "gabiCarv@gmail.com", "123456*", "Gerente Loja 1");
    }

    public static void listSeller() {
        SellerRepository.list();
    }
    
    public static void deleteSeller() {
        SellerRepository.delete("db7cc371-1f4d-4a50-871e-b770bf07a343");
    }
}