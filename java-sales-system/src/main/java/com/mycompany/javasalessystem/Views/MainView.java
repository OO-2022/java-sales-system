package com.mycompany.javasalessystem.Views;

import java.util.Scanner;
import com.mycompany.javasalessystem.Views.ClientView;

public class MainView {

    public static void index() {
        System.out.println("Bem-vindo(a) a papelaria Orientação&Objetos");

        Scanner teclado = new Scanner(System.in);

        System.out.println("Selecione o que deseja fazer: ");

        System.out.println("(1) Ver Clientes");
        System.out.println("(2) Cadastrar Clientes");
        
        System.out.println("(3) Ver Funcionarios");
        System.out.println("(4) Cadastrar Funcionario");
        
        int option = teclado.nextInt();
        
        if (option == 1 || option == 2){
            ClientView.viewClientOptionsSwitch(option);
        } else if (option == 3 || option == 4){
            SellerView.viewSellerOptionsSwitch(option);
        } else {
            index();
        }

        
    }
}
