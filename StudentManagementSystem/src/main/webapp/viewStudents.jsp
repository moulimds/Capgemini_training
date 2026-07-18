<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sms.model.Student" %>

<!DOCTYPE html>
<html>
<head>

<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>View Students</title>

<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="container">

<h2>Student List</h2>

<div class="table-container">

<table>

<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Phone</th>
<th>Course</th>
<th>Address</th>
<th>DOB</th>
<th>Update</th>
<th>Delete</th>
</tr>

<%
ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("students");

if(list != null){
    for(Student s : list){
%>

<tr>

<td><%= s.getStudentId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getPhone() %></td>
<td><%= s.getCourse() %></td>
<td><%= s.getAddress() %></td>
<td><%= s.getDateOfBirth() %></td>

<td>
<a href="updateStudent.jsp?studentId=<%= s.getStudentId() %>">
Update
</a>
</td>

<td>
<a href="DeleteStudentServlet?studentId=<%= s.getStudentId() %>"
onclick="return confirm('Are you sure you want to delete this student?');">
Delete
</a>
</td>

</tr>

<%
    }
}
%>

</table>

</div>

<br>

<a href="dashboard.html">Back to Dashboard</a>

</div>

</body>
</html>