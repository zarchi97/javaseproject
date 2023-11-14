package project;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Accounttable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accounttable frame = new Accounttable();
					frame.setVisible(true);
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
	public Accounttable() throws SQLException {
		

		
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 826, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(0, 139, 139));
		scrollPane.setViewportView(table);
		

		model=new DefaultTableModel();
	    
				
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				AdminManagement admin=new AdminManagement();
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(173, 216, 230));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(757, 414, 79, 33);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("View Member");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(312, 11, 233, 51);
		contentPane.add(lblNewLabel);

	
//		
		
		JComboBox combo1 = new JComboBox();
			combo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=String.valueOf(combo1.getSelectedItem());				
				
				model.setRowCount(0);
				
				String url="jdbc:mysql://localhost:3306/mydb";
				Connection con;
				try {
					con = DriverManager.getConnection(url,"root","root");
					
					Statement st=con.createStatement();
					String query="select * from account where name ='"+name+"' ";
					ResultSet rs=st.executeQuery(query);
					
					
					while(rs.next()) {
						String id=rs.getString(1);
						String name1=rs.getString(2);
						int ph=rs.getInt(3);
						String email=rs.getString(4);
						String pass=rs.getString(5);
						
						Object[] row = {id,name1,ph,email,pass};
						model.addRow(row);
						
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
		});
		combo1.setSelectedIndex(-1);
		combo1.setBounds(717, 79, 119, 33);
		contentPane.add(combo1);
		
		
		String url="jdbc:mysql://localhost:3306/mydb";
		Connection con1=DriverManager.getConnection(url,"root","root");
		Statement st1=con1.createStatement();
		String qurey1="select name from account";
		ResultSet rs1=st1.executeQuery(qurey1);
		
		//int rowCount = 0;
		Vector<String> nlist = new Vector<>();
		while (rs1.next()) {
			String uname = rs1.getString("name");
			nlist.add(uname);
		}
		combo1.setModel(new DefaultComboBoxModel<>(nlist));
		
		
		
		JButton btnNewButton_1 = new JButton("View All");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] col= {"ID","Name","Phone Number","Email","Password"};
				model.setColumnIdentifiers(col);
				
				table.setModel(model);
				model.setRowCount(0);
				
				String url="jdbc:mysql://localhost:3306/mydb";
				Connection con;
				try {
					con = DriverManager.getConnection(url,"root","root");
					
					Statement st=con.createStatement();
					String query="select * from account";
					ResultSet rs=st.executeQuery(query);
					
					
					while(rs.next()) {
						String id=rs.getString(1);
						String name=rs.getString(2);
						int ph=rs.getInt(3);
						String email=rs.getString(4);
						String pass=rs.getString(5);
						
						Object[] row = {id,name,ph,email,pass};
						model.addRow(row);
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
				
			
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(608, 79, 99, 33);
		contentPane.add(btnNewButton_1);


		
	}
	private void Show() {

	}
}
