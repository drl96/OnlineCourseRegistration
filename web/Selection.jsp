<%-- 
    Document   : Selection
    Created on : Oct 29, 2020, 6:25:50 PM
    Author     : drleo
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.txstate.cis.drl81.CourseBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selected Course</title>
    </head>
    <body>
        <h1>Selected Course</h1>
        <%
            CourseBean cBean = (CourseBean)session.getAttribute("Cart");
        %>
        
        

        
        <p>Selected Course: <%=cBean.getCourseNumber()%>, <%=cBean.getName()%>, <%=cBean.getCostPerDay()%></p>
       
        <form action="ConfirmationDisplayServlet" method="post">
            <label>Course Duration: </label><input type="number" name="duration"><br>
            <input type="submit" value="Submit">   
        </form>
        <p><a href="CourseServlet">Back to Course List</a></p>

    </body>
</html>
