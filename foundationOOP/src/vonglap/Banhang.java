package vonglap;

import java.util.Scanner;

public class Banhang {
	public static int soluonghang[];
    public static String tenhang[];
    public static String tenkh[];
    public static String mahg[];
    public static int dg[];
    
    public static void nhapmang(int n)
    {int i;
     Scanner sc = new Scanner(System.in);
     soluonghang=new int[100];
     tenhang=new String[100];
     mahg=new String[100];
     dg=new int[100];
     
     for(i=0;i<n;i++)
     {System.out.println(" Ma san pham:");
      mahg[i]=sc.nextLine();
     System.out.println("Ten san pham:");
      tenhang[i]=sc.nextLine();
     System.out.println("Don gia:");
      dg[i]=sc.nextInt();
     System.out.println("So luong hang:");
      soluonghang[i]=sc.nextInt();
     System.out.println("***********");
     sc.nextLine();
    }
}

   public static void hthi(int n)
   {int i;
    for(i=0;i<n;i++)
   { System.out.println(" ..........Ma hang la:" +mahg[i] );
     System.out.println(" ..........Ten hang la:" +tenhang[i] );
     System.out.println(" ..........Don gia la:" +dg[i] );
     System.out.println(" ......... So luong mua la: " +soluonghang[i] );
     System.out.println(" -------------------------------------- " );}
   }
   
   public static void chen(int n, int vt, String mmahg, String mtenh, int msl, int mdg)
   {int i;
    for(i=n;i>vt;i--)
       {mahg[i]=mahg[i-1]; tenhang[i]=tenhang[i-1]; soluonghang[i]=soluonghang[i-1]; dg[i]=dg[i-1];}
        mahg[i]=mmahg; tenhang[i]=mtenh; soluonghang[i]=msl; dg[i]=mdg;
   }
   public static void xoa(int n, int vt)
   {int i;
    for(i=vt;i<n;i++)
       {mahg[i]=mahg[i+1]; tenhang[i]=tenhang[i+1]; soluonghang[i]=soluonghang[i+1]; dg[i]=dg[i+1];}
   }
   public static void sx(int n)
   {int i, j, tg3, tg4; String tg1, tg2; 
    for(i=0;i<n;i++)
	for(j=0;j<n;j++)
       if(mahg[i].compareTo (mahg[i])>0)
	   {
    	tg1=mahg[i]; mahg[i]=mahg[j]; mahg[j]=tg1;
	    tg2=tenhang[i]; tenhang[i]=tenhang[j];tenhang[j]=tg2;
		tg3=soluonghang[i]; soluonghang[i]=soluonghang[j]; soluonghang[j]=tg3;
	    tg4=dg[i]; dg[i]=dg[j]; dg[j]=tg4;
	   }
   }
   
   public static int timkiem(String mmahang, int n)
   {int i;
	for(i=0;i<n;i++)
	   {if(mahg[i].equals(mmahang)==true) break;}
    if(i<n) return (dg[i]);
    else return 0;
   }
   
}