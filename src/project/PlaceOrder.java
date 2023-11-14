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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PlaceOrder extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtQty;
	private JComboBox Combo1, Combo;
	private JTextField txtPrice;
	private String url;
	private JTextField txtqty;
	private JTextField txtOrg;

	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaceOrder frame = new PlaceOrder();
					frame.setVisible(true);
					frame.setLocation(300, 70);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlaceOrder() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 573);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Place Order");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(141, 11, 280, 52);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Book Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(63, 94, 135, 42);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("UserName:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(63, 146, 135, 42);
		contentPane.add(lblNewLabel_1_1);

		txtQty = new JTextField();
		txtQty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtQty.setColumns(10);
		txtQty.setBounds(208, 307, 199, 42);
		contentPane.add(txtQty);

		JLabel lblNewLabel_1_1_1 = new JLabel("Price:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(99, 360, 70, 42);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Available Qty:");
		lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_2_1.setBounds(63, 252, 135, 42);
		contentPane.add(lblNewLabel_1_1_2_1);

		txtqty = new JTextField();
		txtqty.setBounds(208, 254, 199, 42);
		contentPane.add(txtqty);
		txtqty.setColumns(10);

		JLabel lblNewLabel_1_1_2 = new JLabel("Qty:");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(99, 305, 50, 42);
		contentPane.add(lblNewLabel_1_1_2);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(208, 148, 199, 42);
		contentPane.add(txtUsername);

		txtPrice = new JTextField();
		txtPrice.setBounds(208, 360, 199, 43);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);

		txtOrg = new JTextField();
		txtOrg.setColumns(10);
		txtOrg.setBounds(208, 201, 199, 42);
		contentPane.add(txtOrg);

		JLabel lblNewLabel_1_1_3 = new JLabel("Original Qty:");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_3.setBounds(63, 199, 135, 42);
		contentPane.add(lblNewLabel_1_1_3);

		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname = Combo1.getSelectedItem().toString();
				String uname = txtUsername.getText();
				String org = txtOrg.getText();
				String avaquan = txtqty.getText();
				String quantity = txtQty.getText();
				String pr = txtPrice.getText();

				if (!bname.equals("") && !uname.equals("") && !org.equals("") && !txtQty.getText().equals("")
						&& !avaquan.equals("") && !pr.equals("")) {
					String url = "jdbc:mysql://localhost:3306/mydb";
					Connection con;
					try {
						con = DriverManager.getConnection(url, "root", "root");
						Statement st = con.createStatement();
						String query6 = "select * from account";
						ResultSet rs = st.executeQuery(query6);
						boolean flag = false;
						while (rs.next()) {
							String uuname = rs.getString("name");
							//String email = rs.getString("email");
							if (uuname.equals(uname) ) {
								flag = true;
								break;
							}
						}
					if(flag) {
					double price = Double.valueOf(pr);
					int qty = Integer.valueOf(quantity);
					int Aqty = Integer.valueOf(avaquan);
					int orgqty = Integer.valueOf(org);

					if (qty > Aqty) {
						JOptionPane.showMessageDialog(btnPlaceOrder,
								"Books is not enough!.\n You can order " + Aqty + " books.");
					} else {
					
						String query1 = "insert into addorder(bookname,username,originalqty,avaliableqty,orderqty,price) values(?,?,?,?,?,?)";
						Connection con1;
						try {
							con1 = DriverManager.getConnection(url, "root", "root");
							PreparedStatement ps = con1.prepareStatement(query1);
							ps.setString(1, bname);
							ps.setString(2, uname);
							ps.setInt(3, orgqty);
							ps.setInt(4, Aqty);
							ps.setInt(5, qty);
							ps.setDouble(6, price * qty);
							ps.executeUpdate();
							JOptionPane.showMessageDialog(btnPlaceOrder, "Add Order Successful!");

							// Connection con;
							// Connection con;
								con = DriverManager.getConnection(url, "root", "root");
								Statement st1 = con.createStatement();
								String query5 = "select AvaOrderQty from addbooks";
								ResultSet rs1 = st1.executeQuery(query5);
								while (rs1.next()) {
								    String OQty = rs1.getString("AvaOrderQty");
								    int BBqty = Integer.valueOf(OQty);
								    int orderbook=(Aqty-qty );
									String Obook=String.valueOf(orderbook);
									String query7 = "update addbooks set AvaOrderQty='" +Obook +"'where BookName= '"
											+ bname + "'";
									PreparedStatement ps1 = con.prepareStatement(query7);
									ps1.executeUpdate();
								}

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					}else {
						JOptionPane.showMessageDialog(btnPlaceOrder, "Your account doesn't exist");
					}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}

				else {
					JOptionPane.showMessageDialog(btnPlaceOrder, "Please fill complete information", "Warning Message",
							1);
				}

			}
		});
		btnPlaceOrder.setBackground(new Color(176, 196, 222));
		btnPlaceOrder.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnPlaceOrder.setBounds(88, 461, 135, 42);
		contentPane.add(btnPlaceOrder);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combo1.setSelectedItem("");
				txtUsername.setText("");
				txtOrg.setText("");
				txtqty.setText("");
				txtQty.setText("");
				txtPrice.setText("");

			}
		});
		btnCancel.setBackground(new Color(176, 196, 222));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.setBounds(254, 461, 105, 42);
		contentPane.add(btnCancel);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnClose.setBackground(new Color(176, 196, 222));
		btnClose.setBounds(397, 461, 105, 42);
		contentPane.add(btnClose);

		Combo1 = new JComboBox();
		Combo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname = (String) Combo1.getSelectedItem();
				String url = "jdbc:mysql://localhost:3306/mydb";
				try {
					Connection con = DriverManager.getConnection(url, "root", "root");
					Statement st = con.createStatement();
					String query = "select OrderQty,AvaOrderQty,Price from addbooks where BookName='" + bname + "'";
					ResultSet rs = st.executeQuery(query);
					boolean flag = false;
					while (rs.next()) {
						String price = rs.getString("Price");
						String oqty = rs.getString("OrderQty");
						String aoqty = rs.getString("AvaOrderQty");
						txtPrice.setText(price);
						txtqty.setText(aoqty);
						txtOrg.setText(oqty);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Combo1.setSelectedIndex(-1);
		Combo1.setBounds(208, 94, 199, 42);
		contentPane.add(Combo1);
		String url = "jdbc:mysql://localhost:3306/mydb";
		Connection con;
		try {
			con = DriverManager.getConnection(url, "root", "root");
			Statement st = con.createStatement();
			String query4 = "select BookName from addbooks";
			ResultSet rs = st.executeQuery(query4);

			Vector<String> blist = new Vector<>();
			while (rs.next()) {
				String bkname = rs.getString("BookName");
				blist.add(bkname);
			}
			Combo1.setModel(new DefaultComboBoxModel<>(blist));

			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
