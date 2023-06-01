package Views;
import javax.swing.*;

import DAO.Register;
import DAO.check_Login;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class Login_View extends JFrame implements ActionListener {
	JLabel Username;
	JLabel Password;
	JLabel Title;
	JTextField t1;
	JPasswordField p1;
	final JButton submit ;
	JLabel message;
	JLabel label;
	JLabel dm;
	JLabel link;
	final JButton register;
	
	Container c;
	public Login_View()
	{
		this.setSize(400,450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("LOGIN");
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.WHITE);
		Font obj = new Font("Arial" , Font.PLAIN , 14);
		label = new JLabel();
		message = new JLabel();
		Username = new JLabel();
		Password = new JLabel();
		link = new JLabel();
		submit = new JButton("Login");
		dm = new JLabel("Login Using:");
		dm.setFont(obj);
		
		c = new Container();
		c = this.getContentPane();
		Username.setText("Username:");
		Password.setText("Password:");
		Username.setFont(obj);
		Password.setFont(obj);
		Username.setBounds(50,130,70,20);
		Password.setBounds(50,170,70,20);
		submit.setBounds(60,220,100,25);
		dm.setBounds(140 , 260, 100, 25);
		
		t1 = new JTextField();
		t1.setBounds(170,130,150,28);
		p1 = new JPasswordField();
		p1.setBounds(170,170,150,28);
		submit.setBackground(Color.WHITE);
		try {
		label.setIcon(new ImageIcon(getClass().getResource("log.png")));
		}
		catch (Exception e)
		{
			System.out.println("Image not found");
		}
		try {
			message.setIcon(new ImageIcon(getClass().getResource("logo.png")));
			}
			catch (Exception e)
			{
				System.out.println("Image not found");
			}
		try {
			link.setIcon(new ImageIcon(getClass().getResource("logg.png")));
			}
			catch (Exception e)
			{
				System.out.println("Image not found");
			}
		Dimension size = label.getPreferredSize();
		label.setBounds(50,20,300,100);
		Dimension size1 = message.getPreferredSize();
		message.setBounds(140,260,300,100);
		Dimension size2 = message.getPreferredSize();
		link.setBounds(190,257,300,100);
		 register = new JButton("Register");
		register.setBounds(200 , 220 , 100 , 25);
		register.setBackground(Color.WHITE);
		JLabel sign = new JLabel("Don't Have An Account? Sign Up Here!!!");
		sign.setFont(obj);
		sign.setBounds(60 , 310 , 300, 100);
		JLabel md = new JLabel("Enter Your Credentials and Click on Register");
		md.setBounds(50, 340 , 400, 100);
		md.setFont(obj);
		register.addActionListener((ActionListener)this);
		submit.addActionListener((ActionListener) this);
		
		
		
		c.add(t1);
		c.add(p1);
		c.add(Username);
		c.add(Password);
		c.add(submit);
		c.add(label);
		c.add(message);
		c.add(dm);
		c.add(link);
		c.add(sign);
		c.add(register);
		c.add(md);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String user = t1.getText();
		char[] pass = p1.getPassword();
		String passw = "";
		for(char i : pass)
		{
			passw = passw+i;
		}
		if(e.getSource()==register)
		{
			try {
				new Register(user , passw);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource()==submit)
		{
			try {
				new check_Login(user, passw , this);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		
	}
	

}
