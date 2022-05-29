package MVC;


import java.util.Objects;

public class Student implements Comparable<Student> {
    private String id;
    private String studentName;
    private String semester;
    private String courseName;
    public Student (){
    }
    public Student(String id, String studentName, String semester, String courseName){
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;   
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemeter() {
        return semester;
    }

    public void setSemeter(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    @Override
    public String toString(){
         return id+" | "+studentName + " | " + this.semester + " | " + this.courseName;
     }
    
    @Override
    public int compareTo(Student student){
        return this.studentName.compareTo(student.getStudentName());
    }

    @Override
    public boolean equals(Object obj) {
        Student other = (Student) obj;
        return (id==other.id);
    }
    
    public void setStudent(Student s){
        if(this.equals(s)) {
            studentName=s.studentName;
            semester=s.semester;
            courseName=s.courseName;
        }
    }
}

