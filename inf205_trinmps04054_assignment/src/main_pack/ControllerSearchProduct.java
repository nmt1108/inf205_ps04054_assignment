/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author manhtri
 */
public class ControllerSearchProduct implements ActionListener{
    ProductList prodList;
    SMS_View_Search_Product searchPView;
    SMS_View view;
    DatabaseHandler dbh;
    //FileHandler<Product> fhl = new FileHandler();
    //String path = "F:\\Netbeans Projects\\dsa_bt005_trinmgt60859_assignment_1\\data.txt";
    
    public ControllerSearchProduct(SMS_View_Search_Product searchPView,SMS_View view ,DatabaseHandler dbh){
        this.searchPView = searchPView;
       
        this.view = view;
        this.dbh = dbh;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        //searchPView.setVisible(true);
        //Product product = null;
        System.out.println("Action Event Search Product View started");
        String[] foundData = null;
        try {
                foundData = dbh.searchProductFromDB(searchPView.getCode(), "product");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }        
        if (e.getSource() == searchPView.getButton("search")) {
            if (foundData != null) {
                System.out.println("Record found!");
                searchPView.updateView(foundData);
                searchPView.getButton("edit").setEnabled(true);
                searchPView.getButton("delete").setEnabled(true);
                //searchPView.getButton("save").setEnabled(true);                
            } else {
                String s = "No data found";
                foundData = new String[6];
                foundData[0] = searchPView.getCode();
                foundData[1] = s;
                foundData[2] = s;
                foundData[3] = s;
                foundData[4] = s;
                foundData[5] = s;
                System.out.println("No record found!");
            }
            
        } else if (e.getSource() == searchPView.getButton("clear")) {
            searchPView.clear();
            System.out.println("Text Clear");
        } else if (e.getSource() == searchPView.getButton("edit")) {
            searchPView.enableF();
            searchPView.getButton("save").setEnabled(true);
            
            
            
        }else if (e.getSource() == searchPView.getButton("delete")) {
//            prodList.getProductList_ll().remove(product);
//            prodList.getDetail(prodList.getProductList_ar());
//            System.out.println("Item delete");
              
            
        }else if (e.getSource() == searchPView.getButton("save")) {
            try {
                dbh.updateRecord(searchPView.getCode(), foundData, "product");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }            
            System.out.println("Save edited record!");
        } else if (e.getSource() == searchPView.getButton("quit")){
            searchPView.setVisible(false);
            view.setVisible(true);
        } else{
            System.out.println("No button clicked!");
        }
        System.out.println("End of event! Next event");
    }
    }

    

