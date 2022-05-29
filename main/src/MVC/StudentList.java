package MVC;


import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

import main.SinhVien;

public class StudentList {
    private ArrayList<Student> sList;
    public static int idcounter=1;
//-----------------------------------------------------
    public StudentList() {
        this.sList= new ArrayList<Student>();
       
    }
//-----------------------------------------------------
    public StudentList(ArrayList<Student> sList) {
        this.sList = sList;
    }
//-----------------------------------------------------
    public ArrayList<Student> getsList() {
        return sList;
    }
//-----------------------------------------------------
    public void setsList(ArrayList<Student> sList) {
        this.sList = sList;
    }
//-----------------------------------------------------
    @Override
    public String toString() {
        String s="Student List\n--------------------\n";
        Collections.sort(sList);
        for(Student st:sList) s+=st+"\n";
        return s;
    }
//-----------------------------------------------------
    public void add(Student s){
        sList.add(s);
        idcounter++;
    }
//----------------------------------------------------- 
    public void delete(String id){
    	for(int i=0; i<sList.size(); i++) {
    		if(sList.get(i).getId().equals(id))
    			sList.remove(i);
    	}
		
    }
//-----------------------------------------------------
    public void update(Student s, String id, String CourseName ){
    	for(int i=0; i<sList.size(); i++) {
    		if(sList.get(i).getId().equals(id)) {
    			Student sv = sList.get(i);
    			sv.setCourseName(CourseName);
    			sList.set(i, sv);
    		}
    	}
		
    }
//-----------------------------------------------------
    public StudentList find(Predicate p){
        StudentList sL=new StudentList();
        for(Student s:sList)
            if(p.test(s)) sL.add(s);
        return sL;
    }
//-----------------------------------------------------    
}
