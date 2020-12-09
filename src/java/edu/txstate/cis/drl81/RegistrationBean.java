/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.txstate.cis.drl81;

/**
 *
 * @author drleo
 */
public class RegistrationBean {

    
    
    
    
    
    public RegistrationBean(String userID, int courseNumber, String name, String date, double totalPayment) {
        this.userID = userID;
        this.courseNumber = courseNumber;
        this.name = name;
        this.date = date;
        this.totalPayment = totalPayment;
    }
    
    

    
    
        private String userID;

    /**
     * Get the value of userID
     *
     * @return the value of userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Set the value of userID
     *
     * @param userID new value of userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    
    
    
    
        private int courseNumber;

    /**
     * Get the value of courseNumber
     *
     * @return the value of courseNumber
     */
    public int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Set the value of courseNumber
     *
     * @param courseNumber new value of courseNumber
     */
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    
    
    
    
        private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    
    
    
        private String date;

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(String date) {
        this.date = date;
    }

    
    
    
    
        private double totalPayment;

    /**
     * Get the value of totalPayment
     *
     * @return the value of totalPayment
     */
    public double getTotalPayment() {
        return totalPayment;
    }

    /**
     * Set the value of totalPayment
     *
     * @param totalPayment new value of totalPayment
     */
    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    
}
