package project;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class project 
{

	private JFrame frame;
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
					project window = new project();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public project()
	{
		//initialize();
		try
		{
			Class.forName(driver);
			conn=DriverManager.getConnection(DB_URL,USER,PASS); 
			initialize();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1366,1366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
		    final Image backgroundImage = javax.imageio.ImageIO.read(new File("/home/ccoew/Downloads/bgmain.resized.jpg"));
		    frame.setContentPane(new JPanel(new BorderLayout()) {
		        @Override public void paintComponent(Graphics g) {
		            g.drawImage(backgroundImage, 0, 0, null);
		        }
		    });
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to The Velvet Box");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		//lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(498, 26, 361, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Here?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		//lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(618, 109, 160, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				register reg=new register();
				reg.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(593, 218, 140, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Else");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 15));
		
		lblNewLabel_2.setBounds(636, 337, 160, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				login lg=new login();
				lg.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(593, 443, 140, 33);
		frame.getContentPane().add(btnNewButton_1);
	}

		
	
}
