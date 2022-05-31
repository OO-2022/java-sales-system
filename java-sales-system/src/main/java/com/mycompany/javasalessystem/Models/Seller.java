package com.mycompany.javasalessystem.Models;

public class Seller extends User {
    private String occupation;

    public Seller(String id, String name, String email, String password, String occupation) {
        super(id, name, email, password);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
}
