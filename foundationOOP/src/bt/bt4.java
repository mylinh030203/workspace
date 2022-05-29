package bt;
import java.util.Scanner;

public class bt4 {
	public static void main(String args[]) {
		char h;
		Scanner key=new Scanner(System.in);
		System.out.print("input of charater");
		h=key.next().charAt(0);
		System.out.print("ASCIIcode of "+h+" is "+(byte)h);
		
	}

}
