package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.awt.Font;

public class register extends JFrame {

	private JPanel contentPane;
	private JTextField textRName;
	private JTextField textRUsername;
	private JPasswordField RpasswordField;
	Connection conn=null;
	Statement stmt=null;
	 static final String DB_URL="jdbc:mysql://localhost/c67";
	  static final String driver="com.mysql.jdbc.Driver";
	  static final String USER="root";
	  static final String PASS="password";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1366,1366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(430, 105, 141, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(430, 215, 141, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(430, 317, 141, 28);
		contentPane.add(lblNewLabel_2);
		
		textRName = new JTextField();
		textRName.setBounds(778, 106, 133, 28);
		contentPane.add(textRName);
		textRName.setColumns(10);
		
		textRUsername = new JTextField();
		textRUsername.setBounds(778, 216, 133, 28);
		contentPane.add(textRUsername);
		textRUsername.setColumns(10);
		
		RpasswordField = new JPasswordField();
		RpasswordField.setBounds(778, 318, 133, 28);
		contentPane.add(RpasswordField);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="insert into Users(name,user_name,password)"+"values(?,?,?)";
					PreparedStatement pst1=conn.prepareStatement(query);
					pst1.setString(1,textRName.getText());
					pst1.setString(2,textRUsername.getText());
					pst1.setString(3,RpasswordField.getText());
					pst1.execute();
					login lg=new login();
					lg.setVisible(true);
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(572, 462, 117, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("REGISTER");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_3.setBounds(613, 41, 126, 28);
		contentPane.add(lblNewLabel_3);
	}
}
