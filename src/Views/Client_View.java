package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Network.Client;
import Utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Client_View extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JTextArea textArea ;
	private Client client ;
;	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void sendIt()
	{
		String message = textField.getText();
		System.out.println("message from JtextFeild");
		try {
			client.sendMessage(UserInfo.User_Name+" - "+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					try {
						Client_View frame = new Client_View();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public Client_View() throws UnknownHostException, IOException {
		textArea = new JTextArea();
		client = new Client(textArea);
		setTitle("Chat Screen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 750, 314);
		contentPane.add(scrollPane);
		
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
		textArea.setBounds(20, 35, 730, 271);
//		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("SansSerif", Font.PLAIN, 15));
		textField.setBounds(10, 344, 631, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		btnNewButton.setBounds(653, 348, 107, 36);
		contentPane.add(btnNewButton);
		this.setVisible(true);
		
	}
}
