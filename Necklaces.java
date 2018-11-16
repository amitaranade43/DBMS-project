package project;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class Necklaces extends JFrame {

	private JPanel contentPane;
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
					Necklaces frame = new Necklaces();
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
	public Necklaces() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1366,1366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNImg1 = new JLabel("New label");
		lblNImg1.setBounds(73, 24, 204, 196);
		Image img1=new ImageIcon(this.getClass().getResource("/necklace2001.jpg")).getImage();
		contentPane.setLayout(null);
		lblNImg1 .setIcon(new ImageIcon(img1));
		contentPane.add(lblNImg1);
		//product1
		final JButton btnNAC1 = new JButton("Add to Cart");
		btnNAC1.setBounds(398, 140, 117, 25);
		btnNAC1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select custid from Users where login_status=1";
					String query2="select * from Products where prod_id=1";
					PreparedStatement pst1=conn.prepareStatement(query);
					int c1=0;
					int c4=0;
					int c3=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,1);
					mystmt.execute();
					int cid=0;
					ResultSet rs=pst1.executeQuery();
					while(rs.next())
					{
						cid=rs.getInt(1);
					}
					System.out.println(cid);
					PreparedStatement pst2=conn.prepareStatement(query2);
					ResultSet rs1=pst2.executeQuery();
					while(rs1.next())
					{
						//int c1=rs1.getInt(1);//prodid
						c2=rs1.getString("p_name");
						System.out.println(c2);
						//String c2=rs1.getString(2);//p_name
						c3=rs1.getInt(3);//price
						System.out.println(c3);
						c4=rs1.getInt(4);//quantity
						System.out.println(c4);
					}
					String query1="insert into mycart(custid,prod_id,p_name,price,available_quantity)"+"values(?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query1);
					pst.setInt(1,cid);
					pst.setInt(2,1);
					pst.setString(3,c2);
					pst.setInt(4,c3);
					pst.setInt(5,c4);
					pst.execute();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				btnNAC1.setText("Added Successfully");
				//Cart c1=new Cart();
				//c1.setVisible(true);
				
			}
		});
		contentPane.add(btnNAC1);
		
		JLabel lblNewLabel = new JLabel("Price : Rs 650");
		lblNewLabel.setBounds(388, 94, 165, 25);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(51, 51, 51));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(77, 255, 200, 200);
		Image img2=new ImageIcon(this.getClass().getResource("/necklace2002.jpg")).getImage();
		lblNewLabel_1 .setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(77, 483, 200, 200);
		Image img3=new ImageIcon(this.getClass().getResource("/necklace2003.jpg")).getImage();
		lblNewLabel_2 .setIcon(new ImageIcon(img3));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(705, 24, 200, 200);
		Image img4=new ImageIcon(this.getClass().getResource("/necklace2004.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img4));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(705, 255, 200, 200);
		Image img5=new ImageIcon(this.getClass().getResource("/necklac2005.jpg")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img5));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Price : Rs 1000");
		lblNewLabel_5.setBounds(398, 312, 155, 33);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblNewLabel_5);
		//product2
		final JButton btnNewButton = new JButton("Add to Cart");
		btnNewButton.setBounds(398, 357, 117, 25);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select custid from Users where login_status=1";
					PreparedStatement pst1=conn.prepareStatement(query);
					String query2="select * from Products where prod_id=2";
					int cid=0;
					int c3=0;
					int c4=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,2);
					mystmt.execute();
					ResultSet rs=pst1.executeQuery();
					while(rs.next())
					{
						cid=rs.getInt(1);
					}
					System.out.println(cid);
					PreparedStatement pst2=conn.prepareStatement(query2);
					ResultSet rs1=pst2.executeQuery();
					while(rs1.next())
					{
						//c1=rs1.getInt(1);
					    c2=rs1.getString(2);
					    c3=rs1.getInt(3);
						c4=rs1.getInt(4);
					}
					String query1="insert into mycart(custid,prod_id,p_name,price,available_quantity)"+"values(?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query1);
					pst.setInt(1,cid);
					pst.setInt(2,2);
					pst.setString(3,c2);
					pst.setInt(4,c3);
					pst.setInt(5,c4);
					pst.execute();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				btnNewButton.setText("Added Successfully");
				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblPriceRs = new JLabel("Price : Rs 1500");
		lblPriceRs.setBounds(398, 520, 155, 33);
		lblPriceRs.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblPriceRs);
		//Product3
		final JButton button = new JButton("Add to Cart");
		button.setBounds(398, 571, 117, 25);
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select custid from Users where login_status=1";
					PreparedStatement pst1=conn.prepareStatement(query);
					String query2="select * from Products where prod_id=3";
					int cid=0;
					int c3=0;
					int c4=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,3);
					mystmt.execute();
					ResultSet rs=pst1.executeQuery();
					while(rs.next())
					{
						cid=rs.getInt(1);
					}
					System.out.println(cid);
					PreparedStatement pst2=conn.prepareStatement(query2);
					ResultSet rs1=pst2.executeQuery();
					while(rs1.next())
					{
						// c1=rs1.getInt(1);
					    c2=rs1.getString(2);
					    c3=rs1.getInt(3);
						c4=rs1.getInt(4);
					}
					String query1="insert into mycart(custid,prod_id,p_name,price,available_quantity)"+"values(?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query1);
					pst.setInt(1,cid);
					pst.setInt(2,3);
					pst.setString(3,c2);
					pst.setInt(4,c3);
					pst.setInt(5,c4);
					pst.execute();
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				button.setText("Added Successfully");
			}
		});
		contentPane.add(button);
		//Product4
		final JButton button_1 = new JButton("Add to Cart");
		button_1.setBounds(1010, 140, 117, 25);
		button_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select custid from Users where login_status=1";
					PreparedStatement pst1=conn.prepareStatement(query);
					String query2="select * from Products where prod_id=4";
					int cid=0;
					int c3=0;
					int c4=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,4);
					mystmt.execute();
					ResultSet rs=pst1.executeQuery();
					while(rs.next())
					{
						cid=rs.getInt(1);
					}
					System.out.println(cid);
					PreparedStatement pst2=conn.prepareStatement(query2);
					ResultSet rs1=pst2.executeQuery();
					while(rs1.next())
					{
						//c1=rs1.getInt(1);
						 c2=rs1.getString(2);
						 c3=rs1.getInt(3);
						 c4=rs1.getInt(4);
					}
					String query1="insert into mycart(custid,prod_id,p_name,price,available_quantity)"+"values(?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query1);
					pst.setInt(1,cid);
					pst.setInt(2,4);
					pst.setString(3,c2);
					pst.setInt(4,c3);
					pst.setInt(5,c4);
					pst.execute();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				button_1.setText("Added Successfully");
			}
		});
		contentPane.add(button_1);
		
		JLabel lblPriceRs_1 = new JLabel("Price : Rs 800");
		lblPriceRs_1.setBounds(1010, 94, 165, 25);
		lblPriceRs_1.setForeground(UIManager.getColor("Button.foreground"));
		lblPriceRs_1.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblPriceRs_1);
		
		JLabel lblPriceRs_2 = new JLabel("Price : Rs 900");
		lblPriceRs_2.setBounds(1010, 316, 165, 25);
		lblPriceRs_2.setForeground(UIManager.getColor("Button.foreground"));
		lblPriceRs_2.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblPriceRs_2);
		//Product 5
		final JButton button_2 = new JButton("Add to Cart");
		button_2.setBounds(1010, 357, 117, 25);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select custid from Users where login_status=1";
					PreparedStatement pst1=conn.prepareStatement(query);
					String query2="select * from Products where prod_id=5";
					int cid=0;
					int c3=0;
					int c4=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,5);
					mystmt.execute();
					ResultSet rs=pst1.executeQuery();
					while(rs.next())
					{
						cid=rs.getInt(1);
					}
					System.out.println(cid);
					PreparedStatement pst2=conn.prepareStatement(query2);
					ResultSet rs1=pst2.executeQuery();
					while(rs1.next())
					{
						//c1=rs1.getInt(1);
						 c2=rs1.getString(2);
						 c3=rs1.getInt(3);
						 c4=rs1.getInt(4);
					}
					String query1="insert into mycart(custid,prod_id,p_name,price,available_quantity)"+"values(?,?,?,?,?)";
					PreparedStatement pst=conn.prepareStatement(query1);
					pst.setInt(1,cid);
					pst.setInt(2,5);
					pst.setString(3,c2);
					pst.setInt(4,c3);
					pst.setInt(5,c4);
					pst.execute();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				button_2.setText("Added Successfully");
			}
		});
		contentPane.add(button_2);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCategories = new JMenu("Categories");
		mnCategories.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnCategories);
		
		JMenuItem mntmOther= new JMenuItem("Other Accessoris");
		mntmOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Other o1=new Other();
				o1.setVisible(true);
				
			}
		});
		mnCategories.add(mntmOther);
		
		JSeparator separator = new JSeparator();
		mnCategories.add(separator);
		
		JMenuItem mntmBracelets = new JMenuItem("Bracelets and Bangles");
		mntmBracelets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bracelets b1=new Bracelets();
				b1.setVisible(true);
				
			}
		});
		mnCategories.add(mntmBracelets);
		
		JSeparator separator_1 = new JSeparator();
		mnCategories.add(separator_1);
		
		JMenuItem mntmNecklaces = new JMenuItem("Necklaces");
		mntmNecklaces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Necklaces n1=new Necklaces();
				n1.setVisible(true);
				
			}
		});
		mnCategories.add(mntmNecklaces);
		
		JSeparator separator_2 = new JSeparator();
		mnCategories.add(separator_2);
		
		JMenuItem mntmEarrings = new JMenuItem("Earrings");
		mntmEarrings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Earrings e1=new Earrings();
				e1.setVisible(true);
				
			}
		});
		mnCategories.add(mntmEarrings);
		
		JSeparator separator_3 = new JSeparator();
		mnCategories.add(separator_3);
		
		JMenuItem mntmRings = new JMenuItem("Rings");
		mntmRings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rings r1=new Rings();
				r1.setVisible(true);
				
			}
		});
		mnCategories.add(mntmRings);
		
		JMenu mnMyCart = new JMenu("My Cart");
		mnMyCart.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnMyCart);
		
		JMenuItem mntmMyCart=new JMenuItem("Cart");
		mntmMyCart .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart c1=new Cart();
				c1.setVisible(true);
				
			}
		});
		mnMyCart.add(mntmMyCart);
		JMenu mnMyAccount = new JMenu("My Account");
		menuBar.add(mnMyAccount);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cp1=new ChangePassword();
				cp1.setVisible(true);
				
			}
		});
		mnMyAccount.add(mntmChangePassword);
		JMenu mnLogout = new JMenu("Logout");
		mnLogout.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mnLogout);
		JMenuItem mntmlogout=new JMenuItem("Logout");
		mntmlogout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="update Users set login_status=0 where login_status=1";
					Statement pst=conn.createStatement();
					pst.execute(query);
					String query1="delete from mycart";
					Statement stmt=conn.createStatement();
					stmt.execute(query1);
					login l1=new login();
					l1.setVisible(true);
				} catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		mnLogout.add(mntmlogout);
		getContentPane().setLayout(null);
		
		
	}
}
