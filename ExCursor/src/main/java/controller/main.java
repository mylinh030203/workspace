package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;

import model.ReadXMLExample;
import model.WriteXmlStAXCursor;

//import model.readwritexml;
import model.student;
import model.studentList;
import view.menu;

public class main {

	public static void main(String[] args) throws JAXBException, FileNotFoundException, XMLStreamException {
		Scanner sc = new Scanner(System.in);
		ReadXMLExample RXE = new ReadXMLExample();
		WriteXmlStAXCursor wxsc = new WriteXmlStAXCursor();
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
					wxsc.writeXml(stlist);
					break;
				case 3:
					System.out.println("nhap id cua sinh vien can sua ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("nhap thong tin moi ");
					st = st.them();
					stlist = stlist.sua(id, st);
					wxsc.writeXml(stlist);
					break;
				case 4:
					System.out.println("nhap id cua sinh vien can xoa ");
					int id2 = sc.nextInt();
					sc.nextLine();
					stlist = stlist.xoa(id2);
					wxsc.writeXml(stlist);
					break;
			}
			
		}while(choose!=5);
		
	}

}
