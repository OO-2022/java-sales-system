/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames;

import com.mycompany.javasalessystem.Models.Product;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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