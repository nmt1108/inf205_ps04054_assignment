/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;


/**
 *
 * @author manhtri
 */
public class ControllerAddProduct implements ActionListener, WindowListener{
    SMS_View_Add_Product apView;
    SMS_View view;
    //ProductList prodList;
    //FileHandler<Product> fhl = new FileHandler();
    //String path = "F:\\Netbeans Projects\\dsa_bt005_trinmgt60859_assignment_1\\test.txt";
    DatabaseHandler dbh;
    
    public ControllerAddProduct(SMS_View_Add_Product apView, SMS_View view, DatabaseHandler dbh ){
        this.dbh= dbh;
        this.apView = apView;
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action Event Add Product View started");
        if (e.getSource() == apView.getButton("add")) {
            System.out.println("Read data from view!");
            try {
                dbh.addToDB("product", apView.getData());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
//            prodList.addProduct(apView.getData());
//            //get more data of product from users
//            System.out.println("Add to ArrayList, print ArrayList details");
//            
//            prodList.getDetail(prodList.getProductList_ar());
//            //using linked list
//            System.out.println("Add to LinkedList, print LinkedList details");
//            
//            prodList.getDetail(prodList.getProductList_ll());
        } else if (e.getSource() == apView.getButton("clear")) {
            apView.clear();
            System.out.println("Text Clear");
        } else if (e.getSource() == apView.getButton("quit")) {
            view.setVisible(true);
            apView.setVisible(false);
        }
        System.out.println("End of event! Next event");
    }
    

    @Override
    public void windowOpened(WindowEvent we) {
         
    }

    @Override
    public void windowClosing(WindowEvent we) {
       
    }

    @Override
    public void windowClosed(WindowEvent we) {
       
    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
      
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }
    
}
