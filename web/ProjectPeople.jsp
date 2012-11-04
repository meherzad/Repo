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



        <div id="wrap">
            <br><br><br><br><br><br>
            People:

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
                <script type="text/javascript">

                </script>

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