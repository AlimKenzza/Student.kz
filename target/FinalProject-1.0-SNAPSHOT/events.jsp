
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="tableStyles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home Page</title>
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>

    <script>
        $(document).ready(function () {
            $.getJSON('http://localhost:8080/FinalProject_war/rest/events', function (data){
                $.each(data, function(i, f){
                    $('#main').append('<div class="row mb-5">' + ' <div class="card p-5 bg-light">' + '<h3 class="card-title">' + f.eventName
                        + '</h3>' + '<h5 class="card-subtitle text-dark p-3">' + f.eventDate + '</h5>' + '<p class="card-text p-3">' + "Total Event Cost is " + f.eventCost + " bucks"+ '</p>'
                        + '</div>' + '</div>');


                })
            });
        });
    </script>
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
    <h1 class="text-center">Events</h1>
    <p class="text-center">Main events of the University</p>
</div>
<div class="container mb-5 d-flex flex-column align-items-center" id="main">

    <h2 style="margin-top: 50px;" class="text-center">Events</h2>
    <p class="text-center">The list of all events of the University</p>



</div>


</div>


<footer class="page-footer bg-primary text-light fixed-bottom">

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