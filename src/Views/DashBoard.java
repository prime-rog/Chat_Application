package Views;

import java.awt.*;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class DashBoard extends JFrame {
	
	JLabel timage;
	Container c ;
	public DashBoard(String S) {
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("DAHSBOARD");
		getContentPane().setLayout(null);
		this.setResizable(true);
		this.getContentPane().setBackground(Color.WHITE);
		c = new Container();
		c = this.getContentPane();
		timage = new JLabel();
		try
		{
			timage.setIcon(new ImageIcon(getClass().getResource("chi2.png")));
		}
		catch (Exception e)
		{
			System.out.println("Image not found");
		}
		timage.setBounds(400,10,400,400);
		
		
		
		
		c.add(timage);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO OUR CHAT ROOM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(226, 388, 610, 53);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("JOIN OUR CHAT ROOM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Client_View();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(283, 521, 494, 85);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("This Chat Room Was Created By Aman Singh");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 21));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(175, 680, 710, 36);
		getContentPane().add(lblNewLabel_1);
		
		
		
		setVisible(true);
		
	}
}
