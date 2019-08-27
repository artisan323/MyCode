package student;

import student.student;

public class StudentDemo {
    public static void main(String[] args) {

        student[] s = new student[3];
        student st = new student("刘浩","三班",12);

        System.out.println(st.toString());
    }
}
