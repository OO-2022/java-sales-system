package com.mycompany.javasalessystem.Views;

import com.mycompany.javasalessystem.Models.Client;
import com.mycompany.javasalessystem.Repositories.ClientRepository;
import java.util.Scanner;

public class ClientView {

    public static void viewClientOptionsSwitch(int option) {
        Scanner teclado = new Scanner(System.in);

        
        switch (option) {
            case 1:
                ClientRepository.read();
                break;
            case 2:
                Client cliente = clientCreationForm();
                if (cliente != null) System.out.println("Sucesso na criacao");
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
    
    public static Client clientCreationForm() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Nome do Cliente: ");
        String name = teclado.nextLine();
        
        System.out.print("CPF do Cliente: ");
        String cpf = teclado.nextLine();
        
        System.out.print("Email do Cliente: ");
        String email = teclado.nextLine();    
        
        System.out.print("Telefone do Cliente: ");
        String telefone = teclado.nextLine();
        
        System.out.print("CEP do Cliente: ");
        String cep = teclado.nextLine();
        
        Client cliente = ClientRepository.create(name, cpf, email, telefone, cep);
        return cliente;
    }
}
