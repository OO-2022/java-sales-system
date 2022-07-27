/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames.Client;

import com.mycompany.javasalessystem.Models.Client;
import com.mycompany.javasalessystem.Repositories.ClientRepository;
import com.mycompany.javasalessystem.Utils.Encrypt;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ClientEvents implements MouseListener {
    
    private final ClientFrame frame;
    private final JButton button;
    private final ClientRepository clientRepository;
    
    public ClientEvents(ClientFrame frame, JButton button) {
        this.frame = frame;
        this.button = button;
        this.clientRepository = new ClientRepository();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (button.getText()) {
            case "Adicionar" -> {
                DefaultListModel<Client> model = (DefaultListModel<Client>) frame.getList().getModel();
                    
                String id = frame.getTfId().getText();
                String name = frame.getTfName().getText();
                String email = frame.getTfEmail().getText();
                String phone = frame.getTfPhone().getText();
                String cep = frame.getTfCep().getText();
                String cpf = frame.getTfCpf().getText();
                
            try {
                model.addElement(ClientRepository.create(name, cpf, email, phone, cep));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

                frame.getList().setModel(model);
                frame.repaint();
            }
            case "Editar" -> {
                int selectedIndex = frame.getList().getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<Client> model = (DefaultListModel<Client>) frame.getList().getModel();
                    
                    Client client = model.getElementAt(selectedIndex);
                    client.setId(frame.getTfId().getText());
                    client.setName(frame.getTfName().getText());
                    client.setCpf(frame.getTfCpf().getText());
                    client.setEmail(frame.getTfEmail().getText());
                    client.setPhone(frame.getTfPhone().getText());
                    client.setCep(frame.getTfCep().getText());
                    
                    try {
                        ClientRepository.update(client.getId(), client.getName(), client.getCpf(), client.getEmail(), client.getPhone(), client.getCep());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    
                    frame.repaint();
                }
            }
            case "Limpar" -> {
                frame.getTfName().setText("");
                frame.getTfCpf().setText("");
                frame.getTfEmail().setText("");
                frame.getTfPhone().setText("");
                frame.getTfCep().setText("");
                
            }
            case "Remover" ->{
                int selectedIndex = frame.getList().getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<Client> model = (DefaultListModel<Client>) frame.getList().getModel();
                    Client client = model.get(selectedIndex);
                    model.removeElementAt(selectedIndex);
                    frame.getList().setModel(model);
                    try {
                        ClientRepository.delete(client.getId());
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
