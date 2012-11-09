<%-- 
    Document   : userResetPassword
    Created on : 5 Nov, 2012, 5:05:46 PM
    Author     : meherzad
--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="container conatiner_support" >
        <div class="row" style="position: relative;margin-right: 5%;">
            <h2>Reset Password</h2>
        </div>
    </div>

    <div class="container conatiner_support" style="min-height: 400px;">
        <div class="row" style="position: relative;margin-right: 5%;">

            <form method="post" name="forgetPass" action="">


                <table id="tblfrm">
                    <tr>
                        <td>
                            <input type="hidden" value="${requestScope.userid}" 
                                   id="hiddenuserid" name="hiddenuserid"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="hidden" value="${requestScope.verifyId}" 
                                   id="hiddenVerfId" name="hiddenVerfId"/>
                        </td>
                    </tr>
                    <tr>
                        <td>New Password</td>
                    <div class="container conatiner_support">
                        <div class="row" style="position: relative;margin-right: 5%;">
                            <td><input type="password" name="newpass" id="newpass" onblur="verifyPasswordFormat(this.id); checkBlank('newpass','cnfrmpass');"/></td>
                            </tr>
                            <tr>
                                <td>Confirm Password</td>
                                <td><input type="password" name="cnfrmpass" id="cnfrmpass" onblur="passwordmatch('newpass','cnfrmpass')"/></td>
                            </tr>
                            <tr>
                                <td><input type="button" name="submit" value="Submit" onclick="return passwordValidation()" id="btnsubmit" /></td>
                            </tr>
                        </div>
                    </div>
                </table>
                <div id="userResult"></div>
            </form>

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
            $("#btnsubmit").live('click',function(){
                var hiddenuserid=$('#hiddenuserid').attr('value');
                var hiddenVerfId=$('#hiddenVerfId').attr('value');
                var newpass=$('#newpass').attr('value');
                // alert('sdf');
                $.ajax({
                    url : 'ServletSubmitPass',
                    data : {
                        'hiddenuserid' : hiddenuserid,
                        'hiddenVerfId' : hiddenVerfId,
                        'newpass': newpass                
                    },
                    type : 'post',
                    success:function(dt){
                        //dt.status1
                        $("#tblfrm").css('display','none');
                        $("#userResult").html(dt.status1);
                            
                    },
                    error:function(){
                        $("#userResult").html('Error');
                    }
                });
            });              
        })();
    </script>

</body>
</html> 