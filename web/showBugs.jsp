<%-- 
    Document   : showBugs
    Created on : 6 Nov, 2012, 5:41:26 PM
    Author     : meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/paging.css">
        <script src="js/jquery-1.7.2.min.js" ></script>
        <script type="text/javascript" src="http://cloud.github.com/downloads/wycats/handlebars.js/handlebars-1.0.0.beta.6.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/quickpager.jquery.js" type="text/javascript"></script>
        <style>
            .issuelist{
                margin-left:13%;
                font: 18px 'Segoe UI',Tahoma,Arial,Helvetica,sans-serif;
                color: #253340;
                font-weight: lighter;
                position: relative;
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
                                    <li class="liSin" style="display: none;">
                                        <a id="lnkSignUp" href="ServletUserDashBoard">Home</a>
                                    </li>
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
                            <img id="projImg" src="" />
                        </a>
                    </div>
                    <h1 class="project_title">
                        <div id="projTitle">
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

        <div class="issuelist"> 
            <a id="createBug" href="CreateBug.jsp?projId=">Create bug</a>
            <c:if test="${requestScope.status eq 'success'}">

                <h3>
                    <img src="images/bugs.png"/>&nbspBugs ..!!</h3>

                <c:forEach items="${requestScope.buglist}" var="bug">

                    <a href="ServletShowBugDetail?BugId=${bug.bugId}&ProjName=${requestScope.projname}&projiurl=${requestScope.projiurl}&bugissue=${bug.issue}" style="color: #253340;">
                        ${bug.issue}</a>
                    <p class="muted"><small>${bug.timeStamp}</small></p>
                </c:forEach>
            </c:if>
        </div>


        <script type="text/javascript">
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
                $.each($('a.bugDetail'),function(key,val){
                    var link=$(val).attr('href');
                    link=link+projId;
                    $(val).attr('href',link);
                });
                var link=$("#createBug").attr('href');
                link=link+projId;
                $("#createBug").attr('href',link);
                
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
                        $("#projTitle").html(dt.projName);
                        $('#projImg').attr('src',dt.iUrl);
                    },
                    error:function(){
                        console.log('error');
                    }
                });
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
       
            })();
        </script>
    </body>
</html>
