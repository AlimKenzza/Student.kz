package servlets;

import dao.ClubDao;
import dao.Dao;
import dao.StudentDao;
import model.Club;
import model.Student;
import resource.StudentResource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class AdminServlet extends HttpServlet {
    StudentDao studentDao = new StudentDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int studentId = Integer.parseInt(request.getParameter("studentId"));
//        StudentDao studentDao = new StudentDao();
//        StudentResource studentResource = new StudentResource();
//        studentResource.deleteById(studentId);
//        List<Student> students = new ArrayList<>(studentDao.fetch());
//        request.setAttribute("students", students);
//        ClubDao clubDao = new ClubDao();
//        ArrayList<Club> clubs = new ArrayList<>(clubDao.fetch());
//        request.setAttribute("clubs", clubs);
//        request.getRequestDispatcher("admin.jsp").forward(request, response);
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                try {
                    showNewForm(request,response);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                break;
            case "/insert":
                try {
                    addStudent(request,response);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                break;
            case "/delete" :
                try {
                    deleteStudent(request,response);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                break;
            case "/edit":
                try {
                    showEditForm(request,response);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                break;
            case "/update":
                try {
                    updateStudent(request,response);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                break;
            default:
                try {
                    listStudent(request,response);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                break;
        }
    }
    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Student> studentList = studentDao.fetch();
        request.setAttribute("studentList", studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student-list.jsp");
        requestDispatcher.forward(request,response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student-form.jsp");
        requestDispatcher.forward(request,response);
    }
    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        Student newStudent = new Student(id, fname,lname, email, groupId);
        studentDao.add(newStudent);
        response.sendRedirect("list");
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDao.delete(id);
        response.sendRedirect("list");
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDao.get(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student-form.jsp");
        request.setAttribute("student", existingStudent);
        requestDispatcher.forward(request,response);
    }
    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        Student student = new Student(id, fname,lname,email,groupId);
        studentDao.edit(student);
        response.sendRedirect("list");
    }
}
