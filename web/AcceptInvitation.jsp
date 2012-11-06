<%-- 
    Document   : AcceptInvitation
    Created on : 6 Nov, 2012, 1:08:59 AM
    Author     : meherzad
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <form name="acceptInvitation" method="POST">

            <c:if test="${requestScope.status eq 'sucess'}">
               <table>
                <c:forEach items="${requestScope.nameList}" var="nam">
                        <tr>
                            <td>Send Invitation to ${nam.projName} ?</td>
                        <td>
                            <input type="button" data-type="accept" class="btnInvitation" value="Accept" name="acceptinvite"
                                   id="contentbtnacpt" data-projId="${nam.projId}"></td>
                        <td>
                            <input type="button" data-type="decline" class="btnInvitation" value="Decline" name="declineinvite"
                                   id="contentbtndec" data-projId="${nam.projId}"></td>

                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            
                        
       
<script type="text/javascript">
  (function(){
        $(".btnInvitation").live('click',function(){
            var selId=$(this).attr('data-projId');
            var type=$(this).attr('data-type');
            alert(selId);
            alert(type);
            //console.log("here" + selName);
           $.ajax({
                url:'ServletAcceptInvitation',
                type : 'POST',
                data :{
                    'type':type,
                    'ProjectId':selId
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
    </form>
    </body>
</html>