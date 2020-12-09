/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.txstate.cis.drl81;

import edu.txstate.cis.drl81.CourseBean;
import edu.txstate.cis.drl81.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author drleo
 */
public class CourseDB {
    
    //get list of courses in the database
    public static ArrayList<CourseBean> getCourses(){
        ArrayList<CourseBean> listCourse = new ArrayList<CourseBean>();
        Connection connection = null;
        try{
            connection = DBConnection.getConnection();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        
        try{
            Statement statement = connection.createStatement();
            ResultSet courses = statement.executeQuery("select * from courses");
            while (courses.next()){
                CourseBean bean = new CourseBean(courses.getInt(1), courses.getString(2), courses.getDouble(3));
                listCourse.add(bean);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return listCourse;
    }
    
    
    //get course from id
    public static CourseBean getCourse(String code){//GIVING THIS A STRING BUT IT IS AN INT IN THE DATABASE (this is because the sql must be a string)
        CourseBean course = null;
        
        Connection connection = null;
        try{
            connection = DBConnection.getConnection();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        try{
            String SQL = "select * from courses where coursenumber=?";
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setString(1, code);
            ResultSet courses = statement.executeQuery();
            if (courses.next()){
                course = new CourseBean(courses.getInt(1), courses.getString(2), courses.getDouble(3));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return course;
    }
}
