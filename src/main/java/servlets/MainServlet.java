package servlets;

import dao.ClubDao;
import model.Club;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("username").equals("admin")) {
            request.getRequestDispatcher("first.jsp").forward(request, response);
        } else {
            ClubDao clubDao = new ClubDao();
            ArrayList<Club> clubs = new ArrayList<>(clubDao.fetch());
            request.setAttribute("clubs", clubs);
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }
    }
}
