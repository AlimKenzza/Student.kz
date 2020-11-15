package servlets;

import dao.ClubDao;
import dao.NewsDao;
import model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeServlet")
public class ClubServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clubId = Integer.parseInt(request.getParameter("clubid"));
        NewsDao newsDao = new NewsDao();
        ArrayList<News> news = newsDao.getAllNewsByClubId(clubId);
        request.setAttribute("newsbyclubs", news);
        request.getRequestDispatcher("club.jsp").forward(request,response);
    }
}
