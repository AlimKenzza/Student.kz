<%--
  Created by IntelliJ IDEA.
  User: Bekezhan
  Date: 15.11.2020
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="tableStyles.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <style>
        .my-custom-scrollbar {
            position: relative;
            height: 200px;
            overflow: auto;
        }
        .table-wrapper-scroll-y {
            display: block;
        }
    </style>
</head>
<body>

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
                <a class="nav-link" href="#">Clubs</a>
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
<div>
    <h1 style="text-align: center; margin-top: 20px;">
        Admin Page
    </h1>
</div>

<div class="container">

    <h2 style="margin-top: 50px;" class="text-center">Students</h2>
    <p class="text-center">The list of all students in the Astana IT University</p>

    <!--
    <div class="row">
        <div class="table-responsive">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Student id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">GroupId</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${requestScope.students}" var="obj">
                    <tr>
                        <td><c:out value="${obj.studentId}"/></td>
                        <td><c:out value="${obj.firstName}"/></td>
                        <td><c:out value="${obj.lastName}"/></td>
                        <td><c:out value="${obj.email}"/></td>
                        <td><c:out value="${obj.groupId}"/></td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    -->
    <div class="container">
        <div class="table-wrapper-scroll-y my-custom-scrollbar">

            <table class="table table-bordered table-striped mb-0">
                <thead>
                <tr>
                    <th scope="col">Student id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">GroupId</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.students}" var="obj">
                    <tr>
                        <td><c:out value="${obj.studentId}"/></td>
                        <td><c:out value="${obj.firstName}"/></td>
                        <td><c:out value="${obj.lastName}"/></td>
                        <td><c:out value="${obj.email}"/></td>
                        <td><c:out value="${obj.groupId}"/></td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>


    <div class="container">

        <h2 style="margin-top: 50px;" class="text-center">Clubs</h2>
        <p class="text-center">The list of all clubs in the Astana IT University</p>
        <div class="row">

            <div class="table-wrapper-scroll-y my-custom-scrollbar">

                <table class="table table-bordered table-striped mb-0">
                    <thead>
                    <tr>
                        <th scope="col">Club id</th>
                        <th scope="col">Club Name</th>
                        <th scope="col">Members Amount</th>
                        <th scope="col">Leader</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.clubs}" var="obj">
                        <tr>
                            <td><c:out value="${obj.clubId}"/></td>
                            <td><c:out value="${obj.clubName}"/></td>
                            <td><c:out value="${obj.memberCount}"/></td>
                            <td><c:out value="${obj.leader}"/></td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>

            </div>

        </div>

        
        <!-- events -->
        <div class="container">

            <h2 style="margin-top: 50px;" class="text-center">Events</h2>
            <p class="text-center">The list of all events in the Astana IT University</p>


            <div class="table-wrapper-scroll-y my-custom-scrollbar">

                <table class="table table-bordered table-striped mb-0">
                    <thead>
                    <tr>
                        <th scope="col">Event id</th>
                        <th scope="col">Event Name</th>
                        <th scope="col">Event date</th>
                        <th scope="col">Event cost</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.events}" var="obj">
                        <tr>
                            <td><c:out value="${obj.eventId}"/></td>
                            <td><c:out value="${obj.eventName}"/></td>
                            <td><c:out value="${obj.eventDate}"/></td>
                            <td><c:out value="${obj.eventCost}"/></td>
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
