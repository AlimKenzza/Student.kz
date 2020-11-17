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
</head>
<body>

<div class="container">

    <h2 style="margin-top: 50px;" class="text-center">Students</h2>
    <p class="text-center">The list of all students in the Astana IT University</p>
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
    <div class="container">

    <h2 style="margin-top: 50px;" class="text-center">Clubs</h2>
    <p class="text-center">The list of all clubs in the Astana IT University</p>
    <div class="row">
        <div class="table-responsive">

            <table class="table">
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

        <div class="container">

            <h2 style="margin-top: 50px;" class="text-center">Events</h2>
            <p class="text-center">The list of all events in the Astana IT University</p>
            <div class="row">
                <div class="table-responsive">

                    <table class="table">
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
</div>
</body>
</html>
