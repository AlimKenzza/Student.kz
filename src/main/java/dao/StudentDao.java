package dao;

import model.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao extends Dao<Student> {
    private final List<Student> students = new ArrayList<>();

    public int addUser(String username, String password, String email){
        try{
            getConnection();
            pStatement = connection.prepareStatement("INSERT INTO users(username,password,email) VALUES(?,?,?)");
            pStatement.setString(1,username);
            pStatement.setString(2,password);
            pStatement.setString(3,email);
            return pStatement.executeUpdate();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public boolean checkIfLoginExist(String username){
        boolean st = false;
        try {
            getConnection();
            pStatement = connection.prepareStatement("SELECT username FROM users WHERE username = ?");
            pStatement.setString(1, username);
            resultSet = pStatement.executeQuery();
            st = resultSet.next();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        System.out.println(st);
        return st;

    }


    public boolean checkStudent(String username, String password) {
        boolean st = false;
        try {
            getConnection();
            pStatement = connection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");
            pStatement.setString(1, username);
            pStatement.setString(2, password);
            resultSet = pStatement.executeQuery();
            st = resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        System.out.println(st);
        return st;
    }

    @Override
    public List<Student> fetch() {
        try {
            getConnection();
            query = "SELECT * From student_view";
            pStatement = connection.prepareStatement(query);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("fname");
                String lastName = resultSet.getString("lname");
                String email = resultSet.getString("email");
                int groupId = resultSet.getInt("group_id");
                String groupName = resultSet.getString("group_name");
                int courseYear = resultSet.getInt("course_year");
                String major = resultSet.getString("major");
                Student student = new Student();
                student.setStudentId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setGroupId(groupId);
                student.setGroupName(groupName);
                student.setCourseYear(courseYear);
                student.setMajor(major);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return students;
    }

    @Override
    public void add(Student student) {
        try {
            getConnection();
            query = "Insert into students(student_id, fname, lname,email,group_id) VALUES (?,?,?,?,?)";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, student.getStudentId());
            pStatement.setString(2, student.getFirstName());
            pStatement.setString(3, student.getLastName());
            pStatement.setString(4, student.getEmail());
            pStatement.setInt(5, student.getGroupId());
            pStatement.executeUpdate();
            System.out.println("Student successfully added.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
    }

    @Override
    public void edit(Student student) {
        try {
            getConnection();
            query = "UPDATE students SET fname = ?, lname = ?, email = ?, group_id = ? WHERE student_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, student.getFirstName());
            pStatement.setString(2, student.getLastName());
            pStatement.setString(3, student.getEmail());
            pStatement.setInt(4, student.getGroupId());
            pStatement.setInt(5, student.getStudentId());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
    }

    @Override
    public void delete(int id) {
        try {
            getConnection();
            query = "DELETE FROM students WHERE student_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
    }

    @Override
    public Student get(int id) {
        Student student = new Student();
        try {
            getConnection();
            query = "SELECT * From students where student_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("fname");
                String lastName = resultSet.getString("lname");
                String email = resultSet.getString("email");
                int groupId = resultSet.getInt("group_id");

                student.setStudentId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setGroupId(groupId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return student;
    }
    public List<Student> getByYear(int course) {
        try {
            getConnection();
            query = "SELECT * from student_view WHERE course_year = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1,course);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("fname");
                String lastName = resultSet.getString("lname");
                String email = resultSet.getString("email");
                int groupId = resultSet.getInt("group_id");
                String groupName = resultSet.getString("group_name");
                int courseYear = resultSet.getInt("course_year");
                String major = resultSet.getString("major");
                Student student = new Student();
                student.setStudentId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setGroupId(groupId);
                student.setGroupName(groupName);
                student.setCourseYear(courseYear);
                student.setMajor(major);
                students.add(student);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return students;
    }

    public List<Student> getByGroup(int group) {
        try {
            getConnection();
            query = "SELECT * from complex WHERE group_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1,group);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("fname");
                String lastName = resultSet.getString("lname");
                String email = resultSet.getString("email");
                int groupId = resultSet.getInt("group_id");
                String groupName = resultSet.getString("group_name");
                int course = resultSet.getInt("course_year");
                String specialty = resultSet.getString("major");
                Student student = new Student();
                student.setStudentId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setGroupId(groupId);
                student.setGroupName(groupName);
                student.setCourseYear(course);
                student.setMajor(specialty);
                students.add(student);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return students;
    }
    public List<Student> getByMajor(String major) {
        try {
            getConnection();
            query = "SELECT * from student_view WHERE major = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1,major);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("fname");
                String lastName = resultSet.getString("lname");
                String email = resultSet.getString("email");
                int groupId = resultSet.getInt("group_id");
                String groupName = resultSet.getString("group_name");
                int course = resultSet.getInt("course_year");
                String specialty = resultSet.getString("major");
                Student student = new Student();
                student.setStudentId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setGroupId(groupId);
                student.setGroupName(groupName);
                student.setCourseYear(course);
                student.setMajor(specialty);
                students.add(student);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return students;
    }
    public List<Student> getByFname(String fname) {
        try {
            getConnection();
            query = "SELECT * from student_view WHERE fname = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1,fname);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("fname");
                String lastName = resultSet.getString("lname");
                String email = resultSet.getString("email");
                int groupId = resultSet.getInt("group_id");
                String groupName = resultSet.getString("group_name");
                int course = resultSet.getInt("course_year");
                String specialty = resultSet.getString("major");
                Student student = new Student();
                student.setStudentId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setGroupId(groupId);
                student.setGroupName(groupName);
                student.setCourseYear(course);
                student.setMajor(specialty);
                students.add(student);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return students;
    }
    public List<Student> getByLname(String lname) {
        try {
            getConnection();
            query = "SELECT * from student_view WHERE lname = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1,lname);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String firstName = resultSet.getString("fname");
                String lastName = resultSet.getString("lname");
                String email = resultSet.getString("email");
                int groupId = resultSet.getInt("group_id");
                String groupName = resultSet.getString("group_name");
                int course = resultSet.getInt("course_year");
                String specialty = resultSet.getString("major");
                Student student = new Student();
                student.setStudentId(id);
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setEmail(email);
                student.setGroupId(groupId);
                student.setGroupName(groupName);
                student.setCourseYear(course);
                student.setMajor(specialty);
                students.add(student);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return students;
    }
}
