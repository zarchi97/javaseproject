package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtCName;
	private JTextField txtCEmail;
	private JTextField txtCPhone;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 567);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Create New Account");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(190, 25, 293, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(123, 157, 76, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pbone Number:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(91, 219, 136, 51);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(123, 287, 76, 51);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(111, 349, 101, 51);
		contentPane.add(lblNewLabel_1_3);
		
		txtCName = new JTextField();
		txtCName.setBounds(268, 157, 173, 51);
		contentPane.add(txtCName);
		txtCName.setColumns(10);
		
		txtCEmail = new JTextField();
		txtCEmail.setColumns(10);
		txtCEmail.setBounds(268, 283, 173, 51);
		contentPane.add(txtCEmail);
		
		txtCPhone = new JTextField();
		txtCPhone.setColumns(10);
		txtCPhone.setBounds(268, 219, 173, 51);
		contentPane.add(txtCPhone);
		
		pwd = new JPasswordField();
		pwd.setBounds(268, 351, 173, 51);
		contentPane.add(pwd);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtCName.getText();
				String ph=txtCPhone.getText();
				String eml=txtCEmail.getText();
				char[] pass=pwd.getPassword();
				String pswd=String.valueOf(pass);
	            if(!name.equals("") && !ph.equals("") && !eml.equals("") && !pswd.equals("")) {
	            String url="jdbc:mysql://localhost:3306/mydb";
	            try {
					Connection con=DriverManager.getConnection(url,"root","root");
					int phone=Integer.valueOf(pswd);
					Statement st=con.createStatement();
					String query="select * from account";
					ResultSet rs=st.executeQuery(query);
					boolean flag=false;
					while(rs.next()) {
						String uname=rs.getString("name");
						String email=rs.getString("email");
						if(!name.equals(uname) && !eml.equals(email)) {
							flag=true;
							break;
						}
					}
					if(flag) {
						String query1="insert into account(name,phone,email,password) values (?,?,?,?)";
						PreparedStatement ps=con.prepareStatement(query1);
						ps.setString(1, name);
						ps.setInt(2, phone);
						ps.setString(3, eml);
						ps.setString(4, pswd);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(btnCreate, "Account Create Successful!");
					}
					else {

						JOptionPane.showMessageDialog(btnCreate, "User exist! \n Try another one");
						

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            	
	            }else {
	            	JOptionPane.showMessageDialog(btnCreate, "Please fill complete information", "Warning Message", 1);

	            }
				
			}
		});
		btnCreate.setBackground(new Color(176, 196, 222));
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCreate.setBounds(78, 437, 161, 51);
		contentPane.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCName.setText("");
				txtCPhone.setText("");
				txtCEmail.setText("");
				pwd.setText("");
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.setBackground(new Color(176, 196, 222));
		btnCancel.setBounds(278, 437, 110, 51);
		contentPane.add(btnCancel);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnClose.setBackground(new Color(176, 196, 222));
		btnClose.setBounds(422, 437, 110, 51);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\images12.png"));
		lblNewLabel_2.setBounds(91, 11, 121, 120);
		contentPane.add(lblNewLabel_2);
	}
}
