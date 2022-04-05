package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsServiceImpl {
    private static final String connectionPath = "jdbc:mysql://localhost:3306/hw20";
    private static final String user = "root";
    private static final String password = "rootroot";
    private static final String s = "select * from Students";

    public List<Student> getAll() throws SQLException {
        ArrayList<Student> students = new ArrayList<Student>();
        Connection connection = DriverManager.getConnection(connectionPath, user, password);

        try {
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(s);
            while (resultset.next()) {
                Student st = new Student(resultset.getInt("student_code"), resultset.getString("full_name"), resultset.getInt("group_number"), resultset.getString("year_of_admission"));
                System.out.println(st);
                students.add(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Student> getByName(String name) throws SQLException {
        ArrayList<Student> student = new ArrayList<>();
        Connection con = DriverManager.getConnection(connectionPath, user, password);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Student stud = new Student(rs.getInt("student_code"), rs.getString("full_name"), rs.getInt("group_number"), rs.getString("year_of_admission"));
            if (stud.getFull_name().equals(name)) {
                student.add(stud);
            }
        }
        System.out.println(student);
        return student;
    }

    public List<Student> getByIds(List<Integer> ids) throws SQLException {
        ArrayList<Student> student = new ArrayList<>();
        Connection con = DriverManager.getConnection(connectionPath, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(s);

        while (rs.next()) {
            Student stud = new Student(rs.getInt("student_code"), rs.getString("full_name"), rs.getInt("group_number"), rs.getString("year_of_admission"));
            for (int i = 0; i < ids.size(); i++) {
                if (ids.get(i).equals(stud.getStudent_code())){
                    student.add(stud);
                }
            }
        }
        System.out.println(student);
        return student;
    }
}
