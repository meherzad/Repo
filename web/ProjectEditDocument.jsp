<%-- 
    Document   : ProjectEditDocument
    Created on : 4 Nov, 2012, 6:19:02 PM
    Author     : meherzad
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css">
        <link rel="stylesheet" type="text/css" href="css/editor.css">
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script src="js/advanced.js"></script>
        <script src="js/wysihtml5-0.3.0.js"></script>
        <style>
            body {
                font-family: Verdana;
                font-size: 11px;
            }

            h2 {
                margin-bottom: 0;
            }

            small {
                display: block;
                margin-top: 40px;
                font-size: 9px;
            }

            small,
            small a {
                color: #666;
            }

            a {
                color: #000;
                text-decoration: underline;
                cursor: pointer;
            }

            #toolbar [data-wysihtml5-action] {
                float: right;
            }

            #toolbar,
            textarea {
                width: 850px;
                padding: 5px;
                -webkit-box-sizing: border-box;
                -ms-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }

            textarea {
                height: 280px;
                border: 2px solid green;
                font-family: Verdana;
                font-size: 11px;
            }

            textarea:focus {
                color: black;
                border: 2px solid black;
            }

            .wysihtml5-command-active {
                font-weight: bold;
            }

            [data-wysihtml5-dialog] {
                margin: 5px 0 0;
                padding: 5px;
                border: 1px solid #666;
            }


        </style>

    <body>
        <h1>Documentation</h1>
        <form method="post" id="insrt" name="insrt" action="ServletEditDocument">
            <div id="toolbar" style="display: none;">
                <a data-wysihtml5-command="bold" title="CTRL+B"></a> 
                <a data-wysihtml5-command="italic" title="CTRL+I"></a> 
                <a data-wysihtml5-command="insertUnorderedList"></a> 
                <a data-wysihtml5-command="insertOrderedList"></a>
                <a data-wysihtml5-command="createLink"></a> 
                <a data-wysihtml5-command="insertImage" title="Insert an image" class="command"></a>
                <a data-wysihtml5-command="formatBlock" data-wysihtml5-command-value="h1"></a> 
                <a data-wysihtml5-command="formatBlock" data-wysihtml5-command-value="h2"></a>
                <!--<a data-wysihtml5-command="formatBlock" data-wysihtml5-command-value="h3"></a>
                <a data-wysihtml5-command="formatBlock" data-wysihtml5-command-value="h4">Small</a> |
                <a data-wysihtml5-command="formatBlock" data-wysihtml5-command-value="h5">Smaller</a> |-->
                <c:if test="${requestScope.requesttype eq 'Edit'}">
                    <div >
                        Sucess
                    </div>
                </c:if>

                <input type="hidden" id="hiddenProjId" name="hiddenProjId"/>
                <div data-wysihtml5-dialog="createLink" style="display: none;">
                    <label>
                        Link:
                        <input data-wysihtml5-dialog-field="href" value="http://">
                    </label>
                    <a data-wysihtml5-dialog-action="save">OK</a>&nbsp;<a data-wysihtml5-dialog-action="cancel">Cancel</a>
                </div>
                <div data-wysihtml5-dialog="insertImage" style="display: none;">
                    <label>
                        Image:
                        <!-- <input data-wysihtml5-dialog-field="src" value="http://">-->
                        <!--    </label>
                            <form id="form1" enctype="multipart/formdata" action="" method="post">
                                <input type="file" id="photo" name="file1" />
                                <a data-wysihtml5-dialog-action="save">Save</a>
                                <a data-wysihtml5-dialog-action="cancel">Cancel</a>
                            </form>
                        -->
                        <!--<input type="submit" id="save" name="save" value="Upload" />&nbsp;<input type="button" id="cancel" name="cancel" value="Cancel" /><a data-wysihtml5-dialog-action="cancel">Cancel</a>-->
                </div>


            </div>
            <textarea id="textarea" name="data" placeholder="Enter text ..."></textarea>
            <br><input type="reset" value="Reset">
            &nbsp;
            <input type="submit" value="Save">

        </form>


        <div id="log"></div>


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
                console.log(projId);
                if(projId!=null){
                    $.ajax({
                        url:'ServletViewDocumentation',
                        data:{
                            'projId': projId,
                            'type':1
                        },
                        type:'post',
                        success:function(dt){
                            //alert("suceess");
                            console.log(dt);
                            console.log(dt.projDoc);
                            $("#textarea").attr('value',dt.projDoc);
                        }
                    });
                }
                $("#hiddenProjId").attr('value',projId);
                console.log($("#insrt").attr('action'));
                var editor = new wysihtml5.Editor("textarea", {
                    toolbar:      "toolbar",
                    stylesheets:  "stylesheet.css",
                    parserRules:  wysihtml5ParserRules
                });
    
                var log = document.getElementById("log");
  
                editor
                .on("load", function() {
                    log.innerHTML += "<div></div>";
                })
                .on("focus", function() {
                    log.innerHTML += "<div></div>";
                })
                .on("blur", function() {
                    log.innerHTML += "<div></div>";
                })
                .on("change", function() {
                    log.innerHTML += "<div></div>";
                })
                .on("paste", function() {
                    log.innerHTML += "<div></div>";
                })
                .on("newword:composer", function() {
                    log.innerHTML += "<div></div>";
                })
                .on("undo:composer", function() {
                    log.innerHTML += "<div></div>";
                })
                .on("redo:composer", function() {
                    log.innerHTML += "<div></div>";
                });
  
            })();

        </script>
    </body>
</html>
