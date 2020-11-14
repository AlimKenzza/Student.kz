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
    public void deleteStudentById(Integer id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM students WHERE student_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteClubById(Integer id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM clubs WHERE club_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addClub(Clubs club)  {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into clubs(club_id, club_name, members_count,leader) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, club.getClubId());
            preparedStatement.setString(2, club.getClubName());
            preparedStatement.setInt(3,club.getMemberCount());
            preparedStatement.setString(4,club.getLeader());
            preparedStatement.executeUpdate();
            System.out.println("Club successfully added.");
            connection.close();
            preparedStatement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addStudent(Students student)  {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into students(student_id, fname, lname,email,group_id) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3,student.getLastName());
            preparedStatement.setString(4,student.getEmail());
            preparedStatement.setInt(5, student.getGroupId());
            preparedStatement.executeUpdate();
            System.out.println("Student successfully added.");
            connection.close();
            preparedStatement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateStudent(Students student) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students SET fname = ?, lname = ?, email = ?, group_id = ? WHERE student_id = ?");
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2,student.getLastName());
            preparedStatement.setString(3,student.getEmail());
            preparedStatement.setInt(4,student.getGroupId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateClub(Clubs club) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE clubs SET club_name = ?, members_count = ?, leader = ? WHERE club_id = ?");
            preparedStatement.setString(1, club.getClubName());
            preparedStatement.setInt(2, club.getMemberCount());
            preparedStatement.setString(3, club.getLeader());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
