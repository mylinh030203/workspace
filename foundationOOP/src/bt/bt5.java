package basic;

import java.util.Scanner;

public class bt5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		System.out.print("input number a and b");
		Scanner key = new Scanner(System.in);
		a=key.nextInt();
		b=key.nextInt();
		System.out.println("output");
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.println(a+"-"+b+"="+(a-b));
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println(a+"/"+b+"="+(a/b)+" has a remander of "+(a%b));
	}

}
