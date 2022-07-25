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
import com.mycompany.javasalessystem.Utils.Verifications;
import java.lang.reflect.Type;
import java.util.ArrayList;
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

    public static Admin create(String name, String email, String password, String occupation) throws Exception {
        if (!Verifications.verifyName(name)) {
            throw new Exception("Nome invalido");
        }

        if (!Verifications.verifyEmail(email)) {
            throw new Exception("Email invalido");
        }

        if (!Verifications.verifyPassword(password)) {
            throw new Exception("Senha deve ter no minimo 8 caracteres");
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

    public static void find(String id) throws Exception {
        Admin admin = findById(id);

        if (admin == null) {
            throw new Exception("Administrador nao encontrado no sistema");
        }

        System.out.println("ID admin: " + admin.getId());
        System.out.println("Nome: " + admin.getName());
        System.out.println("Email: " + admin.getEmail());
        System.out.println("Senha: " + admin.getPassword());
        System.out.println("Occupation: " + admin.getOccupation());
        System.out.println("");
    }

    public static Admin update(String id, String name, String email, String password, String occupation) throws Exception {
        if (Verifications.verifyName(name) == false) {
            throw new Exception("Nome invalido");
        }

        if (Verifications.verifyEmail(email) == false) {
            throw new Exception("Email invalido");
        }

        if (Verifications.verifyPassword(password) == false) {
            throw new Exception("Senha deve ter no minimo 8 caracteres");
        }

        Admin admin = findById(id);

        if (admin == null) {
            throw new Exception("Administrador nao encontrado no sistema");
        }

        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setOccupation(occupation);

        new AdminRepository().save();

        return admin;
    }

    public static void delete(String id) throws Exception {
        Admin admin = findById(id);

        if (admin == null) {
            throw new Exception("Administrador nao encontrado no sistema");
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