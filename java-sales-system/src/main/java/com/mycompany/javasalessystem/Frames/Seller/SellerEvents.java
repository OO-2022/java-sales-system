/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasalessystem.Frames.Seller;

import com.mycompany.javasalessystem.Models.Seller;
import com.mycompany.javasalessystem.Repositories.SellerRepository;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Paulo
 */
public class SellerEvents implements MouseListener {
    
    private final SellerFrame frame;
    private final JButton button;
    private final SellerRepository sellerRepository;
    
    public SellerEvents(SellerFrame frame, JButton button) {
        this.frame = frame;
        this.button = button;
        this.sellerRepository = new SellerRepository();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (button.getText()) {
            case "Adicionar" -> {
                DefaultListModel<Seller> model = (DefaultListModel<Seller>) frame.getList().getModel();
                    
                String id = frame.getTfId().getText();
                String name = frame.getTfName().getText();
                String email = frame.getTfEmail().getText();
                String password = frame.getTfPassword().getText();
                String occupation = frame.getTfOccupation().getText();
                
                model.addElement(SellerRepository.create(name, email, password, occupation));

                frame.getList().setModel(model);
                frame.repaint();
            }
            case "Editar" -> {
                int selectedIndex = frame.getList().getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<Seller> model = (DefaultListModel<Seller>) frame.getList().getModel();
                    
                    Seller seller = model.getElementAt(selectedIndex);
                    seller.setId(frame.getTfId().getText());
                    seller.setName(frame.getTfName().getText());
                    seller.setEmail(frame.getTfEmail().getText());
                    seller.setPassword(frame.getTfPassword().getText());
                    seller.setOccupation(frame.getTfOccupation().getText());
                    
                    SellerRepository.update(seller.getId(), seller.getName(), seller.getEmail(), seller.getPassword(), seller.getOccupation());
                    
                    frame.repaint();
                }
            }
            case "Limpar" -> {
                frame.getTfId().setText("");
                frame.getTfName().setText("");
                frame.getTfEmail().setText("");
                frame.getTfPassword().setText("");
                frame.getTfOccupation().setText("");
                
            }
            case "Remover" ->{
                int selectedIndex = frame.getList().getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<Seller> model = (DefaultListModel<Seller>) frame.getList().getModel();
                    Seller seller = model.get(selectedIndex);
                    model.removeElementAt(selectedIndex);
                    frame.getList().setModel(model);
                    SellerRepository.delete(seller.getId());
                                
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
