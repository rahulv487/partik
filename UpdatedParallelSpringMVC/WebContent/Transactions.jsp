<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Transactions</title>
</head>
<body>

<table>

<tr>

<td>Name</td>
<td>Mobile No.</td>
<td>Credit</td>
<td>Debit</td>
<td>Transaction ID</td>
<td>Balance</td>


</tr>

<a:forEach var = "tra" items = "${l}">

<tr>

<td>${tra.tname}</td>
<td>${tra.tmobno}</td>
<td>${tra.credit}</td>
<td>${tra.debit}</td>
<td>${tra.transid}</td>
<td>${tra.balance}</td>

</tr>

</a:forEach>

</table>

</body>

</html>

