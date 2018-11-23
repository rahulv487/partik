<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Your Money</title>
</head>
<body>
<table>

<fo:form action="withdrawMoney" method="post" modelAttribute="ww">

<tr>
<td>Mobile No.  <fo:input path="cmobno" /></td>
<td><fo:errors path="cmobno"></fo:errors></td>
</tr>

<tr>
<td>Withdraw Amount  <fo:input path="cbal" /></td> 
<td><fo:errors path="cbal"></fo:errors></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Withdraw Money" />
</td>
</tr>

<tr>
<td><fo:input path="cname" value="Udit Yadav" type="hidden" /></td> 
</tr>
<tr>
<td><fo:input path="cage" value="21" type="hidden" /></td> 
</tr>


</fo:form>
</table>
</body>
</html>

