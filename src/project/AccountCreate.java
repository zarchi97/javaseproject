package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Window.Type;

public class AccountCreate extends JFrame {

	private JPanel contentPane;
	private JTextField txtCName;
	private JTextField txtCPhone;
	private JTextField txtCEmail;
	private JPasswordField pwd;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountCreate frame = new AccountCreate();
					frame.setVisible(true);
					frame.setLocation(400, 50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountCreate() {

		view();
	}

	public void view() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setBounds(116, 151, 72, 59);
		contentPane.add(lblName);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setForeground(new Color(0, 0, 0));
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPhoneNumber.setBounds(74, 214, 136, 59);
		contentPane.add(lblPhoneNumber);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmail.setBounds(111, 276, 99, 59);
		contentPane.add(lblEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(97, 341, 99, 59);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\images12.png"));
		lblNewLabel_1.setBounds(52, 11, 136, 120);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Create New Account");
		lblNewLabel.setBounds(196, 38, 233, 59);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));

		txtCName = new JTextField();
		txtCName.setBounds(220, 159, 192, 46);
		contentPane.add(txtCName);
		txtCName.setColumns(10);

		txtCPhone = new JTextField();
		txtCPhone.setColumns(10);
		txtCPhone.setBounds(220, 221, 192, 46);
		contentPane.add(txtCPhone);

		txtCEmail = new JTextField();
		txtCEmail.setColumns(10);
		txtCEmail.setBounds(220, 284, 192, 46);
		contentPane.add(txtCEmail);

		pwd = new JPasswordField();
		pwd.setBounds(220, 349, 192, 46);
		contentPane.add(pwd);

		JButton btnCreate = new JButton("Create Account");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname = txtCName.getText();
				String cemail = txtCEmail.getText();
				char password[] = pwd.getPassword();
				String pswd = String.valueOf(password);

				String phone = txtCPhone.getText();

				if (!cemail.equals("") && !cname.equals("") && !phone.equals("") && !pswd.equals("")) {

					String url = "jdbc:mysql://localhost:3306/mydb";
					try {
						Connection con = DriverManager.getConnection(url, "root", "root");
						int cphone = Integer.valueOf(phone);
						Statement st = con.createStatement();
						String query = "select*from account";
						ResultSet rs = st.executeQuery(query);
						boolean flag = false;
						while (rs.next()) {
							String uname = rs.getString("name");
							int ph = rs.getInt("phone");
							String email = rs.getString("email");
							String pwd = rs.getString("password");

							if (cemail.equals(email) && cname.equals(uname)) {
								flag = true;
								break;
							}

						}
						if (flag) {
							JOptionPane.showMessageDialog(btnCreate, "User exist! \n Try another one");
							
						} else {
							String query1 = "insert into account(name,phone,email,password) values(?,?,?,?)";
							PreparedStatement ps=con.prepareStatement(query1);
							ps.setString(1, cname);
							ps.setInt(2, cphone);
							ps.setString(3, cemail);
							ps.setString(4, pswd);

							ps.executeUpdate();
							JOptionPane.showMessageDialog(btnCreate, "Account Create Successful!");
//                            ForUser user=new ForUser();
//                            user.setVisible(true);
//							dispose();
							con.close();

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(btnCreate, "Please fill complete information", "Warning Message", 1);
				}
				
			}

		});
		btnCreate.setBackground(new Color(176, 196, 222));
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCreate.setBounds(83, 428, 159, 46);
		contentPane.add(btnCreate);

		JButton btnCCancel = new JButton("Cancel");
		btnCCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCName.setText("");
				txtCPhone.setText("");
				txtCEmail.setText("");
				pwd.setText("");

			}
		});
		btnCCancel.setBackground(new Color(176, 196, 222));
		btnCCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCCancel.setBounds(272, 428, 99, 46);
		contentPane.add(btnCCancel);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnClose.setBackground(new Color(176, 196, 222));
		btnClose.setBounds(404, 428, 99, 46);
		contentPane.add(btnClose);

		
	}
}
