<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
    </head>
    <h1>Registration Form</h1>
    <body>
        
        <%
            String error = (String) request.getSession().getAttribute("Error");
            if(error != null)
            {
                if(error.equals("User exists")){%>
                    USER EXISTS!
               <%}
            }else{
               String success_check = (String) request.getSession().getAttribute("Success_Request");
               if(success_check != null){%>
                    REQUEST SENT!
                <%}
            }%>
                
        <form id="reg_form" action="RegistrationRequestServlet" method="POST" onsubmit="return checkFields()">
            <h3>Personal Information</h3>
            <input id="fName" type="text" name="firstName" placeholder="First name" required>   
            <input id="mName" type="text" name="middleName" placeholder="Middle name" required> 
            <input id="lName" type="text" name="lastName" placeholder="Last name" required> <br></br>
            Birth date:<br>
            <input id="bDate" type="date" name="birthDate" required/> <br></br>
            Attach picture <br> <input type="file" name="pic" accept="image/*"> <br></br>
            <input id="occup" type="text" name="occupation" placeholder="Occupation" required> <br></br>
            <input id="tNum" type="text" name="telnum" placeholder="Telephone number" required> <br></br>
            <input id="mNum" type="text" name="mobnum" placeholder="Mobile number" required> <br></br>
            <h3>Property Information</h3>
            Moving In Date:<br>
            <input id="mvIn" type="date" name="movingIn" required> <br></br>
            <input id="bNum" type="number" name="blocknum" placeholder="Block number" required> 
            <input id="lNum" type="number" name="lotnum" placeholder="Lot number" required> <br></br>
            <h3>Account Information</h3>
            <input id="uName" type="text" name="username" placeholder="Username" required> <br></br>
            <input id="pWord" type="password" name="passwd" placeholder="Password" required> <br></br>
            <input id="cPass" type="password" name="confirm_passwd" placeholder="Confirm password" required> <br></br>
            <input type="submit" value="Submit">
        </form>
        
        <script>
            
            /*document.addEventListener("DOMContentLoaded", function(event){
                alert(<%=error%>);
            });*/
            function verifyUserName(){
                
            }
            
            function checkFields()
            {
                var pWord = document.getElementById("pWord").value;
                var cPass = document.getElementById("cPass").value;
                
                if(pWord!=cPass)
                {
                    alert("Passwords do not match");
                    return false;
                }
                
                
                return true;
                
            }
        </script>
    </body>
    
</html>

 