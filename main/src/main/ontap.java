package main;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ontap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pnt = Pattern.compile(".*[0-9]+.*");
		Pattern pnns = Pattern.compile("\\d{2}[-|/]\\d{2}[-|/]\\d{4}$");
		Pattern pnage = Pattern.compile("\\d+$");
		Pattern pnemail = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Scanner sc = new Scanner(System.in);
		
				
		System.out.println("Nhap vao ho ten");
		String Hoten = sc.nextLine();
		
		while(pnt.matcher(Hoten).matches() == true) {
			System.out.println("Ho ten khong hop le");
			System.out.println("Nhap vao ho ten");
			Hoten = sc.nextLine();
		}
		System.out.println("Nhap vao ngay thang nam sinh");
		String namsinh = sc.nextLine();
		
			
		while(pnns.matcher(namsinh).matches()==false) {
			System.out.println("Nam sinh khong hop le");
			System.out.println("Nhap vao ngay thang nam sinh");
			namsinh = sc.nextLine();
		}
		
		System.out.println("Nhap vao tuoi");
		String tuoi = sc.nextLine();
		
		while(pnage.matcher(tuoi).matches()==false) {
			System.out.println("tuoi khong hop le");
			System.out.println("Nhap vao tuoi");
			tuoi = sc.nextLine();
		}
		
		System.out.println("Nhap vao email");
		String email = sc.nextLine();
		while (pnemail.matcher(email).matches()==false) {
			System.out.println("Email khong hop le");
			System.out.println("Nhap vao email");
			email = sc.nextLine();
		}	
	}
}
