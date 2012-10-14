<%-- 
    Document   : index
    Created on : 14 Oct, 2012, 12:18:40 AM
    Author     : meherzad
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.AALOAD"%>
<%@page import="Repo.model.DatabaseManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <%
                DatabaseManager obj = new DatabaseManager();
                obj.connect();
                ResultSet rs = obj.getData("select * from user;");
                while (rs.next()) {
            %>

            <tr>
                <td>
                    <%=rs.getString("id") + " " + rs.getString("name")%>
                </td> 
            </tr>
            <%
                }
            %>
        </table> 

    </body>
</html>
