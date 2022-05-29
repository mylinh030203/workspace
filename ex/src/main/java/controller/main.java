package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import model.ReadXMLExample;
import model.WriteXmlStAXIterator;
import model.student;
import model.studentList;
import view.menu;





public class main {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException  {
		Scanner sc = new Scanner(System.in);
		ReadXMLExample RXE = new ReadXMLExample();
		WriteXmlStAXIterator wxsi = new WriteXmlStAXIterator();
		studentList stlist = RXE.read();
		student st = new student();
		menu m= new menu();
		
		int choose;
		do {
			choose = m.Display();
			switch (choose){
				case 1:
					System.out.println(RXE.read());
					break;
				case 2: 
					stlist.add(st.them());
					wxsi.writeXml2(stlist);
					break;
				case 3:
					System.out.println("nhap id cua sinh vien can sua ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("nhap thong tin moi ");
					st = st.them();
					stlist = stlist.sua(id, st);
					wxsi.writeXml2(stlist);
					break;
				case 4:
					System.out.println("nhap id cua sinh vien can xoa ");
					int id2 = sc.nextInt();
					sc.nextLine();
					stlist = stlist.xoa(id2);
					wxsi.writeXml2(stlist);
					break;
			}
			
		}while(choose!=5);
		
	}

}
