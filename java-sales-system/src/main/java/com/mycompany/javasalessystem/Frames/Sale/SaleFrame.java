/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames.Sale;

import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Utils.Session;

import com.mycompany.javasalessystem.Repositories.ProductRepository;
import com.mycompany.javasalessystem.Repositories.ClientRepository;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class SaleFrame extends JFrame{
    private JPanel principal;
    private JPanel rightPanel;
    private JPanel leftPanel;
    
    private JList listaCompras;
    
    JComboBox cbClientes;
    JLabel clientes;
    JComboBox cbProdutos;
    JLabel produtos;
    
    
    private JButton btnSeller;
    private JButton btnClient;
    Border lineBorder;   
    
    public SaleFrame() {
        lineBorder = BorderFactory.createLineBorder(new Color(75, 134, 115));
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
    
    public JComboBox getCbCliente() {
        return cbClientes;
    }        
    public void setCbClientes(JComboBox cbClientes) {
        this.cbClientes = cbClientes;
    }    
    public JLabel getClientes() {
        return clientes;
    }
    public void setClientes(JLabel clientes) {
        this.clientes = clientes;
    }
    
    public JComboBox getCbProduto() {
        return cbProdutos;
    }        
    public void setCbProdutos(JComboBox cbProdutos) {
        this.cbProdutos = cbProdutos;
    }    
    public JLabel getProdutos() {
        return produtos;
    }
    public void setProdutos(JLabel produtos) {
        this.produtos = produtos;
    }  
    
    private void configuraJanela() {
        this.setSize(600, 400);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        //Configuração da janela
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);      

        setTitle(Session.titleAccordingToSession());
        
        setLocationRelativeTo(null);        
    }
    
    public void configRightPanel(){        
        rightPanel = new JPanel();
        rightPanel.setVisible(true);
        rightPanel.setBackground(new Color(246, 251, 244));
        rightPanel.setPreferredSize(new Dimension(300, 400));
        
        rightPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Dados da Compra"));

        rightPanel.setLayout(new BorderLayout());

        
        //Instanciando e configurando os botões
        /*
        btnSeller.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeller.setBackground(Color.WHITE);
        btnSeller.setForeground(Color.black);
        //btnSeller.addMouseListener(new SaleEvents(btnSeller));
        
        btnClient = new javax.swing.JButton("Cadastrar cliente");
        btnClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClient.setBackground(Color.WHITE);
        btnClient.setForeground(Color.black);
        //btnClient.addMouseListener(new SaleEvents(btnClient));
        
        btnProduct = new javax.swing.JButton("Gerenciar estoque");
        btnProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProduct.setBackground(Color.WHITE);
        btnProduct.setForeground(Color.black);
        //btnProduct.addMouseListener(new SaleEvents(btnProduct));
        
        btnSale = new javax.swing.JButton("Sessão de vendas");
        btnSale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSale.setBackground(Color.WHITE);
        btnSale.setForeground(Color.black);
        //btnSale.addMouseListener(new SaleEvents(btnSale));
        
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
        
        */
        principal.add(rightPanel, BorderLayout.EAST);
        
    }
    
    private void configLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setVisible(true);
        leftPanel.setBackground(new Color(246, 251, 244));
        leftPanel.setPreferredSize(new Dimension(350, 400));
        leftPanel.setLayout(new GridLayout(4, 3, 3, 0));
        principal.add(leftPanel, BorderLayout.WEST);
        
        JPanel leftGap = new JPanel();
        leftGap.setPreferredSize(new Dimension(30, 330));
        leftGap.setBackground(new Color(246, 251, 244));
        
        JPanel rightGap = new JPanel();
        rightGap.setPreferredSize(new Dimension(30, 330));
        rightGap.setBackground(new Color(246, 251, 244));
        //rightGap.setBackground(Color.GRAY);
        rightGap.setVisible(true);
        
        String[] listOfProducts = ProductRepository.getListOfProducts();
        produtos = new JLabel("Lista de Produtos");
        cbProdutos = new JComboBox(listOfProducts);
        
        String[] listOfClientes = ClientRepository.getListOfClients();
        clientes = new JLabel("Lista de Clientes");
        cbClientes = new JComboBox(listOfClientes);
        
        leftPanel.add(leftGap);
        leftPanel.add(produtos);
        leftPanel.add(cbProdutos);         
        leftPanel.add(clientes);
        leftPanel.add(cbClientes);
        leftPanel.add(rightGap);
        
        leftPanel.repaint();
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
        SaleFrame tela = new SaleFrame();
        tela.montaTela();
    }

}

