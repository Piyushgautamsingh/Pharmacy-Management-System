package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order_details extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_details frame = new Order_details();
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
	public Order_details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 121, 1006, 51);
		contentPane.add(panel);
		
		Button button = new Button("Customer List");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerList list=new CustomerList();
				Medicines_Stock stock=new Medicines_Stock();
				list.setVisible(true);
				stock.setVisible(false);
			}
		});
		button.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(253, 10, 200, 31);
		panel.add(button);
		
		Button button_1 = new Button("Medicines Stock");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medicines_Stock stock=new Medicines_Stock();
				stock.setVisible(false);
				stock.setVisible(true);
			}
		});
		button_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(514, 10, 200, 31);
		panel.add(button_1);
		
		Button button_2 = new Button("Order Details");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order_details order=new Order_details();
				order.setVisible(true);
			}
		});
		button_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(772, 10, 211, 31);
		panel.add(button_2);
		
		Button button_3 = new Button("Home");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_page home=new Home_page();
				home.setVisible(true);
			}
		});
		button_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(26, 10, 187, 30);
		panel.add(button_3);
		
		textField = new JTextField();
		textField.setText("                                                                                       Copyright@2019 Piyush Gautam All Right Reserved  ");
		textField.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBackground(new Color(153, 204, 204));
		textField.setBounds(0, 703, 1004, 27);
		contentPane.add(textField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 204, 204));
		panel_1.setBounds(0, 0, 1006, 123);
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Order_details.class.getResource("/Admin/Logo_164x97.png")));
		label.setBounds(12, 13, 164, 97);
		panel_1.add(label);
		
		textField_1 = new JTextField();
		textField_1.setText("MediCrest");
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(153, 204, 204));
		textField_1.setBounds(227, 13, 180, 45);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText(" Live healthy. Live happy. Live Longs.");
		textField_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(153, 204, 204));
		textField_2.setBounds(188, 63, 243, 37);
		panel_1.add(textField_2);
		
		Button button_4 = new Button("Logout");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_admin logout=new Login_admin();
				logout.setVisible(true);
			}
		});
		button_4.setForeground(Color.RED);
		button_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(869, 10, 81, 30);
		panel_1.add(button_4);
	}
}
