package View;
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

import Controller.Quanlysinhvien;

public class GiaoDien extends JFrame {
	public JFrame f2;
	public JTextField tfmasv;
	public JTextField tften;
	public JTextField tflop;
	public JTextField tfdiem;
	public JButton btadd;
	public JButton btdelete;
	public JButton btupdate;
	public JButton btfind;
	public JTable tbsv;
	public JScrollPane sp;
	
	
	public GiaoDien() {
		frame();
	}
	
	public JTextField getTfmasv() {
		return tfmasv;
	}

	public void setTfmasv(JTextField tfmasv) {
		this.tfmasv = tfmasv;
	}

	public JTextField getTften() {
		return tften;
	}

	public void setTften(JTextField tften) {
		this.tften = tften;
	}

	public JTextField getTflop() {
		return tflop;
	}

	public void setTflop(JTextField tflop) {
		this.tflop = tflop;
	}

	public JTextField getTfdiem() {
		return tfdiem;
	}

	public void setTfdiem(JTextField tfdiem) {
		this.tfdiem = tfdiem;
	}

	public JButton getBtadd() {
		return btadd;
	}

	public void setBtadd(JButton btadd) {
		this.btadd = btadd;
	}

	public JButton getBtdelete() {
		return btdelete;
	}

	public void setBtdelete(JButton btdelete) {
		this.btdelete = btdelete;
	}

	public JButton getBtupdate() {
		return btupdate;
	}

	public void setBtupdate(JButton btupdate) {
		this.btupdate = btupdate;
	}

	public JButton getBtfind() {
		return btfind;
	}

	public void setBtfind(JButton btfind) {
		this.btfind = btfind;
	}

	public JTable getTbsv() {
		return tbsv;
	}

	public void setTbsv(JTable tbsv) {
		this.tbsv = tbsv;
	}

	public JScrollPane getSp() {
		return sp;
	}

	public void setSp(JScrollPane sp) {
		this.sp = sp;
	}
	
	public void frame() {
		f2 = new JFrame("Quan ly sinh vien");
		JLabel lbmasv = new JLabel("Masv");
		JLabel lbten = new JLabel("Ten");
		JLabel lblop = new JLabel("Lop");
		JLabel lbdiem = new JLabel("DiemTB");
		tfmasv = new JTextField(20);
		tften = new JTextField(20);
		tflop = new JTextField(20);
		tfdiem = new JTextField(20);
		btadd = new JButton ("Add");
		btdelete = new JButton ("Delete");
		btupdate = new JButton ("Update");
		btfind = new JButton ("Find");
		tbsv = new JTable();
		sp = new JScrollPane(tbsv);
		
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
		
    	
    }
	public void clear() {
		tfdiem.setText("");
		tflop.setText("");
		tfmasv.setText("");
		tften.setText("");
	}
	public static void main(String[] args) {
		new GiaoDien();
	}

	
	}
	

