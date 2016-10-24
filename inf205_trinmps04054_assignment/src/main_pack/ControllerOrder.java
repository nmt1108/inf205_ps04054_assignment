/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manhtri
 */
public class ControllerOrder implements ActionListener{
    SMS_View_Order oView;
    SMS_View view;
    OrderList oList;
    ProductList prodList;
    CustomerList cusList;
    DatabaseHandler dbh;
   
   public ControllerOrder(SMS_View_Order oView,SMS_View view , DatabaseHandler dbh ){
       this.oView = oView;      
       this.view = view;
       this.dbh = dbh;
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == oView.getButton("add")) {
            System.out.println("Read data from view!");
            try {
                //            System.out.println("Add to LinkedList, print LinkedList details");
//            oList.addOrder(oView.getData(), prodList, cusList);
//            //get more data of product from users
//            //System.out.println("Add to ArrayList, print ArrayList details");
//            
//            oList.getDetail(oList.getOList());
//            //using linked list
            dbh.addToDB("order_product", oView.getData());
            } catch (SQLException ex) {
                System.out.println(ex.getCause());
            }
            //update sold record and num in stock record in product table
            
            
            
            
        } else if (e.getSource() == oView.getButton("clear")) {
            oView.clear();
            System.out.println("Text Clear");
        } else if (e.getSource() == oView.getButton("quit")) {
           
                //fhl.writeToFile(path, prodList.getProductList_ar());
            
        }
        System.out.println("End of event! Next event");
    }
    
}
