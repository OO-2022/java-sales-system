/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

 */

package com.mycompany.javasalessystem.Frames.Sale;

import com.mycompany.javasalessystem.Frames.Client.ClientFrame;
import com.mycompany.javasalessystem.Models.Sale;
import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Models.Client;
import com.mycompany.javasalessystem.Repositories.ClientRepository;
import com.mycompany.javasalessystem.Repositories.SaleRepository;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class SaleEvents implements MouseListener {

    private final SaleFrame frame;
    private final JButton button;
    private final SaleRepository saleRepository;

    public SaleEvents(SaleFrame frame, JButton button) {
        this.frame = frame;
        this.button = button;
        this.saleRepository = new SaleRepository();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (button.getText()) {
            case "Definir Cliente" -> {

                Client cliente = (Client) frame.cbClientes.getSelectedItem();

                try {
                    Sale sale = saleRepository.create(cliente.getCpf());
                    frame.setSale(sale);
                    frame.configSale();
                    frame.setClienteText(cliente.getName() + " - " + cliente.getCpf());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

                frame.repaint();

                break;
            }
            case "Criar Cliente" -> {
                ClientFrame telaClient = new ClientFrame();
                telaClient.montaTela();

                break;
            }
            case "Adiciona Produto" -> {
                if (frame.getSale() == null) {
                    JOptionPane.showMessageDialog(null, "Defina primeiro o cliente");
                    return;
                }

                try {
                    Product produto = (Product) frame.cbProdutos.getSelectedItem();
                    int quantidade = Integer.parseInt(frame.tfTotalProdutos.getText());

                    frame.getSale().addProduct(produto.getId(), quantidade);
                    frame.configSale();

                    frame.salePanel.repaint();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Entrada invalida");
                }

                break;
            }
            case "Finalizar Compra" -> {
                if (frame.getSale() == null || frame.getSale().getProducts().size() == 0) {
                    JOptionPane.showMessageDialog(null, "Para finalizar a compra, voce deve inicia-la");
                    return;
                }

                Object[] options = {"Sim", "Nao"};
                Client cliente = (Client) frame.cbClientes.getSelectedItem();
                int opcao = JOptionPane.showOptionDialog(null, "Deseja finalizar a venda?", "Venda do cliente " + cliente.getName(), JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                if (opcao == 1) {
                    return;
                }

                try {
                    geraNotaFiscal(frame.getSale());
                } catch (IOException ex) {
                    Logger.getLogger(SaleEvents.class.getName()).log(Level.SEVERE, null, ex);
                }

                opcao = JOptionPane.showOptionDialog(null, "Deseja outra venda?", "Venda do cliente " + cliente.getName(), JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                if (opcao == 0) {
                    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    SaleFrame telaSale = new SaleFrame();
                    telaSale.montaTela();
                    return;
                }

                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                break;
            }
        }

    }

    public void removeItemFromList(int position, int quantidade) {
        try {
            frame.getSale().removeProduct(position, quantidade);
            frame.configSale();

            frame.salePanel.repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void geraNotaFiscal(Sale sale) throws IOException {
        Client cliente = ClientRepository.findById(sale.getIdClient());

        FileWriter arq = new FileWriter("src/main/java/com/mycompany/javasalessystem/Temp/" + sale.getId() + ".txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("NOTA FISCAL%n");
        gravarArq.printf("- Cliente:" + cliente.getName() + "%n");
        gravarArq.printf("%n");

        for (Product product : sale.getProducts()) {
            String nome = product.getName();
            int quantidade = product.getQuantity();
            double preco = product.getPrice();

            gravarArq.printf("-> " + nome + ": " + quantidade + " x " + preco + " = " + (preco * quantidade) + "%n");
        }

        DecimalFormat df = new DecimalFormat("0.00");
        gravarArq.printf("Preco final: " + df.format(sale.getFinalPrice()) + "%n");
        gravarArq.printf("%n");
        gravarArq.printf("- Data: " + sale.getDate() + "%n");
        gravarArq.printf("%n");

        arq.close();

        JOptionPane.showMessageDialog(null, "\nNota Fiscal do cliente foi gravada com sucesso");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBackground(new Color(95, 208, 104));
        button.setForeground(new Color(246, 251, 244));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(Color.WHITE);
        button.setForeground(Color.black);
    }
}
