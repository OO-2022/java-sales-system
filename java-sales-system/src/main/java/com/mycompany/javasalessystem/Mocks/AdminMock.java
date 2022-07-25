/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Mocks;

import com.mycompany.javasalessystem.Models.Admin;
import com.mycompany.javasalessystem.Repositories.AdminRepository;

public class AdminMock {
    public static void createAdmin() {
        Admin admin = AdminRepository.create("Gabriella Carvalho", "gabriella@gmail.com", "gabriella123", "Admin");
    }

    public static void updateAdmin() {
        Admin admin = AdminRepository.update("5f3ed3bb-b6fd-4f47-836e-c343bd2e8fa7","Rafael Vargas", "vargasrafael@gmail.com", "203698777**abc", "Admin");
    }

    public static void listdmin() {
        AdminRepository.list();
    }

    public static void deleteAdmin() {
        AdminRepository.delete("2f9790e6-a370-4b74-a762-3ff980ef1ec0");
    }
}
