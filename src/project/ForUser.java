package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ForUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForUser frame = new ForUser();
					frame.setVisible(true);
					frame.setLocation(350, 50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ForUser() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Our Library");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(140, 11, 388, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Books");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\view.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				ViewBook view = null;
				try {
					view = new ViewBook();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				view.setVisible(true);
				view.setLocation(70, 20);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(95, 118, 177, 58);
		contentPane.add(btnNewButton);
		
		JButton btnBorrowBook = new JButton("Borrow Book");
		btnBorrowBook.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\return icon.jpg"));
		btnBorrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				Borrowing borrow = null;
				try {
					borrow = new Borrowing();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    borrow.setVisible(true);
			    borrow.setLocation(350, 2);
				dispose();
			}
		});
		btnBorrowBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBorrowBook.setBackground(new Color(176, 196, 222));
		btnBorrowBook.setBounds(372, 116, 191, 63);
		contentPane.add(btnBorrowBook);
		
		JButton btnCalculateFine = new JButton("Place Order");
		btnCalculateFine.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\order.jpg"));
		btnCalculateFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				PlaceOrder order=new PlaceOrder();
				order.setVisible(true);
				order.setLocation(350, 2);
			}
		});
		btnCalculateFine.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCalculateFine.setBackground(new Color(176, 196, 222));
		btnCalculateFine.setBounds(95, 238, 178, 58);
		contentPane.add(btnCalculateFine);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\return1.png"));
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=false;
				ReturnBook ret = null;
				try {
					ret = new ReturnBook();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ret.setVisible(true);
				ret.setLocation(350,2);
				dispose();
			}
		});
		btnReturnBook.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReturnBook.setBackground(new Color(176, 196, 222));
		btnReturnBook.setBounds(372, 238, 191, 58);
		contentPane.add(btnReturnBook);
	}

}
