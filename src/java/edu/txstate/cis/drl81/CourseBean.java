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
public class CourseBean {

    
    
    
    public CourseBean(int courseNumber, String name, double costPerDay) {
        this.courseNumber = courseNumber;
        this.name = name;
        this.costPerDay = costPerDay;
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
    
    
        private double costPerDay;

    /**
     * Get the value of costPerDay
     *
     * @return the value of costPerDay
     */
    public double getCostPerDay() {
        return costPerDay;
    }

    /**
     * Set the value of costPerDay
     *
     * @param costPerDay new value of costPerDay
     */
    public void setCostPerDay(double costPerDay) {
        this.costPerDay = costPerDay;
    }

}
