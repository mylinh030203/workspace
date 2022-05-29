package MVC;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Menu {
    private ArrayList mChon= new ArrayList();
    private String title="";
//--------------------------------------
    public Menu(String[] mc, String td){
       title = td;
      for(int i=0; i<mc.length;i++) {
    	  mChon.add(mc[i]);
      }
    }
//--------------------------------------
    public void setTitle(String td){
    	this.title=td;
    }
//--------------------------------------
    public ArrayList getmChon() {
		return mChon;
        
    }
//--------------------------------------    
    public void addItem(Object a){
    	mChon.add(a);
       
    }
//--------------------------------------    
    public Menu() {
    	title="";
    	mChon=new ArrayList<String>();
    }
//--------------------------------------
    public void display(){
        System.out.println(title);
        System.out.println("-----------------------------");
        for(int i=0; i<mChon.size();i++) 
            System.out.println(mChon.get(i));
        System.out.println("-----------------------------");
    }
//--------------------------------------   
    public int getSelected(){
        display();
        System.out.print("Please select..:");
        Scanner sc= new Scanner(System.in);
        return sc.nextInt();
    }
//--------------------------------------
    public abstract void execute(int n);
//--------------------------------------
    public void run(){
        while(true){
            int n=getSelected();
            if(n>mChon.size()) break;
            execute(n);
            
        }
    }
//--------------------------------------    
}
