/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasalessystem.Frames.Seller;

import com.mycompany.javasalessystem.Models.Seller;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Marcos Paulo
 */
public class SellerListEvent implements ListSelectionListener {

    SellerFrame tela;

    public SellerListEvent(SellerFrame tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = tela.getList().getSelectedIndex();

        if (firstIndex != -1) {
            Seller elementAt = (Seller) tela.getList().getModel().getElementAt(firstIndex);
            tela.getTfId().setText(elementAt.getId());
            tela.getTfName().setText(elementAt.getName());
            tela.getTfEmail().setText(elementAt.getEmail());
            tela.getTfPassword().setText(elementAt.getPassword());
            tela.getTfOccupation().setText(elementAt.getOccupation());
        }
    }

}