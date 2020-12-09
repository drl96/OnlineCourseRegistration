/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.txstate.cis.drl81;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {

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
        if (bean != null){      
//            ArrayList<CourseBean> courses = new ArrayList<CourseBean>();
//            courses.add(new CourseBean(2346, "Beginner Java", 3.23));
//            courses.add(new CourseBean(2347, "Intermediate Java", 3.50));
//            courses.add(new CourseBean(2348, "Advanced Java", 4.18));
//            courses.add(new CourseBean(3476, "Beginner Python", 3.12));
//            courses.add(new CourseBean(3477, "Intermediate Python", 3.39));

            ArrayList<CourseBean> courses = CourseDB.getCourses();

            request.setAttribute("Courses", courses);
            
            
            //check for "code" in url 
            //if there, filter courses based on "code"
            String code = request.getParameter("code");
            if (code != null){
//                int intCode = Integer.parseInt(code);
//                CourseBean p = courses.stream()
//                                        .filter(item -> intCode == item.getCourseNumber())
//                                        .findAny()
//                                        .orElse(null);

                CourseBean course = CourseDB.getCourse(code);
                session.setAttribute("Cart", course);//contains a single course bean

                
               
                //create new cookie of selected product
                Cookie c = new Cookie("CartCookie", code);
                c.setMaxAge(60*60*24*365);
                c.setPath("/");
                response.addCookie(c);
                                           
                getServletContext().getRequestDispatcher("/SelectionDisplayServlet").forward(request, response);
            }
            
                      
            //get "CartCookie" from LoginServlet
            String cartCookie = (String) request.getAttribute("CartCookie");     
            //if there is a "CartCookie", filter the courses ArrayList based on the code stored in "CartCookie"
            if (cartCookie != null){
                int intCartCode = Integer.parseInt(cartCookie);
                CourseBean p2 = courses.stream()
                                        .filter(item -> intCartCode == item.getCourseNumber())
                                        .findAny()
                                        .orElse(null);
                session.setAttribute("Cart", p2);//contains a single course bean
                
                session.setAttribute("CartCookieCode", cartCookie);//only used for the delete cookie function

                getServletContext().getRequestDispatcher("/SelectionDisplayServlet").forward(request, response);
            }
                
            getServletContext().getRequestDispatcher("/CourseList.jsp").forward(request, response);
            

        } else{
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);       
        }

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
