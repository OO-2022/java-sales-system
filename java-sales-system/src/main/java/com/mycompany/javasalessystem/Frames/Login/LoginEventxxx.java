/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/
/*
package com.mycompany.javasalessystem.Frames.Login;

import com.mycompany.javasalessystem.Frames.ProductFrame;
import com.mycompany.javasalessystem.Models.User;
import com.mycompany.javasalessystem.Repositories.UserRepository;
import com.mycompany.javasalessystem.Utils.Session;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginEventxxx implements ActionListener{
    private TelaLoginxxx tela;

    public LoginEventxxx(TelaLoginxxx tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
	try {
            signIn();
	} catch (Exception e) {
            e.printStackTrace();
	}
    }
    
    private void signIn() {
	String email = tela.getTfUser().getText();
        String password = tela.getPfPassword().toString();

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return;
	}
        
        System.out.println(email+" "+password);
        User user = UserRepository.signIn(email, password);
        
        if (user == null) {
            JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
            return;
	}
        
        JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
        
        if (Session.getAdmin() != null) {
            ProductFrame tela = new ProductFrame();
            tela.montaTela();
	}

	if (Session.getSeller() != null) {
            //sellerView
	}

        if(tela.getTfUser().getText().equals("Marcos") && tela.getPfPassword().getText().equals("123456")){
            JOptionPane.showMessageDialog(null, "Bem-vindo!");
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario e/ou senha invalido(s)");
        }
    }
}
*/