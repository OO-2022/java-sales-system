/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames.Seller;

import com.mycompany.javasalessystem.Models.Seller;
import com.mycompany.javasalessystem.Models.Admin;
import com.mycompany.javasalessystem.Models.User;


import com.mycompany.javasalessystem.Repositories.SellerRepository;
import com.mycompany.javasalessystem.Repositories.AdminRepository;
import com.mycompany.javasalessystem.Utils.Encrypt;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
                String occupation = frame.getCbOccupation().getSelectedItem().toString();
                String cpf = frame.getTfCpf().getText();
                
                try {                
                    model.addElement(SellerRepository.create(name, email, password, occupation, cpf));                
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                    frame.getList().setModel(model);
                    frame.repaint();
                }
            case "Editar" -> {
                int selectedIndex = frame.getList().getSelectedIndex();
                if (selectedIndex != -1) {
                    
                    String id = frame.getTfId().getText();
                    String name = frame.getTfName().getText();
                    String email = frame.getTfEmail().getText();
                    String password = frame.getTfPassword().getText();
                    String occupation = frame.getCbOccupation().getSelectedItem().toString();
                    String cpf = frame.getTfCpf().getText();
                    
                    try {
                        SellerRepository.update(id, name, email, password, occupation, cpf);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                        
                   
                    frame.repaint();
                }
            }
            case "Limpar" -> {
                frame.getTfName().setText("");
                frame.getTfCpf().setText("");
                frame.getTfEmail().setText("");
                frame.getTfPassword().setText("");
                
            }
            case "Remover" ->{
                int selectedIndex = frame.getList().getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<Seller> model = (DefaultListModel<Seller>) frame.getList().getModel();
                    Seller seller = model.get(selectedIndex);
                    model.removeElementAt(selectedIndex);
                    frame.getList().setModel(model);
                    try {
                        SellerRepository.delete(seller.getId());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
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
