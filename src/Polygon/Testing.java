package Polygon;

import Utils.StudentsServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class Testing {

    public static void main(String[] args) throws SQLException {
        ArrayList<Integer> studentCode = new ArrayList<>(3);
        studentCode.add(1);
        studentCode.add(3);
        studentCode.add(6);

        StudentsServiceImpl jd = new StudentsServiceImpl();
        jd.getAll();
        System.out.println("----------------------");
        jd.getByName("Vekichko Egor");
        System.out.println("----------------------");
        jd.getByIds(studentCode);
        System.out.println("----------------------");
        jd.addStudent(4040, "Bozhe Konchene", 404, "12.20.2001");
        System.out.println("----------------------");
        jd.deleteStudent(4040);
    }
}
