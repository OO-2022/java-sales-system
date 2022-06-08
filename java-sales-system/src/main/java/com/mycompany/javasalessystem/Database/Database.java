/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.mycompany.javasalessystem.Repositories.*;

public final class Database {
    public static final String PATH_FOLDER = "src/main/java/com/mycompany/javasalessystem/Database/Jsons/";
    
    private static ProductRepository productRepository = new ProductRepository();
    private static SellerRepository sellerRepository = new SellerRepository();
    private static AdminRepository adminRepository = new AdminRepository();
    private static ClientRepository clientRepository = new ClientRepository();
    private static SaleRepository saleRepository = new SaleRepository();
    
    
    public static void write(String fileName, String json) {
        try {
            File file = new File(PATH_FOLDER + fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read(String fileName) {
        try {
            FileReader fileReader = new FileReader(PATH_FOLDER + fileName);
            BufferedReader buffer = new BufferedReader(fileReader);

            String value = buffer.readLine();
            buffer.close();

            return value;

        } catch (Exception e) {
            return "";
        }
    }

    public static void load() {
        productRepository.load();
        sellerRepository.load();
        clientRepository.load();
        adminRepository.load();   
        saleRepository.load();
    }
}
