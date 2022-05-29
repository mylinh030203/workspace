package btmau;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Comparator;

public class StudentRepository {
    private static List<Student> students = new ArrayList();
    private static int idCounter = 0;

    public StudentRepository() {
    }

    public static void Add(Student student) {
        student.id = GetId();
        students.add(student);
    }

    public static void Update(String id, Student student) {
        for(int i = 0; i < students.size(); ++i) {
            if (((Student)students.get(i)).getId().equals(id)) {
                ((Student)students.get(i)).setStudentName(student.getStudentName());
                ((Student)students.get(i)).setSemester(student.getSemester());
                ((Student)students.get(i)).setCourseName(student.getCourseName());
                break;
            }
        }

    }

    public static void Delete(String id) {
        students.removeIf((e) -> {
            return e.getId().equals(id);
        });
    }

    public static List<Student> List() {
        Collections.sort(students, new StudentComparator());
        return students;
    }

    public static boolean IsStudentExisting(String id) {
        for(int i = 0; i < students.size(); ++i) {
            if (((Student)students.get(i)).getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public static int CountStudent() {
        return students.size();
    }

    private static synchronized String GetId() {
        ++idCounter;
        return String.valueOf(idCounter);
    }
    public class StudentComparator implements Comparator<Student> {
        public StudentComparator() {
        }

        public int compare(Student s, Student t) {
            int f = s.studentName.compareTo(t.studentName);
            return f != 0 ? f : s.courseName.compareTo(t.courseName);
        }
    }

}