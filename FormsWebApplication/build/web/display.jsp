<%-- 
    Document   : display
    Created on : Jun 12, 2018, 11:51:59 AM
    Author     : vladyslavivchenko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Using Forms</title>
    </head>
    <body>
        <h1>Using Forms</h1>
        
        <%
            String firstName = request.getParameter("first");
            String lastName = request.getParameter("last");
            String emailAddress = request.getParameter("email");
            String gender = request.getParameter("gender");
            String dateOfBirth = request.getParameter("dob");
            
        %>
        
        <table border="1">
            
            <tbody>
                <tr>
                    <td>First name : </td>
                    <td><%= firstName %> </td>
                </tr>
                <tr>
                    <td>Last name : </td>
                    <td><%= lastName %> </td>
                </tr>
                <tr>
                    <td>Email address : </td>
                    <td><%= emailAddress %> </td>
                </tr>
                <tr>
                    <td>Gender : </td>
                    <td><%= gender %> </td>
                </tr>
                <tr>
                    <td>DOB : </td>
                    <td><%= dateOfBirth %> </td>
                </tr>
            </tbody>
        </table>

        
    </body>
</html>
