package model;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
//đánh dấu
public class news {
	ArrayList<item> item = new ArrayList();
	public news() {
		item = new ArrayList();
	}
	public news(ArrayList<item> item) {
		this.item = item;
	}
	public ArrayList<item> getItem() {
		return item;
	}
	public void setItem(ArrayList<item> item) {
		this.item = item;
	}
	public void add(item Item) {
		item.add(Item);
	}
	
	public String toString() {
		String ans="";
		for(item Item:item) {
			ans = ans+ Item.toString()+"\n";
		}
		return ans;
	}
	public news sua(String date, item Item) {
		for(int i = 0; i < item.size(); i++) {
			if(date.equals(item.get(i).getDate())) {
				item.set(i, Item);
			}
		}
		return new news(item);
	}
	public news xoa(String date) {
		for(int i = 0; i < item.size(); i++) {
			if(date.equals(item.get(i).getDate())) {
				item.remove(i);
			}
		}
		return new news(item);
	}

}
