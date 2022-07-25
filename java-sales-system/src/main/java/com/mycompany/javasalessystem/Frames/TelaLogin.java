/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import javax.swing.*;

public class TelaLogin extends JFrame{
    
    private JPanel panel;
    private JButton login;
    private JLabel user;
    private JLabel password;
    private JLabel brand;
    private JPasswordField pfPassword;
    private JTextField tfUser;
    private int lastIndex;
    
    public TelaLogin() {
        this.lastIndex = 0;
    }
    
    //GETTERS E SETTERS
    public JButton getLogin() {return login;}

    public void setLogin(JButton login) {this.login = login;}

    public JLabel getUser() {return user;}

    public void setUser(JLabel user) {this.user = user;}

    public JLabel getPassword() {return password;}

    public void setPassword(JLabel password) {this.password = password;}

    public JLabel getBrand() {return brand;}

    public void setBrand(JLabel name) {this.brand = brand;}

    public JPasswordField getPfPassword() {return pfPassword;}

    public void setPfPassword(JPasswordField pfPassword) {this.pfPassword = pfPassword;}

    public JTextField getTfUser() {return tfUser;}

    public void setTfUser(JTextField tfUser) {this.tfUser = tfUser;}
    
   
    
    private void configuraJanela() {
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel = new JPanel();
        //panel.setLayout(new BorderLayout());
        //Configuração da janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);
        setTitle("Login");
        
        //Inicializando as variáveis
        login = new javax.swing.JButton();
        user = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        brand = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        pfPassword = new javax.swing.JPasswordField();
        //this.addWindowListener(new EventoJanela(this));
    
        user.setLabelFor(tfUser);
        user.setText("Usuário");
        brand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brand.setText("PAPELARIA ORIENTAÇÃO&OBJETOS");
        password.setText("Senha");
        login.setText("Entrar");
        login.addActionListener(new LoginEvent(this));
        
        //Layout
            setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        brand.setAlignmentX(CENTER_ALIGNMENT);
        brand.setAlignmentY(BOTTOM_ALIGNMENT);
        user.setAlignmentX(CENTER_ALIGNMENT);
        getContentPane().add(brand);
        getContentPane().add(user);
        
        
    }
    public void mostraTela() {
        //this.add(panel);
        this.setVisible(true);
    }

    public void montaTela() {
        configuraJanela();
        mostraTela();
    }

    public static void main(String[] args) {
        TelaLogin tela = new TelaLogin();
        tela.montaTela();
    }
}
