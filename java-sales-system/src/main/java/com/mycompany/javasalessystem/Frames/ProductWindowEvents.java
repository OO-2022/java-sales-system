/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames;

import com.mycompany.javasalessystem.Models.Product;
import com.mycompany.javasalessystem.Repositories.ProductRepository;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class ProductWindowEvents implements WindowListener {

    private final ProductFrame frame;
    private final ProductRepository productRepository;

    public ProductWindowEvents(ProductFrame frame) {
        this.frame = frame;
        productRepository = new ProductRepository();
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        
        productRepository.load();
        List<Product> products  = ProductRepository.getProducts();

        DefaultListModel<Product> model = new DefaultListModel<>();
        for (Product product : products) {
            model.addElement(product);
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
