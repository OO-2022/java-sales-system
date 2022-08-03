/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

 */

package com.mycompany.javasalessystem.Frames.Sale;

import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Models.Sale;
import com.mycompany.javasalessystem.Models.Client;
import com.mycompany.javasalessystem.Utils.Session;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.ArrayList;

public class SaleFrame extends JFrame {

    private JPanel principal;
    private JPanel rightPanel;
    private JPanel leftPanel;

    private JList listaCompras;

    JPanel salePanel = new JPanel();
    JPanel saleProductsPanel = new JPanel();
    Sale sale = null;

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

    JLabel clienteText;

    JButton finalizaCompra;

    Border lineBorder;

    JScrollPane scrollFrame = new JScrollPane();

    public String getClienteText() {
        return this.clienteText.getText();
    }

    public void setClienteText(String conteudo) {
        clienteText.setText(conteudo);
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public SaleFrame() {
        lineBorder = BorderFactory.createLineBorder(new Color(75, 134, 115));
    }

    public JComboBox getCbProdutos() {
        return cbProdutos;
    }

    public JComboBox getCbClientes() {
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

        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        //Configuração da janela
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);

        setTitle(Session.titleAccordingToSession());

        this.addWindowListener(new SaleWindowEvents(this));

        setLocationRelativeTo(null);
    }

    public void configSale() {
        saleProductsPanel.removeAll();

        ArrayList<Product> produtosCompra = sale.getProducts();
        saleProductsPanel.setLayout(new FlowLayout());
        saleProductsPanel.setPreferredSize(new Dimension(320, 800));

        salePanel.setLayout(new BorderLayout());

        clienteText = new JLabel("");
        JPanel clientePanel = new JPanel();
        clientePanel.setBackground(new Color(246, 251, 244));
        clientePanel.setPreferredSize(new Dimension(350, 20));

        clientePanel.add(clienteText);

        salePanel.add(clientePanel, BorderLayout.NORTH);

        int cont = 0;
        for (Product product : produtosCompra) {
            String nome = product.getName();
            int quantidade = product.getQuantity();
            double preco = product.getPrice();
            int local = cont + 1;

            JPanel panel = new JPanel();
            JButton button = new JButton("Remover");
            button.addActionListener(e -> {
                SaleEvents evt = new SaleEvents(this, button);
                evt.removeItemFromList(local, quantidade);
            });

            JLabel line = new JLabel(nome + " - " + quantidade + " x " + preco + " = " + (preco * quantidade));
            panel.add(line);
            panel.add(button);
            saleProductsPanel.add(panel);
            cont++;
        }

        salePanel.add(scrollFrame, BorderLayout.CENTER);
        scrollFrame.setViewportView(saleProductsPanel);

        saleProductsPanel.revalidate();
        saleProductsPanel.repaint();

        scrollFrame.revalidate();
        scrollFrame.repaint();

        salePanel.revalidate();
        salePanel.repaint();
    }

    public void configRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setVisible(true);
        rightPanel.setBackground(new Color(246, 251, 244));
        rightPanel.setPreferredSize(new Dimension(350, 500));

        rightPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Dados da Compra"));

        rightPanel.setLayout(new BorderLayout());

        salePanel.setBackground(new Color(246, 251, 244));
        salePanel.setPreferredSize(new Dimension(350, 500));
        rightPanel.add(salePanel);

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
        centerContent.setLayout(new GridLayout(10, 1, 0, 15));

        leftPanel.add(rightGap, BorderLayout.WEST);
        leftPanel.add(leftGap, BorderLayout.EAST);
        leftPanel.add(topGap, BorderLayout.NORTH);
        leftPanel.add(bottomGap, BorderLayout.SOUTH);
        leftPanel.add(centerContent, BorderLayout.CENTER);

        clientes = new JLabel("Lista de Clientes");

        insertCliente = new JButton("Definir Cliente");
        insertCliente.addMouseListener(new SaleEvents(this, insertCliente));

        produtos = new JLabel("Lista de Produtos");

        totalProdutos = new JLabel("Total de Produtos");
        tfTotalProdutos = new JTextField();

        insertProduto = new JButton("Adiciona Produto");
        insertProduto.addMouseListener(new SaleEvents(this, insertProduto));

        centerContent.add(clientes);
        centerContent.add(cbClientes);
        centerContent.add(insertCliente);
        centerContent.add(produtos);
        centerContent.add(cbProdutos);
        centerContent.add(totalProdutos);
        centerContent.add(tfTotalProdutos);
        centerContent.add(insertProduto);

        finalizaCompra = new JButton("Finalizar Compra");
        finalizaCompra.addMouseListener(new SaleEvents(this, finalizaCompra));

        centerContent.add(finalizaCompra);

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
