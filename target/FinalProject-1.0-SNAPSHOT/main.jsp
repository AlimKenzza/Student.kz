<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="tableStyles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home Page</title>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
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

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="main.jsp">AITULife</a>

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="MainServlet">Clubs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="events.jsp">Events</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">Log-out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="jumbotron">
    <h1 class="text-center">Hello, ${sessionScope.username}</h1>
    <p class="text-center">The page where you can see data about clubs</p>
</div>
<div class="container">

    <h2 style="margin-top: 50px;" class="text-center">Clubs</h2>
    <p class="text-center">The list of all clubs in the Astana IT University</p>
    <div class="row">
        <div class="table-responsive">

            <table class="table p-5">
                <thead>
                <tr>
                    <th scope="col">Club Index</th>
                    <th scope="col">Club Name</th>
                    <th scope="col">Member Count</th>
                    <th scope="col">Club Admin</th>
                    <th scrope="col">Visit</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${requestScope.clubs}" var="obj">
                    <tr>
                        <td><c:out value="${obj.clubId}"/></td>
                        <td><c:out value="${obj.clubName}"/></td>
                        <td><c:out value="${obj.memberCount}"/></td>
                        <td><c:out value="${obj.leader}"/></td>
                        <td><a href="ClubServlet?clubid=${obj.clubId}"><button type="button" class="btn btn-dark" id="clubvisit">Visit</button></a></td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>




</div>

</div>

<footer class="page-footer bg-primary text-light m-t-5 fixed-bottom">

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">2020 Copyright:
        <a href="https://mdbootstrap.com/" class="text-light text-decoration-none">coltshifter.com</a>
    </div>
    <!-- Copyright -->

</footer>




<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>