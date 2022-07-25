/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames;

import com.mycompany.javasalessystem.Frames.Seller.SellerFrame;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class AdminEvents implements MouseListener{
    private JButton button;

    
    public AdminEvents(JButton button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (button.getText().equals("Cadastrar funcionário")){
            SellerFrame telaSeller = new SellerFrame();
            telaSeller.montaTela();
        }
        else if (button.getText().equals("Cadastrar cliente")){
            
        }
        else if (button.getText().equals("Gerenciar estoque")){
            ProductFrame telaProduct = new ProductFrame();
            telaProduct.montaTela();
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
