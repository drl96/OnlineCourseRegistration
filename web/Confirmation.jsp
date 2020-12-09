<%-- 
    Document   : Confirmation
    Created on : Nov 3, 2020, 3:42:45 PM
    Author     : drleo
--%>

<%@page import="edu.txstate.cis.drl81.CourseBean"%>
<%@page import="edu.txstate.cis.drl81.RegistrationBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        <h1>Course Registration Successful!</h1>
        <%
            RegistrationBean regBean = (RegistrationBean)session.getAttribute("Registration");
            CourseBean courBean = (CourseBean)session.getAttribute("Cart");    

            String days = (String) request.getAttribute("courseDuration");      
        %>
              
                
        <p>Course Number: <%=regBean.getCourseNumber()%></p>
        <p>Course Name: <%=regBean.getName()%></p>
        <p>Cost Per Day: $<%=courBean.getCostPerDay()%></p>
        <p>Duration of Course: <%=days%></p>
        <p>Total Payment: $<%=regBean.getTotalPayment()%></p>

        <a href="CourseServlet">Register for another course</a>
    </body>
</html>
