package iostream;

import javax.swing.JFrame;
import javax.tools.JavaFileManager.Location;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

public class EX4 extends JFrame{
	protected static final String OldContent = null;
	public EX4() {
		jframe();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EX4 e = new EX4();
	}
	public void jframe() {
		JFrame f = new JFrame();
		JLabel lb = new JLabel();
		JButton btopen = new JButton("Open");
		JButton btsave = new JButton("Save As");
		JTextArea jta = new JTextArea();
		JScrollPane jsc = new JScrollPane(jta);
		jsc.setPreferredSize(new Dimension(600, 400));
		f.setLocation(20,30);
		//f.setLayout(new GridLayout(2,2));
		Container cont = f.getContentPane();
		JPanel pn1 = new JPanel();
		pn1.add(jsc);
		JPanel pn2 = new JPanel();
		pn2.add(btopen);
		pn2.add(btsave);
		pn2.setLayout(new GridLayout(1,2));
		cont.add(pn1, BorderLayout.NORTH);
		cont.add(pn2, BorderLayout.SOUTH);
	
		f.setSize(700,500);
		f.setVisible(true);
		btopen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
		        int returnVal = chooser.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		            System.out.println(chooser.getSelectedFile());
		        }
		        String s="";
		        try {
		        FileInputStream b = new FileInputStream(chooser.getSelectedFile());
				int i = 0;
				while((i = b.read())!=-1) {
					//System.out.print((char)i);
					s=s+(char)i;
				}
				jta.setText(s);
		        }catch(Exception t) {
		        	System.out.println(t);
		        }
				
			}
		});
		btsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = JOptionPane.showInputDialog("Nhap vao ten file moi");
				
				File fileOut = new File(s);
		        FileWriter Filewriter;
				try {
					Filewriter = new FileWriter(fileOut, StandardCharsets.UTF_8);
					BufferedWriter bufferedWriter = new BufferedWriter(Filewriter);
					bufferedWriter.write(jta.getText());
					bufferedWriter.close();
					
				} catch (Exception h) {
					// TODO Auto-generated catch block
					h.printStackTrace();
				}
			}
		});
		
	}

}
