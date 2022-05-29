package basic;

import java.util.Scanner;

public class giaithua {
	static int s=1, a=0;
	static int i;
	static int giaithua (int n) {
		
		for ( i=1;i<=n;i++) {
			  s=s*i;
				a=a+s;
			 
			  }
		
		
	 return a;
	}
	public static void main(String args[]) {
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("input n");
		int n=sc.nextInt();
		System.out.println("in ra tong giai thua "+giaithua(n));
		}
		
	}

	/*public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n,i;
	int s=1;
		System.out.println("input n ");
		n=sc.nextInt();
		for (i=1;i<=n;i++) {
			s=s*i;
		}
		System.out.println("in ra giai thua "+s);
	}*/


