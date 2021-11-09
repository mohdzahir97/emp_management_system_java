package com.crud.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.crud.model.Model;
import com.crud.service.EmployeeDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username_login;
	private JPasswordField txt_password_login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(42, 42, 860, 464);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(87, 25, 657, 116);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEmployeeManagementSystem = new JLabel("Employee Management System");
		lblEmployeeManagementSystem.setBackground(Color.WHITE);
		lblEmployeeManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeManagementSystem.setBounds(180, 10, 298, 39);
		panel_1.add(lblEmployeeManagementSystem);
		lblEmployeeManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblAdminLoginPanel = new JLabel("Admin Login Panel");
		lblAdminLoginPanel.setBounds(180, 59, 298, 39);
		panel_1.add(lblAdminLoginPanel);
		lblAdminLoginPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLoginPanel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdminLoginPanel.setBackground(Color.WHITE);
		
		JLabel lblusername = new JLabel("UserName");
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblusername.setBounds(85, 172, 121, 39);
		panel.add(lblusername);
		
		JLabel lbluserpass = new JLabel("Password");
		lbluserpass.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbluserpass.setBounds(87, 245, 133, 39);
		panel.add(lbluserpass);
		
		txt_username_login = new JTextField();
		txt_username_login.setBounds(284, 174, 460, 39);
		panel.add(txt_username_login);
		txt_username_login.setColumns(10);
		
		txt_password_login = new JPasswordField();
		txt_password_login.setColumns(10);
		txt_password_login.setBounds(284, 247, 460, 39);
		panel.add(txt_password_login);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					
						String adminname=txt_username_login.getText();
						String adminpassword=txt_password_login.getText();
						Model m=new Model();
						m.setAdminname(adminname);m.setAdminpass(adminpassword);
						if(new EmployeeDao().validAdmin(m)) {
							Register showRegFrame=new Register();
							showRegFrame.setVisible(true);
							showRegFrame.show_table_data();
							dispose();
							
							
						}else {
							JOptionPane.showMessageDialog(null, "UserName and Password is Incorect....");
						}
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(87, 316, 133, 39);
		panel.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a=JOptionPane.showConfirmDialog(null, "Are you sure?");
					if (a==JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnCancel.setBounds(284, 316, 133, 39);
		panel.add(btnCancel);
	}
}

//package com.crud.view;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import com.crud.model.Model;
//import com.crud.service.EmployeeDao;
//import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;
//
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//
//import java.awt.Font;
//import javax.swing.SwingConstants;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Color;
//import java.awt.SystemColor;
//
//class LoginDemo extends JFrame{
//	
//	private JPanel contentPane;
//	private JTextField txt_username_login;
//	private JTextField txt_password_login;
//	
//
//
//	public LoginDemo() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 802, 612);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JPanel login_panel = new JPanel();
//		login_panel.setBackground(Color.LIGHT_GRAY);
//		login_panel.setForeground(Color.WHITE);
//		login_panel.setBounds(430, 79, 606, 423);
//		contentPane.add(login_panel);
//		login_panel.setLayout(null);
//		
//		JLabel lbl_username_login = new JLabel("UserName");
//		lbl_username_login.setFont(new Font("Tahoma", Font.BOLD, 16));
//		lbl_username_login.setHorizontalAlignment(SwingConstants.LEFT);
//		lbl_username_login.setBounds(98, 116, 105, 50);
//		login_panel.add(lbl_username_login);
//		
//		JLabel lbl_password_login = new JLabel("Password");
//		lbl_password_login.setHorizontalAlignment(SwingConstants.LEFT);
//		lbl_password_login.setFont(new Font("Tahoma", Font.BOLD, 16));
//		lbl_password_login.setBounds(98, 217, 125, 50);
//		login_panel.add(lbl_password_login);
//		
//		txt_username_login = new JTextField();
//		txt_username_login.setBounds(298, 119, 225, 50);
//		login_panel.add(txt_username_login);
//		txt_username_login.setColumns(10);
//		
//		txt_password_login = new JTextField();
//		txt_password_login.setColumns(10);
//		txt_password_login.setBounds(298, 220, 225, 50);
//		login_panel.add(txt_password_login);
//		
//		JButton btn_adminlogin = new JButton("Login");
//		btn_adminlogin.setBackground(new Color(102, 205, 170));
//		btn_adminlogin.setForeground(Color.WHITE);
//		btn_adminlogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//				
//					String adminname=txt_username_login.getText();
//					String adminpassword=txt_password_login.getText();
//					Model m=new Model();
//					m.setAdminname(adminname);m.setAdminpass(adminpassword);
//					if(new EmployeeDao().validAdmin(m)) {
//						Register showRegFrame=new Register();
//						showRegFrame.setVisible(true);
//						showRegFrame.show_table_data();
//						dispose();
//						
//						
//					}else {
//						JOptionPane.showMessageDialog(null, "UserName and Password is Incorect....");
//					}
//					
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		btn_adminlogin.setFont(new Font("Tahoma", Font.BOLD, 16));
//		btn_adminlogin.setBounds(98, 316, 120, 40);
//		login_panel.add(btn_adminlogin);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(204, 153, 204));
//		panel.setBounds(95, 30, 428, 58);
//		login_panel.add(panel);
//		panel.setLayout(null);
//		
//		JLabel lbl_admin_login = new JLabel("Admin Login");
//		lbl_admin_login.setBounds(153, 10, 115, 38);
//		lbl_admin_login.setHorizontalAlignment(SwingConstants.CENTER);
//		lbl_admin_login.setFont(new Font("Tahoma", Font.BOLD, 18));
//		lbl_admin_login.setBackground(Color.WHITE);
//		panel.add(lbl_admin_login);
//		
//		JButton btn_adminlogin_1 = new JButton("Cancel");
//		btn_adminlogin_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					int a=JOptionPane.showConfirmDialog(null, "Are you sure?");
//					if (a==JOptionPane.YES_OPTION) {
//						System.exit(0);
//					}
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		});
//		btn_adminlogin_1.setForeground(Color.WHITE);
//		btn_adminlogin_1.setFont(new Font("Tahoma", Font.BOLD, 16));
//		btn_adminlogin_1.setBackground(new Color(102, 205, 170));
//		btn_adminlogin_1.setBounds(298, 316, 120, 40);
//		login_panel.add(btn_adminlogin_1);
//	}
//}
//
//
//public class Login{
//
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginDemo frame = new LoginDemo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	
//}
