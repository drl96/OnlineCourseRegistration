/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.txstate.cis.drl81;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author drleo
 */
@WebServlet(name = "ConfirmationDisplayServlet", urlPatterns = {"/ConfirmationDisplayServlet"})
public class ConfirmationDisplayServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserBean bean = (UserBean) session.getAttribute("User");
        
        if (bean == null){
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);  
        }        
        

        //GET USER ID
        String userID = bean.getId();
        
                
        //GET COURSE NUMBER AND NAME
        CourseBean course = (CourseBean)session.getAttribute("Cart");
        int courseID = course.getCourseNumber();
        String courseName = course.getName();
        
        
        //GET STRING OF TODAY'S DATE
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH);
        currentMonth = currentMonth + 1;
        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);           
        String today = String.valueOf(currentMonth) + "/" + String.valueOf(currentDay) + "/" + String.valueOf(currentYear);
        
        
        //GET TOTAL PAYMENT       
        //-get duration
        String duration = request.getParameter("duration");
        request.setAttribute("courseDuration", duration);//only used to display duration on confirmation jsp
        int intDuration = Integer.parseInt(duration);
        //get cost per day of selected course
        double costPerDay = course.getCostPerDay();       
        double totalCost = intDuration * costPerDay;
        
        
        //~~~ADD REGISTRATION TO DATABASE~~~
        RegDB.addReg(bean, course, intDuration);
        
        
        //SAVE NEW REGISTRATION BEAN
        RegistrationBean rBean = new RegistrationBean(userID, courseID, courseName, today, totalCost);
        //save registration bean to the session
        session.setAttribute("Registration", rBean);
        
        
        //WRITE REGISTRATION BEAN TO TXT FILE
        ServletContext sc = this.getServletContext();
        String path = sc.getRealPath("/WEB-INF/RegList.txt");
        RegistrationIO.save(rBean, path);
        
        
        //SAVE DURATION IN THE SESSION (for use to display on final page)
        //request.setAttribute("Duration", duration); //?????
        
        
        //DELETE COOKIE
        String cartCookie = (String) session.getAttribute("CartCookieCode");
        Cookie c = new Cookie("CartCookie", cartCookie);
        c.setMaxAge(0); 
        c.setPath("/");
        response.addCookie(c);

        getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response); 


    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
