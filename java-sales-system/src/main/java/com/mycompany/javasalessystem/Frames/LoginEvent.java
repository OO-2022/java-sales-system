/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasalessystem.Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Paulo
 */
public class LoginEvent implements ActionListener{
    private TelaLogin tela;

    public LoginEvent(TelaLogin tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(tela.getTfUser().getText().equals("Marcos") && tela.getPfPassword().getText().equals("123456")){
            JOptionPane.showMessageDialog(null, "Bem-vindo!");
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalido(s)");
        }
    }
    
}
