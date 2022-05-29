package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class studentList {
	ArrayList<student> stlist = new ArrayList();
	public studentList() {
		stlist = new ArrayList();
	}
	public studentList(ArrayList<student> stlist) {
		this.stlist = stlist;
	}
	public ArrayList<student> getStlist() {
		return stlist;
	}
	public void setStlist(ArrayList<student> stlist) {
		this.stlist = stlist;
	}
	public void add(student st) {
		stlist.add(st);
	}
	public String toString() {
		String ans="";
		for(student st:stlist) {
			ans = ans+st.toString()+"\n";
		}
		return ans;
	}
	public studentList sua(int id, student st) {
		for(int i = 0; i < stlist.size(); i++) {
			if(id == stlist.get(i).getId()) {
				stlist.set(i, st);
			}
		}
		return new studentList(stlist);
	}
	public studentList xoa(int id) {
		for(int i = 0; i < stlist.size(); i++) {
			if(id == stlist.get(i).getId()) {
				stlist.remove(i);
			}
		}
		return new studentList(stlist);
	}

}
