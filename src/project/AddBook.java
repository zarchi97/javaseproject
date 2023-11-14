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
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Window.Type;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBName;
	private JTextField txtBAuthor;
	private JTextField txtQty;
	private JTextField txtPrice;
	private JTextField txtBorrow;
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtsearch;
	private int n;
	private JTextField txtAQty;
	private JTextField txtABQty;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * 
	 */
	public void showRecord() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/mydb";
		Connection con=DriverManager.getConnection(url,"root","root");
		String query="select * from addbooks";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();
			int num=rsm.getColumnCount();
			DefaultTableModel df= (DefaultTableModel) model;
			df.setRowCount(0);
			while(rs.next()) {
				Vector obj=new Vector<>();
				for(int i=1;i<=n;i++) {
					obj.add(rs.getString(1));
					obj.add(rs.getString(2));
					obj.add(rs.getString(3));
					obj.add(rs.getString(4));
					obj.add(rs.getString(5));
					obj.add(rs.getString(6));
					obj.add(rs.getString(7));
				}
				df.addRow(obj);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
					frame.setVisible(true);
					frame.setLocation(1, 1);
					
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
	public AddBook() throws SQLException {
		setType(Type.POPUP);
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1423, 737);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Books");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(226, 29, 206, 64);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(487, 149, 786, 403);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		model=new DefaultTableModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		scrollPane.setBounds(10, 11, 766, 381);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			
//			public void keyPressed(KeyEvent e) {
//				DefaultTableModel model=(DefaultTableModel) table.getModel();
//				String tblName= table.getValueAt(table.getSelectedRow(), 0).toString();
//				txtBAuthor.setText( model.getValueAt(table.getSelectedRow(), 1).toString());
//				txtQty.setText( model.getValueAt(table.getSelectedRow(), 2).toString());
//				txtAQty.setText( model.getValueAt(table.getSelectedRow(), 3).toString());
//				txtPrice.setText( model.getValueAt(table.getSelectedRow(), 4).toString());
//                txtBorrow.setText( model.getValueAt(table.getSelectedRow(), 5).toString());
//				txtABQty.setText( model.getValueAt(table.getSelectedRow(), 6).toString());
//				txtBName.setText(tblName);							
//				}
		});
		table.setBackground(new Color(95, 158, 160));
		scrollPane.setViewportView(table);
		
		table.setModel(model);
		
		JButton btnNewButton = new JButton("Search");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
    		DefaultTableModel ob=(DefaultTableModel) model;
			TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(model);
			table.setRowSorter(obj);
			obj.setRowFilter(RowFilter.regexFilter(txtsearch.getText()));
			}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(1031, 95, 116, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				AdminManagement admin=new AdminManagement();
				admin.setVisible(true);
				dispose();
			}
		});
		
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.setBounds(1157, 94, 116, 46);
		contentPane.add(btnNewButton_1);
		
		txtBName = new JTextField();
		txtBName.setBounds(179, 147, 236, 43);
		contentPane.add(txtBName);
		txtBName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name:");
		lblNewLabel_1.setBounds(31, 140, 168, 53);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtBAuthor = new JTextField();
		txtBAuthor.setBounds(179, 201, 236, 43);
		contentPane.add(txtBAuthor);
		txtBAuthor.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Author:");
		lblNewLabel_1_1.setBounds(31, 194, 168, 53);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtQty = new JTextField();
		txtQty.setBounds(179, 255, 236, 43);
		contentPane.add(txtQty);
		txtQty.setColumns(10);
		
		txtAQty = new JTextField();
		txtAQty.setColumns(10);
		txtAQty.setBounds(179, 309, 236, 43);
		contentPane.add(txtAQty);
		
		txtABQty = new JTextField();
		txtABQty.setColumns(10);
		txtABQty.setBounds(179, 477, 236, 43);
		contentPane.add(txtABQty);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Avaliable Order Qty:");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(9, 309, 169, 53);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Avaliable Borrow Qty:");
		lblNewLabel_1_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4_1.setBounds(0, 470, 178, 53);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Org Order Qty:");
		lblNewLabel_1_2.setBounds(22, 248, 132, 53);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_3 = new JLabel("Price:");
		lblNewLabel_1_3.setBounds(53, 357, 74, 53);
		contentPane.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_4 = new JLabel("Org Borrow Qty:");
		lblNewLabel_1_4.setBounds(10, 411, 144, 53);
		contentPane.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		txtPrice = new JTextField();
		txtPrice.setBounds(179, 364, 236, 43);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		txtBorrow = new JTextField();
		txtBorrow.setBounds(179, 418, 236, 43);
		contentPane.add(txtBorrow);
		txtBorrow.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(129, 542, 97, 47);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jOptionPane=new JOptionPane();
				String bname = txtBName.getText();
				String bauthor = txtBAuthor.getText();
				String AQty=txtAQty.getText();
				String ABQty=txtABQty.getText();
				String bbook = txtBorrow.getText();
                if (!bname.equals("") && !bauthor.equals("") && !txtQty.getText().equals("") && !txtPrice.getText().equals("")) {
					int qty = Integer.valueOf(txtQty.getText());
					int aqty=Integer.valueOf(AQty);
					double price = Double.valueOf(txtPrice.getText());
					int borrow=Integer.valueOf(bbook);
					int abqty=Integer.valueOf(ABQty);
					String url = "jdbc:mysql://localhost:3306/mydb";
					try {
						Connection con = DriverManager.getConnection(url, "root", "root");
						Statement st=con.createStatement();
						String query1="select*from addbooks";
						ResultSet rs=st.executeQuery(query1);
						boolean flag=false;
						while(rs.next()) {
							String bkname=rs.getString("BookName");
							if(bname.equals(bkname)) {
								flag=true;
								break;
							}
						}if(flag) {
							jOptionPane.setLocation(400, 50);
								jOptionPane.showMessageDialog(btnAdd, "There is a book with this name!");
						}else {
							String query2="insert into addbooks(BookName,Author,OrderQty,AvaOrderQty,Price,BorrowQty,AvaBorrowQty) values(?,?,?,?,?,?,?)";
							PreparedStatement ps = con.prepareStatement(query2);
							ps.setString(1, bname);
							ps.setString(2, bauthor);
							ps.setInt(3, qty);
							ps.setInt(4, aqty);
							ps.setInt(7, abqty);
							ps.setDouble(5, price);
							ps.setInt(6, borrow);
							ps.executeUpdate();
							JOptionPane.showMessageDialog(btnAdd, "Add Book Successful!");
						
						}
						
						} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(btnAdd, "Please fill complete information", "Warning Message", 1);
					}
				}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnAdd.setBackground(new Color(176, 196, 222));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBName.setText("");
				txtBAuthor.setText("");
				txtAQty.setText("");
				txtQty.setText("");
				txtPrice.setText("");
				txtBorrow.setText("");
				txtABQty.setText("");
			}
		});
		btnCancel.setBounds(305, 542, 97, 47);
		contentPane.add(btnCancel);
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCancel.setBackground(new Color(176, 196, 222));
		
		txtsearch = new JTextField();
		txtsearch.setBounds(875, 96, 146, 43);
		contentPane.add(txtsearch);
		txtsearch.setColumns(10);
		
		
		Object[] col= {"BookName","Author","OrderQty","AvaOrderQty","Price","BorrowQty","AvaBorrowQty"};
		model.setColumnIdentifiers(col);
		String url="jdbc:mysql://localhost:3306/mydb";
		Connection con=DriverManager.getConnection(url,"root","root");
		Statement st=con.createStatement();
		String query1="select * from addbooks";
		ResultSet rs=st.executeQuery(query1);
		while(rs.next()) {
			Object []row= {rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6),rs.getInt(7),rs.getInt(8)};
					model.addRow(row);	
			}
			
	}
}
