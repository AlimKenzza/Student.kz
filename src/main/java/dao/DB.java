package dao;

import model.Clubs;
import model.Students;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Context initialContext = new InitialContext();
            Context envCtx = (Context) initialContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/week");
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static boolean checkStudent(String username, String password) {
        boolean st = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            st = resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }


    public List<Students> listAll() {
        ArrayList<Students> students = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From students");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Students student = new Students(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    public List<Clubs> listAllClubs() {
        ArrayList<Clubs> clubs = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From clubs");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Clubs club = new Clubs(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getString(4));
                clubs.add(club);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clubs;
    }

    public Students getById(Integer id) {
        Students student = new Students();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From students where student_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                student = new Students(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    public Clubs getByClubId(Integer id) {
        Clubs club = new Clubs();

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * From clubs where club_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                club = new Clubs(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            }
            return club;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return club;
    }
}
