package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;

public class Cart extends JFrame 
{

	private JPanel contentPane;
	Connection conn=null;
	Statement stmt=null;
	 static final String DB_URL="jdbc:mysql://localhost/c67";
	  static final String driver="com.mysql.jdbc.Driver";
	  static final String USER="root";
	  static final String PASS="password";
	  int count=0;
	  private JTable table;

	public Cart() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366,1366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 102, 1035, 425);
		contentPane.add(scrollPane);
		Border border;
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(50);
		table.setBackground(Color.cyan);
		//table.setBorder(border);
		JButton btnNewButton = new JButton("Show My Cart");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select p_name,price from mycart";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(420, 42, 217, 25);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Total Amount");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="select sum(price) from mycart";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs1=pst.executeQuery();
					while(rs1.next())
					{
						int totalamount=rs1.getInt(1);
						JTextField textField = new JTextField();
						textField.setText("Rs"+totalamount);
						textField.setBounds(329, 575, 114, 25);
						contentPane.add(textField);
						textField.setColumns(10);
						
					}
				} catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(114, 575, 179, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Proceed to pay");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DetailsForm detailsform=new DetailsForm();
				detailsform.setVisible(true);
			}
			
		});
		btnNewButton_2.setBounds(349, 629, 165, 25);
		contentPane.add(btnNewButton_2);
		
		
		
	
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
		
		JButton btnNewButton_3 = new JButton("Cancel order");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				try 
				{
					Class.forName(driver);
					conn=(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
					String query="delete from mycart";
					Statement st=conn.createStatement();
					st.execute(query);
					JOptionPane.showMessageDialog(null,"Order canceled!");
				} catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(608, 575, 153, 25);
		contentPane.add(btnNewButton_3);
	}
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					new Cart().setVisible(true);
				}
					 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
