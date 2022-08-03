/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

 */

package com.mycompany.javasalessystem.Frames.Client;

import com.mycompany.javasalessystem.Models.Client;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClientListEvent implements ListSelectionListener {

    ClientFrame tela;

    public ClientListEvent(ClientFrame tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = tela.getList().getSelectedIndex();

        if (firstIndex != -1) {
            Client elementAt = (Client) tela.getList().getModel().getElementAt(firstIndex);
            tela.getTfId().setText(elementAt.getId());
            tela.getTfName().setText(elementAt.getName());
            tela.getTfCpf().setText(elementAt.getCpf());
            tela.getTfEmail().setText(elementAt.getEmail());
            tela.getTfPhone().setText(elementAt.getPhone());
            tela.getTfCep().setText(elementAt.getCep());
        }
    }

}
