<%@ page import="com.sms.dao.StudentDAO" %>
<%@ page import="com.sms.model.Student" %>

<%
int id = Integer.parseInt(request.getParameter("studentId"));

StudentDAO dao = new StudentDAO();

Student s = dao.searchStudent(id);
%>

<!DOCTYPE html>

<html>

<head>

<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<meta charset="UTF-8">

<title>Update Student</title>

<link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="container">

<h2>Update Student</h2>

<form action="UpdateStudentServlet" method="post">

<input type="hidden"
name="studentId"
value="<%=s.getStudentId()%>">

<label>Name</label>

<input type="text"
name="name"
value="<%=s.getName()%>">

<label>Email</label>

<input type="email"
name="email"
value="<%=s.getEmail()%>">

<label>Phone</label>

<input type="text"
name="phone"
value="<%=s.getPhone()%>">

<label>Course</label>

<input type="text"
name="course"
value="<%=s.getCourse()%>">

<label>Address</label>

<textarea name="address"><%=s.getAddress()%></textarea>

<label>Date of Birth</label>

<input type="date"
name="dateOfBirth"
value="<%=s.getDateOfBirth()%>">

<input type="submit"
value="Update Student">

</form>

</div>

</body>

</html>