/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.txstate.cis.drl81;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author drleo
 */
public class RegDB {
    public static void addReg(UserBean user, CourseBean course, int duration){
        Connection connection = null;
        try{
            connection = DBConnection.getConnection();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        try{
            
            String SQL = "insert into registration values(?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(SQL);//no keys will be generated
            
            statement.setString(1, user.getId());
            
            int intCn = course.getCourseNumber();
            String strCn = String.valueOf(intCn);
            statement.setString(2, strCn);
            
            Timestamp now = new Timestamp(System.currentTimeMillis());
            statement.setTimestamp(3, now);
            
            String strDuration = String.valueOf(duration);
            statement.setString(4, strDuration);
            
            statement.executeUpdate();           
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
}
