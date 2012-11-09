<%-- 
    Document   : UserEditProfile
    Created on : 4 Nov, 2012, 5:33:29 PM
    Author     : meherzad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/style 2.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/paging.css">
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="http://cloud.github.com/downloads/wycats/handlebars.js/handlebars-1.0.0.beta.6.js"></script>

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
                                        <a id="lnkSignUp" href="frmRegistration.html"> Sign Up</a>
                                    </li>
                                    <li class="liSin" style="display: none;">
                                        <a id="lnkSignIn" href="#myModal" data-toggle="modal">Sign In</a>
                                    </li>
                                    <li class="liSout" style="display: none;">
                                        <a href="userProfile.jsp?userId=" id="userName"></a>
                                    </li>
                                    <li class="liSout" style="display: none;">
                                        <a id="lnkSignOut" >SignOut</a>
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
            <div class="row" style="position: relative;margin-right: 5%;">
                <div id="wrap">
                    <br>
                    <div id="username"></div>
                    <div id="ProjectMembers" class="top_border">
                        <div class="user_column"><br>
                            <h2 class="heading" style="width:700px">User Picture</h2>
                            <p>Choose a picture to display in your profile...</p><br>

                            <form id="Avtarimage" name="Avtarimage" onsubmit="return uploadimage();" action="ServletUploadImage" method="post" enctype="multipart/form-data">
                                <input type="file" name="avatar" id="avatar"/>
                                <input type="submit" id="uoloadAvatar" class="ok" style="display:inline" value="upload" onclick="uploadimage();"/>                 
                                <br> <br> 
                                <div id="loderdiv"><image src="images/loading.gif" style="widht:200px;height:20px">
                                </div>
                                <p>GIF,JPEG,JPG,BMP and PNG files are supported.</p><br>                     
                            </form>   


                            <h2 class="heading" style="width:700px">Personal Statement</h2>
                            <p>A few words about yourself...</p><br>
                            <input type="text" name="about" id="about"/><br>
                            <input type="button" class="ok" value="Update" name="updateabout" onclick="upabout();"/><br>
                            <h2 class="heading" style="width:700px">Change Password</h2>

                            <lable>Current Password</lable>&nbsp;&nbsp;&nbsp;<input type="Password" name="CurrentPassword" id="CurrentPassword"/><br>
                            <lable>New Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</lable><input type="Password" name="NewPassword" id="NewPassword"/><br>
                            <lable>Confirm Password</lable>&nbsp;&nbsp;<input type="Password" name="ConfirmPassword" id="ConfirmPassword"/><br><br>
                            <span id="lblResult"></span>
                            <input type="button" class="ok" value="Update" name="Update" onclick="changepass();"/>
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

        <script id="filluser" type="text/x-handlebars-template">
            {{#each this}}

            {{userName}}
            {{/each}}

        </script>
        <script type="text/javascript">
            (function(){
                $("#loderdiv").hide();
                $.ajax({
                    url:"ServletEditProfile",
                    type:"POST",
                    data:{type:'userdetail'},       
                    success:function(dt){
                        var temp=Handlebars.compile($("#filluser").html());
                        $("#username").append(temp(dt.userdetail)); 
                        
                    }
                });
            })();
            function uploadimage()
            {   
                $("#loderdiv").show();
                var about=$("#avatar").val();
                var parts = about.split('.');
                ext=parts[parts.length - 1];
                switch (ext.toLowerCase()) 
                {
            
                    case 'jpg':
                    case 'jpeg':
                    case 'gif':
                    case 'bmp':
                    case 'png':
                        $('#loderdiv').delay(4000).fadeOut();
                        return true;
                }
                $("#loderdiv").hide();
                alert("File Extension is not Support!!");
                $("#avatar").val("");
                return false;

            }
            function upabout()
            {
                var about=$("#about").val();
                if(about!="")
                {
                    $.ajax({
                        url:"ServletEditProfile",
                        type:"POST",
                        data:{type:'updateabout',val:about},    
                        success:function(dt){
                            $("#about").val("");
                            $("#lblResult").html('Update successfully!!');
                        }});
                }
                else
                {
                    $("#lblResult").html('Personal Statement is Empty!!');
                }
                    
            }
            function changepass()
            {
                var Current=$("#CurrentPassword").val();
                var New=$("#NewPassword").val();
                var Confirm=$("#ConfirmPassword").val();
                if(Current!="" && Confirm!="" && New!="")
                {
                    if(New==Confirm)
                    {
                        $.ajax({
                            url:"ServletEditProfile",
                            type:"POST",
                            data:{
                                type:'changepass',
                                Current:Current,
                                New:New,
                                Confirm:Confirm
                            },    
                            success:function(dt){
                                console.log(dt);
                                console.log(dt.result);
                                $("#lblResult").html(dt.result);
                                $("#CurrentPassword").val("");
                                $("#NewPassword").val("");
                                $("#ConfirmPassword").val("");
                            }});
                    }
                    else
                    {
                        $("#lblResult").html("Confirm Password doesn't Match!!");
                        $("#ConfirmPassword").val("");
                    }
                }
                else
                {
                    $("#lblResult").html('Please Fill all the detail!!');
                }
                    
            }
        </script>
    </body>
</html>
