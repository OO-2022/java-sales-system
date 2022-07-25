/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.javasalessystem.Database.Database;
import com.mycompany.javasalessystem.Models.Admin;
import com.mycompany.javasalessystem.Utils.Encrypt;
import com.mycompany.javasalessystem.Utils.Verifications;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdminRepository implements Repository {

    private static final String FILE_NAME = "admins.json";

    private static ArrayList<Admin> admins = new ArrayList<>();
    
    public AdminRepository() {
    }
    
    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public static Admin findById(String id) {
        for (Admin admin : admins) {
            if (admin.getId().compareTo(id) == 0) {
                return admin;
            }
        }

        return null;
    }

    public static Admin create(String name, String email, String password, String occupation) {
        if (!Verifications.verifyName(name)) {
            System.out.println("Nome invalido");
            return null;
        }

        if (!Verifications.verifyEmail(email)) {
            System.out.println("Email invalido");
            return null;
        }

        if (!Verifications.verifyPassword(password)) {
            System.out.println("Senha deve ter no minimo 8 caracteres");
            return null;
        }

        String adminId = UUID.randomUUID().toString();

        Admin admin = new Admin(adminId, name, email, password, occupation);

        admins.add(admin);

        new AdminRepository().save();

        return admin;
    }

    public static void list() {
        if (admins.isEmpty()){
            System.out.println("Ainda nao ha produtos cadastrados");
            System.out.println("-- ** --");
        }
        else{
            for (Admin admin : admins) {
                System.out.println("ID admin: " + admin.getId());
                System.out.println("Nome: " + admin.getName());
                System.out.println("Email: " + admin.getEmail());
                System.out.println("Senha: " + admin.getPassword());
                System.out.println("Occupation: " + admin.getOccupation());
                System.out.println("");
            }
    }
    }

    public static void find(String id) {
        Admin admin = findById(id);

        if (admin == null) {
            System.out.println("Administrador nao encontrado no sistema");
            return;
        }

        System.out.println("ID admin: " + admin.getId());
        System.out.println("Nome: " + admin.getName());
        System.out.println("Email: " + admin.getEmail());
        System.out.println("Senha: " + admin.getPassword());
        System.out.println("Occupation: " + admin.getOccupation());
        System.out.println("");
    }

    public static Admin update(String id, String name, String email, String password, String occupation) {
        if (Verifications.verifyName(name) == false) {
            System.out.println("Nome invalido");
            return null;
        }

        if (Verifications.verifyEmail(email) == false) {
            System.out.println("Email invalido");
            return null;
        }

        if (Verifications.verifyPassword(password) == false) {
            System.out.println("Senha deve ter no minimo 8 caracteres");
            return null;
        }

        Admin admin = findById(id);

        if (admin == null) {
            return null;
        }

        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setOccupation(occupation);

        new AdminRepository().save();

        return admin;
    }

    public static void delete(String id) {
        Admin admin = findById(id);

        if (admin == null) {
            System.out.println("Administrador nao encontrado no sistema");
            return;
        }

        admins.remove(admin);

        new AdminRepository().save();
    }

    public void save() {
        Gson gson = new Gson();

        String json = gson.toJson(admins);

        Database.write(FILE_NAME, json);
    }

    public void load() {
        Gson gson = new Gson();

        String stringFile = Database.read(FILE_NAME);

        Type type = new TypeToken<ArrayList<Admin>>() {
        }.getType();

        ArrayList<Admin> adminsArray = gson.fromJson(stringFile, type);

        if (adminsArray != null) {
            admins = adminsArray;
        }
    }
}