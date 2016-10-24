/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author manhtri
 */
public class DatabaseHandler {
    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String USERNAME="ps04054";
    private final String PASSWORD="ps04054";
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=inf205_assignment;";
    Statement stmt;
    public DatabaseHandler() throws ClassNotFoundException, SQLException{        
        Class.forName(DRIVER);
    }
    
    public void connect() throws SQLException{
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        stmt = con.createStatement();
        System.out.println("Database connected successfully!");
        DatabaseMetaData databaseMetaData = con.getMetaData();
        System.out.println("Username: "+databaseMetaData.getUserName());
    }

    
    public String[] searchProductFromDB(String id, String table) throws SQLException{
             
        String query = "SELECT * FROM product WHERE product_id = " + "'" + id + "'";
        ResultSet rs = stmt.executeQuery(query);
        if(!rs.first()){
            ResultSetMetaData rsmd = rs.getMetaData();
            String[] record = new String[(rsmd.getColumnCount())]; 
            switch(table){
                case "product":
                    while (rs.next()) {
                        record[0] = rs.getString(1);
                        record[1] = rs.getString(2);
                        record[2] = rs.getString(3);
                        record[3] = rs.getString(4);
                        record[4] = rs.getString(5);
                        record[5] = rs.getString(6);
                    }
                    break;
                case "customer":
                    while (rs.next()) {
                        record[0] = rs.getString(1);
                        record[1] = rs.getString(2);
                        record[2] = rs.getString(3);
                    }
                    break;
            }            
            return record; 
        }else{
            return null;
        }
    }
             
    
    
    public void updateNumInStock(String productId, String currentNum, String numSold){
        boolean isUpdate = true;
        //UPDATE table_name
        //SET column1=value1,column2=value2,...
        //WHERE some_column=some_value;
        int cNum = Integer.parseInt(currentNum);
        int sNum = Integer.parseInt(numSold);
        if(cNum < sNum){
            isUpdate = false;
        }else{
            cNum = cNum - sNum;
            String updateNum = String.valueOf(cNum);
            String query = "UPDATE product SET num_in_stock = + " + updateNum + " WHERE product_id = " +productId;
            try {
                int rowAffect = stmt.executeUpdate(query);
            } catch (SQLException ex) {               
            }            
        }        
           
    }
    
    public void updateRecord(String productID, String[] data, String tableName) throws SQLException{
        //UPDATE table_name
        //SET column1=value1,column2=value2,...
        //WHERE some_column=some_value;
        String query = "";
        int rows = -1;
        switch(tableName){
            case "product":
                query = "UPDATE product set product_name = " + "'" + data[1] + "'"
                        + ", product_category = " + "'" + data[2] + "'"
                        + ", price = " + "'" + data[3] + "'"
                        + ", num_of_stock = " + "'" + data[4] + "'"
                        + ", sold = " + "'" + data[5] + "'"
                        + "where product_id = " + "'" + data[0] + "'";
                rows = stmt.executeUpdate(query);
                System.out.println("Row affected " + rows);
                break;
            
            case "customer":
                query = "UPDATE customer SET customer_name = " + "'" + data[1] + "'"
                        + ", customer_email = " + "'" + data[2] + "'"
                        + " where customer_id = " + "'" + data[0] + "'";
                rows = stmt.executeUpdate(query);
                System.out.println("Row affected " + rows);
                break;
            default:
                System.out.println("No table with " + tableName + " exists!");
                System.out.println("Row affected " + rows);
        }
        
    }
    
    
    public void addToDB(String table , String[] data) throws SQLException{
        String query = "";        
        switch(table){
            case "customer":
                query = "INSERT INTO customer values ("
                         + "'"+ data[0]+ "'" + "," 
                + "'"+ data[1]+ "'" + "," 
                + "'"+ data[2]+ "'" + ");" ;
               
                break;
            case "product":
                query = "INSERT INTO product values ("
                + "'"+ data[0]+ "'" + "," 
                + "'"+ data[1]+ "'" + "," 
                + "'"+ data[2]+ "'" + ","
                + "'"+ data[3]+ "'" + "," 
                + "'"+ data[4]+ "'" + "," 
                + "'"+ data[5]+ "'" + ");";
                break;
            case "order_product":
                query = "INSERT INTO order_product values"
                + "'"+ data[0]+ "'" + "," 
                + "'"+ data[1]+ "'" + "," 
                + "'"+ data[2]+ "'" + ","
                + "'"+ data[3]+ "'" + "," 
                + "'"+ data[4]+ "'" + "," 
                + "'"+ data[5]+ "'" + ");";
                break;                
            default: System.out.println("Not applicable");
        }
        int rowAffect = stmt.executeUpdate(query);   
        System.out.println("Num of rows affect: " + rowAffect);
    }
    
    public void getDataFromDB(String table) throws SQLException {        
        String query = "SELECT * FROM " + table;
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        String[] data = new String[rsmd.getColumnCount()];        
        switch (table) {
            case "customer":
                while (rs.next()) {
                    data[0] = rs.getString(1);
                    data[1] = rs.getString("customer_name");
                    data[2] = rs.getString("customer_email");
                    System.out.print("Customer id: " + data[0]);
                    System.out.print("Customer name: " + data[1]);
                    System.out.println("Customer email: " + data[2]);
                }
                break;
            case "product":
                System.out.println("Print all record in product table");
                while (rs.next()) {
                    data[0] = rs.getString("product_id");
                    data[1] = rs.getString("product_name");
                    data[2] = rs.getString("product_category");
                    data[3] = rs.getString("price");
                    data[4] = rs.getString("num_in_stock");
                    data[5] = rs.getString("sold");
                    System.out.print("Product id: " + data[0] +"//");
                    System.out.print("Product name: " + data[1] + "//");
                    System.out.print("Product category: " + data[2] + "//");
                    System.out.print("Product price: " + data[3] + "//");
                    System.out.print("Number in Stock: " + data[4] + "//");
                    System.out.println("Sold: " + data[5] + "//");
                }
                break;
            case "order_product":
                while (rs.next()) {
                    data[0] = rs.getString("order_id");
                    data[1] = rs.getString("o_customer_id");
                    data[2] = rs.getString("o_product_id");
                    data[3] = rs.getString("o_price");
                    data[4] = rs.getString("o_quantity");
                    data[5] = rs.getString("o_total");
                    System.out.print("Order id: " + data[0] + "//");
                    System.out.print("Product id: " + data[1] + "//");
                    System.out.println("Customer id: " + data[2] + "//");
                    System.out.println("Product price: " + data[3] + "//");
                    System.out.println("Quantity: " + data[4] + "//");
                    System.out.println("Sold: " + data[5] + "//");
                }
                break;
            default: System.out.println("No table with name " + table + " exist!");
        }
    }
        
    }

