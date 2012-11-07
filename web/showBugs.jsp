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

        <table border="1" bgcolor="yellow">

            <c:if test="${requestScope.status eq 'success'}">

                <tr>
                    <th> Issue </th>
                </tr>


                <c:forEach items="${requestScope.buglist}" var="bug">

                    <tr>
                        <td> <a class="bugDetail"  href="ServletShowBugDetail?BugId=${bug.bugId}&
                                BugIssue=${bug.issue}&projId=">
                                ${bug.issue}</a></td>
                    </tr>
                </c:forEach>

            </c:if>
            <a id="createBug" href="CreateBug.jsp?projId=">Create bug</a>
        </table>


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
                    },
                    error:function(){
                        console.log('error');
                    }
                });
            })();
        </script>
    </body>
</html>
