/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Views;

import com.mycompany.javasalessystem.Models.Seller;
import com.mycompany.javasalessystem.Repositories.SellerRepository;
import com.sun.tools.javac.Main;

import java.text.ParseException;
import java.util.Scanner;

public class SellerView {

    public static void viewSellerOptionsSwitch(int option) throws ParseException, CloneNotSupportedException, Exception {
        Scanner teclado = new Scanner(System.in);
        
        switch (option) {
            case 3:
                SellerRepository.list();
                break;
            case 4:
                Seller seller = sellerCreationForm();
                if (seller != null) System.out.println("Sucesso na criacao do vendedor");
                break;
        }
        
        System.out.println("Selecione: ");
        System.out.println("(0) Sair");
        System.out.println("(1) Voltar ao menu");
        int outOrIn = MainView.leOption();
        
        if (outOrIn == 1){
            MainView.index();
        }       
        
    }
    
    public static Seller sellerCreationForm() throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Nome do Funcionario: ");
        String name = teclado.nextLine();
        
        System.out.println("Email do Fucionario: ");
        String email = teclado.nextLine();    
        
        System.out.println("Senha do Funcionario: ");
        String password = teclado.nextLine();
        
        System.out.println("Cargo do Funcionario: ");
        String occupation = teclado.nextLine();
        
        Seller seller = SellerRepository.create(name, email, password, occupation);
        return seller;
    }
}
