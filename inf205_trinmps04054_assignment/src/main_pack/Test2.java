/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

/**
 *
 * @author manhtri
 */

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {
  public static Connection getConnection() throws Exception {
    String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    String url = "jdbc:odbc:northwind";
    String username = "";
    String password = "";
    Class.forName(driver); // load JDBC-ODBC driver
    return DriverManager.getConnection(url, username, password);
  }

  public static void main(String args[]) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      conn = getConnection();
      stmt = conn.createStatement();
      String query = "select EmployeeID, LastName, FirstName from Employees";
      rs = stmt.executeQuery(query);
      while (rs.next()) {
        System.out.println(rs.getString("EmployeeID") + " " + rs.getString("LastName") + " "
            + rs.getString("FirstName"));
      }
    } catch (Exception e) {
      // handle the exception
      e.printStackTrace();
      System.err.println(e.getMessage());
    } finally {
      try {
        rs.close();
        stmt.close();
        conn.close();
      } catch (Exception ee) {
        ee.printStackTrace();
      }
    }
  }
}

