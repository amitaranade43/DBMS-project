package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	public int loginstatus;
	Connection conn=null;
	Statement stmt=null;
	 static final String DB_URL="jdbc:mysql://localhost/c67";
	  static final String driver="com.mysql.jdbc.Driver";
	  static final String USER="root";
	  static final String PASS="password";
	  private JTextField textLUsername;
	  private JPasswordField LpasswordField;
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366,1366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(410, 129, 128, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(410, 252, 128, 31);
		contentPane.add(lblNewLabel_1);
		
		textLUsername = new JTextField();
		textLUsername.setBounds(767, 132, 114, 25);
		contentPane.add(textLUsername);
		textLUsername.setColumns(10);
		
		LpasswordField = new JPasswordField();
		LpasswordField.setBounds(767, 255, 114, 25);
		contentPane.add(LpasswordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Class.forName(driver);
					conn=DriverManager.getConnection(DB_URL,USER,PASS); 
					//stmt=conn.createStatement();
					//String query = "select * from Users "+ "where user_name=?";
					PreparedStatement pst=conn.prepareStatement("select * from Users "+ "where user_name=? and password=?");
					pst.setString(1,textLUsername.getText());
					pst.setString(2, LpasswordField.getText());
					ResultSet rs=pst.executeQuery();
					int count=0;
					while(rs.next())
				     {
						count++;
					 }
					if(count==1) 
					{
						PreparedStatement pst1=conn.prepareStatement("update Users set login_status=1 where user_name=? and password=?");
						loginstatus=1;
						 System.out.println(loginstatus);
						pst1.setString(1,textLUsername.getText());
						pst1.setString(2, LpasswordField.getText());
						pst1.executeUpdate();
						HomePage hp=new HomePage();
						hp.setVisible(true);
						setVisible(false);
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null,"DUplicate Password / Username");
						textUsername.setText("");
						textPassword.setText("");
						textUsername.requestFocus();	
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Wrong Password / Username");
						textUsername.setText("");
						textPassword.setText("");
						textUsername.requestFocus();
					}
					conn.close();
				}
				  catch(Exception e)
				  {
					  System.out.println(e);
				  }
			}
		});
		btnNewButton.setBounds(591, 420, 117, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_2.setBounds(614, 41, 170, 31);
		contentPane.add(lblNewLabel_2);
	}
}
