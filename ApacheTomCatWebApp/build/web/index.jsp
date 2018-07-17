<%-- 
    Document   : index
    Created on : Jun 12, 2018, 12:08:20 PM
    Author     : vladyslavivchenko
--%>
<%@page import="java.sql.*"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Selecting Data From a DB!</title>
    </head>
    <body>
        <h1>Selecting Data From a DB!</h1>
        <%!
            public class TestDataB {

                String URL = "jdbc:mysql://localhost:3306/testDB";
                String USERNAME = "root";
                String PASSWORD = "vladislav24";

                Connection connection = null;
                PreparedStatement selectTest = null;
                ResultSet resultSet = null;

                public TestDataB() {
                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                        selectTest = connection.prepareStatement("SELECT * FROM testDB.testTable");


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public ResultSet getTest() {
                    try {
                        resultSet = selectTest.executeQuery();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return resultSet;
                }
            }
        %>
        <%
            TestDataB testD = new TestDataB();
            ResultSet tests = testD.getTest();

        %>
        <table border="1">

            <tbody>
                <tr>
                    <td>ID</td>
                    <td>Value</td>
                </tr>
                <% while (tests.next()) {%>  
                <tr>
                    <td><%= tests.getInt("idTest")%></td>
                    <td><%= tests.getString("text")%></td>
                </tr>
                <% }%>
            </tbody>
        </table>


    </body>
</html>
