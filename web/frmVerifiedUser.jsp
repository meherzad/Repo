<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-1.7.2.min.js" ></script>
        <script type="text/javascript" src="http://cloud.github.com/downloads/wycats/handlebars.js/handlebars-1.0.0.beta.6.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <header class="navbar">
            <div class="navbar-inner">
                <div class="container conatiner_support">
                    <div class="float_left">
                        <p id="logo">
                            <a href="index.html">Site
                                Logo</a> <span class="tagline">Free project hosting</span>
                        </p>
                    </div>
                    <div class="float_right">
                        <ul class="ul_list">
                            <li>
                                <ul class="ul_list" id="nav">
                                    <li><a id="lnkSignUp" href="frmRegistration.html"> Sign Up</a></li>
                                    <li><a id="lnkSignIn" href="#myModal" data-toggle="modal">Sign In</a></li>

                                    <li><input id="searchSite" name="searchSite" maxlength="500"
                                               type="text" value="" autocomplete="off"
                                               title="Search all projects"
                                               style="color: rgb(170, 170, 170); font-style: italic;">
                                    </li>
                                </ul>
                            </li>

                        </ul>
                        <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
                                <h3 id="myModalLabel" style="color: #6A747E;"><center>Sign In</center></h3>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" method="post" action="">
                                    <div class="control-group">
                                        <label class="loginLabel" for="inputEmail">Email</label>
                                        <div class="controls">
                                            <input type="text" id="username" name="username" placeholder="Email">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="loginLabel" for="inputPassword">Password</label>
                                        <div class="controls">
                                            <input type="password" id="password" name="password" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <label class="checkbox">
                                                <input type="checkbox"> 
                                                <label class="loginLabel" style="text-align: left !important;padding-top: 0px !important; ">Remember me</label>
                                            </label><br>
                                            <div style="color: red;" id="loginStatus"></div>
                                            <button type="button" class="btn" id="btnLogIn">Sign in</button>
                                        </div>
                                    </div>
                                </form>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </header>


        <div class="container conatiner_support">
            <div>
                <p>Congratulation your account has been verified. You can login to your account.</p>
            </div>
        </div>

        <div id="footer">
            <div class="row">
                <hr style="color:">
                <ul class="ul_list">
                    <li class="list"></li>
                    <li class="list"><a href="#">Get Help</a></li>
                    <li class="list"><a href="#">Privacy Statement</a></li>
                    <li class="list"><a href="#">Terms of Use</a></li>
                    <li class="list"><a href="#">Code of Conduct</a></li>
                    <li class="list"><a href="#">Advertise With Us</a></li>

                </ul>
            </div>
        </div>
    </body>
</html>