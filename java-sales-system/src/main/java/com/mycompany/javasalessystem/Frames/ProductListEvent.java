/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasalessystem.Frames;

import com.mycompany.javasalessystem.Models.Product;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Marcos Paulo
 */
public class ProductListEvent implements ListSelectionListener {

    ProductFrame tela;

    public ProductListEvent(ProductFrame tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = tela.getList().getSelectedIndex();

        if (firstIndex != -1) {
            Product elementAt = (Product) tela.getList().getModel().getElementAt(firstIndex);
            tela.getTfId().setText(elementAt.getId());
            tela.getTfName().setText(elementAt.getName());
            tela.getTfQuantity().setText(String.valueOf(elementAt.getQuantity()));
            tela.getTfPrice().setText(String.valueOf(elementAt.getPrice()));
        }
    }

}