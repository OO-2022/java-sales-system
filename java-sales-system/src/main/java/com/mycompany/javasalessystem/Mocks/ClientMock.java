/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Mocks;

import com.mycompany.javasalessystem.Models.Client;
import com.mycompany.javasalessystem.Repositories.ClientRepository;

public class ClientMock {
    public static void createClient() {
        Client client = ClientRepository.create("Ana Julia Madrigal", "38255456600", "ana@gmail.com", "32991365584", "36085221");
    }

    public static void updateClient() {
        Client client = ClientRepository.update("c17bc41b-b118-4f70-8a49-15af8fc33c25","Paulo Geraldo do Valle Carvalho", "385664775500", "carvalho.paulo@gmail.com", "32991365584", "36085221");
    }

    public static void listClient() {
        ClientRepository.list();
    }
    
    public static void deleteClient() {
        ClientRepository.delete("6d00ea4d-0c64-4c32-9d0d-29c0fac77ec5");
    }
}
