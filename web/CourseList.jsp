<%-- 
    Document   : CourseList
    Created on : Oct 29, 2020, 1:34:01 AM
    Author     : drleo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="edu.txstate.cis.drl81.CourseBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course List</title>
    </head>
    <body>
        <h1>Course List</h1>
        <%
            ArrayList<CourseBean> list = (ArrayList<CourseBean>) request.getAttribute("Courses");
            for (CourseBean c:list){        
        %>
        <p><%=c.getCourseNumber()%>, <%=c.getName()%>, <%=c.getCostPerDay()%> <a href="CourseServlet?code=<%=c.getCourseNumber()%>">Select Course</a></p>
        <%
            }
        %>
        
    </body>
</html>
