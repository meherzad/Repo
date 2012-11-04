
var validemail=false;//for email in proper format
var validpass=false;//for password in correct format
var sizematch=false;//length match of the password
var passpattern=false;//pattern match of the password
var passmatch=false;//password and confirm password match or not



function verifyEmailFormat(txtboxid)//checks for the correct frormat of the emailid.
{
    var emailtxt=document.getElementById(txtboxid).value;//value of the email textbox
    var atpos=emailtxt.indexOf("@");
    var dotpos=emailtxt.lastIndexOf(".");
    
   // document.getElementById("error").hidden=false;
   
     if(emailtxt!="")//email entered
     {
         if (atpos<1 || dotpos<atpos+2 || dotpos+2>=emailtxt.length)//if the format doesnt match
         {
            // document.getElementById("error").innerHTML="Not a valid email address"; 
             alert("Not a valid email address");
             document.getElementById(txtboxid).focus();
             validemail=false;		
         }
         else//if the format matches
         {
              validemail=true;
         }
         
     }//end main if
     else
         {
            //  document.getElementById("error").style.borderColor="#FF0000";
              validemail=false;
         }
   
}


        
function passwordmatch(newpass,cnfrmpass)//checks if the password and confirm password match or not
{        
    var password=document.getElementById(newpass).value;//password textbox value
    var confirm_password=document.getElementById(cnfrmpass).value;//confirm password textbox value
        if(confirm_password!=password)
        {
           // document.getElementById("error").innerHTML="Passwords donot match. Please re-enter."; 
            alert("Passwords donot match. Please re-enter.");
           // document.getElementById(cnfrmpass).focus();
            passmatch=false;
        }
        else
        {//if the values match.
            passmatch=true;
        }
}
function passwordValidation()
{
    if(passmatch==false)
    {
            alert("password donot match......");
            return false;
            
            
    }
    else
    {
            return true;
    }
}

   

//-----functon for checking the password size minimum 6 and alphanumeric values.-----------
function verifyPasswordFormat(tbid)
{
    var numberexists=false,alphexists=false;
    var pass=document.getElementById(tbid).value;
    var passsize=pass.length;
    var i;
    var charcode;
    
    if(passsize<6)//password size less than 6 
        {
            sizematch=false;
            alert("password size should be minimum 6");
            //document.getElementById("error").innerHTML="Password should be of minimum 6 characters";
        }
        else
            {
               sizematch=true;
   //---for checking if the password contains alphanumeric characters. -----------
    for(i=0; i<passsize; i++)
        {
           charcode=pass.charCodeAt(i);//taking unicode value of each character
		             
          if (charcode >32 && charcode < 65)//for special characters and number
              {
                  numberexists=true;				
              }
           if((charcode >64 && charcode<91)||(charcode>96 && charcode < 123))//for a-z and A-Z
               {
                   alphexists=true;
               }          
        }
        
                if(numberexists==true && alphexists==true)//password contains both numbers and alphabets
                    {
                       passmatch=true; 
                    }
                    else
                        {
                            alert("password must contain alphanumeric value");
                           // document.getElementById("error").innerHTML="Password must have alphanemeric value";
                            passmatch=false;
                        }   
      }
      
      if(sizematch==true && passmatch==true)//size 6 or more and alphanumeric.
          {
              validpass=true;
          }
         /* else
              {
                  alert("invalid password");
                 // document.getElementById("error").innerHTML="Please enter a valid password.";
              }*/
}
    

function validate()
{
    if((validemail==false) || (emailusable==false) || (validpass==false) || (passmatch==false))
        {
            //document.getElementById("error").innerHTML="Please fill in all the required details corretcly.";
            alert("Please fill in all the required details corretcly.");
            return;
        }
 }
 
 
 function blankTextbox(tbid)
 {
     value=document.getElementById(tbid).value;
     
     if(value=="")
         {
             document.getElementById("error").innerHTML="Please enter the value. Can not leave it blank.";
             return false;
         }
         else
             return true;
 }