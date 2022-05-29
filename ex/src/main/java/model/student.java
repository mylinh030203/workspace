package model;

import java.util.Scanner;

public class student {
	 int id;
	 String name;
	 String age;
	 public student() {
		 this.id = 0;
		 this.name = "Linh";
		 this.age = "19";
	 }
	 public student(int id, String name, String age) {
		 this.id = id;
		 this.name = name;
		 this.age = age;
	 }
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	public String toString() {
		return "id ="+this.id+" name = "+this.name+" age = "+this.age;
	}
	public student them() {
		student st = new student();
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap id ");
		st.id = sc.nextInt();
		sc.nextLine();
		System.out.println("nhap ten ");
		st.name = sc.nextLine();
		System.out.println("nhap tuoi ");
		st.age = sc.nextLine();
		return st;
	}

}
