<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Customer</title>
</head>
<body>
<table>
<fo:form action="addData" method="post" modelAttribute="aa">

<tr>
<td>Customer Name </td>
<td><fo:input path="cname" /></td>
<td><fo:errors path="cname"></fo:errors></td>
</tr>

<tr>
<td>Customer Age </td>
<td><fo:input path="cage" /></td>
<td><fo:errors path="cage"></fo:errors></td>
</tr>

<tr>
<td>Customer Mobile No. </td>
<td><fo:input path="cmobno" /></td>
<td><fo:errors path="cmobno"></fo:errors></td>
</tr>

<tr>
<td>Initial Balance </td>
<td><fo:input path="cbal" /></td>
<td><fo:errors path="cbal"></fo:errors></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Add Customer" />
</td>
</tr>

</fo:form>
</table>
</body>
</html>