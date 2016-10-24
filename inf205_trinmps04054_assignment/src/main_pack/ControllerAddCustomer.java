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

/**
 *
 * @author manhtri
 */
public class ControllerAddCustomer implements ActionListener{
    SMS_View view;
    SMS_View_Add_Customer acView;
    DatabaseHandler dbh;
    
    
    public ControllerAddCustomer(SMS_View_Add_Customer acView,SMS_View view ,DatabaseHandler dbh){
        this.dbh= dbh;
        this.acView = acView;
        this.view = view;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action Event Add Product View started");
        if (e.getSource() == acView.getButton("add")) {
            System.out.println("Read data from view!");
             try {
                dbh.addToDB("product", acView.getData());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
//            cusList.addCustomer(acView.getData());
//            //get more data of product from users
//            System.out.println("Add to ArrayList, print ArrayList details");
//            
//            cusList.getCusListDetail(cusList.getCus_al());
//            //using linked list
//            System.out.println("Add to LinkedList, print LinkedList details");
//            
//            cusList.getCusListDetail(cusList.getCus_al());
        } else if (e.getSource() == acView.getButton("clear")) {
            acView.clear();
            System.out.println("Text Clear");
        } else if (e.getSource() == acView.getButton("quit")) {
            view.setVisible(true);
            acView.setVisible(false);
        }
        System.out.println("End of event! Next event");
    }
      
}
