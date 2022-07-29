/*
@authors

Aluna: Gabriella Carvalho                  Matrícula: 202165047A
Aluno: Marcos Paulo Rodrigues da Silva     Matrícula: 202165556C
Aluno: Rafael de Oliveira Vargas           Matrícula: 202035022
Aluno: Ticiano de Oliveira Fracette        Matrícula: 202065189AC

*/

package com.mycompany.javasalessystem.Frames.Sale;

import com.mycompany.javasalessystem.Models.Seller;
import com.mycompany.javasalessystem.Repositories.SellerRepository;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class SaleWindowEvents implements WindowListener {

    private final SaleFrame frame;
    private final SellerRepository sellerRepository;

    public SaleWindowEvents(SaleFrame frame) {
        this.frame = frame;
        sellerRepository = new SellerRepository();
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        
        sellerRepository.load();
        List<Seller> sellers  = SellerRepository.getSellers(); 

        DefaultListModel<Seller> model = new DefaultListModel<>();
        for (Seller seller : sellers) {
            model.addElement(seller);
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
