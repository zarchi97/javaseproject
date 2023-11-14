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
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class UpdateBooks extends JFrame {

	private JPanel contentPane;
	private JTextField txtQty;
	private JTextField txtPrice;
	private JTextField txtBQty;
    private DefaultTableModel model;
    private JTable table;
    private JTextField txtAqty;
    private JTextField txtAbqty;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBooks frame = new UpdateBooks();
					frame.setVisible(true);
					frame.setLocation(2, 2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public UpdateBooks() throws SQLException {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1258, 676);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Book");
		lblNewLabel.setBackground(new Color(245, 245, 245));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 30, 394, 62);
		contentPane.add(lblNewLabel);
		
		model=new DefaultTableModel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(473, 129, 766, 349);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 745, 327);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(95, 158, 160));
		scrollPane.setViewportView(table);
		
		table.setModel(model);
		
		JButton btnNewButton = new JButton("<<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				AdminManagement admin=new AdminManagement();
				admin.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(1150, 489, 89, 34);
		contentPane.add(btnNewButton);
		
		JComboBox combo2 = new JComboBox();
		combo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/mydb";
				
				Connection con;
				try {
					con = DriverManager.getConnection(url, "root", "root");
					
					String query="select OrderQty,AvaOrderQty,Price,BorrowQty,AvaBorrowQty from addbooks where BookName= ?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, (String) combo2.getSelectedItem());
					ResultSet rs=pst.executeQuery();
					while(rs.next()) {
						txtQty.setText(String.valueOf(rs.getInt("OrderQty")));
						txtBQty.setText( String.valueOf(rs.getInt("BorrowQty")));
						txtPrice.setText( String.valueOf(rs.getDouble("Price")));
						txtAqty.setText( String.valueOf(rs.getInt("AvaOrderQty")));
						txtAbqty.setText(String.valueOf(rs.getInt("AvaBorrowQty")));
					}
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			
				
			}
		});
		combo2.setBounds(200, 115, 198, 48);
		contentPane.add(combo2);
		combo2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		String url="jdbc:mysql://localhost:3306/mydb";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,"root","root");
			Statement st=con.createStatement();
			String query4="select BookName from addbooks";
			ResultSet rs=st.executeQuery(query4);
			int rowCount=0;
			Vector<String>blist=new Vector<>();
			while(rs.next()) {
				String bkname=rs.getString("BookName");
				blist.add(bkname);
				}	
			combo2.setModel(new DefaultComboBoxModel<>(blist));
			
			} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel lblNewLabel_1 = new JLabel("Book Name:");
		lblNewLabel_1.setBounds(59, 113, 118, 53);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("Original Order Qty:");
		lblNewLabel_1_1.setBounds(23, 170, 167, 53);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Original Borrow Qty:");
		lblNewLabel_1_1_1.setBounds(22, 348, 180, 53);
		contentPane.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_2 = new JLabel("Price:");
		lblNewLabel_1_2.setBounds(85, 290, 66, 53);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(176, 196, 222));
		btnUpdate.setBounds(95, 502, 108, 49);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname =String.valueOf(combo2.getSelectedItem());
				String qty = txtQty.getText();
                String bqty = txtBQty.getText();
                String price=txtPrice.getText();
                String Aqty = txtAqty.getText();
                String Abqty = txtAbqty.getText();
               
				if (!bname.equals("") && !qty.equals("") &&!bqty.equals("") &&!Aqty.equals("") &&!Abqty.equals("") && !price.equals("")) {
					String url = "jdbc:mysql://localhost:3306/mydb";
					try {
						Connection con = DriverManager.getConnection(url, "root", "root");
						int Qty = Integer.valueOf(qty);
						int BQty = Integer.valueOf(bqty);
						Double pr=Double.valueOf(price);
						int AQty = Integer.valueOf(Aqty);
						int ABQty = Integer.valueOf(Abqty);
						//int BQty = Integer.valueOf(bqty);
						Statement st = con.createStatement();
						String query = "select * from addbooks";
						ResultSet rs = st.executeQuery(query);
						boolean flag = false;
						while (rs.next()) {
							String bkname = rs.getString(2);
							if (bname.equals(bkname)) {
								flag = true;
								break;
							}
						}
						if (flag) {
							String query1 = "update addbooks set OrderQty='"+ Qty +"',AvaOrderQty='"+AQty+"' ,Price='"+ pr +"',BorrowQty='"+ BQty+"',AvaBorrowQty='"+ABQty+"'  where BookName= '"+ bname +"'";
							PreparedStatement ps = con.prepareStatement(query1);
							ps.executeUpdate();
							JOptionPane.showMessageDialog(btnUpdate, "Update successful!");
							con.close();
						}
//						else {
//							JOptionPane.showMessageDialog(btnUpdate, "This book doesn't exist");
//						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(btnUpdate, "Please fill info");
				}
				
				}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
				
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(176, 196, 222));
		btnCancel.setBounds(277, 502, 103, 49);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
				
		txtQty = new JTextField();
		txtQty.setBounds(200, 174, 198, 49);
		contentPane.add(txtQty);
		txtQty.setColumns(10);
		
		txtBQty = new JTextField();
		txtBQty.setBounds(200, 352, 198, 49);
		contentPane.add(txtBQty);
		txtBQty.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(200, 294, 198, 49);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtAqty = new JTextField();
		txtAqty.setColumns(10);
		txtAqty.setBounds(200, 234, 198, 49);
		contentPane.add(txtAqty);
		
		txtAbqty = new JTextField();
		txtAbqty.setColumns(10);
		txtAbqty.setBounds(200, 412, 198, 49);
		contentPane.add(txtAbqty);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Avaliable Borrow Qty:");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(10, 412, 192, 53);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Avaliable Order Qty:");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(10, 234, 180, 53);
		contentPane.add(lblNewLabel_1_1_2);
		Object[] col= {"ID","BookName","Author","OrderQty","AvaOrderQty","Price","BorrowQty","AvaBorrowQty"};
		model.setColumnIdentifiers(col);
		//String url="jdbc:mysql://localhost:3306/mydb";
		//Connection con=DriverManager.getConnection(url,"root","root");
		Statement st=con.createStatement();
		String query1="select * from addbooks";
		ResultSet rs=st.executeQuery(query1);
		while(rs.next()) {
			Object []row= {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8)};
					model.addRow(row);	
			}
			
	}
}
