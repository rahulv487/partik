<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit Your Money</title>
</head>
<body>
<table>

<fo:form action="depositMoney" method="post" modelAttribute="dd">

<tr>
<td>Mobile No.  <fo:input path="cmobno" /></td>
<td><fo:errors path="cmobno"></fo:errors></td>
</tr>

<tr>
<td>Deposit Amount  <fo:input path="cbal" /></td> 
<td><fo:errors path="cbal"></fo:errors></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Deposit Money" />
</td>
</tr>

<tr>
<td><fo:input path="cname" value="Rahul Verma" type="hidden" /></td> 
</tr>
<tr>
<td><fo:input path="cage" value="21" type="hidden"/></td> 
</tr>


</fo:form>
</table>
</body>
</html>