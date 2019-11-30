package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Button;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerList extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerList frame = new CustomerList();
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
	public CustomerList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 774);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 204, 204));
		panel.setBounds(0, 0, 1006, 123);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CustomerList.class.getResource("/Admin/Logo_164x97.png")));
		label.setBounds(12, 13, 164, 97);
		panel.add(label);
		
		textField = new JTextField();
		textField.setText("MediCrest");
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(new Color(153, 204, 204));
		textField.setBounds(227, 13, 180, 45);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText(" Live healthy. Live happy. Live Longs.");
		textField_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(153, 204, 204));
		textField_1.setBounds(188, 63, 243, 37);
		panel.add(textField_1);
		
		Button button = new Button("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_admin logout=new Login_admin();
				logout.setVisible(true);
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(915, 10, 81, 30);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(0, 121, 1006, 51);
		contentPane.add(panel_1);
		
		Button button_1 = new Button("Customer List");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerList list=new CustomerList();
				list.setVisible(true);
			}
		});
		button_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(253, 10, 200, 31);
		panel_1.add(button_1);
		
		Button button_2 = new Button("Medicines Stock");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medicines_Stock stock=new Medicines_Stock();
				stock.setVisible(true);
			}
		});
		button_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(514, 10, 200, 31);
		panel_1.add(button_2);
		
		Button button_3 = new Button("Order Details");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order_details order=new Order_details();
				order.setVisible(true);
			}
		});
		button_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(772, 10, 211, 31);
		panel_1.add(button_3);
		
		Button button_4 = new Button("Home");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Home_page home=new Home_page();
					home.setVisible(true);
			}
		});
		button_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(26, 10, 187, 30);
		panel_1.add(button_4);
		
		textField_2 = new JTextField();
		textField_2.setText("                                                                                       Copyright@2019 Piyush Gautam All Right Reserved  ");
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(153, 204, 204));
		textField_2.setBounds(2, 694, 1004, 27);
		contentPane.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 170, 1006, 523);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(178, 92, 655, 373);
		panel_2.add(scrollPane_1);
		
		Button List = new Button("Load Customer List");
		List.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2085");
					PreparedStatement ps=con.prepareStatement("Select *from User_details;");
			
					
					
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		List.setBounds(381, 32, 238, 33);
		panel_2.add(List);
		
		table = new JTable();
		table.setBounds(178, 465, 655, -375);
		panel_2.add(table);
	}
}
