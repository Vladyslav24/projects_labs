<%-- 
    Document   : index
    Created on : Jun 12, 2018, 10:44:44 PM
    Author     : vladyslavivchenko
--%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("com.mysql.jdbc.Driver");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserting data to DB</title>
    </head>
    <body>
        <h1>Inserting data to DB</h1>
        <%!
            public class TestDataB {

                String URL = "jdbc:mysql://localhost:3306/testDB";
                String USERNAME = "root";
                String PASSWORD = "vladislav24";

                Connection connection = null;
                PreparedStatement insertTest = null;
                ResultSet resultSet = null;

                public TestDataB() {
                    try {
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                        insertTest = connection.prepareStatement("INSERT INTO testDB.testTable (idTest, text) VALUES (?,?);");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public int setTest(int id, String text) {
                    int result = 1;
                    try {
                        insertTest.setInt(1, id);
                        insertTest.setString(2, text);
                        result = insertTest.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    return result;
                }
            }
        %>
        <%
            int result = 0;

            if (request.getParameter("submit") != null) {

                int id = 0;
                String text = new String();

                if (request.getParameter("testID") != null) {
                    id = Integer.parseInt(request.getParameter("testID"));
                }
                if (request.getParameter("text") != null) {
                    text = request.getParameter("text");
                }

                TestDataB tb = new TestDataB();

            }
        %>
        <form name="myForm" action="index.jsp" method="POST">
            <table border="0">

                <tbody>
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="testID" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Value</td>
                        <td><input type="text" name="text" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>

            <input type="hidden" name="hidden" value="<%=result %>" />

            <input type="reset" value="Clear" name="clear" />
            <input type="submit" value="Submit" name="submit" />

        </form>

    </body>
</html>
