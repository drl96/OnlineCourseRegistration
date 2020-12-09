/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.txstate.cis.drl81;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author drleo
 */
public class RegistrationIO {
    
    public static void save(RegistrationBean rBean, String filePath){
        
        try {
            File file = new File (filePath);
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.println(rBean.getUserID() + "|" + rBean.getCourseNumber() + "|" + rBean.getName() + "|" + rBean.getDate() + "|" + rBean.getTotalPayment());
            out.close();                  
        }
        
        catch (Exception ex){
            ex.printStackTrace();     
        }
    
    
    }   
    
}
