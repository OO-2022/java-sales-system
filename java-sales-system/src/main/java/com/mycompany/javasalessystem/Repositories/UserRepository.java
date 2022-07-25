/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Repositories;

import com.mycompany.javasalessystem.Models.Admin;
import com.mycompany.javasalessystem.Models.Seller;
import com.mycompany.javasalessystem.Models.User;
import com.mycompany.javasalessystem.Utils.Encrypt;
import com.mycompany.javasalessystem.Utils.Session;
import java.util.ArrayList;

public class UserRepository {
    private static SellerRepository sellerRepository = new SellerRepository();
    private static AdminRepository adminRepository = new AdminRepository();
    
    
    public static User signIn(String email, String password) {
        adminRepository.load();
        sellerRepository.load();
        
	ArrayList<Admin> admins = adminRepository.getAdmins();
	ArrayList<Seller> sellers = sellerRepository.getSellers();

	for (Admin admin : admins) {
            if (admin.getEmail().equalsIgnoreCase(email) && admin.getPassword().equals(Encrypt.hashMD5(password))) {
                Session.setAdmin(admin);
                return admin;
            }
	}
        
	for (Seller seller : sellers) {
            if (seller.getEmail().equalsIgnoreCase(email) && seller.getPassword().equals(Encrypt.hashMD5(password))) {
                Session.setSeller(seller);
                return seller;
            }
	}

        return null;
    }

    public static void signOut() {
        Session.setAdmin(null);
        Session.setSeller(null);
    }
}
