/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.sql.SQLException;


/**
 *
 * @author manhtri
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DatabaseHandler dbh = null;
        try {
             dbh = new DatabaseHandler();
             dbh.connect();
             dbh.getDataFromDB("product");
              dbh.getDataFromDB("customer");
               dbh.getDataFromDB("order_product");
        } catch (ClassNotFoundException ex ) {
            System.out.println("Class not found error!");
        }
        
    }
}
