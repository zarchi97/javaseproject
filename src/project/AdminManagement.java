package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminManagement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminManagement frame = new AdminManagement();
					frame.setVisible(true);
					frame.setLocation(50, 50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminManagement() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Books");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\addbook3.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				AddBook add = null;
				try {
					add = new AddBook();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				add.setVisible(true);
				add.setLocation(2, 2);
				dispose();
				}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(70, 256, 193, 64);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteBooks = new JButton("Delete Books");
		btnDeleteBooks.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\deletebook2.png"));
		btnDeleteBooks.setHorizontalAlignment(SwingConstants.LEADING);
		btnDeleteBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				DeleteBooks de = null;
				try {
					de = new DeleteBooks();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				de.setVisible(true);
				de.setLocation(2, 2);
				dispose();
			}
		});
		btnDeleteBooks.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteBooks.setBackground(new Color(176, 196, 222));
		btnDeleteBooks.setBounds(70, 458, 193, 64);
		contentPane.add(btnDeleteBooks);
		
		JButton btnUpdateBooks = new JButton("Update Books");
		btnUpdateBooks.setHorizontalAlignment(SwingConstants.LEADING);
		btnUpdateBooks.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\return2.png"));
		btnUpdateBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				UpdateBooks up = null;
				try {
					up = new UpdateBooks();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				up.setVisible(true);
				up.setLocation(2, 2);
				dispose();
			}
		});
		btnUpdateBooks.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdateBooks.setBackground(new Color(176, 196, 222));
		btnUpdateBooks.setBounds(70, 362, 193, 64);
		contentPane.add(btnUpdateBooks);
		
		JButton btnOrder = new JButton("View Order");
		btnOrder.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\orders-icon-12.jpg"));
		btnOrder.setHorizontalAlignment(SwingConstants.LEADING);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOrders order = null;
				try {
					order = new ViewOrders();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				order.setVisible(true);
				order.setLocation(2,2);
				dispose();
				
			}
		});
		btnOrder.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOrder.setBackground(new Color(176, 196, 222));
		btnOrder.setBounds(370, 256, 193, 64);
		contentPane.add(btnOrder);
		
		JButton btnUpdateBooks_1 = new JButton("View Return Books");
		btnUpdateBooks_1.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\borrowicon.png"));
		btnUpdateBooks_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnUpdateBooks_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				ReturnBookView rbook = null;
				try {
					rbook = new ReturnBookView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rbook.setVisible(true);
				rbook.setLocation(2, 2);
				dispose();
				
			}
		});
		btnUpdateBooks_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdateBooks_1.setBackground(new Color(176, 196, 222));
		btnUpdateBooks_1.setBounds(370, 362, 193, 64);
		contentPane.add(btnUpdateBooks_1);
		
		JButton btnNewUser = new JButton("New User");
		btnNewUser.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\1.png"));
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				AccountCreate acc=new AccountCreate();
				acc.setVisible(true);
				acc.setLocation(300, 70);
			}
		});
		btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewUser.setBackground(new Color(176, 196, 222));
		btnNewUser.setBounds(70, 149, 193, 64);
		contentPane.add(btnNewUser);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome Admin");
		lblNewLabel_1.setBackground(new Color(188, 143, 143));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel_1.setBounds(2, 11, 619, 55);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				Login user=new Login();
				user.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\logout.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(370, 458, 193, 64);
		contentPane.add(btnNewButton_1);
		
		JButton btnViewMember = new JButton("View Member:");
		btnViewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				Accounttable table = null;
				try {
					table = new Accounttable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setVisible(true);
			}
		});
		btnViewMember.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\member.png"));
		btnViewMember.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnViewMember.setBackground(new Color(176, 196, 222));
		btnViewMember.setBounds(370, 149, 193, 64);
		contentPane.add(btnViewMember);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\Old-library.png"));
		lblNewLabel.setBounds(2, 0, 619, 558);
		contentPane.add(lblNewLabel);
	}
}
