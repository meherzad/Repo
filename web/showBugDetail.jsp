<%-- 
    Document   : showBugDetail
    Created on : 6 Nov, 2012, 5:49:23 PM
    Author     : meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="screen"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
        <link type="text/css" rel="stylesheet" href="css/style.css">
        <script src="js/jquery-1.7.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <style>
            #buglist{
                width: 60%;
                font: 15px 'Segoe UI',Tahoma,Arial,Helvetica,sans-serif;
                margin-left: 13%;
                margin-top: 5%;
            }
        </style>
    </head>
    <body>
        <header class="navbar">
            <div class="navbar-inner">
                <div class="container conatiner_support">
                    <div class="float_left" style="margin-left:-45px;">
                        <p id="logo">
                            <a href="index.html">Site
                                Logo</a> <span class="tagline">Free project hosting</span>
                        </p>
                    </div>
                    <div class="float_right">
                        <ul class="ul_list">
                            <li>
                                <ul class="ul_list" id="nav">
                                    <li class="liSout" style="display: none;"><a id="lnkSignOut" >SignOut</a></li>
                                    <li>
                                        <input id="searchSite" name="searchSite" maxlength="500"
                                               type="text" value="" autocomplete="off"
                                               title="Search all projects"
                                               style="color: rgb(170, 170, 170);
                                               font-style: italic;margin-top: -5px;"
                                               placeholder="Search">
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </header>
        <div class="container conatiner_support">
            <div class="row" style="position: relative;">
                <div class="project_head">
                    <div class="project_head_image">
                        <a href="#" >
                            <img src="images/p1.jpg" />
                        </a>
                    </div>
                    <h1 class="project_title">
                        <div>
                            <a href="#">
                                Sample project 
                            </a>
                        </div>
                    </h1>
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

        <c:if test="${requestScope.status eq 'success'}">
            <div id="buglist">
                <a href="" id="addComment">Add comment</a>
                <legend> ${requestScope.bugissue} </legend>
                <blockquote> 
                    <p> <br/><c:forEach items="${requestScope.bug_comm_list}" var="comment">

                            ${comment.comment}<br/>

                            <small> ${comment.timeSatmp}</small>
                        </c:forEach>
                    </p>
                    <div id="msgResult"></div>
                    <p>
                        <input type="text" id="addComment" >
                        <input type="button" id="add" value="Add"> 
                    </p>
                </blockquote>
            </div>   
        </c:if>
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
                $.ajax({
                    url:'ServletCheckUserSession',
                    type:'post',
                    success:function(dt){
                        console.log(dt);
                        if (dt.status=='fail'){
                            $("ul.ul_list li.liSin").css('display','inline');
                            $("ul.ul_list li.liSout").css('display','none');
                        }else{
                            $("ul.ul_list li.liSout").css('display','inline');
                            $("ul.ul_list li.liSin").css('display','inline');
                        }
                    }
                });
                $('#add').click(function(){
                   if ($('#addComment').val()==''){
                       $('#msgResult').html('Add comment');
                       return;
                   } 
                   $.ajax({
                      url:'ServletAddComment',
                      data:{
                          
                      },
                      type:'post',
                      success:function(dt){
                          
                      }
                   });
                });
                $("#lnkSignOut").live('click',function(){
                    $.ajax({
                        url:'ServletSignOut',
                        type:'post',
                        success:function(dt){
                            console.log(dt);
                            if (dt.status=='success'){
                                $("ul.ul_list li.liSout").css('display','none');
                            }else{
                                $("ul.ul_list li.liSin").css('display','inline');
                            }
                        }
                    });
                });
                console.log(projId);
                $("#hdnProjId").attr('value',projId);
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
                $("#addComment").click(function(){
                    
                })
            })();
        </script>

    </body>
</html>
