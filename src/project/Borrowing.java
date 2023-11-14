package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.demo.JCalendarDemo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Borrowing extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private DefaultTableModel model;
	private JTextField txtAqty;
	private JTextField txtBqty;
	private JTextField txtOrg;
	private JTextField txtBQTY;
	private String obqty;
	private String bqty;
	private String BQty;
	private int BBqty;
	private int Borrbook;
	String Bbook;

	// private int BBqty;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrowing frame = new Borrowing();
					frame.setVisible(true);
					frame.setLocation(300, 5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Borrowing() throws SQLException {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Borrow Book");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(151, 26, 317, 58);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(106, 115, 142, 48);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Book Name:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(106, 182, 142, 48);
		contentPane.add(lblNewLabel_1_1);

		txtUsername = new JTextField();
		txtUsername.setBounds(258, 117, 219, 48);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("Lend Date:");
		lblNewLabel_1_2.setBounds(106, 436, 100, 21);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JDateChooser txtdate = new JDateChooser();
		txtdate.setDateFormatString("MM-dd-yyyy");
		txtdate.setBounds(258, 421, 219, 48);
		contentPane.add(txtdate);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Borrow Qty:");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(106, 359, 142, 48);
		contentPane.add(lblNewLabel_1_1_1_1);

		txtOrg = new JTextField();
		txtOrg.setColumns(10);
		txtOrg.setBounds(258, 244, 219, 48);
		contentPane.add(txtOrg);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Original Qty:");
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1_2.setBounds(106, 241, 142, 48);
		contentPane.add(lblNewLabel_1_1_1_2);

		JComboBox combo1 = new JComboBox();
		combo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname = (String) combo1.getSelectedItem();
				String url = "jdbc:mysql://localhost:3306/mydb";
				try {
					Connection con1 = DriverManager.getConnection(url, "root", "root");
					Statement st = con1.createStatement();
					String query1 = "select AvaBorrowqty,BorrowQty from addbooks where BookName='" + bname + "'";
					ResultSet rs = st.executeQuery(query1);
					boolean flag = false;
					while (rs.next()) {
						bqty = rs.getString("AvaBorrowQty");
						obqty = rs.getString("BorrowQty");
						txtAqty.setText(bqty);
						txtOrg.setText(obqty);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
//		combo1.setSelectedIndex(-1);
		combo1.setBounds(258, 165, 219, 37);
		contentPane.add(combo1);
		String url = "jdbc:mysql://localhost:3306/mydb";
		Connection con;
		try {
			con = DriverManager.getConnection(url, "root", "root");
			Statement st = con.createStatement();
			String query4 = "select BookName from addbooks";
			ResultSet rs = st.executeQuery(query4);
			int rowCount = 0;
			Vector<String> blist = new Vector<>();
			while (rs.next()) {
				String bkname = rs.getString("BookName");
				blist.add(bkname);
			}
			combo1.setModel(new DefaultComboBoxModel<>(blist));
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		combo1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		combo1.setBounds(258, 180, 219, 53);
		contentPane.add(combo1);

		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.setBackground(new Color(176, 196, 222));
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtUsername.getText();
				String bname = (String) combo1.getSelectedItem();
				String org = txtOrg.getText();
				String Aqty = txtAqty.getText();
				String bqty = txtBqty.getText();
				Date d = new Date(txtdate.getDate().getTime());
				if (!name.equals("") && !bname.equals("") && !Aqty.equals("") && !bqty.equals("")) {
					String url = "jdbc:mysql://localhost:3306/mydb";
					Connection con;
					try {
						con = DriverManager.getConnection(url, "root", "root");
						Statement st1;

						st1 = con.createStatement();
						String query4 = "select * from datarecord";
						ResultSet rs4 = st1.executeQuery(query4);
						boolean flag = false;
						while (rs4.next()) {

							String Qty = rs4.getString("originalqty");
							int Oqty = Integer.valueOf(Qty);
							String aqty = rs4.getString("avaliableqty");
							// System.out.println(Integer.valueOf(rs4.getString("avaliableqty")));
							String Boqty = rs4.getString("borrowqty");
							// Date dd = new Date(dat.getDate().getTime());
//								String dat=rs1.getString("lenddate");
							String uuname = rs4.getString(2);
							String bbname = rs4.getString(3);
							int stat = rs4.getInt(12);

							if (name.equals(uuname) && rs4.getInt("status") == 0) {
								flag = true;
								break;
							}
						}

						if (flag) {
						JOptionPane.showMessageDialog(btnBorrow, "You have borrowed!");
					} 
				else {

						int Org = Integer.valueOf(org);
						int borrowqty = Integer.valueOf(bqty);
						int avaliableqty = Integer.valueOf(Aqty);
						if (borrowqty > avaliableqty) {

							JOptionPane.showMessageDialog(btnBorrow,
									"Books is not enough!.\n You can borrow " + avaliableqty + " books.");
						}

						else {
							//String url = "jdbc:mysql://localhost:3306/mydb";
							try {
								Connection con2 = DriverManager.getConnection(url, "root", "root");
								// int Bqty = Integer.valueOf(bqty);
								Statement st = con2.createStatement();
								String query2 = "select*from account";
								ResultSet rs = st.executeQuery(query2);
								// boolean flag = false;
								while (rs.next()) {
									String uname = rs.getString("name");
									if (name.equals(uname)) {
										flag = true;
										break;
									}
								}
								if (flag) {

									String query8 = "insert into datarecord(username,bookname,originalqty,avaliableqty,borrowqty,returnqty,lenddate,returndate,lapday,fine,status) values(?,?,?,?,?,?,?,?,?,?,?)";
									PreparedStatement ps8 = con2.prepareStatement(query8);
									ps8.setString(1, name);
									ps8.setString(2, bname);
									ps8.setInt(3, Org);
									ps8.setInt(4, avaliableqty);
									ps8.setInt(5, borrowqty);
									ps8.setInt(6, 0);
									ps8.setDate(7,d );
									//Date dd = new Date(txtdate.getDate().getTime());
									
									ps8.setDate(8,d);
									ps8.setInt(9, 0);
									ps8.setDouble(10, 0);
									ps8.setInt(11, 0);
									ps8.executeUpdate();
									JOptionPane.showMessageDialog(btnBorrow, "Borrow Successful!");

									// Connection con;
									con = DriverManager.getConnection(url, "root", "root");
									Statement st2 = con.createStatement();
									String query5 = "select AvaBorrowQty from addbooks";
									ResultSet rs1 = st2.executeQuery(query5);
									while (rs1.next()) {
										String BQty = rs1.getString("AvaBorrowQty");
										int BBqty = Integer.valueOf(BQty);
										int Borrbook = (avaliableqty - borrowqty);
										String Bbook = String.valueOf(Borrbook);
										String query6 = "update addbooks set AvaBorrowQty='" + Bbook
												+ "'where BookName= '" + bname + "'";
										PreparedStatement ps1 = con.prepareStatement(query6);
										ps1.executeUpdate();
									}

								} else {

									JOptionPane.showMessageDialog(btnBorrow, "Username doesn't exist here!");
								}

							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(btnBorrow, "Please fill complete information", "Warning Message", 1);
				}

			}
		});
		btnBorrow.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBorrow.setBounds(101, 515, 115, 48);
		contentPane.add(btnBorrow);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText("");
				combo1.setSelectedItem("");
				txtdate.setDate(null);
				txtOrg.setText("");
				txtAqty.setText("");
				txtBqty.setText("");

			}
		});
		btnCancel.setBackground(new Color(176, 196, 222));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.setBounds(258, 515, 115, 48);
		contentPane.add(btnCancel);
		model = new DefaultTableModel();

		JButton btnCancel_1 = new JButton("Back");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				ForUser user = new ForUser();
				user.setVisible(true);
				dispose();
			}
		});
		btnCancel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel_1.setBackground(new Color(176, 196, 222));
		btnCancel_1.setBounds(418, 515, 115, 48);
		contentPane.add(btnCancel_1);

		txtAqty = new JTextField();
		txtAqty.setBounds(258, 303, 219, 48);
		contentPane.add(txtAqty);
		txtAqty.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Available Qty:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(106, 300, 142, 48);
		contentPane.add(lblNewLabel_1_1_1);

		txtBqty = new JTextField();
		txtBqty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		txtBqty.setColumns(10);
		txtBqty.setBounds(258, 362, 219, 48);
		contentPane.add(txtBqty);

		Object[] col = { "ID", "UserName", "BookName", "Original Qty", "Avaliable Borrow Qty", "Borrow Qty",
				"lend Date", "Status" };
		model.setColumnIdentifiers(col);

		Connection con3 = DriverManager.getConnection(url, "root", "root");
		Statement st = con3.createStatement();
		String query6 = "select * from borrowtable";
		ResultSet rs = st.executeQuery(query6);
		while (rs.next()) {
			Object[] row = { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6),
					rs.getDate(7), rs.getInt(8) };
			model.addRow(row);
		}
	}

}
