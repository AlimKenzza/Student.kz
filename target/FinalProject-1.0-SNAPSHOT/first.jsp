<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 11.11.2020
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/navbar.css">
    <link rel="stylesheet" href="css/min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    int counter;
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("counter")) {
            counter = Integer.parseInt(cookie.getValue());
            counter++;
            cookie.setValue(counter + "");
            response.addCookie(cookie);
        }
    }

    Cookie[] newCookies = request.getCookies();
    PrintWriter pw = response.getWriter();
    for (Cookie cookie : newCookies) {
        if (cookie.getName().equals("counter")) {
            pw.println("This session visited website " + cookie.getValue() + " times (Cookie)");
        }
    }
%>


<header class="site-header">
    <div class="wrapper site-header__wrapper">
        <div class="site-header__start">
            <img src="img/aitu.png" style="height: 80px; width: 320px;">
            <a href="#" class="brand">StudentsMove</a>
        </div>
        <div class="site-header__end">
            <nav class="nav">
                <button class="nav__toggle" aria-expanded="false" type="button">
                    menu
                </button>
                <ul class="nav__wrapper">
                    <li class="nav__item"><a href="#">Home</a></li>
                    <li class="nav__item"><a href="#">About</a></li>
                    <li class="nav__item"><a href="#">Services</a></li>
                    <li class="nav__item"><a href="#">Hire us</a></li>
                    <li class="nav__item"><a href="#">Contact</a></li>
                </ul>
            </nav>
            <div class="search">
                <button class="search__toggle" aria-label="Open search">
                    Search
                </button>
                <form class="search__form" action="">
                    <label class="sr-only" for="search">Search</label>
                    <input
                            type="search"
                            name=""
                            id="search"
                            placeholder="What's on your mind?"
                    />
                </form>
            </div>
        </div>
    </div>
</header>
<form action="LogoutServlet">
    <input type="submit" name="submit" value="Logout">
</form>
<script src="javascript/navbar.js"></script>
</body>
</html>
