package DAO;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Utils.Encryption;

public class Register {
	CommonDAO obj = new CommonDAO();

	public Register(String user, String passw) throws SQLException {
		Connection con = null;
		Statement stm = null;
		try {
			con = obj.createConnection();
			String sql = "INSERT INTO User Values('" + user + "' , '" + Encryption.passwordEncrypt(passw) + "')";
			stm = con.createStatement();
			int rs = stm.executeUpdate(sql);
			if (rs != 0)
				JOptionPane.showMessageDialog(null, "You are Registered");
		}
		catch(Exception e)
		{
			System.out.println("Error in Registration");
		}
//		finally {
//			stm.close();
//			con.close();
//		}
	}
}
