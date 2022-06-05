/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189ac

*/

package com.mycompany.javasalessystem;

import com.mycompany.javasalessystem.Database.Database;
import com.mycompany.javasalessystem.Mocks.ClientMock;
import com.mycompany.javasalessystem.Views.MainView;

public class Application {

    public static void main(String[] args) {
        System.out.println("O programa está em execução...");
        Database.load();
        
        System.out.println("Bem-vindo(a) a papelaria Orientacao&Objetos");
        
        MainView.index();
     
    }
}

