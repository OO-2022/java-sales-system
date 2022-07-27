/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames;

import com.mycompany.javasalessystem.Models.Product;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class ProductFrame extends JFrame{
    
    private JPanel principal;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JList list;
    
    JLabel id;
    JTextField tfId;
    JLabel name;
    JTextField tfName;
    JLabel quantity;
    JTextField tfQuantity;
    JLabel price;
    JTextField tfPrice;
    Border lineBorder;
    //Getters e setters
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
    public JList getList() {
        return list;
    }
    public void setList(JList list) {
        this.list = list;
    }
    public JLabel getId() {
        return id;
    }
    public void setId(JLabel id) {
        this.id = id;
    }
    public JTextField getTfId() {
        return tfId;
    }
    public void setTfId(JTextField tfId) {
        this.tfId = tfId;
    }
    public JLabel getNameX() {
        return name;
    }
    public void setName(JLabel name) {
        this.name = name;
    }
    public JTextField getTfName() {
        return tfName;
    }
    public void setTfName(JTextField tfName) {
        this.tfName = tfName;
    }
    public JLabel getQuantity() {
        return quantity;
    }
    public void setQuantity(JLabel quantity) {
        this.quantity = quantity;
    }
    public JTextField getTfQuantity() {
        return tfQuantity;
    }
    public void setTfQuantity(JTextField tfQuantity) {
        this.tfQuantity = tfQuantity;
    }
    public JLabel getPrice() {
        return price;
    }
    public void setPrice(JLabel price) {
        this.price = price;
    }
    public JTextField getTfPrice() {
        return tfPrice;
    }
    public void setTfPrice(JTextField tfPrice) {
        this.tfPrice = tfPrice;
    }

    public ProductFrame() {
         lineBorder = BorderFactory.createLineBorder(new Color(75, 134, 115));
    }
    
    private void configuraJanela() {
        setSize(700, 500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Administração de estoque");
        setResizable(false);
        setLocationRelativeTo(null);
        
        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBackground(new Color(249, 254, 248));
        
        DefaultListModel<Product> model = new DefaultListModel<>();
        list = new JList<>(model);
        
        this.addWindowListener(new ProductWindowEvents(this));
    }

    private void configRightPanel() {
        //painel com 3 subdivisoes
        rightPanel = new JPanel();
        rightPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Produto"));
        rightPanel.setLayout(new FlowLayout(0, 0, 0));
        rightPanel.setPreferredSize(new Dimension(400, 400));
        rightPanel.setBackground(new Color(246, 251, 244));
                
        JPanel leftGap = new JPanel();
        leftGap.setPreferredSize(new Dimension(30, 330));
        leftGap.setBackground(new Color(246, 251, 244));
        
        //painel central com as informações
        JPanel midGap = new JPanel();
        //midGap.setPreferredSize(new Dimension(320, 330));
        midGap.setPreferredSize(new Dimension(330, 400));
        midGap.setBackground(new Color(246, 251, 244));
        midGap.setLayout(new GridLayout(3,1,5,20));
        configMidGap(midGap);
        
        JPanel rightGap = new JPanel();
        rightGap.setPreferredSize(new Dimension(30, 330));
        rightGap.setBackground(new Color(246, 251, 244));
        rightGap.setVisible(true);
        
        rightPanel.add(leftGap);
        rightPanel.add(midGap);
        rightPanel.add(rightGap);
        
        principal.add(rightPanel, BorderLayout.EAST);
    }
    private void configMidGap(JPanel midGap){
        //topPanel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4,2,10,0));
        topPanel.setPreferredSize(new Dimension(300, 100));
        topPanel.setBackground(new Color(246, 251, 244));
        
        id = new JLabel("ID");
        tfId = new JTextField();
        tfId.setEditable(false);
        name = new JLabel("Name");
        tfName = new JTextField();
        quantity = new JLabel("Quantity");
        tfQuantity = new JTextField();
        price = new JLabel("Price");
        tfPrice = new JTextField();

        //adicionando cada componente em ordem pré-determinada
        topPanel.add(id);
        topPanel.add(name);
        topPanel.add(tfId);
        topPanel.add(tfName);
        topPanel.add(quantity);
        topPanel.add(price);
        topPanel.add(tfQuantity);
        topPanel.add(tfPrice);
        
        //centerPanel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,2,25,20));
        centerPanel.setPreferredSize(new Dimension(300, 10));
        centerPanel.setBackground(new Color(246, 251, 244));
        
        JButton adicionar = new JButton("Adicionar");
        adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adicionar.setBackground(Color.WHITE);
        adicionar.setForeground(Color.black);
        adicionar.addMouseListener(new ProductEvents(this, adicionar));
        
        JButton editar = new JButton("Editar");
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.setBackground(Color.WHITE);
        editar.setForeground(Color.black);
        editar.addMouseListener(new ProductEvents(this, editar));
        
        JButton limpar = new JButton("Limpar");
        limpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpar.setBackground(Color.WHITE);
        limpar.setForeground(Color.black);
        limpar.addMouseListener(new ProductEvents(this, limpar));
        
        JButton remover = new JButton("Remover");
        remover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remover.setBackground(Color.WHITE);
        remover.setForeground(Color.black);
        remover.addMouseListener(new ProductEvents(this, remover));
        
        centerPanel.add(adicionar);
        centerPanel.add(editar);
        centerPanel.add(limpar);
        centerPanel.add(remover);
        
        //bottomPanel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,2,0,10));
        bottomPanel.setPreferredSize(new Dimension(300, 100));
        bottomPanel.setBackground(new Color(246, 251, 244));
        
        midGap.add(topPanel);
        midGap.add(centerPanel);
        midGap.add(bottomPanel);
    }
    private void configLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Estoque"));
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(280, 330));
        leftPanel.setBackground(new Color(246, 251, 244));

        list.setVisible(true);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new ProductListEvent(this));
        leftPanel.add(new JScrollPane(list), BorderLayout.CENTER);
        
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
        ProductFrame tela = new ProductFrame();
        tela.montaTela();
    }
}
