package model;
import java.util.Scanner;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class item {
	String date;
	String title;
	String author;
	content cont;
	
	public item() {
		
	}
	public item(String date,String title,content cont, String author)
	{
		this.date = date;
		this.title = title;
		this.cont = cont;
		this.author = author;	
	}
	public String getDate() {
		return date;
	}
	@XmlAttribute
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public	content getContent() {
		return cont;
	}
	@XmlElement
	public void setContent(content cont) {
		this.cont = cont;
	}
	
	public String getAuthor() {
		return author;
	}
	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}
	public String toString() {
		return "date :"+this.date +"\n"
				+ "title :" + this.title+"\n"
				+cont.toString()+"\n"
				+"author :"+this.author;
	}
	public item them() {
		content cn = new content();
		item Item = new item();
		Scanner sc = new Scanner(System.in);
		System.out.println("Date ");
		Item.date = sc.nextLine();
		System.out.println("title ");
		Item.title = sc.nextLine();
		Item.setContent( cn.them());
		System.out.println("author ");
		 Item.author = sc.nextLine();
		return Item;
	}
	
	
	

}
