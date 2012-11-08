<%-- 
    Document   : userResetPassword
    Created on : 5 Nov, 2012, 5:05:46 PM
    Author     : meherzad
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/validations.js"></script>
        <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <form method="post" name="forgetPass" action="">


            <table id="tblfrm">
                <tr>
                    <td>
                        <input type="hidden" value="${requestScope.userid}" 
                               id="hiddenuserid" name="hiddenuserid"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="hidden" value="${requestScope.verifyId}" 
                               id="hiddenVerfId" name="hiddenVerfId"/>
                    </td>
                </tr>
                <tr>
                    <td>New Password</td>
                    <td><input type="password" name="newpass" id="newpass" onblur="verifyPasswordFormat(this.id); checkBlank('newpass','cnfrmpass');"/></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="cnfrmpass" id="cnfrmpass" onblur="passwordmatch('newpass','cnfrmpass')"/></td>
                </tr>
                <tr>
                    <td><input type="button" name="submit" value="Submit" onclick="return passwordValidation()" id="btnsubmit" /></td>
                </tr>
               
            </table>
                               <div id="userResult"></div>
        </form>
        <script>
            (function(){
                $("#btnsubmit").live('click',function(){
                    var hiddenuserid=$('#hiddenuserid').attr('value');
                    var hiddenVerfId=$('#hiddenVerfId').attr('value');
                    var newpass=$('#newpass').attr('value');
                   // alert('sdf');
                    $.ajax({
                        url : 'submitPassServlet',
                        data : {
                            'hiddenuserid' : hiddenuserid,
                            'hiddenVerfId' : hiddenVerfId,
                            'newpass': newpass                
                        },
                        type : 'post',
                        success:function(dt){
                            //dt.status1
                            $("#tblfrm").css('display','none');
                            $("#userResult").html(dt.status1);
                            
                        },
                        error:function(){
                            alert('kj');
                        }
                    });
                });              
            })();
        </script>

    </body>
</html> 