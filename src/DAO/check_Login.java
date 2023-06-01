package DAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Utils.Encryption;
import Utils.UserInfo;
import Views.DashBoard;
import Views.Login_View;

public class check_Login {

	CommonDAO obj = new CommonDAO();

	public check_Login(String user, String passw , JFrame fm) throws SQLException {
		Connection con = null;
		Statement stm = null;
		String encrypt = Encryption.passwordEncrypt(passw);
		try {
			 con = obj.createConnection();
			String sql = "select * from User where username ='" + user + "' and password='" + encrypt + "' ";
			 stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				UserInfo.User_Name = user;
				JOptionPane.showMessageDialog(null , "Welcome "+ user);
				DashBoard dash  = new DashBoard("Welocme " + user);
				dash.setVisible(true);
				fm.dispose();
				
			} else {
				JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally
//		{
//			stm.close();
//			con.close();
//		}
	}
}
