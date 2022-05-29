package Connect;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Quanlysinhvien {
	JFrame f2 = new JFrame("Quan ly sinh vien");
	JLabel lbmasv = new JLabel("Masv");
	JTextField tfmasv = new JTextField(20);
	JLabel lbten = new JLabel("Ten");
	JTextField tften = new JTextField(20);
	JLabel lblop = new JLabel("Lop");
	JTextField tflop = new JTextField(20);
	JLabel lbdiem = new JLabel("DiemTB");
	JTextField tfdiem = new JTextField(20);
	JButton btadd = new JButton ("Add");
	JButton btdelete = new JButton ("Delete");
	JButton btupdate = new JButton ("Update");
	JButton btfind = new JButton ("Find");
	
	JTable tbsv = new JTable();
	JScrollPane sp = new JScrollPane(tbsv);
	
	
	String Masv;
	String Ten;
	String Lop;
	Double DiemTB;
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	public Quanlysinhvien() {
		conn = new Connect().connect();
		jframecustomer();
		button();
	}
	public Quanlysinhvien(String Masv, String Ten, String Lop, Double DiemTB) {
		this.Masv = Masv;
		this.Ten = Ten;
		this.Lop = Lop;
		this.DiemTB = DiemTB;
	}
	public String getMasv() {
		return Masv;
	}
	public void setMasv(String masv) {
		Masv = masv;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public String getLop() {
		return Lop;
	}
	public void setLop(String lop) {
		Lop = lop;
	}
	public Double getDiemTB() {
		return DiemTB;
	}
	public void setDiemTB(Double diemTB) {
		DiemTB = diemTB;
	}
	public void jframecustomer() {
    	JPanel pnmasv = new JPanel();
    	pnmasv.add(lbmasv);
    	pnmasv.add(tfmasv);
		
    	lbmasv.setForeground(Color.BLUE);
    	pnmasv.setLayout(new GridLayout(1,2));
		
		JPanel pnname = new JPanel();
		pnname.add(lbten);
		pnname.add(tften);
		lbten.setForeground(Color.BLUE);
		pnname.setLayout(new GridLayout(1,2));
		
		JPanel pnlop = new JPanel();
		pnlop.add(lblop);
		pnlop.add(tflop);
		lblop.setForeground(Color.BLUE);
		pnlop.setLayout(new GridLayout(1,2));
		
		JPanel pndiem = new JPanel();
		pndiem.add(lbdiem);
		pndiem.add(tfdiem);
		lbdiem.setForeground(Color.BLUE);
		pndiem.setLayout(new GridLayout(1,2));
		
		
		
		JPanel pnbton = new JPanel();
		pnbton.add(btadd);
		pnbton.add(btupdate);
		pnbton.add(btdelete);
		pnbton.add(btfind);
		
		
		
		btfind.setBackground(Color.PINK);
		btupdate.setBackground(Color.PINK);
		
		btdelete.setBackground(Color.PINK);
		btadd.setBackground(Color.PINK);
		
		pnbton.setLayout(new GridLayout(1,4));
		
		JPanel pntable = new JPanel();
		sp.setPreferredSize(new Dimension(720, 500));
		Border bd = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder tbdcus= BorderFactory.createTitledBorder(bd, "Quan Ly sinh vien");
		pntable.setBorder(tbdcus);
		pntable.add(sp);
		pntable.setBackground(Color.WHITE);
		
		JPanel pnall = new JPanel();
		pnall.add(pnmasv);
		pnall.add(pnname);
		pnall.add(pnlop);
		pnall.add(pndiem);
		
		pnall.setLayout(new GridLayout(4,1));
		Border bdpnall = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder tbdpnall= BorderFactory.createTitledBorder(bdpnall, "");
		pnall.setBorder(tbdpnall);
		pnall.setBackground(Color.WHITE);
		
		f2.setLocation(100,20);
		
		Container cont2 =  f2.getContentPane();
		cont2.add(pnall,BorderLayout.WEST);
		cont2.add(pntable,BorderLayout.CENTER);
		cont2.add(pnbton, BorderLayout.SOUTH);
		
		f2.pack();
		f2.setSize(1200,600);
		f2.setVisible(true);
		Select();
    	
    }
	public void Select() {
		Connect cn = new Connect();
		rs=cn.listAll("Select * from quanlysinhvien");
		String column[] = {"Masv", "Ten","Lop","DiemTB"};	
	    DefaultTableModel tm = new DefaultTableModel (column, 0);
		try {
			while(rs.next()) {
				
		        Object data[]= {rs.getString("Masv"), rs.getString("Ten"), rs.getString("Lop"), rs.getDouble("DiemTB")};
		        tm.addRow(data);
			}
			tbsv.setModel(tm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Insert() {
		String sql = "INSERT INTO quanlysinhvien VALUES (?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,tfmasv.getText() );
			ps.setString(2,tften.getText() );
			ps.setString(3,tflop.getText() );
			ps.setString(4,tfdiem.getText());
			int record = ps.executeUpdate();
			if(record >0) {
				JOptionPane.showMessageDialog(null, "Insert Success");
			}else JOptionPane.showMessageDialog(null, "Insert Fail");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Update() {
		Connect cn = new Connect();
		if(tften.getText().length()!=0) {
			  int record = cn.executeDB("Update quanlysinhvien set Ten = '"+tften.getText()+"'"
						+ " where Masv = '"+tfmasv.getText()+"'");
			  if (record>0)  ;
			  else JOptionPane.showMessageDialog(null, "Update Ten was Fail");
		  }
		  if(tflop.getText().length()!=0) {
			  int record = cn.executeDB("Update quanlysinhvien set Lop = '"+tflop.getText()+"'"
						+ " where Masv = '"+tfmasv.getText()+"'");
			  if (record>0)  ;
			  else JOptionPane.showMessageDialog(null, "Update Lop was Fail");
		  }
		  if(tfdiem.getText().length()!=0) {
				  int record = cn.executeDB("Update quanlysinhvien set DiemTB = '"+tfdiem.getText()+"'"
							+ " where Masv = '"+tfmasv.getText()+"'");
				  if (record>0)  ;
				 else JOptionPane.showMessageDialog(null, "Update Diem trung binh was Fail");
		  }
		  
		
	}
	public void Find() {
		Connect cn = new Connect();
		rs=cn.listAll("Select * from quanlysinhvien where Masv = '"+tfmasv.getText()+"' or "
				+ "Ten = '"+tften.getText()+"' or Lop = '"+tflop.getText()+"'"
				+ "or DiemTB = '"+tfdiem.getText()+"'");
		String column[] = {"Masv", "Ten","Lop","DiemTB"};	
	    DefaultTableModel tm = new DefaultTableModel (column, 0);  
		try {
			while(rs.next()) {
				           
		        Object data[]= {rs.getString("Masv"), rs.getString("Ten"), rs.getString("Lop"), rs.getDouble("DiemTB")};
		        tm.addRow(data);
			}
			tbsv.setModel(tm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Delete() {
		Connect cn = new Connect();
		try {
			int record = cn.executeDB("Delete from quanlysinhvien where Masv = '"+tfmasv.getText()+"'");
			if (record>0) JOptionPane.showMessageDialog(null, "Delete Success");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void button() {
		btadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Insert();
				Select();
				new Quanlysinhvien();
				f2.dispose();
				
			}
		});
		btdelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				Delete();
				Select();
				new Quanlysinhvien();
				f2.dispose();
			}
		});
		btfind.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				Find();
				new Quanlysinhvien();
				f2.dispose();
			}
		});
		btupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				Update();
				Select();
				new Quanlysinhvien();
				f2.dispose();
			}
		});
	}

}
