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
        int option = teclado.nextInt();

        ClientView.viewClientOptionsSwitch(option);
    }
}
