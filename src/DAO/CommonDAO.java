package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import static Utils.ConfigReader.getValue;
public class CommonDAO {
	public Connection createConnection()
	{
		try {
//			String driver = ConfigReader.getValue("DRIVER");
//			String ur_l = ConfigReader.getValue("CONNECTION_URL");
//			String user_n = ConfigReader.getValue("USER_ID");
//			String pass = ConfigReader.getValue("PASSWORD");
//		Class.forName(driver);
//		final String url = ur_l;
//		final String User_id = user_n;
//		final String password = pass;
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String url = "jdbc:mysql://localhost:3306/chat_application";
		final String User_id = "root";
		final String password = "root";
		Connection con = DriverManager.getConnection(url , User_id , password);
		if(con!=null)
		{
			System.out.println("Connection Created .........");
//			con.close();
		}
		return con;
		}
		catch(Exception e)
		{
			System.out.println("Fail.............");
		}
		return null;
	}
}
