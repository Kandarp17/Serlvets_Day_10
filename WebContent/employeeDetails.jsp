<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

int empNum=Integer.parseInt(session.getAttribute("empNumber").toString());
String empName=session.getAttribute("empName").toString();
double empSalary=Double.parseDouble(session.getAttribute("empSalary").toString());
int departmentNumber=Integer.parseInt(session.getAttribute("departmentNumber").toString());
String empQualification=session.getAttribute("empQualification").toString();
String empDesignation=session.getAttribute("empDesignation").toString();
%>
<font color="blue" size="10">
Employee Details
</font>
<hr>

<font color="green" size="4">
SessionID: <%=session.getId() %>

empNumber: <%=empNum %>
<br>
empName: <%=empName%>
<br>
empSalary: <%=empSalary %>
<br>
DepartmentNumber: <%=departmentNumber %>
<br>
EmpQualification: <%=empQualification %>
<br>
empDesignation: <%=empDesignation %>
</font>
</body>
</html>