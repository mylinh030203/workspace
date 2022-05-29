package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

public class qlsv {
	public static void main(String[] agrs) {
		ArrayList<SinhVien> dssv = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int c;
		do {
			System.out.println("<-----Menu----->");
			System.out.println("1-Tao danh sach");
			System.out.println("2-Tim kiem va sap xep");
			System.out.println("3-Sua hoac xoa");
			System.out.println("4-Bao cao");
			System.out.println("5-Thoat");
			c = sc.nextInt();
			sc.nextLine();
			switch (c) {
			case 1: {
				System.out.println("nhap ds sinh vien");
				for (int i = 1; i <= 3; i++) {
					SinhVien sv = new SinhVien();
					sv.nhap();
					dssv.add(sv);
				}
				for (SinhVien sv : dssv) {
					System.out.println(sv.toString());
				}
				String a;
				do {
					System.out.println("Ban co muon them sinh vien Y/N");
					a = sc.nextLine();
					if (a.equals("Y") || a.equals("y")) {
						SinhVien sv = new SinhVien();
						sv.nhap();
						dssv.add(dssv.size(), sv);
					} else {
						break;
					}
				} while (a.equals("Y") || a.equals("y"));
				for (SinhVien sv : dssv) {
					System.out.println(sv.toString());
				}
				break;
			}
			case 2: {
				System.out.println("sap xep va tim kiem");
				dssv.sort(new Comparator<SinhVien>() {
					@Override
					public int compare(SinhVien o1, SinhVien o2) {
						// TODO Auto-generated method stub
						String ten1 = o1.getTen();
						String ten2 = o2.getTen();
						return (int) (ten1.compareTo(ten2));
					}

				});
				for (SinhVien sv : dssv) {
					System.out.println(sv.toString());
				}
				String name = sc.nextLine();
				for (SinhVien sv : dssv) {
					if (sv.getTen().contains(name))
						System.out.println(sv.toString());

				}

				break;
			}

			case 3: {
				System.out.println("Ban muon xoa(D) hay sua(U)");
				String a;
				a = sc.nextLine();
				if (a.equals("D") || a.equals("d")) {
					System.out.println("xoa sv co masv la: ");
					int m = sc.nextInt();
					sc.nextLine();
					dssv.remove(m - 1);
					for (SinhVien sv : dssv) {
						System.out.println(sv.toString());
					}
				}

				if (a.equals("U") || a.equals("u")) {
					System.out.println("Ban muon sua ten(1) hay Hoc ky(2) hay Khoa hoc(3)");
					int b = sc.nextInt();
					sc.nextLine();
					switch (b) {
					case 1: {
						System.out.println("sua sv co masv la: ");
						int s = sc.nextInt();
						sc.nextLine();
						System.out.println("nhap ten sv");
						String ten = sc.nextLine();

						for (int i = 0; i < dssv.size(); i++) {
							SinhVien sv = dssv.get(i);
							if ((s) == sv.getMsv()) {
								sv = dssv.get(s - 1);
								sv.setTen(ten);
								dssv.set((s - 1), sv);
								for (SinhVien sv1 : dssv) {
									System.out.println(sv1.toString());
								}
							}

						}

						break;
					}
					case 2: {
						System.out.println("sua sv co masv la: ");
						int s = sc.nextInt();
						sc.nextLine();
						System.out.println("nhap hoc ky dang hoc cua sv");
						String Hocky = sc.nextLine();

						for (int i = 0; i < dssv.size(); i++) {
							SinhVien sv = dssv.get(i);
							if ((s) == sv.getMsv()) {
								sv = dssv.get(s - 1);
								sv.setHocky(Hocky);
								dssv.set((s - 1), sv);
								for (SinhVien sv1 : dssv) {
									System.out.println(sv1.toString());
								}
							}

						}
						break;

					}
					case 3: {
						System.out.println("sua sv co masv la: ");
						int s = sc.nextInt();
						sc.nextLine();
						System.out.println("nhap hoc ky dang hoc cua sv");
						String Khoahoc = sc.nextLine();

						for (int i = 0; i < dssv.size(); i++) {
							SinhVien sv = dssv.get(i);
							if ((s) == sv.getMsv()) {
								sv = dssv.get(s - 1);
								sv.setKhoahoc(Khoahoc);
								dssv.set((s - 1), sv);
								for (SinhVien sv1 : dssv) {
									System.out.println(sv1.toString());
								}
							}

						}

						break;
					}

					}

				}

				break;

			}
			case 4: {
				ArrayList<String> s=new ArrayList<>();
				for(int i=0; i<dssv.size(); i++) {
					SinhVien sv = dssv.get(i);
					s.add(sv.getTen()+"\t|"+sv.getKhoahoc());
				}
				s.sort(new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {			
						return (int) (o1.compareTo(o2));
					}
					
				});
				int dem=1;
				for(int i=1; i<s.size();i++) {
					if(s.get(i).equals(s.get(i-1)))
						dem++;
					else {
						System.out.println(s.get(i-1)+"\t|"+dem);
						dem=1;
					}
						
				}
				System.out.println(s.get(s.size()-1)+"\t|"+dem);
				
				

			}

			}
		} while (c != 5);

	}

}
