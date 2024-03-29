/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

 */

package com.mycompany.javasalessystem.Frames.Seller.CRUDSeller;

import com.mycompany.javasalessystem.Models.Seller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CreateSellerListEvent implements ListSelectionListener {

    CreateSellerFrame tela;

    public CreateSellerListEvent(CreateSellerFrame tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = tela.getList().getSelectedIndex();

        if (firstIndex != -1) {
            Seller elementAt = (Seller) tela.getList().getModel().getElementAt(firstIndex);
            tela.getTfId().setText(elementAt.getId());
            tela.getTfName().setText(elementAt.getName());
            tela.getTfCpf().setText(elementAt.getCpf());
            tela.getTfEmail().setText(elementAt.getEmail());
            tela.getTfPassword().setText(elementAt.getPassword());
            tela.getCbOccupation().setSelectedItem(elementAt.getOccupation());
        }
    }

}
