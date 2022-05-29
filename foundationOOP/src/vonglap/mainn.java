package vonglap;

import java.util.Scanner;

public class mainn {
	 public static int n, m;
	 	public static void main(String[] args) {
	 		Scanner sc= new Scanner(System.in);
	 		 boolean ok=true;
	 			do {
	 				System.out.println(" --------HAY CHON MENU-------- ");
	 				System.out.println(" 1.Nhap so luong hang  ");
	 				System.out.println(" 2.Tim kiem  ");
	 				System.out.println(" 3.Chen san pham  ");
	 				System.out.println(" 4.Xoa vi tri can xoa  ");
	 				System.out.println(" 5.Sap xep  ");
	 				System.out.println(" 6.Nhap so khach mua  ");
	 				System.out.println(" 7.Tinh tien  ");
	 				int chon =sc.nextInt();
	 				switch(chon){
	 				case 1:{ 
	 					System.out.println(" Nhap so luong mang thuc te");
	 	       n=sc.nextInt();
	 	      Banhang.nhapmang(n);
	 	      Banhang.hthi(n);
	 	      break;}
	 				case 2:{
	 	      System.out.println("Don gia cua mang hang can tim kiem la:"+Banhang.timkiem("vvv",n));
	 	      System.out.println("Don gia cua mang hang can tim kiem la:"+Banhang.timkiem("bbb",n));
	 	      break;}
	 				case 3:{
	 	      int vt; String mahg, tenhang; int soluonghang, dg;
	 	      System.out.println("Nhap vi tri can chen:");
	 	      vt=sc.nextInt();
	 	      sc.nextLine();
	 	      System.out.println("Nhap ma can chen:");
	 	      mahg=sc.nextLine();
	 	      System.out.println("Nhap ten hang can chen:");
	 	      tenhang=sc.nextLine();
	 	      System.out.println("Nhap so luong can chen:");
	 	      soluonghang=sc.nextInt();
	 	      System.out.println("Nhap don gia can chen:");
	 	      dg=sc.nextInt();
	 	      Banhang.chen( vt,n, mahg, tenhang, soluonghang, dg);
	 	      n++;
	 	      System.out.println("Mang sau khi chen la:");
	 	      Banhang.hthi(n);	
	 	      break;}
	 				case 4:{
	 					int vt; String mahg, tenhang; int soluonghang, dg;
	 				System.out.println(" Nhap vi tri can xoa");
	 				vt=sc.nextInt();
	 				sc.nextLine();
	 	      Banhang.xoa(n,vt); 
	 	      n--;
	 	      System.out.println("Mang xoa la: ");
	 	      Banhang.hthi(n);	
	 	      break;}
	 				case 5:{
	 					System.out.println(" Nhap vi tri can sap xep");
	 				n=sc.nextInt();
	 	      Banhang.sx(n);
	 	      System.out.println("Mang sau khi sap xep la:");
	 	      Banhang.hthi(n);
	 	      break;}
	 				case 6:{
	 	      System.out.println(" Nhap so luong thuc te cua mang khach ");
	 	      m=sc.nextInt();
	 	    hanghoa.nhapmang(m);
	 	   hanghoa.hthi(m);
	 	      break;}
	 				case 7:{
	 					hanghoa.tinhtien(n);
	 	      }
	 				default: {System.out.println("exit");ok=false;break; }
	 				}
	 	 			}      while(ok!=true);
	 	}
	 }