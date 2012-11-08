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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/style.css">
        <style >
            #frgtPass{
                border-bottom: 3px #5EA8DE solid;
                background-color: #F0F1F4;
                color: #253340;
                display: block;
                float: left;
                font: 18px 'Segoe UI', Tahoma, Arial, Helvetica, sans-serif;
                font-weight: lighter;
                margin: 0px 0px 0px 12px;
                padding: 40px;
                position: relative;
                top: 20px;
            }
        </style>
    </head>

    <body>
        <header class="navbar">
            <div class="navbar-inner">
                <div class="container conatiner_support">
                    <div class="float_left">
                        <p id="logo">
                            <a href="index.html">Site
                                Logo</a> <span class="tagline">Free project hosting</span>
                        </p>
                    </div>
                    <div class="float_right">
                        <ul class="ul_list">
                            <li>
                                <ul class="ul_list" id="nav">
                                    <li><a id="lnkSignUp" href="frmRegistration.html"> Sign Up</a></li>
                                    <li><a id="lnkSignIn" href="#myModal" data-toggle="modal">Sign In</a></li>

                                    <li><input id="searchSite" name="searchSite" maxlength="500"
                                               type="text" value="" autocomplete="off"
                                               title="Search all projects"
                                               style="color: rgb(170, 170, 170); font-style: italic;">
                                    </li>
                                </ul>
                            </li>

                        </ul>
                        <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
                                <h3 id="myModalLabel" style="color: #6A747E;"><center>Sign In</center></h3>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" method="post" id="modalForm" action="">
                                    <div class="control-group">
                                        <label class="loginLabel" for="inputEmail">Email</label>
                                        <div class="controls">
                                            <input type="text" id="username" name="username" placeholder="Email">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="loginLabel" for="inputPassword">Password</label>
                                        <div class="controls">
                                            <input type="password" id="Userpass" name="password" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <label class="checkbox">
                                                <input type="checkbox"> 
                                                <label class="loginLabel" style="text-align: left !important;padding-top: 0px !important; ">Remember me</label>
                                            </label><br>
                                            <div style="color: red;" id="loginStatus"></div>
                                            <a href="userForgetPassword.jsp">Forget Password</a>
                                            <button type="button" class="btn" id="btnLogIn">Sign in</button>
                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </header>

        <form method="post" name="forgetPass" action="ServletSendMail">
            <div class="container conatiner_support">
                <c:if test="${requestScope.status ne 'success'}">
                    <div class="row" style="position: relative;margin-right: 5%;">
                        <div id="intro_container">
                            <!--<h4 id="intro">Forget Password ...  </h4>-->

                            <img src="images/fpass.gif" width="300px" height="300px"> 



                        </div>
                        <div id="frgtPass">

                            <table>
                                <tr>
                                    <td>User id</td>
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

                    </div>
                </div>
            </div>
        </form>
        <div id="footer">
            <div class="row">
                <hr style="color:">
                <ul class="ul_list footer_link">
                    <li class="list"></li>
                    <li class="list"><a href="#">Get Help</a></li>
                    <li class="list"><a href="#">Privacy Statement</a></li>
                    <li class="list"><a href="#">Terms of Use</a></li>
                    <li class="list"><a href="#">Code of Conduct</a></li>
                    <li class="list"><a href="#">Advertise With Us</a></li>

                </ul>
            </div>
        </div>
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
                                    $("#userResult").html('Email exist');
                                    
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