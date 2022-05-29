package basic;

/*import java.util.Scanner;

public class ex2 {
	public static void count(String chuoi) {
		System.out.print("so chuoi la "+chuoi.length());
	}
	public static void main(String args []) {
		System.out.print("nhap chuoi can dem");
		Scanner sc =new Scanner(System.in);
		String chuoi=sc.nextLine();
		count(chuoi);
		
	
	}

}*/
	import java.util.Scanner;
public class ex2{
	public static void main(String args[]) {
		System.out.println("nhap vao chuoi");
		Scanner sc= new Scanner(System.in);
		String chuoi=sc.nextLine();
		int skt=chuoi.length();
		System.out.print("so ky tu trong chuoi la "+skt);
	}
}
