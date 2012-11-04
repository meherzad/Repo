<%-- 
    Document   : userProfile
    Created on : 4 Nov, 2012, 4:25:46 PM
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
        <div id="wrap">
            <br><br><br><br><br><br>
            Profile
            <div id="ProjectMembers" class="top_border">
                <div id="user_left_column">
                    <div id="stats"></div>
                    <div class="clear"></div>
                    <h2>Coordinator For</h2>
                    <ul class="paging" id="coordinator"></ul>

                </div>

                <div id="user_right_column">
                    <h2>Devloper For</h2>
                    <ul class="paging" id="devloper"></ul>
                    <br>
                    <h2>Projects I'm Following</h2>
                    <ul class="paging" id="following"></ul>
                </div>

            </div>
            <script id="statscon" type="text/x-handlebars-template">
                {{#each this}}
                <img class="avatar" src="{{image}}">
                <div class="clear"></div>
                <h2>User Stats</h2>
                <div class="UserDetails" id="stats">
                    <font style="font-size:25px"> {{nick}}</font><br><br>
                    <font style="font-size:15px"> member since {{jDate}}</font><br><br>
                    {{statement}}<br><br>
                    <a href="UserEditProfile.jsp?userid={{userId}}" class="bold" id="lblEditProfile"
                       >Edit Profile</a> <br> 


                </div><br>
                {{/each}}
                </script>
                <script id="projectList" type="text/x-handlebars-template">
                    {{#each this}}
                    <li>
                        <br>
                        <a href="ServletProjectHome?projId={{{projectid}}}" class="bold">{{project}}</a>
                        <br>                 

                    </li>

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
                        var userId = getParameterByName('userId');
                        //                        alert(userId);
                        $.ajax({
                            url:"ServletUserProfile",
                            type:"POST",
                            data:{
                                'userId':userId
                            },
                            success:function(dt){
                                console.log(dt.developer);    
                                var temp=Handlebars.compile($("#statscon").html());
                                $("#stats").append(temp(dt.userdetail));
                                var temp1=Handlebars.compile($("#projectList").html());
                                $("#coordinator").append(temp1(dt.coordinator));
                                var temp2=Handlebars.compile($("#projectList").html());
                                $("#following").append(temp2(dt.follower));
                                var temp3=Handlebars.compile($("#projectList").html());
                                $("#devloper").append(temp3(dt.devloper));
                                $("ul.paging").quickPager({
                                    pageSize:"4", 
                                    currentPage:"1", 
                                    pagerLocation:"before"
                                });
                                if (dt.sessionUser!=userId){
                                    $("#lblEditProfile").css('display','none');
                                }
                            },
                            error:function(){
                                alert('error');
                            }
                        });
                    })();
                </script>
        </body>
    </html>
