/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames;

import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Repositories.ProductRepository;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ProductEvents implements MouseListener {
    
    private final ProductFrame frame;
    private final JButton button;
    private final ProductRepository productRepository;
    
    public ProductEvents(ProductFrame frame, JButton button) {
        this.frame = frame;
        this.button = button;
        this.productRepository = new ProductRepository();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (button.getText()) {
            case "Adicionar" -> {
                DefaultListModel<Product> model = (DefaultListModel<Product>) frame.getList().getModel();
                    
                String id = frame.getTfId().getText();
                String name = frame.getTfName().getText();
                int quantity = Integer.parseInt(frame.getTfQuantity().getText());
                double price = Double.parseDouble(frame.getTfPrice().getText());
                
            try {
                model.addElement(ProductRepository.create(name, price, quantity));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

                frame.getList().setModel(model);
                frame.repaint();
            }
            case "Editar" -> {
                int selectedIndex = frame.getList().getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<Product> model = (DefaultListModel<Product>) frame.getList().getModel();
                    
                    Product product = model.getElementAt(selectedIndex);
                    product.setId(frame.getTfId().getText());
                    product.setName(frame.getTfName().getText());
                    product.setQuantity(Integer.parseInt(frame.getTfQuantity().getText()));
                    product.setPrice(Double.parseDouble(frame.getTfPrice().getText()));
                    
                    try {
                        ProductRepository.update(product.getId(), product.getName(), product.getPrice(), product.getQuantity());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    
                    frame.repaint();
                }
            }
            case "Limpar" -> {
                frame.getTfId().setText("");
                frame.getTfName().setText("");
                frame.getTfQuantity().setText("");
                frame.getTfPrice().setText("");
                
            }
            case "Remover" ->{
                int selectedIndex = frame.getList().getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<Product> model = (DefaultListModel<Product>) frame.getList().getModel();
                    Product product = model.get(selectedIndex);
                    model.removeElementAt(selectedIndex);
                    frame.getList().setModel(model);
                    try {
                        ProductRepository.delete(product.getId());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                                
                    frame.repaint();
                }
                
                
            }
        }
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
