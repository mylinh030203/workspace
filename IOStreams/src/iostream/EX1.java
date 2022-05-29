package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class EX1 {
	public static void main(String []agrs) {
		Scanner sc = new Scanner(System.in);
		String hoten = "Ho va Ten : ";
		String masinhvien = "\nMa sinh vien : ";
		System.out.println("Nhap vao ten sinh vien");
		String sthoten = sc.nextLine();
		System.out.println("Nhap vao ma sinh vien");
		String stmasinhvien = sc.nextLine();
		try {
			FileOutputStream a = new FileOutputStream("F:\\eclipse\\IOStreams\\HoTenSV.txt");
			byte[]hovaten = hoten.getBytes();
			a.write(hovaten);
			byte[]sthovaten = sthoten.getBytes();
			a.write(sthovaten);
			byte[]MSV = masinhvien.getBytes();
			a.write(MSV);
			byte[]stMSV = stmasinhvien.getBytes();
			a.write(stMSV);
			System.out.println("success");
			FileInputStream b = new FileInputStream("F:\\eclipse\\IOStreams\\HoTenSV.txt");
			int i = 0;
			while((i = b.read())!=-1) {
				System.out.print((char)i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
