package controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import model.news;
import view.menu;
import model.ReadwithStaxCursor;
import model.WritewithJaxb;
import model.content;
import model.item;



public class main {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException, JAXBException {
		Scanner sc = new Scanner(System.in);
		WritewithJaxb rwx = new WritewithJaxb();
		ReadwithStaxCursor rsc = new ReadwithStaxCursor();
		menu m= new menu();
		news news = rsc.read();
		item Item = new item();
		int choose;
		do {
			choose = m.Display();
			switch (choose){
				case 1:
					System.out.println(rsc.read());
					break;
				case 2: 
					news.add(Item.them());
					rwx.write(news);
					break;
				case 3:
					System.out.println("input date ");
					String date = sc.nextLine();
					System.out.println("input new news");
					Item = Item.them();
					news = news.sua(date, Item);
					rwx.write(news);
					break;
				case 4:
					System.out.println("input date delete ");
					String date2 = sc.nextLine();
					news = news.xoa(date2);
					rwx.write(news);
					break;
			}
			
		}while(choose!=5);
//		System.out.println(rsc.read());
//		 news.add(Item);
//		rwx.write(news);
		// TODO Auto-generated method stub
		//"12/12/1111","abc",new content("ghsfj","https://scontent.fdad1-1.fna.fbcdn.net/v/t39.30808-1/278136727_147455494440971_2886811556421653009_n.jpg?stp=dst-jpg_p200x200&_nc_cat=109&ccb=1-5&_nc_sid=7206a8&_nc_ohc=Q6qqRZUrWXQAX8x_DRC&_nc_ht=scontent.fdad1-1.fna&oh=00_AT-TnSY7E-hnhmvPOYkouLvmUzNzUIDwuNNBVtPOUS4Zzw&oe=6265B47A","fjk"),"Linh"

	}

}
