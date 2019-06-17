<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
</head>
<body>
<font color="green" size="4">
Employee Registration Successful
</font>
<hr>
<%
int empNumber=Integer.parseInt(request.getParameter("empNumber"));
%>
<font color="green" size="4">
Employee Registration Successful with empNumber: <%=empNumber %>
</font>
</body>
</html>