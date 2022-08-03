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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.DefaultListModel;

public class CreateAdminWindowEvents implements WindowListener {

    private final CreateAdminFrame frame;
    private final AdminRepository adminRepository;

    public CreateAdminWindowEvents(CreateAdminFrame frame) {
        this.frame = frame;
        adminRepository = new AdminRepository();
    }

    @Override
    public void windowOpened(WindowEvent e) {

        adminRepository.load();
        List<Admin> admins = AdminRepository.getAdmins();

        DefaultListModel<Admin> model = new DefaultListModel<>();
        for (Admin admin : admins) {
            model.addElement(admin);
        }
        frame.getList().setModel(model);

        frame.repaint();
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
