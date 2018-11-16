package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class HomePage extends JFrame {
	Connection conn=null;
	Statement stmt=null;
	 static final String DB_URL="jdbc:mysql://localhost/c67";
	  static final String driver="com.mysql.jdbc.Driver";
	  static final String USER="root";
	  static final String PASS="password";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1366,1366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
			public void actionPerformed(ActionEvent e)
			{
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
		
		JLabel lblImg = new JLabel("img1");
		Image img=new ImageIcon(this.getClass().getResource("/necklacemain.resized.jpg")).getImage();
		lblImg .setIcon(new ImageIcon(img));
		lblImg.setBounds(168, 0, 404, 336);
		getContentPane().add(lblImg);
		
		JLabel lblImg_1 = new JLabel("img2");
		Image img1=new ImageIcon(this.getClass().getResource("/bracelets.jpg")).getImage();
		lblImg_1.setIcon(new ImageIcon(img1));
		lblImg_1.setBounds(801, 36, 444, 265);
		getContentPane().add(lblImg_1);
		
		JLabel lblImg_2 = new JLabel("img3");
		Image img2=new ImageIcon(this.getClass().getResource("/earrings1.jpg")).getImage();
		lblImg_2.setIcon(new ImageIcon(img2));
		lblImg_2.setBounds(95, 396, 412, 244);
		getContentPane().add(lblImg_2);
		
		JButton btnShopNow = new JButton("Shop Bracelets and Bangles");
		btnShopNow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Bracelets b1=new Bracelets();
				b1.setVisible(true);
				 setVisible(false);
			}
		});
		btnShopNow.setBounds(885, 313, 240, 23);
		getContentPane().add(btnShopNow);
		
		JButton btnShopNecklaces = new JButton("Shop Necklaces");
		btnShopNecklaces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Necklaces n1=new Necklaces();
				n1.setVisible(true);
				 setVisible(false);
			}
		});
		btnShopNecklaces.setBounds(282, 361, 167, 23);
		getContentPane().add(btnShopNecklaces);
		
		JButton btnShopEarrings = new JButton("Shop Earrings");
		btnShopEarrings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Earrings e1=new Earrings();
				e1.setVisible(true);
				 setVisible(false);
			}
		});
		btnShopEarrings.setBounds(231, 645, 175, 23);
		contentPane.add(btnShopEarrings);
		
		JLabel lblImg_3 = new JLabel("img4");
		Image img3=new ImageIcon(this.getClass().getResource("/jewbox1.jpg")).getImage();
		lblImg_3 .setIcon(new ImageIcon(img3));
		lblImg_3.setBounds(640, 381, 228, 235);
		contentPane.add(lblImg_3);
		
		JButton btnShopOther = new JButton("Shop Other Accessories");
		btnShopOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Other o1=new Other();
				o1.setVisible(true);
				 setVisible(false);
			}
		});
		btnShopOther.setBounds(640, 644, 218, 25);
		contentPane.add(btnShopOther);
		
		JLabel lblImg_4 = new JLabel("img5");
		Image img4=new ImageIcon(this.getClass().getResource("/rings.jpg")).getImage();
		lblImg_4 .setIcon(new ImageIcon(img4));
		lblImg_4.setBounds(976, 396, 269, 208);
		contentPane.add(lblImg_4);
		
		JButton btnShopRings = new JButton("Shop Rings");
		btnShopRings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rings r1=new Rings();
				r1.setVisible(true);
				setVisible(false);
			}
		});
		btnShopRings.setBounds(1057, 625, 117, 25);
		contentPane.add(btnShopRings);
	  
	}
	
}
