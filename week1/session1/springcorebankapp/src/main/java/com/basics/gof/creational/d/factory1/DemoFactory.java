package com.basics.gof.creational.d.factory1;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemoFactory {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bankdb";
        String username = "root";
        String password = "root";

        Connection con=null;
        try {
             con = DriverManager.getConnection(url, username, password);

             con.setAutoCommit(false);
            PreparedStatement debitStmt = con.prepareStatement(
                    "UPDATE account SET balance = balance - ? WHERE id = ?");

            debitStmt.setBigDecimal(1, new BigDecimal("100"));
            debitStmt.setInt(2, 1);
            debitStmt.executeUpdate();

            // Credit Ekta (id = 6)
            PreparedStatement creditStmt = con.prepareStatement(
                    "UPDATE account SET balance = balance + ? WHERE id = ?");

            creditStmt.setBigDecimal(1, new BigDecimal("100"));
            creditStmt.setInt(2,6 );
            creditStmt.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }finally {
           if(con!=null){
               try {
                   con.close();
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
           }
        }
    }
}
