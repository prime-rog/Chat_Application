package Views;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UserView {
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	Login_View obj = new Login_View();
}	
}
