/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Mocks;

import com.mycompany.javasalessystem.Models.Seller;
import com.mycompany.javasalessystem.Models.User;
import com.mycompany.javasalessystem.Repositories.SellerRepository;

public class SellerMock {
    public static void createSeller() throws Exception{
        Seller seller = SellerRepository.create("Vilma Toledo", "vilma@gmail.com", "123456*", "Vendendora", "10301202699");
    }

    public static void updateSeller() throws Exception{
        //Seller seller = SellerRepository.update("db7cc371-1f4d-4a50-871e-b770bf07a343","Gabriella Carvalho Braga", "gabiCarv@gmail.com", "123456*", "Gerente Loja 1");
    }

    public static void listSeller() {
        SellerRepository.list();
    }
    
    public static void deleteSeller() throws Exception {
        SellerRepository.delete("db7cc371-1f4d-4a50-871e-b770bf07a343");
    }
}