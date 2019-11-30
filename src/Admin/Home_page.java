package Admin;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Label;

public class Home_page extends JFrame {

	private JPanel contentPane;
	private JTextField txtMedicrest;
	private JTextField txtLiv;
	private JTextField txtCopyrightPiyushGautam;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page frame = new Home_page();
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
	public Home_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 204));
		panel.setBounds(0, 0, 1006, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home_page.class.getResource("/Admin/Logo_164x97.png")));
		label.setBounds(12, 13, 164, 97);
		panel.add(label);
		
		txtMedicrest = new JTextField();
		txtMedicrest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_page home=new Home_page();
				home.setVisible(true);
			}
		});
		txtMedicrest.setEditable(false);
		txtMedicrest.setBackground(new Color(153, 204, 204));
		txtMedicrest.setForeground(new Color(0, 0, 0));
		txtMedicrest.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		txtMedicrest.setText("MediCrest");
		txtMedicrest.setBounds(227, 13, 180, 45);
		panel.add(txtMedicrest);
		txtMedicrest.setColumns(10);
		
		txtLiv = new JTextField();
		txtLiv.setEditable(false);
		txtLiv.setBackground(new Color(153, 204, 204));
		txtLiv.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		txtLiv.setText(" Live healthy. Live happy. Live Longs.");
		txtLiv.setBounds(188, 63, 243, 37);
		panel.add(txtLiv);
		txtLiv.setColumns(10);
		
		Button Logout = new Button("Logout");
		Logout.setBackground(Color.WHITE);
		Logout.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		Logout.setForeground(Color.RED);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_admin logout=new Login_admin();
				logout.setVisible(true);
			}
		});
		Logout.setBounds(915, 10, 81, 30);
		panel.add(Logout);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(0, 121, 1006, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Button button = new Button("Customer List");
		button.setBackground(new Color(255, 255, 255));
		button.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button.setBounds(253, 10, 200, 31);
		panel_1.add(button);
		
		Button button_1 = new Button("Medicines Stock");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medicines_Stock stock=new Medicines_Stock();
				stock.setVisible(true);
			}
		});
		button_1.setBackground(new Color(255, 255, 255));
		button_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_1.setBounds(508, 10, 200, 31);
		panel_1.add(button_1);
		
		Button button_2 = new Button("Order Details");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order_details order=new Order_details();
				order.setVisible(true);
			}
		});
		button_2.setBackground(new Color(255, 255, 255));
		button_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		button_2.setBounds(772, 10, 211, 31);
		panel_1.add(button_2);
		
		Button home_1 = new Button("Home");
		home_1.setBackground(Color.WHITE);
		home_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		home_1.setBounds(26, 10, 187, 30);
		panel_1.add(home_1);
		home_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_page home=new Home_page();
				home.setVisible(true);
			}
		});
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(871, 196, -753, 417);
		contentPane.add(desktopPane);
		
		txtCopyrightPiyushGautam = new JTextField();
		txtCopyrightPiyushGautam.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		txtCopyrightPiyushGautam.setBackground(new Color(153, 204, 204));
		txtCopyrightPiyushGautam.setText("                                                                                       Copyright@2019 Piyush Gautam All Right Reserved  ");
		txtCopyrightPiyushGautam.setBounds(2, 694, 1004, 27);
		contentPane.add(txtCopyrightPiyushGautam);
		txtCopyrightPiyushGautam.setColumns(10);
		
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textArea.setText("Medicrest Ltd have a care portfolio of homely facilities, \r\nlocated in Bihar and UP, that offer a variety of care packages \r\nto suit the personal care needs of their elderly residents.\r\nThe services are set up to respect the independence\r\n of service users, while ensuring they feel confident\r\n and secure in their lifestyles.\r\nwe make a wide range of prescription medicines and\r\n other health products conveniently available all across India.\r\n Even second and third tier cities and rural villages can now \r\nhave access to the latest medicines. Since we also offer\r\nalternatives to most medicines, online buyers can expect\r\n significant savings.\r\n\r\n\r\nCONVENIENCE\r\n\r\nHeavy traffic, lack of parking, monsoons, shop closed, \r\nforgetfulness\u2026 these are some of the reasons that \r\ncould lead to skipping of vital medications.\r\n Since taking medicines regularly is a critical \r\ncomponent of managing chronic medical conditions,\r\n it\u2019s best not to run out of essential medicines.\r\n Just log on to netmeds.com, place your order online \r\nand have your medicines delivered to you \u2013 without leaving \r\nthe comfort of your home.");
		textArea.setBounds(467, 298, 516, 350);
		contentPane.add(textArea);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home_page.class.getResource("/Admin/Logo_164x97.png")));
		label_1.setBounds(34, 228, 187, 191);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setText("MediCrest");
		textField_2.setForeground(Color.BLACK);
		textField_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setBounds(608, 230, 180, 45);
		contentPane.add(textField_2);
		
		JLabel lblMedicrest = new JLabel("MediCrest");
		lblMedicrest.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		lblMedicrest.setBounds(258, 270, 102, 66);
		contentPane.add(lblMedicrest);
		
		JLabel lblLiveHealthyLive = new JLabel(" Live healthy. Live happy. Live Longs.");
		lblLiveHealthyLive.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblLiveHealthyLive.setBounds(203, 338, 229, 27);
		contentPane.add(lblLiveHealthyLive);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Piyush Gautham\\Desktop\\hearing-aid-blue-pills-background-medical-pharmacy-healthcare-concept-copy-space-empty-place-text-logo-156259800.jpg"));
		label_2.setBounds(22, 207, 426, 474);
		contentPane.add(label_2);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerList list=new CustomerList();
				list.setVisible(true);
			}
		});
	}
}