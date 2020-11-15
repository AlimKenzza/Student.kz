package servlets;

import dao.StudentDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    StudentDao dao = new StudentDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (dao.checkStudent(username, password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            Cookie websiteVisitCounter = new Cookie("counter", "1");
            websiteVisitCounter.setMaxAge(3600);
            response.addCookie(websiteVisitCounter);
            response.sendRedirect(request.getContextPath() + "/MainServlet");
        } else {
            request.setAttribute("errorMessage", "Incorrect username or password");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
