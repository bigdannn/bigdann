package Utils;

import ObjectForTaining.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsServiceImpl {
    private static final String CONNECTIONPATH = "jdbc:mysql://localhost:3306/hw20";
    private static final String USER = "root";
    private static final String PASSWORD = "rootroot";
    private static final String STR = "select * from Students";

    public List<Student> getAll() throws SQLException {
        ArrayList<Student> students = new ArrayList<Student>();
        Connection connection = DriverManager.getConnection(CONNECTIONPATH, USER, PASSWORD);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(STR);
            while (resultset.next()) {
                Student st = new Student(resultset.getInt("student_code"), resultset.getString("full_name"), resultset.getInt("group_number"), resultset.getString("year_of_admission"));
                System.out.println(st);
                students.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
        return students;
    }
    public List<Student> getByName(String name) throws SQLException {
        ArrayList<Student> student = new ArrayList<>();
        Connection con = DriverManager.getConnection(CONNECTIONPATH, USER, PASSWORD);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(STR);
        while (rs.next()) {
            Student stud = new Student(rs.getInt("student_code"), rs.getString("full_name"), rs.getInt("group_number"), rs.getString("year_of_admission"));
            if (stud.getFull_name().equals(name)) {
                student.add(stud);
            }
        }
        System.out.println(student);
        con.close();
        return student;
    }

    public List<Student> getByIds(List<Integer> ids) throws SQLException {
        ArrayList<Student> student = new ArrayList<>();

        Connection con = DriverManager.getConnection(CONNECTIONPATH, USER, PASSWORD);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(STR);

        while (rs.next()) {
            Student stud = new Student(rs.getInt("student_code"), rs.getString("full_name"), rs.getInt("group_number"), rs.getString("year_of_admission"));
            for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i).equals(stud.getStudent_code())) {
                    student.add(stud);
                }
            }
        }
        con.close();
        System.out.println(student);
        return student;
    }

    public void addStudent(int student_code, String full_name, int group_number, String year_of_admission) throws SQLException {
        String sql = "insert into Students " + " VALUES(?,?, ?,?)";
        try {
            Connection connection = DriverManager.getConnection(CONNECTIONPATH, USER, PASSWORD);
            PreparedStatement preState = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preState.setInt(1, student_code);
            preState.setString(2, full_name);
            preState.setInt(3, group_number);
            preState.setString(4, year_of_admission);
            preState.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getByName(full_name);
    }

    public void deleteStudent(int student_code) throws SQLException {
        String sqlCommand = "DELETE from Students where student_code = " + student_code;

        try{
            Connection con = DriverManager.getConnection(CONNECTIONPATH, USER,PASSWORD);
            PreparedStatement statement = con.prepareStatement(sqlCommand);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getAll();
    }
}
