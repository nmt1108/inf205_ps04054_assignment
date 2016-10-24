/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author manhtri
 */
public class ControllerSearchCustomer implements ActionListener{

    SMS_View view;
    //CustomerList cusList;
    SMS_View_Search_Customer scView;
    DatabaseHandler dbh;
    
    public ControllerSearchCustomer(SMS_View_Search_Customer scView,SMS_View view, DatabaseHandler dbh){
        this.scView = scView;
        
        this.view = view;
        this.dbh = dbh;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == scView.getButton("search")) {
            String foundData[] = null;
             try {
                foundData = dbh.searchProductFromDB(scView.getCode(), "product");

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            if (foundData != null) {
                System.out.println("Record found!");
                scView.updateView(foundData);
                scView.getButton("edit").setEnabled(true);
                scView.getButton("delete").setEnabled(true);
                //searchPView.getButton("save").setEnabled(true);                
            } else {
                String s = "No data found";
                foundData = new String[6];
                foundData[0] = scView.getCode();
                foundData[1] = s;
                foundData[2] = s;
                System.out.println("No record found!");
            }
            
        } else if (e.getSource() == scView.getButton("clear")) {
            scView.clear();
            System.out.println("Text Clear");
        } else if (e.getSource() == scView.getButton("edit")) {
            scView.enableF();
            scView.getButton("save").setEnabled(true);
            
            
            
        }else if (e.getSource() == scView.getButton("delete")) {
//            cusList.getCus_ll().remove(customer);
//            cusList.getCusListDetail(cusList.getCus_ll());
//            System.out.println("Item delete");
            
        } else if (e.getSource() == scView.getButton("enable")) {
            
            //System.out.println("Text Clear");
        } else if (e.getSource() == scView.getButton("disable")) {
           
            System.out.println("Disable Product List");
         
        } else if (e.getSource() == scView.getButton("save")) {
//            //remove old product
//            cusList.getCus_ll().remove(customer);
//            //edit details and add new product to arraylist
//            cusList.addCustomer(scView.getEditedText());
//            cusList.getCusListDetail(cusList.getCus_ll());
//            System.out.println("Save edited record!");
        }else if (e.getSource() == scView.getButton("quit")){
            scView.setVisible(false);
            view.setVisible(true);
        }  
        else{
            System.out.println("No button clicked!");
        }
        System.out.println("End of event! Next event");
    }
}
    

