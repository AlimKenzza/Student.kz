package servlets;

import dao.ClubDao;
import dao.EventDao;
import dao.StudentDao;
import model.Club;
import model.Event;
import model.Student;

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
            StudentDao studentDao = new StudentDao();
            ArrayList<Student> students = new ArrayList<>(studentDao.fetch());
            request.setAttribute("students", students);
            ClubDao clubDao = new ClubDao();
            ArrayList<Club> clubs = new ArrayList<>(clubDao.fetch());
            request.setAttribute("clubs", clubs);
            EventDao eventDao = new EventDao();
            ArrayList<Event> events = new ArrayList<>(eventDao.fetch());
            request.setAttribute("events", events);
            request.getRequestDispatcher("admin.jsp").forward(request, response);

        } else {
            ClubDao clubDao = new ClubDao();
            ArrayList<Club> clubs = new ArrayList<>(clubDao.fetch());
            request.setAttribute("clubs", clubs);
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }
    }
}
