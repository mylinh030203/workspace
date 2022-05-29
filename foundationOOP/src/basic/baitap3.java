package basic;

import java.util.Scanner;

public class baitap3 {

	public static void main(String[] args) {
		byte ASCIIcode;
		Scanner key = new Scanner(System.in);
		System.out.print("input of ASCII");
		ASCIIcode = key.nextByte();
		System.out.print("ASCIIcode "+ ASCIIcode+" is "+(char)ASCIIcode);
	
	}

}
