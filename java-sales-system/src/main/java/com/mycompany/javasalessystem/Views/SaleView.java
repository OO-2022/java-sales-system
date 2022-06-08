/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Views;

import com.mycompany.javasalessystem.Models.Sale;
import com.mycompany.javasalessystem.Repositories.SaleRepository;
import java.text.ParseException;
import java.util.Scanner;

public class SaleView {

    public static void viewSaleOptionsSwitch(int option) throws ParseException, CloneNotSupportedException {
        Scanner teclado = new Scanner(System.in);

        switch (option) {
            case 7:
                SaleRepository.list();
                break;
            case 8:
                Sale sale = saleCreationForm();
                if (sale != null) System.out.println("Sucesso na criacao da venda");
                break;
        }
        
        System.out.println("Selecione: ");
        System.out.println("(0) Sair");
        System.out.println("(1) Voltar ao menu");
        int outOrIn = teclado.nextInt();
        
        if (outOrIn == 1){
            MainView.index();
        }       
        
    }
    
    public static Sale saleCreationForm() throws ParseException, CloneNotSupportedException {
        Scanner teclado = new Scanner(System.in);

        System.out.println("CPF do Cliente: ");
        String client = teclado.nextLine();
        
        Sale sale = SaleRepository.create(client);
        
        if(sale == null){
            return null;
        }
        
        System.out.println("Selecione: ");
        System.out.println("(0) Para finalizar a compra");
        System.out.println("(1) Para adicionar um produto");
        System.out.println("(2) Para remover um produto");

        int option = teclado.nextInt();
        
        while(option != 0){
            if(option == 1){   
                String product = readProduct(sale);
                
                System.out.println("Quantidade: ");
                int quantity = teclado.nextInt();
                
                sale.addProduct(product, quantity);
                
                SaleRepository.listProducts(sale.getId());
            } 
            
            if(option == 2){
                System.out.println("Posicao: ");
                int position = teclado.nextInt();
                
                System.out.println("Quantidade: ");
                int quantity = teclado.nextInt();

                sale.removeProduct(position, quantity);
                
                SaleRepository.listProducts(sale.getId());
            }
            
            System.out.println("Selecione: ");
            System.out.println("(0) Para finalizar a compra");
            System.out.println("(1) Para adicionar um produto");
            System.out.println("(2) Para remover um produto");

            option = MainView.leOption();
        };
        
        SaleRepository.find(sale.getId());
        
        return sale;
    }
    
    public static String readProduct(Sale sale) throws CloneNotSupportedException{
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("ID do Produto:  ");
        String product = teclado.nextLine();
                
        return product;   
    }
}
