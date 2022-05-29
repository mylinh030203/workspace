package btmau;
import java.util.Comparator;

public class StudentRepository$StudentComparator implements Comparator<Student> {
    public StudentRepository$StudentComparator() {
    }

    public int compare(Student s, Student t) {
        int f = s.studentName.compareTo(t.studentName);
        return f != 0 ? f : s.courseName.compareTo(t.courseName);
    }
}
