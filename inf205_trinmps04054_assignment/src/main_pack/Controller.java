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
import java.io.IOException;
import java.sql.SQLException;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author ManhTri
 */
public class Controller implements ActionListener, WindowListener {
    SMS_View view;
    //Product related view
    SMS_View_Add_Product apView;
    SMS_View_Search_Product spView;
    //Customer related view
    SMS_View_Add_Customer acView;
    SMS_View_Search_Customer scView;
    
    SMS_View_Order oView;
    //SMS_View_Search_Customer spView;
    //Use data structure.
    ProductList prodList ;
    CustomerList cusList;
    OrderList oList;
    //Handling data from database
    DatabaseHandler dbh;
    
    

    public Controller(SMS_View view, DatabaseHandler dbh) {
        this.view = view;
        this.dbh = dbh;
    }
   

    @Override
    public void windowOpened(WindowEvent e) {
        try {
            dbh.connect();
            System.out.println("Database connected!");
        }catch(SQLException ex2){
            System.out.println("SQL error!");
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {                       
        if(e.getSource() == view.getButton("add_product")){
            apView = new SMS_View_Add_Product();
            ControllerAddProduct ctrl_a = new ControllerAddProduct(apView,view, dbh);
            apView.registerListener(ctrl_a);            
            apView.setVisible(true);
            view.setVisible(false);
        }else if(e.getSource() == view.getButton("search_product")){
            spView = new SMS_View_Search_Product();
            ControllerSearchProduct ctrl_s = new ControllerSearchProduct(spView, view ,dbh);
            spView.registerListener(ctrl_s);            
            spView.setVisible(true);
            view.setVisible(false);
        }else if(e.getSource() == view.getButton("add_customer")){
            acView = new SMS_View_Add_Customer();
            ControllerAddCustomer ctrl_ac = new ControllerAddCustomer(acView,  view ,dbh);
            acView.registerListener(ctrl_ac); 
            acView.setVisible(true); 
            view.setVisible(false);
        }else if(e.getSource() == view.getButton("search_customer")){
            scView = new SMS_View_Search_Customer();
            ControllerSearchCustomer ctrl_sc = new ControllerSearchCustomer(scView, view ,dbh);
            scView.registerListener(ctrl_sc); 
            scView.setVisible(true); 
            view.setVisible(false);
        }else if(e.getSource() == view.getButton("order")){
            oView = new SMS_View_Order();
            ControllerOrder ctrl_o = new ControllerOrder(oView, view ,dbh);
            oView.registerListener(ctrl_o); 
            scView.setVisible(true); 
            view.setVisible(false);
        }else if(e.getSource() == view.getButton("quit_program")){
            
        }

    }
    
    
    
   
}
