/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/


package com.mycompany.javasalessystem.Utils;

import com.mycompany.javasalessystem.Models.Admin;
import com.mycompany.javasalessystem.Models.Seller;

public class Session {
	private static Admin admin;
	private static Seller seller;

	public static Admin getAdmin() {
            return admin;
	}

	public static void setAdmin(Admin admin) {
            Session.admin = admin;
	}

	public static Seller getSeller() {
            return seller;
	}

	public static void setSeller(Seller seller) {
            Session.seller = seller;
	}
        
        public static String titleAccordingToSession() {
            
            if ( Session.getAdmin() != null){
                return "Olá, "+Session.getAdmin().getName()+"! Você é um administrador.";
            } else if ( Session.getSeller() != null){
                return "Olá, "+Session.getSeller().getName()+"! Você é um vendedor.";
            } else {
                return "";
            }
        
	}
}