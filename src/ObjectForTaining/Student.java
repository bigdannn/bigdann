package ObjectForTaining;

public class Student {

    private int student_code;
    private String full_name;
    private int group_number;
    private String year_of_admission;

    public Student(int sc, String fn, int gn, String yoa){
        this.student_code = sc;
        this.full_name = fn;
        this.group_number = gn;
        this.year_of_admission = yoa;
    }

    public int getStudent_code() {
        return student_code;
    }

    public void setStudent_code(int student_code) {
        this.student_code = student_code;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getGroup_number() {
        return group_number;
    }

    public void setGroup_number(int group_number) {
        this.group_number = group_number;
    }

    public String getYear_of_admission() {
        return year_of_admission;
    }

    public void setYear_of_admission(String year_of_admission) {
        this.year_of_admission = year_of_admission;
    }

    @Override
    public String toString() {
        return "Student{" + "Student code=" + student_code + ", full_name='" + full_name + '\'' +
                ", group_number=" + group_number +
                ", year_of_admission='" + year_of_admission + '\'' +
                '}';
    }
}
