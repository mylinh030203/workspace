package vonglap;

import java.util.Scanner;

public class tonguocso {
	/*public static void main(String args[]) {
		int s=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("n");
		int n=sc.nextInt();
		for (int i=1;i<n;i++) {
			if (n%i==0) {
				s=s+i;
			}
		}
		System.out.print(s);
	}*/
	public static int tonguoc1(int n) {
		int s=0;
		for (int i=1;i<n;i++) {
			if (n%i==0) {
				s=s+i;
			}
		}
		return s;
	}
	public static void main(String args[]) {
		System.out.print("n");
		int n;
		Scanner sc = new Scanner(System.in);
	
		n=sc.nextInt();
		System.out.print("tong = "+tonguoc1(n) );
	}
}
