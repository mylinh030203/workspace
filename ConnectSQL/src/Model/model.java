package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Connect.Connect;
import View.GiaoDien;

public class model {
	Connect cn = new Connect();
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	public model() {
		conn = new Connect().connect();
	}
	public DefaultTableModel Select() {
		
		rs=cn.listAll("Select * from quanlysinhvien");
		String column[] = {"Masv", "Ten","Lop","DiemTB"};	
	    DefaultTableModel tm = new DefaultTableModel (column, 0);
		try {
			while(rs.next()) {
				
		        Object data[]= {rs.getString("Masv"), rs.getString("Ten"), rs.getString("Lop"), rs.getDouble("DiemTB")};
		        tm.addRow(data);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tm;
		
	}
	public void Insert(String Masv, String Ten, String Lop, Double DiemTB) {
		String sql = "INSERT INTO quanlysinhvien VALUES (?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,Masv);
			ps.setString(2,Ten);
			ps.setString(3,Lop);
			ps.setDouble(4,DiemTB);
			int record = ps.executeUpdate();
			if(record >0) {
				JOptionPane.showMessageDialog(null, "Insert Success");
			}else JOptionPane.showMessageDialog(null, "Insert Fail");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Update(String Masv, String Ten, String Lop, Double DiemTB) {
		
		if(Ten.length()!=0) {
			  int record = cn.executeDB("Update quanlysinhvien set Ten = '"+Ten+"'"
						+ " where Masv = '"+Masv+"'");
			  if (record>0)  ;
			  else JOptionPane.showMessageDialog(null, "Update Ten was Fail");
		  }
		  if(Lop.length()!=0) {
			  int record = cn.executeDB("Update quanlysinhvien set Lop = '"+Lop+"'"
						+ " where Masv = '"+Masv+"'");
			  if (record>0)  ;
			  else JOptionPane.showMessageDialog(null, "Update Lop was Fail");
		  }
		  if(DiemTB>=0&&DiemTB<=10) {
				  int record = cn.executeDB("Update quanlysinhvien set DiemTB = '"+DiemTB+"'"
							+ " where Masv = '"+Masv+"'");
				  if (record>0)  ;
				 else JOptionPane.showMessageDialog(null, "Update Diem trung binh was Fail");
		  }
		  
		
	}
	public DefaultTableModel Find(String Masv, String Ten, String Lop, Double DiemTB) {
		
		rs=cn.listAll("Select * from quanlysinhvien where Masv = '"+Masv+"' or "
				+ "Ten = '"+Ten+"' or Lop = '"+Lop+"'"
				+ "or DiemTB = '"+DiemTB+"'");
		String column[] = {"Masv", "Ten","Lop","DiemTB"};	
	    DefaultTableModel tm = new DefaultTableModel (column, 0);  
		try {
			while(rs.next()) {
				System.out.println("gf");           
		        Object data[]= {rs.getString("Masv"), rs.getString("Ten"), rs.getString("Lop"), rs.getDouble("DiemTB")};
		        tm.addRow(data);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tm;
	}
	public void Delete(String Masv) {
		
		try {
			int record = cn.executeDB("Delete from quanlysinhvien where Masv = '"+Masv+"'");
			if (record>0) JOptionPane.showMessageDialog(null, "Delete Success");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
