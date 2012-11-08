<%-- 
    Document   : ProjectPeople
    Created on : 4 Nov, 2012, 2:33:02 PM
    Author     : meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/style 2.css">
        <link rel="stylesheet" href="css/paging.css">
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/quickpager.jquery.js"></script>
        <script type="text/javascript" src="http://cloud.github.com/downloads/wycats/handlebars.js/handlebars-1.0.0.beta.6.js"></script>

    </head>
    <body>
        <!--Add Header Here------------------->
        <header class="navbar">
            <div class="navbar-inner">
                <div class="container conatiner_support">
                    <div class="float_left" style="margin-left:-45px;">
                        <p id="logo">
                            <a href="index.html">Site
                                Logo</a> <span class="tagline">Free project hosting</span>
                        </p>
                    </div>
                    <div class="float_right" style="margin-top: 10px;">
                        <ul class="ul_list">
                            <li>
                                <ul class="ul_list" id="nav">
                                    <li class="liSout" style="display: none;">
                                        <a id="lnkSignOut">SignOut</a>
                                    </li>
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
        <div id="membersManage" class="container conatiner_support" style="margin-top: 10px;
             display: none;">
            <div class="row">
                <a href="">Manage members</a>
            </div>
        </div>
        <div class="container conatiner_support" style="min-height: 400px;">
            <div class="row">
                <h2>People</h2>
                <div id="ProjectMembers" class="top_border">
                    <div class="ProjectMembersLeft" style="float:left;">
                        <div id="CoordinatordContainer" style="margin-bottom:10px;">

                            <h2>Coordinators</h2>
                            <div id="OwnerContainer">
                                <div>

                                </div>
                            </div>
                            <div id="DevlopersContainer" style="margin-bottom:10px;">
                                <h2>Developers </h2>  
                                <ul class="paging" id="developercon">

                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="ProjectMembersRight">
                        <div id="RecentFollowerContainer">
                            <h2>Recent Followers</h2>

                            <ul class="paging" id="follower">

                            </ul>
                        </div>
                    </div>
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

        <script id="templetefollower" type="text/x-handlebars-template">
            {{#each this}}
        <li>
            <div class="UserRow StandardPaddingBottom  ">
                <div class="UserAvatar" style="height:60px; width:60px; float:left">
                    <img class="avatar" style="height:50px;width:50px" src="{{image}}">
                </div>
                <div class="UserDetails">
                    <!--                                    change Link--------------------------------------->
                    <a href="userProfile.jsp?userId={{userId}}" class="bold">{{userName}}</a> <br> 
                    Follows Since<br>
                    {{jDate}}
                </div>
            </div>

        <li>

            {{/each}}
        </script>
        <script id="templeteownercon" type="text/x-handlebars-template">
            {{#each this}}
            <div class="UserRow StandardPaddingBottom  ">
                <div class="UserAvatar" style="height:60px; width:60px; float:left">
                    <img class="avatar" style="height:50px;width:50px" src="{{image}}">
                </div>
                <div class="UserDetails">
                    <!--                                    change Link--------------------------------------->
                    <a href="userProfile.jsp?userId={{userId}}" class="bold">{{userName}}</a> <br> 

                    project owner<br>
                    {{jDate}}
                </div>
            </div>
            {{/each}}
        </script>

        <script id="templetedev" type="text/x-handlebars-template">
            {{#each this}}
        <li>
            <div class="UserRow StandardPaddingBottom  ">
                <div class="UserAvatar" style="height:60px; width:60px; float:left">
                    <img class="avatar" style="height:50px;width:50px" src="{{image}}">
                </div>
                <div class="UserDetails">
                    <!--                                    change Link--------------------------------------->
                    <a href="userProfile.jsp?userId={{userId}}" class="bold">{{userName}}</a> <br> 

                    project developer<br>
                    {{jDate}}
                </div>

            </div>
        <li>
            {{/each}}
        </script>

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
                                $("#membersManage").css('display','none');
                            }else{
                                $("ul.ul_list li.liSin").css('display','inline');
                            }
                        }
                    });
                });

                $.ajax({
                    url:'ServletCheckUserType',
                    data:{
                        'projId':projId
                    },
                    type:'post',
                    success:function(dt){
                        if (dt.status!='true'){
                            $("#projDash").css('display','none');
                        }
                        if (dt.type=='owner'){
                            $("#membersManage").css('display','inline');
                        }
                    },
                    error:function(){
                        console.log('error');
                    }
                });
        
                $.ajax({
                    url:"ServletPeople",
                    type:"POST",
                    data:{
                        'projId':projId
                    },
                    success:function(dt){
                        console.log(dt.developer);
                        var temp=Handlebars.compile($("#templeteownercon").html());
                        $("#OwnerContainer div").append(temp(dt.owner));
                        var temp1=Handlebars.compile($("#templetedev").html());
                        $("#developercon").append(temp1(dt.developer));
                        var temp2=Handlebars.compile($("#templetefollower").html());
                        $("#follower").append(temp2(dt.follower));
                        $("ul.paging").quickPager({
                            pageSize:"7", 
                            currentPage:"1", 
                            pagerLocation:"before"
                        });

                    },
                    error:function(){
                        alert('error');
                    }
                });
            })();
        </script>
    </body>
</html>