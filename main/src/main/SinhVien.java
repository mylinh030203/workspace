package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SinhVien {
	private static int msv = 1;
	private int masv;
	private String ten;
	private String hocky;
	private String khoahoc;
	public SinhVien() {
	this.masv=msv++;
		
	}
	public int getMsv() {
		return masv;
	}
	public void setMsv(int masv) {
		this.masv = masv;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public String getHocky() {
		return hocky;
	}
	public void setHocky(String hocky) {
		this.hocky = hocky;
	}
	public String getKhoahoc() {
		return khoahoc;
	}
	public void setKhoahoc(String khoahoc) {
		this.khoahoc = khoahoc;
	}
	/*public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}*/
	public void nhap() {
		//Pattern pnage = Pattern.compile("\\d+$");
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ten sv");
		this.ten= sc.nextLine();
		System.out.println("nhap hoc ki");
		this.hocky=sc.nextLine();
		System.out.println("nhap khoa hoc");
		this.khoahoc = sc.nextLine();
	/*	System.out.println("Nhap vao tuoi");
		this.tuoi = sc.nextLine();
		
		while(pnage.matcher(this.tuoi).matches()==false) {
			System.out.println("tuoi khong hop le");
			System.out.println("Nhap vao tuoi");
			this.tuoi = sc.nextLine();
		}
		System.out.println("nhap vao lop cua sv");
		this.lop= sc.nextLine();
	}
	public String toString() {
		return ("ma sinh viên "+ this.masv+ "\n"+"Ten sinh viên " +this.ten+"\n"+"Tuoi sinh viên "+this.tuoi
				+"\n"+"Lop sinh viên "+this.lop);*/
	}
	public String toString() {
		return ("Ma sinh vien "+this.masv+"\t Ten sinh vien "+this.ten+"\tHoc ki dang hoc"+this.hocky+"\tKhoa hoc"+this.khoahoc);
	}
	

}
