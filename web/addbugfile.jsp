<%-- 
    Document   : addbugfile
    Created on : 9 Nov, 2012, 3:44:10 PM
    Author     : meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form ACTION ="Servletbugfile?id=${requestScope.temp}" method="post" enctype="multipart/form-data">
            <input type="file" name="txtfile">
            <input type="submit" name="btnfile" value="Upload File">
        </form>
    </body>
</html>
