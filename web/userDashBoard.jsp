<%-- 
    Document   : userDashBoard
    Created on : 3 Nov, 2012, 3:23:48 PM
    Author     : meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-1.7.2.min.js" ></script>
        <script type="text/javascript" src="http://cloud.github.com/downloads/wycats/handlebars.js/handlebars-1.0.0.beta.6.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <style>
            .notimage{
                width: 40px;
                height: 40px;

            }
            .notimage1{
                width: 40px;
                height: 40px;

            }
            #proj_name{

                font-size: 30px;
                margin-left: 10px;
                color:#6A747E;
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
                                    <li class="liSin" style="display: none;">
                                        <a id="lnkSignUp" href="ServletUserDashBoard">Home</a>
                                    </li>
                                    <li class="liSin" style="display: none;">
                                        <a id="lnkSignUp" href="frmRegistration.html"> Sign Up</a></li>
                                    <li class="liSin" style="display: none;"><a id="lnkSignIn" href="#myModal" data-toggle="modal">Sign In</a></li>
                                    <li class="liSout" style="display: none;">
                                        <a id="lnkSignOut" >SignOut</a>
                                    </li>

                                    <li style="margin-top: -5px;"><input id="searchSite" name="searchSite" maxlength="500"
                                                                         type="text" value="" autocomplete="off"
                                                                         title="Search all projects"
                                                                         style="color: rgb(170, 170, 170); font-style: italic;">
                                    </li>
                                </ul>
                            </li>

                        </ul>

                    </div>
                </div>
            </div>
        </header>
        <c:if test="${requestScope.status eq 'success'}">
            <div class="container conatiner_support">
                <div class="row">
                    <div class="float_left">
                        <img id="imgUser" style="float: left;" 
                             src="${requestScope.user.iurl}" width="50" height="50" alt="" />
                        <h2 id="welcome_msg">${requestScope.user.nick}</h2>

                    </div>
                    <div class="float_right" id="createProject">
                        <a href="CreateProject.jsp">Create Project</a>
                        <a href="">Join a Project</a>
                        <a href="UserEditProfile.jsp?userId="${requestScope.user.userId}>Edit profile</a>
                    </div>
                </div>
            </div>

            <div class="container conatiner_support">
                <div class="row"> 
                    <div class="float_left">
                        <c:forEach items="${requestScope.allprojlist}" var="proj">
                            <div id="proj_name">
                                <a href="ServletProjectHome?projId=${proj.projId}" style="color:#999999">
                                    ${proj.projName}
                                </a><br/><br/>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="float_right">

                        <img class="notimage"
                             src="images/MB_0020_light.png"
                             rel="popover"
                             data-placement="bottom"
                             data-content=" " 
                             data-original-title="Hello">

                        <div id="popoverdata" style="display: none;">
                            <c:forEach items="${requestScope.notifications}" var="notification">
                                <div id="row">

                                    <a href="?projId=${notification.notId}">
                                        ${notification.notification}</a>
                                </div>  
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container conatiner_support">
                <c:forEach items="${requestScope.projectList}" var="proj">
                    <div class="row">
                        <div class="float_left">
                            <a href="ServletProjectHome?projId=${proj.projId}">
                                ${proj.projName}
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
        <div id="footer">
            <div class="row">
                <hr style="color:">
                <ul class="ul_list">
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
                $('.notimage').popover({trigger: 'click'}); 
                var data = $("#popoverdata").html();
                var url="images/MB_0020_light1.png";
                console.log(data);
                $('.notimage').attr('data-content',data);
                $.ajax({
                    url:'ServletCheckUserSession',
                    type:'post',
                    success:function(dt){
                        console.log(dt);
                        if (dt.status=='fail'){
                            $("ul.ul_list li.liSin").css('display','inline');
                            $("ul.ul_list li.liSout").css('display','none');
                        }else{
                            $("ul.ul_list li.liSin").css('display','none');
                            $("ul.ul_list li.liSout").css('display','inline');

                        }
                    }
                });
                $("#lnkSignOut").live('click',function(){
                    $.ajax({
                        url:'ServletSignOut',
                        type:'post',
                        success:function(dt){
                            console.log(dt);
                            if (dt.status=='success'){
                                $("ul.ul_list li.liSin").css('display','inline');
                                $("ul.ul_list li.liSout").css('display','none');
                            }else{
                                $("ul.ul_list li.liSin").css('display','none');
                                $("ul.ul_list li.liSout").css('display','inline');

                            }
                        }
                    });
                });
                   
            })();                
        </script>

    </body>
</html>
