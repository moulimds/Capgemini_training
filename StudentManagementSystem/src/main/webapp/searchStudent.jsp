<%@ page import="com.sms.model.Student" %>

<%
Student s=(Student)request.getAttribute("student");
%>

<!DOCTYPE html>

<html>

<head>

<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<meta charset="UTF-8">

<title>Search Result</title>

<link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="container">

<h2>Search Result</h2>

<%

if(s!=null){

%>

<table>

<tr>

<th>ID</th>

<th>Name</th>

<th>Email</th>

<th>Phone</th>

<th>Course</th>

<th>Address</th>

<th>DOB</th>

</tr>

<tr>

<td><%=s.getStudentId()%></td>

<td><%=s.getName()%></td>

<td><%=s.getEmail()%></td>

<td><%=s.getPhone()%></td>

<td><%=s.getCourse()%></td>

<td><%=s.getAddress()%></td>

<td><%=s.getDateOfBirth()%></td>

</tr>

</table>

<%

}

else{

%>

<h3>Student Not Found</h3>

<%

}

%>

<br>

<a href="dashboard.html">Back to Dashboard</a>

</div>

</body>

</html>