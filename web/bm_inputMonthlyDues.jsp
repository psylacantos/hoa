<%-- 
    Document   : bm_inputMonthlyDues
    Created on : 11 25, 17, 4:55:20 PM
    Author     : Kayle Tiu
--%>
<%
    String name = (String)session.getAttribute("username");
    out.println(name);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BM - Monthly Dues</title>
    </head>
    <body onload="load()">
        <h1>Input Monthly Dues</h1>
        <form action="../inputMonthlyDues" method="post">
            <label>Start Date</label>
            <br>
            <input type="month" name="startDate" id="startDate">
            <br>
            <label>End Date</label>
            <br>
            <input type="month" name="endDate" id="endDate">
            <br>
            <label>Amount</label>
            <br>
            <input type="number" placeholder="Input Monthly Dues" name="mDues" min="0">
            <br>
            <button type="submit">Submit</button>
        </form>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script>
        function load(){
            var now = new Date();
            var day = ("0" + now.getDate()).slice(-2);
            var month = ("0" + (now.getMonth() + 2)).slice(-2);
            
            var today = now.getFullYear()+"-"+(month);
            var input1 = document.getElementById("startDate");
            input1.setAttribute("min", today);
        }
        document.getElementById("startDate").onchange = function () {
            var input = document.getElementById("endDate");
            input.setAttribute("min", this.value);
        };
    </script>
</html>
