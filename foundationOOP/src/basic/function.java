package basic;

import java.util.Scanner;

public class function {
	static double calCircleArea (double r)//double r chi muon nhan 1 ki tu cung kieu trong ngoac
	{
		 double s=3.14*r*r;
		 return s;
	 }
	static double calCircleCv (double r) {
		 double c=3.14*2*r;
		 return c;
	 }
	 public static void main(String args []) {
		 Scanner sc =new Scanner(System.in);
		double r = sc.nextDouble();
		 System.out.print("s= "+calCircleArea(r));//ngoac sau ham phai cung kieu du lieu voi ngoac sau ham o tren phan khai bao ham
		 
	 }
}
