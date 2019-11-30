package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JEditorPane;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.DropMode;

import java.awt.CardLayout;

public class Login_admin extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_admin frame = new Login_admin();
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
	public Login_admin(){
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1231, 683);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(621, 0, 592, 636);
		contentPane.add(panel);
		panel.setLayout(null);
		
		userid = new JTextField();
		userid.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		userid.setBounds(208, 260, 286, 45);
		panel.add(userid);
		userid.setColumns(10);
		
		JTextPane txtpnUserId = new JTextPane();
		txtpnUserId.setEditable(false);
		txtpnUserId.setBackground(Color.WHITE);
		txtpnUserId.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		txtpnUserId.setText("User ID");
		txtpnUserId.setBounds(95, 267, 89, 38);
		panel.add(txtpnUserId);
		
		Button button = new Button("Sign in");
		button.setActionCommand("Sign in");
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		button.setBackground(new Color(255, 99, 71));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				String User_id= userid.getText();
				String Password=password.getText();
				if(User_id.equals("Piyush")& Password.equals("2085"))
				{
					Home_page home =new Home_page();
					home.setVisible(true);
					
				}
				else
				{
					Login_admin Login=new Login_admin();
					JOptionPane.showMessageDialog(Login,"Invalid Login");
				}
			
			}
		});
		button.setBounds(249, 475, 184, 45);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Login_admin.class.getResource("/Admin/a_p3.jpg")));
		lblNewLabel.setBounds(249, 38, 184, 185);
		panel.add(lblNewLabel);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("Password");
		textPane_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		textPane_2.setEditable(false);
		textPane_2.setBackground(Color.WHITE);
		textPane_2.setBounds(95, 358, 89, 45);
		panel.add(textPane_2);
		
		password = new JPasswordField();
		password.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		password.setBounds(208, 358, 287, 45);
		panel.add(password);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(281, 77, 56, 16);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(0, 0, 620, 636);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(29, -56, 844, 712);
		panel_1.add(label);
		label.setBackground(new Color(255, 255, 255));
		label.setIcon(new ImageIcon(Login_admin.class.getResource("/Admin/a-P2.jpg")));
	}
}
