package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	
	public static String passwordEncrypt(String plainpassw)
	{
		String encrypted = null;
		try {
			MessageDigest obj = MessageDigest.getInstance("MD5");
			obj.update(plainpassw.getBytes());
			byte[]  encrypt = obj.digest();
			StringBuffer sb = new StringBuffer();
			for(byte b : encrypt)
			{
				sb.append(b);
			}
			encrypted = sb.toString();
//			System.out.println(encrypted);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encrypted;
		
	}
}
