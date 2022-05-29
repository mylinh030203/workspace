package basic;

import java.util.Scanner;

public class bt6 {
	public static void main(String args[]) {
		float pi=3.14f;
		int r ;
		double s,p;
		System.out.print("radius is ");
		Scanner key= new Scanner(System.in);
		r=key.nextInt();
		System.out.println("circumference is "+(p=2*pi*r));
		System.out.println("area is "+(s=r*r*pi));
	}

}
