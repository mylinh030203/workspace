package model;


import java.util.Scanner;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class content {
	String description;
	String image;
	String link;
	public content() {
		
	}
	public content(String description,String image,String link) {
		this.description = description;
		this.image = image;
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	@XmlElement
	public void setImage(String image) {
		this.image = image;
	}
	public String getLink() {
		return link;
	}
	@XmlElement
	public void setLink(String link) {
		this.link = link;
	}
	public String toString() {
		return "content \n"
				+"description :"+this.description+"\n"
				+"image :"+this.image+"\n"
				+"link :"+this.link+"\n";
	}
	public content them() {
		content cont = new content();
		Scanner sc = new Scanner(System.in);
		System.out.println("description ");
		cont.description = sc.nextLine();
		System.out.println("image ");
		cont.image = sc.nextLine();
		System.out.println("link");
		cont.link = sc.nextLine();
		return cont;
	}
}
