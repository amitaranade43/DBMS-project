package project;

import java.awt.BorderLayout;
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
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Other extends JFrame {

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
					Other frame = new Other();
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
	public Other() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366,1366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//CallableStatement cstmt=null;
		/*try {
			String proc="{call set_quantity(?)}";
			cstmt=conn.prepareCall(proc);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(103, 50, 200,200);
		Image img1=new ImageIcon(this.getClass().getResource("/other2001.resized.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(103, 287,200,200);
		Image img2=new ImageIcon(this.getClass().getResource("/other2002.resized.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(103, 518, 200,200);
		Image img3=new ImageIcon(this.getClass().getResource("/other2003.resized.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(786, 50, 200,200);
		Image img4=new ImageIcon(this.getClass().getResource("/other2004.resized.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img4));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(786, 367,200,200);
		Image img5=new ImageIcon(this.getClass().getResource("/other2005.resized.jpg")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img5));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblPriceRs_2 = new JLabel("Price : Rs 300");
		lblPriceRs_2.setForeground(UIManager.getColor("Button.foreground"));
		lblPriceRs_2.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPriceRs_2.setBounds(433, 102, 165, 25);
		contentPane.add(lblPriceRs_2);
		
		JLabel lblPriceRs_3 = new JLabel("Price : Rs 200");
		lblPriceRs_3.setForeground(UIManager.getColor("Button.foreground"));
		lblPriceRs_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPriceRs_3.setBounds(433, 333, 165, 25);
		contentPane.add(lblPriceRs_3);
		
		JLabel lblPriceRs_4 = new JLabel("Price : Rs 450");
		lblPriceRs_4.setForeground(UIManager.getColor("Button.foreground"));
		lblPriceRs_4.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPriceRs_4.setBounds(433, 556, 165, 25);
		contentPane.add(lblPriceRs_4);
		
		JLabel lblPriceRs_1 = new JLabel("Price : Rs 700");
		lblPriceRs_1.setForeground(UIManager.getColor("Button.foreground"));
		lblPriceRs_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPriceRs_1.setBounds(1147, 102, 165, 25);
		contentPane.add(lblPriceRs_1);
		
		JLabel lblPriceRs = new JLabel("Price : Rs 500");
		lblPriceRs.setForeground(UIManager.getColor("Button.foreground"));
		lblPriceRs.setFont(new Font("Dialog", Font.BOLD, 17));
		lblPriceRs.setBounds(1147, 420, 165, 25);
		contentPane.add(lblPriceRs);
		//product22
		final JButton button = new JButton("Add to Cart");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select custid from Users where login_status=1";
					String query2="select * from Products where prod_id=22";
					PreparedStatement pst1=conn.prepareStatement(query);
					int c1=0;
					int c4=0;
					int c3=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,22);
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
					pst.setInt(2,22);
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
		button.setBounds(443, 375, 117, 25);
		contentPane.add(button);
		//product23
		final JButton button_1 = new JButton("Add to Cart");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select custid from Users where login_status=1";
					String query2="select * from Products where prod_id=23";
					PreparedStatement pst1=conn.prepareStatement(query);
					int c1=0;
					int c4=0;
					int c3=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,23);
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
					pst.setInt(2,23);
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
		button_1.setBounds(443, 606, 117, 25);
		contentPane.add(button_1);
		
		final JButton button_2 = new JButton("Add to Cart");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					//cstmt.setInt(1,21);
					String query="select custid from Users where login_status=1";
					String query2="select * from Products where prod_id=21";
					PreparedStatement pst1=conn.prepareStatement(query);
					int c1=0;
					int c4=0;
					int c3=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,21);
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
					pst.setInt(2,21);
					pst.setString(3,c2);
					pst.setInt(4,c3);
					pst.setInt(5,c4);
					pst.execute();
					PreparedStatement pstmt;
					pstmt=conn.prepareStatement("{call set_quantity(?)}");
					pstmt.setInt(1,21);
					pstmt.executeUpdate();
					
					
					
					
					
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				button_2.setText("Added Successfully");
			
		
			}
		});
		button_2.setBounds(443, 151, 117, 25);
		contentPane.add(button_2);
		//product24
		final JButton button_3 = new JButton("Add to Cart");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select custid from Users where login_status=1";
					String query2="select * from Products where prod_id=24";
					PreparedStatement pst1=conn.prepareStatement(query);
					int c1=0;
					int c4=0;
					int c3=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,24);
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
					pst.setInt(2,24);
					pst.setString(3,c2);
					pst.setInt(4,c3);
					pst.setInt(5,c4);
					pst.execute();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				button_3.setText("Added Successfully");
			
			}
		});
		button_3.setBounds(1161, 151, 117, 25);
		contentPane.add(button_3);
		//prduct 25
		final JButton button_4 = new JButton("Add to Cart");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select custid from Users where login_status=1";
					String query2="select * from Products where prod_id=25";
					PreparedStatement pst1=conn.prepareStatement(query);
					int c1=0;
					int c4=0;
					int c3=0;
					String c2="NULL";
					CallableStatement mystmt=conn.prepareCall("{call set_quantity(?)}");
					mystmt.setInt(1,25);
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
					pst.setInt(2,25);
					pst.setString(3,c2);
					pst.setInt(4,c3);
					pst.setInt(5,c4);
					pst.execute();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
				button_4.setText("Added Successfully");
			
			}
		});
		button_4.setBounds(1161, 470, 117, 25);
		contentPane.add(button_4);
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
