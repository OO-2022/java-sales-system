/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames;


import com.mycompany.javasalessystem.Utils.Session;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminFrame extends JFrame{
    private JPanel principal;
    private JPanel rightPanel;
    private JPanel leftPanel;
    
    private JButton btnSeller;
    private JButton btnClient;
    private JButton btnProduct;
    private JButton btnSale;
    private JLabel brand;
    //private Admin admin;
    
    public AdminFrame() {
       // admin = AdminRepository.findById(id); 
    }
    
    //GETTERS E SETTERS
    public JPanel getPrincipal() {
        return principal;
    }
    public void setPrincipal(JPanel principal) {
        this.principal = principal;
    }
    public JPanel getRightPanel() {
        return rightPanel;
    }
    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }
    public JPanel getLeftPanel() {
        return leftPanel;
    }
    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel = leftPanel;
    }
    public JButton getBtnSeller() {
        return btnSeller;
    }
    public void setBtnSeller(JButton btnSeller) {
        this.btnSeller = btnSeller;
    }
    public JButton getBtnClient() {
        return btnClient;
    }
    public void setBtnClient(JButton btnClient) {
        this.btnClient = btnClient;
    }
    public JButton getBtnProduct() {
        return btnProduct;
    }
    public void setBtnProduct(JButton btnProduct) {
        this.btnProduct = btnProduct;
    }
    public JLabel getBrand() {
        return brand;
    }
    public void setBrand(JLabel brand) {
        this.brand = brand;
    }
   
    
    private void configuraJanela() {
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        //Configuração da janela
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        setTitle("Olá, "+Session.getAdmin().getName()+"! Você é um administrador.");
        setLocationRelativeTo(null);
        
    }
    public void configRightPanel(){
        
        rightPanel = new JPanel();
        rightPanel.setVisible(true);
        rightPanel.setBackground(new Color(246, 251, 244));
        rightPanel.setPreferredSize(new Dimension(250, 400));
        rightPanel.setLayout(new BorderLayout());

        
        //Instanciando e configurando os botões
        btnSeller = new javax.swing.JButton("Cadastrar funcionário");
        btnSeller.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeller.setBackground(Color.WHITE);
        btnSeller.setForeground(Color.black);
        btnSeller.addMouseListener(new AdminEvents(btnSeller));
        
        btnClient = new javax.swing.JButton("Cadastrar cliente");
        btnClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClient.setBackground(Color.WHITE);
        btnClient.setForeground(Color.black);
        btnClient.addMouseListener(new AdminEvents(btnClient));
        
        btnProduct = new javax.swing.JButton("Gerenciar estoque");
        btnProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProduct.setBackground(Color.WHITE);
        btnProduct.setForeground(Color.black);
        btnProduct.addMouseListener(new AdminEvents(btnProduct));
        
        btnSale = new javax.swing.JButton("Sessão de vendas");
        btnSale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSale.setBackground(Color.WHITE);
        btnSale.setForeground(Color.black);
        btnSale.addMouseListener(new AdminEvents(btnSale));
        
        brand = new javax.swing.JLabel();
        
        //Layout
        JPanel topGap = new JPanel();
        topGap.setPreferredSize(new Dimension(250, 50));
        topGap.setBackground(new Color(246, 251, 244));
        
        JPanel bottomGap = new JPanel();
        bottomGap.setPreferredSize(new Dimension(250, 50));
        bottomGap.setBackground(new Color(246, 251, 244));
        
        JPanel leftGap = new JPanel();
        leftGap.setPreferredSize(new Dimension(30, 200));
        leftGap.setBackground(new Color(246, 251, 244));
        
        JPanel rightGap = new JPanel();
        rightGap.setPreferredSize(new Dimension(30, 200));
        rightGap.setBackground(new Color(246, 251, 244));
        
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(250, 300));
        centerPanel.setBackground(new Color(246, 251, 244));
        centerPanel.setLayout(new GridLayout(4,1,0,15));
        
        centerPanel.add(btnSeller);
        centerPanel.add(btnClient);
        centerPanel.add(btnProduct);
        centerPanel.add(btnSale);
        
        rightPanel.add(topGap, BorderLayout.NORTH);
        rightPanel.add(leftGap, BorderLayout.WEST);
        rightPanel.add(centerPanel, BorderLayout.CENTER);
        rightPanel.add(rightGap, BorderLayout.EAST);
        rightPanel.add(bottomGap, BorderLayout.SOUTH);
        
        principal.add(rightPanel, BorderLayout.EAST);
        
    }
    
    private void configLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setVisible(true);
        leftPanel.setBackground(new Color(75, 134, 115));
        leftPanel.setPreferredSize(new Dimension(350, 400));
        leftPanel.setLayout(new BorderLayout());
        
        
        principal.add(leftPanel, BorderLayout.WEST);
    }
    
    public void mostraTela() {
        this.add(principal);
        this.setVisible(true);
    }

    public void montaTela() {
        configuraJanela();
        configRightPanel();
        configLeftPanel();
        mostraTela();
    }
    public static void main(String[] args) {
        AdminFrame tela = new AdminFrame();
        tela.montaTela();
    }

}

