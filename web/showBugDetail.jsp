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

    </head>
    <body>
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
            <table border ="1" bgcolor="yellow">
                <tr>
                    <td> ${requestScope.issue} </td>
                </tr>
                <c:forEach items="${requestScope.bug_comm_list}" var="bug_comm">
                    <tr>
                        <td> ${bug_comm.comment}</td>
                    </tr>   

                </c:forEach>
            </table>
        </c:if>
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
            })();
        </script>

    </body>
</html>
