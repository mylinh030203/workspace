package basic;
import java.util.Scanner;

public class sc {

	public static double CalSumSqrt(double n) {
			double S = 0;
			for(int i = 1;i<= n;i++) {
				S = S + Math.sqrt(i);
			}
			return S;
		}
		
		//chuoi: Java is exciting. I love Java
		public static int countJava(String strJava,String word) {
			int count =0;
			String mang[]= strJava.split("");
			for(int i=0;i<mang.length;i++) {
				if(mang[i].contains(word)) count++;
			}
			return count;
		}

		//tinh S=1!+2!+...+n!
		
		public static int tongGT(int n) {
			int gt =1;
			int sum=0;
			for(int i=1;i<=n;i++) {
				gt=gt*i;
				sum=sum+gt;
			}
			return sum;}
	public static void main(String[] args) {
		int count=0;
	Scanner key = new Scanner(System.in);
	
	do {
			System.out.println("Please enter number:");
			int n = key.nextInt();
	

			switch(n) {
			case 1:System.out.println( CalSumSqrt(6.5));
					break;
			case 2:System.out.println( countJava("Java is good. I love Java", "o"));
					break;
			case 3: System.out.println( tongGT(6));
					break;
			default: System.out.println("Re-enter:");
			
			}
	} while(count<10);
	
		}
	}
