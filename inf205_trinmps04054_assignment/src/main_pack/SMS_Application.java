/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

import java.sql.SQLException;

/**
 *
 * @author ManhTri
 */
public class SMS_Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DatabaseHandler dbh = new DatabaseHandler();
        SMS_View view = new SMS_View();
        Controller controller = new Controller(view, dbh);        
        view.registerListener(controller);
        view.setVisible(true);        
    }
}
