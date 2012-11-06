<%-- 
    Document   : userForgetPassword
    Created on : 5 Nov, 2012, 4:44:24 PM
    Author     : meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

    </head>

    <body>
        <form method="post" name="forgetPass" action="ServletSendMail">
            <c:if test="${requestScope.status ne 'success'}">
                <table>
                    <tr>
                        <td> User Id</td>
                        <td><input type="text" name="username" id="UserId"></td>
                        <td><label style="color: red;" id="userResult"></label></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center" >
                            <input type="submit" name="Reset Password" id="btnresetpass">
                        </td>
                    </tr>

                </c:if>
            </table>
            <c:if test="${requestScope.status eq 'success'}">
                <table>
                    <tr>
                        <th> Mail Sent Successfully.... </th>
                    </tr>
                </table>
            </c:if>

        </form>
        <script>
            (function(){
                $("#UserId").change(function(){
                    var value=$(this).attr('value');
                    var len= value.length;
                    console.log(len);
                    if (len>3){
                        $.ajax({
                            url : 'ServletCheckUser',
                            data : {
                                'userName' : value  
                            },
                            type : 'post',
                            success: function(dt){
                                if (dt.status =='success'){
                                    $("#userResult").html(dt.result);
                                    
                                }
                                else{
                                    $("#userResult").html('Server error');
                                }
                            
                            },
                            error:function(){
                                $("#userResult").html('Server error');
                            }
                        });
                    }
                });
            })();
        </script>
    </body>
</html>