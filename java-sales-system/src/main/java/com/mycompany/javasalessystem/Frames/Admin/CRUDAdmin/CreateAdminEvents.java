/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

 */
package com.mycompany.javasalessystem.Frames.Admin.CRUDAdmin;

import com.mycompany.javasalessystem.Models.Admin;

import com.mycompany.javasalessystem.Repositories.AdminRepository;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CreateAdminEvents implements MouseListener {

    private final CreateAdminFrame frame;
    private final JButton button;
    private final AdminRepository adminRepository;

    public CreateAdminEvents(CreateAdminFrame frame, JButton button) {
        this.frame = frame;
        this.button = button;
        this.adminRepository = new AdminRepository();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (button.getText()) {
            case "Adicionar" -> {
                DefaultListModel<Admin> model = (DefaultListModel<Admin>) frame.getList().getModel();

                //String id = frame.getTfId().getText();
                String name = frame.getTfName().getText();
                String email = frame.getTfEmail().getText();
                String password = frame.getTfPassword().getText();
                String occupation = frame.getCbOccupation().getSelectedItem().toString();
                String cpf = frame.getTfCpf().getText();

                try {
                    model.addElement(AdminRepository.create(name, email, password, occupation, cpf));
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
                        AdminRepository.update(id, name, email, password, occupation, cpf);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }

                    frame.repaint();
                }
            }
            case "Limpar" -> {
                frame.getTfId().setText("");
                frame.getTfName().setText("");
                frame.getTfCpf().setText("");
                frame.getTfEmail().setText("");
                frame.getTfPassword().setText("");

            }
            case "Remover" -> {
                int selectedIndex = frame.getList().getSelectedIndex();
                if (selectedIndex != -1) {
                    DefaultListModel<Admin> model = (DefaultListModel<Admin>) frame.getList().getModel();
                    Admin admin = model.get(selectedIndex);
                    model.removeElementAt(selectedIndex);
                    frame.getList().setModel(model);

                    try {
                        AdminRepository.delete(admin.getId());
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
