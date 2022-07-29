/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames.Sale;

import com.mycompany.javasalessystem.Repositories.ProductRepository;
import com.mycompany.javasalessystem.Models.Product;

import com.mycompany.javasalessystem.Repositories.ClientRepository;
import com.mycompany.javasalessystem.Models.Client;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

import  com.mycompany.javasalessystem.Frames.Sale.SaleFrame;

public class SaleWindowEvents implements WindowListener {

    private final SaleFrame frame;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;
    

    public SaleWindowEvents(SaleFrame frame) {
        this.frame = frame;
        productRepository = new ProductRepository();
        clientRepository = new ClientRepository();
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        
        productRepository.load();  
        clientRepository.load();       
        
        ArrayList<Product> listOfProducts = ProductRepository.getProducts();

        for (Product product : listOfProducts) {
            frame.getCbProdutos().addItem(product);        
        }
        
        ArrayList<Client> listOfClients = ClientRepository.getClients();

        for (Client client : listOfClients) {
            frame.getCbClientes().addItem(client);        
        }
                
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
