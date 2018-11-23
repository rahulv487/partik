<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Your Funds</title>
</head>
<body>
<table>

<fo:form action="tfy" method="post" modelAttribute="tt">

<tr>
<td>Sender's Mobile No.  <fo:input path="cmobno" /></td>
<td><fo:errors path="cmobno"></fo:errors></td>
</tr>

<tr>
<td>Receiver's Mobile No.  <input type="text" name="rmobno" value="" /></td> 
<td>${rnomsg}</td>
</tr>

<tr>
<td>Transfer Amount  <fo:input path="cbal" /></td> 
<td><fo:errors path="cbal"></fo:errors></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Transfer Money" />
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

