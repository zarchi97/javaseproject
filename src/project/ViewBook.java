package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.beancontext.BeanContextServiceAvailableEvent;

public class ViewBook extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private int n;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBook frame = new ViewBook();
					frame.setVisible(true);
					frame.setLocation(80, 80);
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
	public ViewBook() throws SQLException {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1141, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         
		JLabel lblNewLabel = new JLabel("View Books");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(445, 11, 244, 45);
		contentPane.add(lblNewLabel);
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 model = new DefaultTableModel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 1106, 366);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(95, 158, 160));
		scrollPane.setViewportView(table);
		table.setModel(model);
		String url="jdbc:mysql://localhost:3306/mydb";
		Connection con = null ;
		try {
			con = DriverManager.getConnection(url,"root","root");
			Statement st=con.createStatement();
			String query4="select * from addbooks";
			ResultSet rs=st.executeQuery(query4);
			int rowCount=0;
			Vector<String>list=new Vector<>();
			boolean flag=false;
			while(rs.next()) {
				String bkname=rs.getString("BookName");
				list.add(bkname);
				Object bknmae = null;
				
				}
		
			} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("<<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				ForUser user = new ForUser();
				user.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(1027, 503, 89, 36);
		contentPane.add(btnNewButton);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(model);
				table.setRowSorter(obj);
				obj.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
			}
		});
		txtSearch.setBounds(998, 77, 118, 36);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
	Object[] col = { "BookName", "Author", "OrderQty","Available OrderQty" ,"Price", "BorrowQty","Available BorrowQty" };
	model.setColumnIdentifiers(col);
	//String url = "jdbc:mysql://localhost:3306/mydb";
	//Connection con = DriverManager.getConnection(url, "root", "root");
	Statement st = con.createStatement();
	String query1 = "select * from addbooks";
	ResultSet rs = st.executeQuery(query1);
	while(rs.next())
	{
		Object[] row = { rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getDouble(6), rs.getInt(7),rs.getInt(8)};
		model.addRow(row);

	}
}
}
