package bt;
class student {
	String name;
	 int age;
	 String address;
	 float mathMark, physicsMark;
	 float averageMark;
	
	public void showinfos()
	{
	System.out.println("Name: " + this.name);	
	System.out.println("Age: " + this.age);			
	System.out.println("Address: " + this.address);
	System.out.println("MathMark: " + this.mathMark);
	System.out.println("Physics: " + this.physicsMark);
	System.out.println("AverageaMark: " + this.averageMark);
	
	}

public static void main(String[] args) {
	student studentOne = new student();
		
	studentOne.name = "Tran Minh Quang";
	studentOne.age = 18;
	studentOne.address = "Quang Tri";
	studentOne.mathMark = 7.3f;
	studentOne.physicsMark = 8f;
	studentOne.averageMark = (studentOne.mathMark + studentOne.physicsMark)/2;
   studentOne.showinfos();		
}


}
