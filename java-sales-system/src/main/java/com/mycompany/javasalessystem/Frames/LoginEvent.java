/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
