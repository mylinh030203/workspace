package basic;

import java.util.Scanner;

public class sinhvien {
	private String ten;
	private String masv;
	private float diemc;
	private float diemjava;
	private float diemtoan;
	public String getTen() {
		return ten;
	}

	
	public void setTen(String ten) {
		this.ten = ten;
	}

	
	public String getMasv() {
		return masv;
	}

	
	public void setMasv(String masv) {
		this.masv = masv;
	}
	
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ma sv");
		this.masv = sc.nextLine();
		System.out.println("ten");
		this.ten = sc.nextLine();
		System.out.println("nhap diemjava");
		this.diemjava = sc.nextFloat();

	}
	public double diemtb() {
	return ((this.diemc+this.diemjava) /2
			);
	}
	public void out() {
		System.out.println(this.masv+" = "+this.diemtb());
	}

	

}

	

