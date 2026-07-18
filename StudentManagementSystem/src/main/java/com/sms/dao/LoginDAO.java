package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sms.util.DBConnection;

public class LoginDAO {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean validateUser(String username, String password) {

        boolean status = false;

        try {

            con = DBConnection.getConnection();
            
            System.out.println("Database Connected");

            String query = "SELECT * FROM login WHERE username=? AND password=?";

            pst = con.prepareStatement(query);

            pst.setString(1, username);
            pst.setString(2, password);
            
            System.out.println("Executing query...");

            rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("User Found");
                status = true;
            } else {
                System.out.println("User Not Found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Status = " + status);
        return status;
    }

}