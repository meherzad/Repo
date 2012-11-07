<%-- 
    Document   : CreateProject
    Created on : 7 Nov, 2012, 11:48:19 AM
    Author     : meherzad
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="js/chosen.jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.24.custom.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/chosen.css"/> 
        <title>JSP Page</title>
    </head>
    <body>
        <form action="" method="post">
            <table>
                <tr>
                    <td> Project Name: 
                    <td> <input type="text" name ="txtprojname" id="txtprojname"> </td>
                </tr>
                <tr>
                    <td> Description: 
                    <td> <input type="text" name ="txtprojdescrip" id="txtprojdescrip"> </td>
                </tr>
                <tr>
                    <td> Owner Id: 
                    <td> <input type="text" name ="txtowner"> </td>
                </tr>
                <tr>
                    <td> Visibility: 
                    <td> <input type="radio" name="visibility" value="private">Private</td>
                    <td> <input type="radio" name="visibility" value="public">Public </td>
                </tr>

                <tr>
                    <td>Tags</td>
                    <td><select data-placeholder="Choose tags for your project" style="width:350px;" 
                                multiple class="chzn-select" name="tags" id="tags">
                            <option value="1">Web Projects</option>
                            <option value="2">Java Projects</option>
                            <option value="3">DotNet Projects</option>
                            <option value="4">Network Applications</option>
                        </select>
                        <input type="hidden" id="hdnVal" name="hdnVal" value=""/>
                    </td>


                </tr>
                <div id="result"></div>
                <tr>
                    <td> <input type="button" name ="btnsubmit" id="btnsubmit" value="Create Project"> </td>
                </tr>
            </table>
        </form>

        <script type="text/javascript">
            (function(){
                $("#tags").chosen().change(function (e){
                    tag='';
                    var selected=$("#tags").children("option").filter(":selected");
                    var selected1=$(this).find("option:selected").attr('value');
                    var option=$(this).val();
                    $("#hdnVal").val(option);
                });
            $("#btnsubmit").click(function(){
                $.ajax({
                    url:'ServletAddProject',
                    data:{
                        'txtprojname' : $("#txtprojname").val(),
                        'hdnVal':$("#hdnVal").val(),
                        'txtprojdescrip':$("#txtprojdescrip").val(),
                        'visibility':$('input[name=visibility]:radio:checked').val()
                    },
                    type:'post',
                    success:function(dt){
                        if (dt.status=='success')
                            $("#result").html('Project successfully added');
                        else
                            $("#result").html('Error');
                    }
                });
            });
        })();
        
        </script>

    </body>

</html>
