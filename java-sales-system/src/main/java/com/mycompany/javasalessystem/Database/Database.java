package com.mycompany.javasalessystem.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public final class Database {
    public static final String PATH_FOLDER = "src/main/java/com/mycompany/javasalessystem/Database/Jsons";
    
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
        
    }
}
