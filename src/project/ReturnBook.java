package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtUname;
	private JTextField txtBname;
	private JTextField txtLap;
	private JTextField txtFine;
	private DefaultTableModel model;
	private JTextField txtLendDate;
	private JTextField txtBqty;
	private String BQty;
	private int BBqty;
	private int rebook;
	private String reBook;
	private int aaqty;
	private int BBoqty;
	private String Boqty;
	private String aqty;
	private String Bqty;
	private int bQTY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
					frame.setVisible(true);
					frame.setLocation(300, 10);
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
	public ReturnBook() throws SQLException {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 652);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Return Book");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(178, 11, 235, 54);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("User Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(50, 95, 157, 47);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Book Name:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(60, 153, 157, 47);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Lend Date:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(50, 271, 157, 47);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Return Date:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(60, 329, 157, 47);
		contentPane.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Expire lap day:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_3.setBounds(50, 393, 157, 47);
		contentPane.add(lblNewLabel_1_1_3);

		txtLap = new JTextField();
		txtLap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = txtLap.getText();
				int number = Integer.valueOf(value);
				if (number > 5) {
					int num1 = number - 5;
					int result = num1 * 500;
					String result1 = String.valueOf(result);
					Double fine = Double.valueOf(result1);
					JOptionPane.showMessageDialog(txtLap, "You must be fine for " + num1 + "day late.");
					txtFine.setText(result1);
				} else {
					JOptionPane.showMessageDialog(txtLap, "You don't need to pay fine");
				}
			}
		});
		txtLap.setColumns(10);
		txtLap.setBounds(314, 391, 79, 47);
		contentPane.add(txtLap);

		JDateChooser txtredate = new JDateChooser();
		txtredate.getCalendarButton().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
//				SimpleDateFormat sdf = new SimpleDateFormat();
//				String ldate = txtLendDate.getText();
//				System.out.println(ldate);
//				String date = txtredate.getDateFormatString();
//				Date fdate = Date.valueOf(ldate);
//				Date dd = new Date(txtredate.getDate().getTime());
//				LocalDate d1 = LocalDate.of(fdate.getYear(), fdate.getMonth(), fdate.getDate());
//				LocalDate d2 = LocalDate.of(dd.getYear(), dd.getMonth(), dd.getDate());
//
//				//Duration diff = Duration.between(fdate, dd);
//				Period period = Period.between(d1, d2);
//				int daysBetween = period.getDays();
////				System.out.println(daysBetween);
////				long diffInMillies = Math.abs(dd.getTime() - fdate.getTime());
////				long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//				txtLap.setText(String.valueOf(daysBetween));

			}
		});
		txtredate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		txtredate.setDateFormatString("MM-dd-yyyy");
		txtredate.setBounds(227, 329, 166, 47);
		contentPane.add(txtredate);

		txtLendDate = new JTextField();
		txtLendDate.setBounds(227, 271, 166, 47);
		contentPane.add(txtLendDate);
		txtLendDate.setColumns(10);

		txtBqty = new JTextField();
		txtBqty.setColumns(10);
		txtBqty.setBounds(227, 213, 166, 47);
		contentPane.add(txtBqty);

		JLabel lblNewLabel_1_1_4 = new JLabel("ReturnBook Qty:");
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_4.setBounds(50, 211, 157, 47);
		contentPane.add(lblNewLabel_1_1_4);

		txtUname = new JTextField();
		txtUname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = txtUname.getText();
				String buname = txtBname.getText();
//				String date = txtredate.getDateFormatString();
//				Date dd = Date.valueOf(date);
				String url = "jdbc:mysql://localhost:3306/mydb";
				try {
					Connection con1 = DriverManager.getConnection(url, "root", "root");
					Statement st = con1.createStatement();
					String query1 = "select username,bookname,borrowqty,lenddate,status from datarecord where username='"
							+ uname + "'";
					ResultSet rs = st.executeQuery(query1);
					boolean flag = false;
					while (rs.next()) {
						String uuname = rs.getString("username");
						String bbname = rs.getString("bookname");
						String bbqty = rs.getString("borrowqty");
						String ldate = rs.getString("lenddate");
						String status = rs.getString("status");
						if (uname.equals(uuname) && Integer.valueOf(status) == 0) {
							flag = true;
							break;
						}
					}
					if (flag) {
						txtUname.setText(uname);
						txtBname.setText(rs.getString("bookname"));
						txtBqty.setText(rs.getString("borrowqty"));
						txtLendDate.setText(rs.getString("lenddate"));
					} else {

						JOptionPane.showMessageDialog(txtUname, "You don't have borrow!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtUname.setBounds(227, 97, 166, 47);
		contentPane.add(txtUname);
		txtUname.setColumns(10);

		txtBname = new JTextField();
		txtBname.setColumns(10);
		txtBname.setBounds(227, 155, 166, 47);
		contentPane.add(txtBname);

		txtFine = new JTextField();
		txtFine.setColumns(10);
		txtFine.setBounds(227, 449, 166, 47);
		contentPane.add(txtFine);

		JLabel lblNewLabel_1_1_3_1 = new JLabel("Fine:");
		lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_3_1.setBounds(60, 451, 157, 47);
		contentPane.add(lblNewLabel_1_1_3_1);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = txtUname.getText();
				String bNAME = txtBname.getText();
				String bqty = txtBqty.getText();
				String LDate = txtLendDate.getText();
				Date date = new Date(txtredate.getDate().getTime());
				String lap = txtLap.getText();

				String f = txtFine.getText();
				Double fine = Double.valueOf(f);
				if (!Name.equals("") || !bNAME.equals("") || !bqty.equals("")  || lap.equals("") || f.equals("")) {
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
						
							String Boqty = rs4.getString("borrowqty");
						
							String uuname = rs4.getString("username");
							String bbname = rs4.getString("bookname");
							String stat = rs4.getString("status");
							
                            if (Name.equals(uuname) && bbname.equals(bNAME) && Integer.valueOf(stat)==0)  {
								
								flag = true;
								break;
							}
						}
						if (flag) {

							con = DriverManager.getConnection(url, "root", "root");

							int bbqty = Integer.valueOf(bqty);
							int lapday = Integer.valueOf(lap);
							String query8 = "insert into datarecord(username,bookname,originalqty,avaliableqty,borrowqty,returnqty,lenddate,returndate,lapday,fine,status) values(?,?,?,?,?,?,?,?,?,?,?)";
							PreparedStatement ps8 = con.prepareStatement(query8);
							
							ps8.setString(1, Name);
							ps8.setString(2, bNAME);
							ps8.setInt(3, Integer.valueOf(rs4.getString("originalqty")));
							ps8.setInt(4, Integer.valueOf(rs4.getString("avaliableqty")));

							ps8.setInt(5, Integer.valueOf(bqty));
							ps8.setInt(6, bbqty);
							ps8.setString(7, LDate);

							ps8.setDate(8, date);
							ps8.setInt(9, lapday);
							ps8.setDouble(10, fine);
							ps8.setInt(11, 1);
							ps8.executeUpdate();
							JOptionPane.showMessageDialog(btnReturn, "Return Book Successful!");

							con = DriverManager.getConnection(url, "root", "root");
							Statement st6 = con.createStatement();
							String query6 = "select * from addbooks";
							ResultSet rs6 = st6.executeQuery(query6);
							while (rs6.next()) {
								String bname = rs6.getString("BookName");
								
								String BQty = rs6.getString("AvaBorrowQty");
								int BBqty = Integer.valueOf(BQty);
								if (bNAME.equals(bname) ) {
									flag = true;
									break;
								}
							}
							if (flag) {
								int rebook = (int) (Integer.valueOf(rs6.getString("AvaBorrowQty"))
										+ Integer.valueOf(bqty));
								String reBook = String.valueOf(rebook);
								String query = "update addbooks set AvaBorrowQty= '" + reBook + "' where BookName= '"
										+ bNAME + "'";
								PreparedStatement ps1 = con.prepareStatement(query);
								ps1.executeUpdate();
							}

						} else {
							JOptionPane.showMessageDialog(btnReturn, "You returned!");
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(btnReturn, "Please fill complete information!", "Warning Message", 1);
				}
			}
		});
		btnReturn.setBackground(new Color(176, 196, 222));
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReturn.setBounds(92, 537, 107, 47);
		contentPane.add(btnReturn);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUname.setText("");
				txtBname.setText("");
				txtBqty.setText("");
				txtLendDate.setText("");
				txtLap.setText("");
				txtFine.setText("");
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.setBackground(new Color(176, 196, 222));
		btnCancel.setBounds(241, 537, 107, 47);
		contentPane.add(btnCancel);

		JButton btnDayDiff = new JButton("Day Diff");
		btnDayDiff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat();
				String ldate = txtLendDate.getText();
				Date fdate = Date.valueOf(ldate);
//				String date = txtredate.getDateFormatString();
				Date dd = new Date(txtredate.getDate().getTime());

				LocalDate d1 = LocalDate.of(fdate.getYear(), fdate.getMonth(), fdate.getDate());
				LocalDate d2 = LocalDate.of(dd.getYear(), dd.getMonth(), dd.getDate());
				Period period = Period.between(d1, d2);
				int daysBetween = period.getDays();
				txtLap.setText(String.valueOf(daysBetween));
				String value = txtLap.getText();
				int number = Integer.valueOf(value);
				if (number > 5) {
					int num1 = number - 5;
					int result = num1 * 500;
					String result1 = String.valueOf(result);
					Double fine = Double.valueOf(result1);
					JOptionPane.showMessageDialog(txtLap, "You must be fine for " + num1 + "day late.");
					txtFine.setText(result1);
				} else {
					JOptionPane.showMessageDialog(txtLap, "You don't need to pay fine");
					int result2 = 0;
					String result3 = String.valueOf(result2);
					txtFine.setText(result3);
				}
			}
		});
		btnDayDiff.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDayDiff.setBounds(237, 397, 67, 41);
		contentPane.add(btnDayDiff);

		model = new DefaultTableModel();
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				ForUser re = new ForUser();
				re.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(385, 537, 102, 47);
		contentPane.add(btnNewButton);
		Object[] col = { "ID", "UserName", "BookName", "ReturnBook Qty", "ReturnDate", "Lap Day", "Fine", "Status" };
		model.setColumnIdentifiers(col);
		String url = "jdbc:mysql://localhost:3306/mydb";
		Connection con = DriverManager.getConnection(url, "root", "root");
		Statement st = con.createStatement();
		String query = "select * from returnbooks";
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			Object[] row = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),
					rs.getInt(6), rs.getDouble(7), rs.getInt(8) };
			model.addRow(row);
		}

	}
}
