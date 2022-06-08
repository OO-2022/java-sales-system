/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Views;

import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Repositories.ProductRepository;
import java.text.ParseException;
import java.util.Scanner;

public class ProductView {

    public static void viewProductOptionsSwitch(int option) throws ParseException, CloneNotSupportedException {
        Scanner teclado = new Scanner(System.in);

        
        switch (option) {
            case 5:
                ProductRepository.list();
                break;
            case 6:
                Product product = productCreationForm();
                if (product != null) System.out.println("Sucesso na criacao do produto");
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
    
    public static Product productCreationForm() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Nome do Produto: ");
        String name = teclado.nextLine();
        
        System.out.println("Preco de cada unidade: ");
        double price = teclado.nextDouble();    
        
        System.out.println("Quantidade do produto: ");
        int quantity = teclado.nextInt();
       
        
        Product product = ProductRepository.create(name, price, quantity);
        
        return product;
    }
}
