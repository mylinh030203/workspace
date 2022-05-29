package vonglap;

import java.util.Scanner;

class hanghoa {
	public static int soluong[];
    public static String mh[];
    public static int soban[];
    public static String tennguoinhan[];
    public static String makh[];
    public static int thanhtien[];
    
    public static void nhapmang(int n)
   {int i;
      Scanner sc = new Scanner(System.in);
      soluong=new int[100];
      thanhtien=new int[100];
      mh=new String[100];
      soban=new int[30];
      makh=new String[100];
      tennguoinhan=new String[100];
     
     for(i=0;i<n;i++)
   { System.out.println("......Nhap ma khach hang...... ");
      makh[i]=sc.nextLine();
     System.out.println(" Nhap ho ten nguoi nhan: ");
      tennguoinhan[i]=sc.nextLine();
     System.out.println(" Nhap ma can mua: ");
      mh[i]=sc.nextLine();
     System.out.println(" Nhap so luong can mua: ");
      soluong[i]=sc.nextInt();
     System.out.println(" Nhap so ban ma khach goi: ");
      soban[i]=sc.nextInt();
      sc.nextLine();
     System.out.println("<<___________________________>>");
     
   }
}

    public static void hthi(int n)
   {int i;
    for(i=0;i<n;i++)
   { System.out.println("     Nhap ho ten nguoi nhan: "+tennguoinhan[i]);
     System.out.println("     Nhap ma hang: "+mh[i]);
     System.out.println("     Nhap so luong mua: "+soluong[i]);
     System.out.println("     Nhap so ban khach hang goi: "+soban[i]);
     System.out.println(" ----------------------------------- ");}
   }
   public static void tinhtien(int n) {
	for(int i=0;i<n;i++)
	   {thanhtien[i]=Banhang.timkiem(mh[i],n)*soluong[i];
	   System.out.println("Tong tien ma "+tennguoinhan[i]+" can phai tra la: "+thanhtien[i] );
	   System.out.println("");}
	   }
}




 
