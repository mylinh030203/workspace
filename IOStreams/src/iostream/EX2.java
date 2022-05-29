package iostream;

import java.io.File;
import java.util.Scanner;

public class EX2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String link;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap link thu muc");
		link = sc.nextLine();
		System.out.println("File [] ListFile");
		File dir = new File(link);
		EX2 myfile = new EX2();
		System.out.println(myfile.bt2(dir));
		
	}
	public int bt2(final File dir ) {
		int dem = 0;
		System.out.println(dir.getPath());
		if(dir.isDirectory()) {
			//System.out.println(dir.getAbsolutePath());
			final File[] child = dir.listFiles();
			if(child == null) {
				return dem;
			}
			for(final File file : child) {
				dem+=bt2(file);
				
			}
		}else {
			//System.out.println(dir.getAbsolutePath());
			dem++;
		}
		
		return dem;
	}

}
