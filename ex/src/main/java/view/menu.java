package view;

import java.util.Scanner;

public class menu {
	public int Display() {
		System.out.println("<!--------!>");
		System.out.println("1-hien thi thong tin");
		System.out.println("2-Them");
		System.out.println("3-Sua");
		System.out.println("4-Xoa");
		System.out.println("<!--------!>");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		return n;
	}

}
