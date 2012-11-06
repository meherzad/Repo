<%-- 
    Document   : searchInvitation
    Created on : 6 Nov, 2012, 12:42:46 AM
    Author     : meherzad
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
        <title>Search user</title>
    </head>
    <body>
    <center>
        <form name="searchresult" method="post">
            <c:if test="${requestScope.status eq 'sucess'}">

                <c:forEach items="${requestScope.nameList}" var="nam">
                    <table>
                        <tr>
                            <td> Send invitation to<a href="index.jsp"> ${nam.username}</a>? </td><br>
                        <td>
                            <input type="button" class="btnInvitation" value="Invite" name="btninvite"
                                   id="contentbuttoninvite" data-userId="${nam.userId}"></td>

                        </tr> </table>
                    </c:forEach>

            </c:if><br>
            <label style="color:red" id="labelcheck">

        </form>

    </center>
    <script type="text/javascript">
  
        
        (function(){
            $(".btnInvitation").live('click',function(){
                var selId=$(this).attr('data-userId');
                alert(selId);
                //console.log("here" + selName);
                $.ajax({
                    url:'ServletRequestUser',
                    type : 'GET',
                    data :{
                        'userId' : selId
                    },
                    success: function(data){
                        if(data.status1='successfull saved')
                        {$("#labelcheck").html("Invitation successfully sent");}
                        else if(data.status1='Unsuccessfull saved')
                        {$("#labelcheck").html('Invitation was unsucessfull');}
                                
                    },
                    error: function(){
                        alert('error');
                    }
                });
                /*var datastring="userId="+selId;
                $.getJSON("request",datastring,function(data){
                    alert(data.status1);
                });*/
            });
        })();
    </script>
</body>
</html>