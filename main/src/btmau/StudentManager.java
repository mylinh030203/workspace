package btmau;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StudentManager {
    private Scanner scan;

    public StudentManager() {
        this.scan = new Scanner(System.in);
    }

    public void Add() {
        while(true) {
            System.out.println("Please input information for creating student: ");
            Student newStudent = this.InputStudent();
            StudentRepository.Add(newStudent);
            System.out.println("Create record was successfully");
            if (StudentRepository.CountStudent() > 2) {
                System.out.println("Do you want to continue (Y/N): ");
                String answer = this.GetStringInput();
                if (!answer.equalsIgnoreCase(new String("Y"))) {
                    return;
                }
            }
        }
    }

    public void UpdateOrDelete() {
        System.out.print("Input Id: ");
        String id = this.GetStringInput();
        boolean isExisting = StudentRepository.IsStudentExisting(id);
        if (!isExisting) {
            System.out.println("Not found record with Id: " + id);
        } else {
            System.out.println("Do you want to update (U) or delete (D) student?");
            String answer = this.GetStringInput();
            System.out.println("Please input new information for update: ");
            if (answer.equalsIgnoreCase(new String("U"))) {
                Student updateStudent = this.InputStudent();
                StudentRepository.Update(id, updateStudent);
                System.out.println("Update record Id: " + id + " was successfully");
            } else if (answer.equalsIgnoreCase(new String("D"))) {
                StudentRepository.Delete(id);
                System.out.println("Delete record Id: " + id + "was successfully");
            }
        }

    }

    public void Find() {
        System.out.print("Find student name: ");
        String nameSeach = this.GetStringInput();
        List<Student> students = StudentRepository.List();
        System.out.println("Result:");
        if (students.size() == 0) {
            System.out.println("Not found any records");
        } else {
            for(int i = 0; i < students.size(); ++i) {
                if (((Student)students.get(i)).getStudentName().contains(nameSeach)) {
                    System.out.println(((Student)students.get(i)).toString());
                }
            }
        }

    }

    public void List() {
        List<Student> students = StudentRepository.List();
        System.out.println("List of students:");
        Map<String, Long> map = (Map)students.stream().collect(Collectors.groupingBy(Student::getStudentNameAndCourseName, Collectors.counting()));
        Iterator var4 = map.entrySet().iterator();

        while(var4.hasNext()) {
            Entry<String, Long> entry = (Entry)var4.next();
            System.out.println((String)entry.getKey() + " | " + entry.getValue());
        }

    }

    private Student InputStudent() {
        Student student = new Student();
        System.out.print("Input Student name: ");
        student.setStudentName(this.GetStringInput());
        System.out.print("Input Semester: ");
        student.setSemester(this.GetStringInput());
        System.out.print("Input Course Name: ");
        student.setCourseName(this.GetStringInput());
        return student;
    }

    private String GetStringInput() {
        String text = this.scan.nextLine();
        return text.trim();
    }

    public void ClearScreen() {
        System.out.print("\f");
    }
}