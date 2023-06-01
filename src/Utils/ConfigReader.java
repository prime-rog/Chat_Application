package Utils;

import java.util.ResourceBundle;

public class ConfigReader {
	ConfigReader(){}
	static ResourceBundle rb = ResourceBundle.getBundle("config");
	public static String getValue(String key)
	{
		return rb.getString(key);
	}
}
