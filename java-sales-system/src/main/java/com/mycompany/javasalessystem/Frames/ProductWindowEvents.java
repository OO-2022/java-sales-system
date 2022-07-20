/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

/**
 *
 * @author Marcos Paulo
 */
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
