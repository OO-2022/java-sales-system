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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.swing.DefaultListModel;

public class ClientWindowEvents implements WindowListener {

    private final ClientFrame frame;
    private final ClientRepository sellerRepository;

    public ClientWindowEvents(ClientFrame frame) {
        this.frame = frame;
        sellerRepository = new ClientRepository();
    }

    @Override
    public void windowOpened(WindowEvent e) {

        sellerRepository.load();
        List<Client> clients = ClientRepository.getClients();

        DefaultListModel<Client> model = new DefaultListModel<>();
        for (Client client : clients) {
            model.addElement(client);
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
