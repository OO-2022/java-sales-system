/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames.Seller;

import com.mycompany.javasalessystem.Models.Seller;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.JComboBox;

public class SellerFrame extends JFrame{
    
    private JPanel principal;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JList list;
    
    JLabel id;
    JTextField tfId;
    JLabel name;
    JTextField tfName;
    JLabel email;
    JTextField tfEmail;
    JLabel password;
    JPasswordField tfPassword;
    JLabel occupation;
    JComboBox cbOccupation;
    JLabel cpf;
    JTextField tfCpf;
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
    public JLabel getEmail() {
        return email;
    }
    public void setEmail(JLabel email) {
        this.email = email;
    }
    public JTextField getTfEmail() {
        return tfEmail;
    }
    public void setTfEmail(JTextField tfEmail) {
        this.tfEmail = tfEmail;
    }
    public JLabel getPassword() {
        return password;
    }
    public void setPassword(JLabel password) {
        this.password = password;
    }
    public JTextField getTfPassword() {
        return tfPassword;
    }
    public void setTfPassword(JPasswordField tfPassword) {
        this.tfPassword = tfPassword;
    }
    public JLabel getOccupation() {
        return occupation;
    }
    public void setOccupation(JLabel occupation) {
        this.occupation = occupation;
    }
    public JComboBox getCbOccupation() {
        return cbOccupation;
    }
    public void setCbOccupation(JComboBox cbOccupation) {
        this.cbOccupation = cbOccupation;
    }
    public JLabel getCpf() {
        return cpf;
    }
    public void setCpf(JLabel cpf) {
        this.cpf = cpf;
    }
    public JTextField getTfCpf() {
        return tfCpf;
    }
    public void setTfCpf(JTextField tfCpf) {
        this.tfCpf = tfCpf;
    }

    public SellerFrame() {
         lineBorder = BorderFactory.createLineBorder(new Color(75, 134, 115));
    }
    
    private void configuraJanela() {
        setSize(700, 500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Controle de Vendedores");
        setResizable(false);
        setLocationRelativeTo(null);
        
        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        principal.setBackground(new Color(249, 254, 248));
        
        DefaultListModel<Seller> model = new DefaultListModel<>();
        list = new JList<>(model);
        
        this.addWindowListener(new SellerWindowEvents(this));
    }

    private void configRightPanel() {
        //painel com 3 subdivisoes
        rightPanel = new JPanel();
        rightPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Vendedor"));
        rightPanel.setLayout(new FlowLayout(0, 0, 0));
        rightPanel.setPreferredSize(new Dimension(400, 400));
        rightPanel.setBackground(new Color(246, 251, 244));
        //rightPanel.setBackground(Color.BLACK);
                
        JPanel leftGap = new JPanel();
        leftGap.setPreferredSize(new Dimension(30, 330));
        leftGap.setBackground(new Color(246, 251, 244));
        //leftGap.setBackground(Color.LIGHT_GRAY);
        
        //painel central com as informações
        JPanel midGap = new JPanel();
        midGap.setPreferredSize(new Dimension(330, 400));
        midGap.setBackground(new Color(246, 251, 244));
        //midGap.setBackground(Color.BLUE);
        midGap.setLayout(new GridLayout(2,1,40,40));
        configMidGap(midGap);
        
        JPanel rightGap = new JPanel();
        rightGap.setPreferredSize(new Dimension(30, 330));
        rightGap.setBackground(new Color(246, 251, 244));
        //rightGap.setBackground(Color.GRAY);
        rightGap.setVisible(true);
        
        rightPanel.add(leftGap);
        rightPanel.add(midGap);
        rightPanel.add(rightGap);
        
        principal.add(rightPanel, BorderLayout.EAST);
    }
    
    private void configMidGap(JPanel midGap){
        //topPanel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6,2,1,2));
        topPanel.setPreferredSize(new Dimension(300, 100));
        topPanel.setBackground(new Color(246, 251, 244));
        //topPanel.setBackground(Color.YELLOW);
        
        id = new JLabel("ID");
        tfId = new JTextField();
        tfId.setEditable(false);
        name = new JLabel("Name");
        tfName = new JTextField();
        cpf = new JLabel("Cpf");
        tfCpf = new JTextField();
        email = new JLabel("Email");
        tfEmail = new JTextField();
        password = new JLabel("Password");
        tfPassword = new JPasswordField();
        
        String listOfOccupations[] = {"Vendedor", "Gerente de Vendas", "Supervisor de Vendas"};
        
        occupation = new JLabel("Occupation");
        cbOccupation = new JComboBox(listOfOccupations);
                
        //adicionando cada componente em ordem pré-determinada
        topPanel.add(id);
        topPanel.add(tfId);
        topPanel.add(name);
        topPanel.add(tfName);
        topPanel.add(cpf);
        topPanel.add(tfCpf);
        topPanel.add(email);
        topPanel.add(tfEmail);
        topPanel.add(password);
        topPanel.add(tfPassword);
        topPanel.add(occupation);
        topPanel.add(cbOccupation);
        
        //centerPanel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,2,15,15));
        centerPanel.setPreferredSize(new Dimension(300, 10));
        centerPanel.setBackground(new Color(246, 251, 244));
        //centerPanel.setBackground(Color.MAGENTA);
        
        JButton adicionar = new JButton("Adicionar");
        adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adicionar.setBackground(Color.WHITE);
        adicionar.setForeground(Color.black);
        adicionar.addMouseListener(new SellerEvents(this, adicionar));
        
        JButton editar = new JButton("Editar");
        editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editar.setBackground(Color.WHITE);
        editar.setForeground(Color.black);
        editar.addMouseListener(new SellerEvents(this, editar));
        
        JButton limpar = new JButton("Limpar");
        limpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpar.setBackground(Color.WHITE);
        limpar.setForeground(Color.black);
        limpar.addMouseListener(new SellerEvents(this, limpar));
        
        JButton remover = new JButton("Remover");
        remover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remover.setBackground(Color.WHITE);
        remover.setForeground(Color.black);
        remover.addMouseListener(new SellerEvents(this, remover));
        
        centerPanel.add(adicionar);
        centerPanel.add(editar);
        centerPanel.add(limpar);
        centerPanel.add(remover);
        
        //bottomPanel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,2,0,10));
        bottomPanel.setPreferredSize(new Dimension(10, 100));
        bottomPanel.setBackground(new Color(246, 251, 244));
        //bottomPanel.setBackground(Color.PINK);
        
        midGap.add(topPanel);
        midGap.add(centerPanel);
        //midGap.add(bottomPanel);
    }
    
    private void configLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Vendedores"));
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(280, 330));
        leftPanel.setBackground(new Color(246, 251, 244));
        //leftPanel.setBackground(Color.RED);

        list.setVisible(true);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new SellerListEvent(this));
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
        SellerFrame tela = new SellerFrame();
        tela.montaTela();
    }
}
