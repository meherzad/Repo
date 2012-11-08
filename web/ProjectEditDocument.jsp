<%-- 
    Document   : ProjectEditDocument
    Created on : 4 Nov, 2012, 6:19:02 PM
    Author     : meherzad
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script src="http://js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
        <script type="text/javascript">
            bkLib.onDomLoaded(nicEditors.allTextAreas);
        </script>
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

        <form action="insertServlet" method="post">
            <table>
                <tr>
                    <td><textarea name="data" style="width:300px; height: 300px;" placeholder="Enter text.." autofocus></textarea></td>
                </tr>
                <tr>
                    <td>
                        <!-- <input type="reset" value="Reset" id="reset"/> -->
                        <input type="submit" value="Save" id="save"/>
                        <a href="viewServlet">view data</a>
                    </td>
                </tr>

            </table>
        </form>

        <script >
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
                    url:'ServletViewDocumentation',
                    data:{
                        type:'1',
                        projId
                    },
                    type:'post',
                    success:function(){
                        
                    }
                });
            })();
        </script>
    </body>
</html>