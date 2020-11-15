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

<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
    <a class="navbar-brand" href="index.html">AITULife</a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#">Clubs</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="events.jsp">Events</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="LogoutServlet">Log-out</a>
        </li>
    </ul>
</nav>
<div class="jumbotron">
    <h1 class="text-center">${requestScope.clubforclubs.clubName}</h1>
    <p class="text-center">The page of the single club</p>
</div>
<div class="container mb-5">


        <h2 style="margin-top: 50px" class="text-center">News</h2>
        <p class="text-center">The list of all news of ${requestScope.clubforclubs.clubName}'s office</p>


    <c:forEach items="${requestScope.newsbyclubs}" var="obj">
        <div class="row mb-5">
            <div class="card p-5 bg-light">
                <h3 class="card-title"><c:out value="${obj.title}"/></h3>
                <h5 class="card-subtitle text-dark p-3"><c:out value="${obj.postDate}"/></h5>
                <p class="card-text p-3"><c:out value="${obj.body}"/></p>
            </div>
        </div>
    </c:forEach>


</div>


<footer class="page-footer bg-primary text-light">

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2020 Copyright:
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