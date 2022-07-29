/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames.Sale;

import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Models.Client;
import com.mycompany.javasalessystem.Utils.Session;
import com.mycompany.javasalessystem.Repositories.ProductRepository;
import com.mycompany.javasalessystem.Repositories.ClientRepository;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.Arrays;

public class SaleFrame extends JFrame{
    private JPanel principal;
    private JPanel rightPanel;
    private JPanel leftPanel;
    
    private JList listaCompras;
    
    JComboBox cbClientes = new JComboBox(); 
    DefaultListModel<Client> modelClient = new DefaultListModel<>();
    DefaultListModel<Product> modelProduct = new DefaultListModel<>();

    JLabel clientes;
    JButton insertCliente;

    JComboBox cbProdutos = new JComboBox();

    JLabel produtos;
    JButton insertProduto;
    
    JLabel totalProdutos;
    JTextField tfTotalProdutos;
    
    Border lineBorder;   
    
    public SaleFrame() {
        lineBorder = BorderFactory.createLineBorder(new Color(75, 134, 115));
    }
    
    public JComboBox getCbProdutos(){
        return cbProdutos;
    }
    
    public JComboBox getCbClientes(){
        return cbClientes;
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
        this.setSize(700, 500);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        //Configuração da janela
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);      

        setTitle(Session.titleAccordingToSession());
        
        this.addWindowListener(new SaleWindowEvents(this));
        
        setLocationRelativeTo(null);        
    }
    
    public void configRightPanel(){        
        rightPanel = new JPanel();
        rightPanel.setVisible(true);
        rightPanel.setBackground(new Color(246, 251, 244));
        rightPanel.setPreferredSize(new Dimension(350, 500));
        
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
        leftPanel.setPreferredSize(new Dimension(350, 500));               
        
        leftPanel.setLayout(new BorderLayout());

        JPanel leftGap = new JPanel();
        leftGap.setPreferredSize(new Dimension(30, 400));
        leftGap.setBackground(new Color(246, 251, 244));
        
        JPanel rightGap = new JPanel();
        rightGap.setPreferredSize(new Dimension(30, 400));
        rightGap.setBackground(new Color(246, 251, 244));
        
        JPanel topGap = new JPanel();
        topGap.setPreferredSize(new Dimension(340, 50));
        topGap.setBackground(new Color(246, 251, 244));
        
        JPanel bottomGap = new JPanel();
        bottomGap.setPreferredSize(new Dimension(340, 50));
        bottomGap.setBackground(new Color(246, 251, 244));
        
        JPanel centerContent = new JPanel();
        centerContent.setPreferredSize(new Dimension(340, 400));
        centerContent.setBackground(new Color(246, 251, 244));
        centerContent.setLayout(new GridLayout(8,1,0,15));

        leftPanel.add(rightGap, BorderLayout.WEST);
        leftPanel.add(leftGap, BorderLayout.EAST);
        leftPanel.add(topGap, BorderLayout.NORTH);
        leftPanel.add(bottomGap, BorderLayout.SOUTH);
        leftPanel.add(centerContent, BorderLayout.CENTER);
        
        produtos = new JLabel("Lista de Produtos");
                               
        totalProdutos = new JLabel("Total de Produtos");
        tfTotalProdutos = new JTextField();
        
        insertProduto = new JButton("Adiciona Produto");
        insertProduto.addMouseListener(new SaleEvents(this, insertProduto));
        
        
        clientes = new JLabel("Lista de Clientes");  
        
        insertCliente = new JButton("Adiciona Cliente");
        insertCliente.addMouseListener(new SaleEvents(this, insertCliente));
        
        centerContent.add(produtos);
        centerContent.add(cbProdutos);           
        centerContent.add(totalProdutos);
        centerContent.add(tfTotalProdutos); 
        centerContent.add(insertProduto);        
        centerContent.add(clientes);
        centerContent.add(cbClientes);
        centerContent.add(insertCliente);
        
        
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
        SaleFrame tela = new SaleFrame();
        tela.montaTela();
    }

}

