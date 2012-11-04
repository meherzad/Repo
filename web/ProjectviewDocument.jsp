<%-- 
    Document   : ProjectviewDocument
    Created on : 4 Nov, 2012, 2:08:01 PM
    Author     : meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${requestScope.user eq 'yes'}">
            <a href="ProjectEditDocument.jsp?projId=${requestScope.doc.projId}" >Edit </a>
        </c:if>
        <c:if test="${requestScope.status eq 'success'}">
            <table>
                <tr>
                    <th> Description </th>
                </tr>


                <tr>
                    <td> ${requestScope.doc.projectDoc}</td>

                </tr>

            </table>
        </c:if>
     
    </body>
</html>
