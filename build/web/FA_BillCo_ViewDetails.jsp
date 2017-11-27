

<%@page import="model.TrxReferences"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.BillingDao" %>
<%@page import="model.Billing,model.PaymentDetails,dao.BillingDao,dao.dbconnect,java.util.ArrayList" %>
<%
    Billing bill=(Billing)request.getAttribute("bill");
    TrxReferences p=(TrxReferences)request.getAttribute("pay");
String string="hidden";
boolean boo=false;
if(bill.getStatus().equalsIgnoreCase("Pending"))
{
    string="submit";
    boo=true;
}
%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
 <style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f2f3f3}
</style>
  <div style="margin-left:30%;padding:1px 16px;height:500px;">
     
<br>
<br>
<br>
 <div style="padding:1px 16px;height:500px;">
  <h1>Billing Details</h1>
  <form action="updateBill" method="post">
      
	<p>Block Number:<%=bill.getBlockNum()%></p>

   
	<p>Lot Number:<%=bill.getLotNum()%></p>
      
	<p>Description of Payment:<%=bill.getDesc()%></p>
	<p>Amount: </p>
        <input type="number" step="any" min="0" id="amt" name="amount" value="<%=bill.getTotalDue()%>" placeholder="<%=bill.getTotalDue()%>" onchange="filters()" readonly >

        <p>Interest
            <%=p.getInterest()%>
        </p>
        <input type="number" step="any" min="0" id="inter" value="<%=p.getInterest()%>" name="interest" placeholder="<%=p.getInterest()%>" onchange="filters()" required >

	<p>Current Status:<%=bill.getStatus()%></p>
        
<select <%=string%> name="status">
        <option value="Paid">Paid
        <option value="Overdue">Overdue
    </select>
    
	<p>Total Amount: </p>
        <input type="hidden" name="billId" value="<%=bill.getID()%>">
        <input type="hidden" name="trxId" value="<%=p.getTrxID()%>">
                <input type="number" min="0" id="totalamt" name="totalAmount" placeholder="0" autofocus readonly>
                <input type="<%=string%>" id="addb" value="Confirm Bill">
                <a href="FA_BillCo_ViewBill.jsp"><input type="button" name="Go Back" value="Go Back"></a>
  </form>
 <script>
        function filters()
        {
            var input,filter,interest, filter2,total;
            input=document.getElementById("amt").value;
            filter =input.value;
            interest=document.getElementById("inter").value;
            filter2=interest.value;
            total=document.getElementById("totalamt");
            total.value=parseFloat(input);
            total.value=parseFloat(input)+parseFloat(interest);
            
            
        }
        
    </script>
      </div>	
  
    </div>

<%@include file="footer.jsp" %>
</body>

<script type="text/javascript">
        /*n =  new Date();
		y = n.getFullYear();
		m = n.getMonth() + 1;
		d = n.getDate();
		document.getElementById("date").innerHTML = m + "/" + d + "/" + y;
		*/
		var d = new Date();
		document.getElementById("date").innerHTML = d.toDateString();
		
		(function () {
    function checkTime(i) {
        return (i < 10) ? "0" + i : i;
    }

    function startTime() {
        var today = new Date(),
            h = checkTime(today.getHours()),
            m = checkTime(today.getMinutes()),
            s = checkTime(today.getSeconds());
        document.getElementById('time').innerHTML = h + ":" + m + ":" + s;
        t = setTimeout(function () {
            startTime()
        }, 500);
    }
    startTime();
})();
	</script>
</html>
