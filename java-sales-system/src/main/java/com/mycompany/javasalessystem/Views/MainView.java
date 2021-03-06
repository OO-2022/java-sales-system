/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Views;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;

public class MainView {

    public static void index() throws ParseException, CloneNotSupportedException, Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Selecione o que deseja fazer: ");

        System.out.println("(1) Ver Clientes");
        System.out.println("(2) Cadastrar Cliente");
        
        System.out.println("(3) Ver Funcionarios");
        System.out.println("(4) Cadastrar Funcionario");
        
        System.out.println("(5) Ver Produtos");
        System.out.println("(6) Cadastrar Produto");
        
        System.out.println("(7) Ver Vendas");
        System.out.println("(8) Cadastrar Venda");
        
        int option = leOption();
        
        switch(option){
            case 1:
            case 2: ClientView.viewClientOptionsSwitch(option);break;
            case 3:
            case 4: SellerView.viewSellerOptionsSwitch(option);break;
            case 5:
            case 6: ProductView.viewProductOptionsSwitch(option);break;
            case 7:
            case 8: SaleView.viewSaleOptionsSwitch(option);break;
            default: index();
        }
    }
    public static int leOption(){
        Scanner teclado = new Scanner(System.in);
        int option;

        try {
            option = teclado.nextInt();
        }catch(InputMismatchException ex) {
            System.out.println("Valor digitado nao e um numero. Selecione uma opcao do menu: ");
            option = leOption();
        }
        return option;
    }
}