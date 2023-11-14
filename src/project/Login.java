package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField pwd;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Library Management System");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 449);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmail.setBounds(117, 177, 75, 46);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(227, 177, 218, 46);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(109, 253, 101, 46);
		contentPane.add(lblPassword);

		pwd = new JPasswordField();
		pwd.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pwd.setEchoChar('*');
		pwd.setBounds(227, 253, 218, 48);
		contentPane.add(pwd);

		JButton btnLogin = new JButton("Login");
		btnLogin.setToolTipText("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				char password[] = pwd.getPassword();
				String pswd = String.valueOf(password);

				if (!email.equals("") && !pswd.equals("")) {

					String url = "jdbc:mysql://localhost:3306/mydb";
					try {
						Connection con = DriverManager.getConnection(url, "root", "root");
						Statement st = con.createStatement();
						String query = "select*from account";
						ResultSet rs = st.executeQuery(query);
						boolean flag = false;
						while (rs.next()) {
							String eml = rs.getString("email");
							String pwd = rs.getString("password");
							if (pwd.equals(pswd) && eml.equals(email)) {
								flag = true;
								break;
							}
						}
						if (flag) {
							if (pswd.equals("admin") && email.equals("admin123@gmail.com")) {
								
                               JOptionPane.showMessageDialog(btnLogin, "Login Successful!");
								AdminManagement wel= new AdminManagement();
								wel.setVisible(true);
								wel.setLocation(350, 20);
								dispose();

							} else {
								JOptionPane.showMessageDialog(btnLogin, "Login Successful!");
								ForUser welco = new ForUser();
								welco.setVisible(true);
								welco.setLocation(300, 10);
								dispose();
							}
						} else {
							JOptionPane.showMessageDialog(btnLogin, "You aren't registered yet!", "Warning Message", 2);
							con.close();
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				else {
					JOptionPane.showMessageDialog(btnLogin, "Please fill complete information", "Warning Message", 1);
				}
			}
		});
		btnLogin.setBackground(new Color(176, 196, 222));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.setBounds(144, 332, 96, 52);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 txtEmail.setText("");
				 pwd.setText("");	
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.setBackground(new Color(176, 196, 222));
		btnCancel.setBounds(320, 332, 96, 52);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Hp\\Documents\\Java SE\\login21.png"));
		lblNewLabel_2.setBounds(209, 68, 120, 82);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(0, 0, 539, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("Welcome to Library Management System");
				lblNewLabel.setBounds(10, 11, 503, 46);
				panel.add(lblNewLabel);
				lblNewLabel.setForeground(new Color(0, 0, 0));
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

	}
}
