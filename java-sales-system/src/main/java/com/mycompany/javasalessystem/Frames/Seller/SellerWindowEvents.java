package com.mycompany.javasalessystem.Frames.Seller;

import com.mycompany.javasalessystem.Models.Seller;
import com.mycompany.javasalessystem.Repositories.SellerRepository;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class SellerWindowEvents implements WindowListener {

    private final SellerFrame frame;
    private final SellerRepository sellerRepository;

    public SellerWindowEvents(SellerFrame frame) {
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
