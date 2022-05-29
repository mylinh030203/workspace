package basic;

import java.util.Scanner;

public class hellovku {
	/*public static void main(String args[]) {
		int a=1,b=1;
		int n=0;
		System.out.println(a);
		
		while( b<=1000) {
		n=b;
		b=a+b;
		a=n;
		System.out.println(a);
		}
		
	}*/
	  public static void main(String[] args) {
		   int n;
	        float x;
	        float sum = 0f;
	        Scanner sc;
	        do {
	            System.out.print("Input n = ");
	             sc = new Scanner(System.in);
	            n = sc.nextInt();
	        }while(n < 0);
	         
	        System.out.print("Input x = ");
	        x = sc.nextFloat();
	         
	        for(int i = 0; i <= n; i++) {
	            sum += Math.pow(x, 2*i)/factorial(2*i);
	        }
	         
	        System.out.println("Sum = " + sum);
	        sc.close();
	    }
	     
	public static long factorial(int n) {
       long sum = 1;
       for(int i = 1; i <= n; i++) {
           sum = sum * i;
       }
       return sum;

	    }

}
