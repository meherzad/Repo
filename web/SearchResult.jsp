<%-- 
    Document   : SearchResult
    Created on : 4 Nov, 2012, 11:35:29 PM
    Author     : meherzad
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form_searchresult" >

            <div id="search">

                <div id="project" style="float:left">
                    <c:if test="${requestScope.projstatus eq 'true'}">
                        <table>
                            <tr>
                                <td> Project Name </td>
                                <td> Project Description </td>
                            </tr> 

                            <c:forEach items="${requestScope.project}" var="proj">  
                                <tr>
                                    <td> ${proj.projName} </td>
                                    <td> ${proj.projDesc} </td>
                                </tr>
                            </c:forEach>

                        </table>
                    </c:if>
                </div>
                <div id="username">
                    <c:if test="${requestScope.unamestatus eq 'true'}">
                        <table>
                            <tr>
                                <td> Username </td>

                            </tr> 

                            <c:forEach items="${requestScope.username}" var="usernm">  
                                <tr>
                                    <td> ${usernm.username} </td>

                                </tr>
                            </c:forEach>

                        </table>
                    </c:if>
                </div>
            </div>
        </form>
    </body>
</html>
