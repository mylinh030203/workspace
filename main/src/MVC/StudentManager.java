package MVC;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import main.SinhVien;

public class StudentManager extends Menu{
    
    private StudentList studentList= new StudentList();
    static String[] menu={"Add new student","Delete student course","Update student course","Find student course","Report","Exit"};
//--------------------------------------------------
    Scanner sc = new Scanner(System.in);
    public StudentManager() {
        super(menu,"Student Management");
        studentList.add(new Student("1","Nguyễn Văn Minh","Summer 21","Java"));
        studentList.add(new Student("2","Nguyễn Văn Minh","Summer 21",".NET"));
        studentList.add(new Student("3","Nguyễn Văn Minh","Spring 21","Java"));
        studentList.add(new Student("4","Nguyễn Văn Mẫn","Spring 21","Java"));
    }
//--------------------------------------------------    
    @Override
    public void execute(int n) {
        switch(n){
            case 1: addStudent();break;
            case 2: deleteStudent();break;
            case 3: updateStudent();break;
            case 4: search();break;
            case 5: report();break;
            case 6: System.exit(0);
        }
    }
//--------------------------------------------------
    public static String getData(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt+" : "); 
        return sc.nextLine();
    }
//--------------------------------------------------
    public void addStudent(){
    	Student sv = new Student();
    	
    	sv.setId(String.valueOf(studentList.idcounter));
		System.out.println("input student name ");
		sv.setStudentName(sc.nextLine());
		System.out.println("input semeter ");
		sv.setSemeter(sc.nextLine());
		System.out.println("input course name ");
		sv.setCourseName(sc.nextLine());
		studentList.add(sv);
		
    }
//--------------------------------------------------
    public void deleteStudent(){
        String id = sc.nextLine();
        studentList.delete(id);
    }
//--------------------------------------------------
    public void search(){
        String sMenu[]={"Search by ID","Search by Student Name","Search by semester","Search by course"};
        Menu sM= new Menu(sMenu,"Searching.."){
            public void execute(int n){
                final StudentList rs;
                switch(n){
                    case 1: String sID=getData("Enter ID");
                            rs=studentList.find(a->((Student)a).getId().equals(sID));
                            System.out.println(rs);break;
                    case 2: String sName=getData("Enter search Name");
                            rs=studentList.find(a->((Student)a).getStudentName().contains(sName));
                            System.out.println(rs);break;
                    case 3:String sStm=getData("Enter search semester");
                            rs=studentList.find(a->((Student)a).getSemeter().equals(sStm));
                            System.out.println(rs);break;
                    case 4:String sCourse=getData("Enter search course");
                            rs=studentList.find(a->((Student)a).getCourseName().equals(sCourse));
                            System.out.println(rs);break;
                }
                
            }
        };
        sM.run();
    }
//--------------------------------------------------
    public void updateStudent(){
    	String id = sc.nextLine();
    	String CourseName = sc.nextLine();
    	studentList.update(null, id, CourseName);
    }
//--------------------------------------------------
    public void report(){
        System.out.println(studentList);
        ArrayList<String> s=new ArrayList<>();
		for(int i=0; i<studentList.getsList().size(); i++) {
			Student sv = studentList.getsList().get(i);
			s.add(sv.getStudentName()+"\t|"+sv.getCourseName());
		}
		s.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {			
				return (int) (o1.compareTo(o2));
			}
			
		});
		int dem=1;
		for(int i=1; i<s.size();i++) {
			if(s.get(i).equals(s.get(i-1)))
				dem++;
			else {
				System.out.println(s.get(i-1)+"\t|"+dem);
				dem=1;
			}
				
		}
		System.out.println(s.get(s.size()-1)+"\t|"+dem);
		
		

	}

	
    
//--------------------------------------------------
    public static void main(String[] args) {
        StudentManager sm= new StudentManager();
        sm.run();
    }
    
}

