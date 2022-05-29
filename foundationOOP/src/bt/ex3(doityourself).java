package basic;

import java.util.Scanner;

public class ex3 {
	public static void main(String args []) {
		int a,b;
		Scanner sc= new Scanner(System.in);
		System.out.println("Width of rectangle is ");
		a= Integer.parseInt(sc.nextLine());
		System.out.println("High of rectangle is ");
		b= Integer.parseInt(sc.nextLine());
		System.out.println("Area of rectangle is "+a*b);
		System.out.println("Perimeter of rectangle is "+2*(a+b));
		
	}

}
/*	import java.util.Scanner;
public class ex3{
	static double area(int a,int b) {
		double s=a*b;
		return s;
	
	}
	static double perimeter(int a,int b) {
		double c=2*(a+b);
			return c;
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.print("input width and high");
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		System.out.println( "Area of rectangle is "+area(a,b));
		System.out.println( "Perimeter of rectangle is "+perimeter(a,b));
	}
}*/
