/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javasalessystem.Frames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Marcos Paulo
 */
public class AdminEvents implements MouseListener{
    private JButton button;

    
    public AdminEvents(JButton button) {
        this.button = button;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (button.getText().equals("Cadastrar funcionário")){
            
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
