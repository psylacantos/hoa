<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declare Pet</title>
    </head>
    <h1>Declare Pet</h1>
    <body>
                
        <form id="pet_form" action="" method="POST">
            <input id="petName" type="text" name="petname" placeholder="Pet name" required>
            <select name="animaltype" required>
                <option value="" disabled selected>Select animal type</option>
                <option value="1">Cat</option>
                <option value="2">Dog</option> 
            </select><br> </br>
            Vaccinated:
            <input type="radio" name="vaccinated" value="1"> Yes
            <input type="radio" name="vaccinated" value="0"> No <br></br>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>