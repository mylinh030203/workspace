package iostream;

import java.io.FileInputStream;
import java.util.Scanner;

public class EX3 {
	public static void main(String[] agrs) {
		int dem=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap link chua file muon dem");
		String st= sc.nextLine();	
		try {
		FileInputStream b = new FileInputStream(st);
		int i = 0;
		while((i = b.read())!=-1) {
			if((char)i=='i') {
				dem++;
			}
		}
		System.out.println(dem);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
