<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Your Balance</title>
</head>
<body>

<fo:form action="checkBal" method="post">

Mobile No.  <input type="text" name="mobno" value="" />    ${rnomsg}<br><br>
<input type="submit" value="Check Balance" />

</fo:form>

</body>
</html>