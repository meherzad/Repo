<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert title here</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/paging.css">
        <script src="js/jquery-1.7.2.min.js" ></script>
        <script type="text/javascript" src="http://cloud.github.com/downloads/wycats/handlebars.js/handlebars-1.0.0.beta.6.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/quickpager.jquery.js" type="text/javascript"></script>
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
                                    <form action="ServletSearch" method="post">
                                        <li><input id="searchSite" name="searchSite" maxlength="500"
                                                   type="text" value="" autocomplete="off"
                                                   title="Search all projects"
                                                   style="color: rgb(170, 170, 170); font-style: italic;">
                                            <input type="submit" value="Search">
                                        </li>
                                    </form>
                                </ul>
                            </li>

                        </ul>
                        <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
                                <h3 id="myModalLabel" style="color: #6A747E;"><center>Sign In</center></h3>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" method="post" action="">
                                    <div class="control-group">
                                        <label class="loginLabel" for="inputEmail">Email</label>
                                        <div class="controls">
                                            <input type="text" id="username" name="username" placeholder="Email">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="loginLabel" for="inputPassword">Password</label>
                                        <div class="controls">
                                            <input type="password" id="password" name="password" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <label class="checkbox">
                                                <input type="checkbox"> 
                                                <label class="loginLabel" style="text-align: left !important;padding-top: 0px !important; ">Remember me</label>
                                            </label><br>
                                            <div style="color: red;" id="loginStatus"></div>

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

        <div class="container conatiner_support">
            <div class="row">
                <div class="float_left">
                    <img id="imgUser" style="float: left;margin-right: 10px;" 
                         src="${requestScope.project.iUrl}" width="50" height="50"  />
                    <h2 id="welcome_msg">${requestScope.project.projName}</h3>

                </div>

            </div>
        </div>

        <div class="container conatiner_support">
            <div class="row">
                <ul id="project_menu">
                    <li>
                        <a class="menuLink" href="ServletProjectHome?projId=" >Home</a>
                    </li>
                    <li id="projDash">
                        <a class="menuLink" href="frmProjectDashboard.html?projId=" >Project Management</a>
                    </li>
                    <li>
                        <a class="menuLink" href="projectDownload.html?projId=" >Downloads</a>
                    </li>
                    <li>
                        <a class="menuLink" href="ServletViewDocumentation?projId=" >Documentation</a>
                    </li>
                    <li>
                        <a class="menuLink" href="ServletGetBugs?projId=" >Bug Tracking</a>
                    </li>
                    <li>
                        <a class="menuLink" href="ServletDiscussionHead?projId=" >Discussion</a>
                    </li>
                    <li>
                        <a class="menuLink" href="ProjectPeople.jsp?projId=" >People</a>
                    </li>
                    <li>
                        <a class="menuLink" href="ProjectLicense.html?projId=" >License</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="container conatiner_support">
            <div class="row">
                <div class="float_left">
                    ${requestScope.project.projDesc}
                </div>
                <div class="float_right">
                    <a id="download_button" href="${requestScope.project.codeUrl}">Download</a>
                </div>
                <div>
                    <form action="ServletSearchUser" method="post">
                        <input type="text" name="txtSearch">
                        <input type="submit" value="Search">
                    </form>
                    <a href="ServletDisplayRequest">View Request</a>
                </div>
            </div>
        </div>
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
                function getParameterByName(name) {
                    name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
                    var regexS = "[\\?&]" + name + "=([^&#]*)";
                    var regex = new RegExp(regexS);
                    var results = regex.exec(window.location.search);
                    if (results == null)
                        return "";
                    else
                        return decodeURIComponent(results[1].replace(/\+/g, " "));
                }
                var projId=getParameterByName("projId");
                $.each($('a.menuLink'), function(key,val){
                    var link=$(val).attr('href');
                    link=link+projId;
                    $(val).attr('href',link);
                });
                $.ajax({
                    url:'ServletCheckUserType',
                    data:{
                        projId:projId
                    },
                    type:'post',
                    success:function(dt){
                        if (dt.status!='true'){
                            $("#projDash").css('display','none');
                        }
                    },
                    error:function(){
                        console.log('error');
                    }
                });
            })();
        </script>
    </body>
</html>