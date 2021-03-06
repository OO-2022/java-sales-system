/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Mocks;

import com.mycompany.javasalessystem.Models.Sale;
import com.mycompany.javasalessystem.Repositories.SaleRepository;
import java.text.ParseException;

public class SaleMock {
    public static void createSale() throws ParseException, CloneNotSupportedException, Exception {
        Sale sale = SaleRepository.create("10301202699");
        
        //sale.addProduct("281b30fb-aaf3-4f12-8aeb-ae9049fe8138", 2);
        //sale.removeProduct(1, 1);
        //sale.addProduct("251e10d2-538c-43b0-9a20-6752f90ee095", 15);
    }
    
    public static void updateSale() throws ParseException, Exception {
        Sale sale = SaleRepository.update("bd44f3bd-d2df-483a-9c2f-5fa899ace665", "10301202699");
    }
    
    public static void listSale() throws ParseException {
        SaleRepository.list();
    }
    
    public static void findSale() throws ParseException, Exception {
        SaleRepository.find("c24826bf-e406-4b6a-a1dc-f5f01e2dabe5");
    }
    
    public static void deleteSale() throws Exception {
        SaleRepository.delete("957de3b8-ef1c-44f2-8f1b-c75abf2de8c8");
    }
}