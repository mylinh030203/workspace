package basic;

import java.util.Scanner;
import java.lang.Math;

public class ex1 {
	public static void main(String args[]) {
		System.out.print("input n");
		Scanner sc = new Scanner(System.in);
		double n= Double.parseDouble(sc.nextLine());
		System.out.println("sin n is "+ Math.sin(n)); 
		System.out.println("cos n is "+ Math.cos(n));
		System.out.println("square root of 2 is "+ Math.sqrt(n));
		
	}

	
}
 