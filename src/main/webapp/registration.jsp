<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 15.11.2020
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <title>HELLO!</title>
    <link rel="stylesheet" href="css/form.css">
</head>
<body>
<form action="LoginServlet" method="post">
    <h1>Registration</h1>
    <div class="icon">
        <i class="fas fa-user-circle"></i>
    </div>
    <div class="formcontainer">
        <div class="container">
            <%--@declare id="username"--%><%--@declare id="password"--%><label for="username"><strong>Username</strong></label>
            <input type="text" placeholder="Enter Username" name="username" required>
            <label for="email"><strong>Email</strong></label>
            <input type="text" placeholder="Enter Email" name="email" required>
            <label for="password"><strong>Password</strong></label>
            <input type="password" placeholder="Enter Password" name="password" required>
        </div>
        <button type="submit"><strong>Registration</strong></button>
    </div>
</form>
</body>
</html>
