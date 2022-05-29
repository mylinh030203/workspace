package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import Model.model;
import View.GiaoDien;

public class Quanlysinhvien {
	 
	public Quanlysinhvien() {
		GiaoDien GD = new GiaoDien();
		model MD = new model();
		DefaultTableModel tm = MD.Select();
		GD.tbsv.setModel(tm);
		button(GD,MD);
	}
	
	public void button(GiaoDien GD, model MD) {
		
		
		DefaultTableModel tm = MD.Select();
		GD.btadd.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				String Masv = GD.tfmasv.getText();
				String Ten = GD.tften.getText();
				String Lop = GD.tflop.getText();
				Double DiemTB = Double.parseDouble(GD.tfdiem.getText());
				System.out.println("hello");
				
				MD.Insert(Masv, Ten, Lop, DiemTB);
				DefaultTableModel tm = MD.Select();
				GD.tbsv.setModel(tm);
				GD.clear();
				
				
			}
		});
		GD.btdelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String Masv = GD.tfmasv.getText();
				
				MD.Delete(Masv);
				DefaultTableModel tm = MD.Select();
				GD.tbsv.setModel(tm);
				GD.clear();
			}
		});
		GD.btfind.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String Masv = GD.tfmasv.getText();
				String Ten = GD.tften.getText();
				String Lop = GD.tflop.getText();
				Double DiemTB = -1.0;
				if(GD.tfdiem.getText().length()>0)
					DiemTB=Double.parseDouble(GD.tfdiem.getText());
				DefaultTableModel tm = MD.Find(Masv, Ten, Lop, DiemTB);
				GD.tbsv.setModel(tm);
				GD.clear();
			}
		});
		GD.btupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String Masv = GD.tfmasv.getText();
				String Ten = GD.tften.getText();
				String Lop = GD.tflop.getText();
				
				Double DiemTB = -1.0;
				if(GD.tfdiem.getText().length()>0)
					DiemTB=Double.parseDouble(GD.tfdiem.getText());
				MD.Update(Masv, Ten, Lop, DiemTB);
				DefaultTableModel tm = MD.Select();
				GD.tbsv.setModel(tm);
				GD.clear();
			}
		});
	}
	public static void main(String[] args) {
		//new GiaoDien();
		new Quanlysinhvien();
	}


}
