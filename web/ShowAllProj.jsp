<%-- 
    Document   : ShowAllProj
    Created on : 5 Nov, 2012, 10:47:03 AM
    Author     : meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${requestScope.status eq 'success'}">
            <table>
                <tr>
                    <td> Project Head </td>
                </tr>

                <c:forEach items="${requestScope.allprojlist}" var="allprojlist">
                    <form action="ser_join_proj?ProjId=${allprojlist.projId}" method="post">
                        <tr>
                            <td> ${allprojlist.projName} </td>


                            <td> <input type="submit" name="btnjoin" value="Join Project"> </td>


                        </tr>
                        <tr>
                            <td> ${allprojlist.projDesc} </td>
                        </tr>
                        <tr>
                        </tr>  

                    </form>   
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>