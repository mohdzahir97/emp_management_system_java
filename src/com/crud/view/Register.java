package com.crud.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.crud.database.CP;
import com.crud.model.Model;
import com.crud.service.EmployeeDao;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.crypto.AEADBadTagException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.io.InterruptedIOException;
import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_phone;
	private JTextField txt_address;
	private JTextField txt_city;
	private JTextField txt_country;
	private JTextField txt_state;
	private JTextField txt_age;
	private JTextField txt_email;
	private JTextField txt_aadharno;
	private JTextField txt_jobpost;
	private JTextField txt_pic_code;
	private JTable table_emp_data;
	private JTextField textFieldsearch;
	private JRadioButton radio_male,radio_female;
	private ButtonGroup r_group;
	
	
	public Register() {
		
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		
		setTitle("Employee Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1207, 694);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee Registration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setForeground(Color.BLACK);
		panel.setBounds(23, 80, 700, 562);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_search_1 = new JPanel();
		panel_search_1.setLayout(null);
		panel_search_1.setForeground(Color.BLACK);
		panel_search_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Modify Employee Data", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_search_1.setBackground(Color.LIGHT_GRAY);
		panel_search_1.setBounds(733, 571, 775, 71);
		contentPane.add(panel_search_1);
		
		JLabel lblNewLabel = new JLabel("Full Name:");
		lblNewLabel.setBounds(27, 27, 93, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		JLabel lbl_phone = new JLabel("Phone");
		lbl_phone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_phone.setBounds(27, 183, 93, 17);
		panel.add(lbl_phone);

		
		JLabel lbl_address = new JLabel("Address:");
		lbl_address.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_address.setBounds(27, 263, 93, 17);
		panel.add(lbl_address);
				
		JLabel lbl_city = new JLabel("City");
		lbl_city.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_city.setBounds(27, 323, 93, 17);
		panel.add(lbl_city);
	
		
		JLabel lbl_state = new JLabel("Satate");
		lbl_state.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_state.setBounds(27, 399, 93, 17);
		panel.add(lbl_state);
		
		JLabel lbl_country = new JLabel("Country");
		lbl_country.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_country.setBounds(354, 399, 93, 17);
		panel.add(lbl_country);	
		
		JLabel lbl_heading_1_1 = new JLabel("Employee Data");
		lbl_heading_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_heading_1_1.setForeground(new Color(0, 0, 0));
		lbl_heading_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_heading_1_1.setBounds(733, 65, 241, 35);
		contentPane.add(lbl_heading_1_1);
		
		JLabel lblpic_code = new JLabel("Pin Code");
		lblpic_code.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpic_code.setBounds(354, 312, 93, 38);
		panel.add(lblpic_code);
		
		JLabel lblaadharno = new JLabel("Aadhar No");
		lblaadharno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblaadharno.setBounds(354, 172, 93, 38);
		panel.add(lblaadharno);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblemail.setBounds(354, 100, 93, 38);
		panel.add(lblemail);
		
		JLabel lbl_age = new JLabel("Age");
		lbl_age.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_age.setBounds(354, 27, 93, 38);
		panel.add(lbl_age);
		
		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_gender.setBounds(27, 111, 93, 17);
		panel.add(lbl_gender);
		
		JLabel lbljobpost = new JLabel("Job Post");
		lbljobpost.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbljobpost.setBounds(354, 252, 93, 38);
		panel.add(lbljobpost);
		
		
		

		
		txt_name = new JTextField();
		txt_name.setToolTipText("Enter the Full Name");
		txt_name.setBounds(130, 33, 194, 32);
		panel.add(txt_name);
		txt_name.setColumns(10);
		
		txt_phone = new JTextField();
		txt_phone.setToolTipText("Enter The Number");
		txt_phone.setColumns(10);
		txt_phone.setBounds(130, 178, 196, 32);
		panel.add(txt_phone);
				
		txt_address = new JTextField();
		txt_address.setToolTipText("Enter The Address");
		txt_address.setColumns(10);
		txt_address.setBounds(130, 258, 194, 32);
		panel.add(txt_address);
		
		txt_city = new JTextField();
		txt_city.setToolTipText("Enter The City");
		txt_city.setColumns(10);
		txt_city.setBounds(130, 318, 194, 32);
		panel.add(txt_city);
		
		txt_state = new JTextField();
		txt_state.setToolTipText("Enter The Satate");
		txt_state.setColumns(10);
		txt_state.setBounds(130, 394, 194, 32);
		panel.add(txt_state);
		
		txt_country = new JTextField();
		txt_country.setToolTipText("Enter The Country");
		txt_country.setColumns(10);
		txt_country.setBounds(457, 394, 194, 32);
		panel.add(txt_country);
		
		
		r_group=new ButtonGroup();
		radio_male = new JRadioButton("Male");
		radio_male.setFont(new Font("Tahoma", Font.BOLD, 14));
		radio_male.setBounds(130, 109, 67, 21);
		panel.add(radio_male);
		
		radio_female = new JRadioButton("Female");
		radio_female.setFont(new Font("Tahoma", Font.BOLD, 14));
		radio_female.setBounds(238, 109, 85, 21);
		panel.add(radio_female);
		r_group.add(radio_male);r_group.add(radio_female);
//		radio_male.setSelected(true);
		
		
		
		txt_age = new JTextField();
		txt_age.setToolTipText("Enter the Full Name");
		txt_age.setColumns(10);
		txt_age.setBounds(457, 33, 194, 32);
		panel.add(txt_age);
		
		txt_email = new JTextField();
		txt_email.setToolTipText("Enter the Full Name");
		txt_email.setColumns(10);
		txt_email.setBounds(457, 106, 194, 32);
		panel.add(txt_email);
	
		
		  
		JLabel validate_aadharnum_2 = new JLabel("");
		validate_aadharnum_2.setHorizontalAlignment(SwingConstants.CENTER);
		validate_aadharnum_2.setForeground(Color.RED);
		validate_aadharnum_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		validate_aadharnum_2.setBounds(385, 209, 266, 21);
		panel.add(validate_aadharnum_2);
		
	
		txt_aadharno = new JTextField();
		txt_aadharno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {

					
				} catch (Exception e2) {
					
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
				    {  
						
				       System.out.println("backspace");
				    }
					
				} catch (Exception e2) {
					
				}
			}
		});
		txt_aadharno.setToolTipText("Enter the Full Name");
		txt_aadharno.setColumns(10);
		txt_aadharno.setBounds(457, 178, 194, 32);
		panel.add(txt_aadharno);
		
		txt_jobpost = new JTextField();
		txt_jobpost.setToolTipText("Enter the Full Name");
		txt_jobpost.setColumns(10);
		txt_jobpost.setBounds(457, 258, 194, 32);
		panel.add(txt_jobpost);
		
	
		JLabel validate_pinnum = new JLabel("");
		validate_pinnum.setHorizontalAlignment(SwingConstants.CENTER);
		validate_pinnum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		validate_pinnum.setForeground(Color.RED);
		validate_pinnum.setBounds(457, 357, 194, 21);
		
		panel.add(validate_pinnum);
		txt_pic_code = new JTextField();
		txt_pic_code.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					int i=Integer.parseInt(txt_pic_code.getText());	
					validate_pinnum.setText("");
				} catch (Exception e2) {
					validate_pinnum.setText("This field accept only number");
					
				}
			}
		});
		txt_pic_code.setToolTipText("Enter the Full Name");
		txt_pic_code.setColumns(10);
		txt_pic_code.setBounds(457, 318, 194, 32);
		panel.add(txt_pic_code);
		
		JPanel panel_search = new JPanel();
		panel_search.setForeground(Color.BLACK);
		panel_search.setBorder(new TitledBorder(null, "Search", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel_search.setBackground(Color.LIGHT_GRAY);
		panel_search.setBounds(266, 466, 435, 71);
		panel.add(panel_search);
		panel_search.setLayout(null);
		
	
		
		textFieldsearch = new JTextField();
		textFieldsearch.setToolTipText("Enter The Satate");
		textFieldsearch.setColumns(10);
		textFieldsearch.setBounds(131, 24, 262, 32);
		panel_search.add(textFieldsearch);
		
		JLabel lbl_empid = new JLabel("Emp Id");
		lbl_empid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_empid.setBounds(22, 33, 93, 17);
		panel_search.add(lbl_empid);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setToolTipText("");
		scrollPane.setBounds(733, 115, 775, 435);
		contentPane.add(scrollPane);
		
		table_emp_data = new JTable();
		scrollPane.setViewportView(table_emp_data);
		
		JLabel lbl_heading_1 = new JLabel("Employee Management System");
		lbl_heading_1.setForeground(new Color(199, 21, 133));
		lbl_heading_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_heading_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbl_heading_1.setBounds(23, 10, 481, 60);
		contentPane.add(lbl_heading_1);
		
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				try {
					if(e.getSource()==btn_save) {
						
						Model m=new Model();
						String fname=txt_name.getText();
						String phonString=txt_phone.getText();
						
						String male=radio_male.getText();
						String female=radio_female.getText();
						
						String addressString=txt_address.getText();
						String cityString=txt_city.getText();
						String stateString=txt_state.getText();
						String countryString=txt_country.getText();
						String eemail=txt_email.getText();
						String ejob=txt_jobpost.getText();
						String eaadhar=txt_aadharno.getText();
						String eage=txt_age.getText();
						String epic_code=txt_pic_code.getText();
						
					
						m.setEname(fname);m.setEphone(phonString);
						
						if (radio_male.isSelected()) {
							m.setEgender(male);
							
						}else if (radio_female.isSelected()) {
							
							m.setEgender(female);
						}
					
						m.setEaddress(addressString);m.setEcity(cityString);m.setEstate(stateString);m.setEcountry(countryString);
						m.setEemail(eemail);m.setEpic_code(epic_code);m.setEage(eage);m.setEjob(ejob);m.setEaadhar(eaadhar);
						
						if (new EmployeeDao().checkEmilExits(m)) {
							JOptionPane.showMessageDialog(null, "This Email Id Already Exits...");		
						}else {
							if(new EmployeeDao().insertEmpRecord(m)) {
								JOptionPane.showMessageDialog(null, "Employee Registration Successfull....");
								show_table_data();
							}else {
								JOptionPane.showMessageDialog(null, "Sorry Employee Registration Unsuccessfull....");
							}	
							
						}
									
				}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
					
			}
		});
		btn_save.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_save.setBounds(27, 485, 85, 32);
		panel.add(btn_save);
		
		
		
		JButton btn_exit = new JButton("Exit");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==btn_exit) {
					try {
						int a=JOptionPane.showConfirmDialog(null, "Are you sure?");
						if (a==JOptionPane.YES_OPTION) {
							System.exit(0);
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});

		btn_exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_exit.setBounds(161, 485, 85, 32);
		panel.add(btn_exit);
		
		JLabel validate_aadharnum_1 = new JLabel("");
		validate_aadharnum_1.setHorizontalAlignment(SwingConstants.CENTER);
		validate_aadharnum_1.setForeground(Color.RED);
		validate_aadharnum_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		validate_aadharnum_1.setBounds(437, 267, 194, 21);
		panel.add(validate_aadharnum_1);
		
	
		
	
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()== btn_update) {
					try {
						Model m=new Model();
						String fname=txt_name.getText();
						String phonString=txt_phone.getText();
						
						String male=radio_male.getText();
						String female=radio_female.getText();
						
						String addressString=txt_address.getText();
						String cityString=txt_city.getText();
						String stateString=txt_state.getText();
						String countryString=txt_country.getText();
						String eemail=txt_email.getText();
						String ejob=txt_jobpost.getText();
						String eaadhar=txt_aadharno.getText();
						String eage=txt_age.getText();
						String epic_code=txt_pic_code.getText();
						String emp_id=textFieldsearch.getText();
						
					
						
						
						m.setEname(fname);m.setEphone(phonString);m.setEmp_id(emp_id);
						if (radio_male.isSelected()) {
							m.setEgender(male);
						
						}else if (radio_female.isSelected()) {
						
							m.setEgender(female);
						}
						m.setEaddress(addressString);m.setEcity(cityString);m.setEstate(stateString);m.setEcountry(countryString);
						m.setEemail(eemail);m.setEpic_code(epic_code);m.setEage(eage);m.setEjob(ejob);m.setEaadhar(eaadhar);
					
						try {
							int a=JOptionPane.showConfirmDialog(null, "Are you sure to update this employee record?");
							if (a==JOptionPane.YES_OPTION) {
								if(new EmployeeDao().updateEmpData(m)) {
									JOptionPane.showMessageDialog(null, "Data Updated Sucessfully...");
								
									
									
									txt_name.setText("");
									txt_phone.setText("");
									txt_aadharno.setText("");
									txt_address.setText(""); txt_age.setText("");
									txt_city.setText("");txt_country.setText("");txt_state.setText("");; 
									txt_email.setText("");txt_aadharno.setText("");
									txt_jobpost.setText("");txt_pic_code.setText("");
									textFieldsearch.setText("");
								
									show_table_data();
								}else {
									JOptionPane.showMessageDialog(null, "Data NOT Updated...");
									
								}

							}
							
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						
						
												
					} catch (Exception e2) {
						e2.printStackTrace();
						
					}
				}
			}
		});
		btn_update.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_update.setBounds(23, 25, 98, 25);
		panel_search_1.add(btn_update);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Model m=new Model();
					String emp_id=textFieldsearch.getText();
					m.setEmp_id(emp_id);
					try {
						int a=JOptionPane.showConfirmDialog(null, "Are you sure to delete this employee details?");
						if (a==JOptionPane.YES_OPTION) {
							if(new EmployeeDao().delelteEmpData(m)) {
								
								JOptionPane.showMessageDialog(null, "Employee Data Deleted Successfully...");
								show_table_data();
								txt_name.setText("");
								txt_phone.setText("");
								txt_aadharno.setText("");
								txt_address.setText(""); txt_age.setText("");
								txt_city.setText("");txt_country.setText("");txt_state.setText("");; 
								txt_email.setText("");txt_aadharno.setText("");
								txt_jobpost.setText("");txt_pic_code.setText("");
								textFieldsearch.setText("");
								
					
							}else {
								JOptionPane.showMessageDialog(null, "Employee Data NOT Deleted...");
								
							}
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_delete.setBounds(170, 25, 98, 25);
		panel_search_1.add(btn_delete);
		
		JButton btn_delete_all = new JButton("Delete All Data");
		btn_delete_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int a=JOptionPane.showConfirmDialog(null, "Are you sure to Delete All Data?");
					if (a==JOptionPane.YES_OPTION) {
						if (new EmployeeDao().deleteAllData()) {
							JOptionPane.showMessageDialog(null, "All Data Deleted Sucessfully...");
							show_table_data();
							txt_name.setText("");
							txt_phone.setText("");
							txt_aadharno.setText("");
							txt_address.setText(""); txt_age.setText("");
							txt_city.setText("");txt_country.setText("");txt_state.setText("");; 
							txt_email.setText("");txt_aadharno.setText("");
							txt_jobpost.setText("");txt_pic_code.setText("");
							textFieldsearch.setText("");
						}else {
							JOptionPane.showMessageDialog(null, "Not Deleted All Data...");
						}	
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btn_delete_all.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_delete_all.setBounds(311, 25, 154, 25);
		panel_search_1.add(btn_delete_all);
		
		
		
		

		
		
		textFieldsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Connection con=CP.conProvider();
					
					String id=textFieldsearch.getText();
					
					String q="select * from emp where id=?";
					
					PreparedStatement pst=con.prepareStatement(q);
					pst.setString(1, id);
					
					ResultSet set=pst.executeQuery();
					if (set.next()) {
						int eid=set.getInt(1);
						String name=set.getString(2);
						String phone=set.getString(3);
						String address=set.getString(4);
						String gender=set.getString(5);
						String city=set.getString(6);
						String state=set.getString(7);
						String country=set.getString(8);
						String age=set.getString(9);
						String email=set.getString(10);
						String jobpost=set.getString(11);
						String aadharno=set.getString(12);
						String pin_code=set.getString(13);
						
					
						txt_name.setText(name);
						txt_phone.setText(phone);
						
						if(gender.equalsIgnoreCase("Male")) {
							radio_male.setSelected(true);
						}else if (gender.equalsIgnoreCase("Female")) {
							radio_female.setSelected(true);
						}
						
						txt_aadharno.setText(aadharno);txt_address.setText(address); txt_age.setText(age);
						txt_city.setText(city);txt_country.setText(country);txt_state.setText(state); 
						txt_email.setText(email);txt_aadharno.setText(aadharno);
						txt_jobpost.setText(jobpost);txt_pic_code.setText(pin_code);

					}else {
						JOptionPane.showMessageDialog(null, "Record Not Found....");
						txt_name.setText("");
						txt_phone.setText("");
						txt_aadharno.setText("");
						txt_address.setText(""); txt_age.setText("");
						txt_city.setText("");txt_country.setText("");txt_state.setText("");; 
						txt_email.setText("");txt_aadharno.setText("");
						txt_jobpost.setText("");txt_pic_code.setText("");
						radio_female.setSelected(false);
						radio_male.setSelected(false);
					}

					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

	}
	
	public void show_table_data() {
		try {
			Connection con=CP.conProvider();
			String q="select * from emp";
			PreparedStatement pst=con.prepareStatement(q);
			ResultSet set=pst.executeQuery();
			
			table_emp_data.setModel(DbUtils.resultSetToTableModel(set));
			
			table_emp_data.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						DefaultTableModel temp_table=(DefaultTableModel)table_emp_data.getModel();
						int selected_row=table_emp_data.getSelectedRow();
						
						textFieldsearch.setText(temp_table.getValueAt(selected_row, 0).toString());
						txt_name.setText(temp_table.getValueAt(selected_row, 1).toString());
						txt_phone.setText(temp_table.getValueAt(selected_row, 2).toString());
						txt_address.setText(temp_table.getValueAt(selected_row, 3).toString());
						

					
						if (temp_table.getValueAt(selected_row, 4).toString().equalsIgnoreCase("Male")) {
							radio_male.setSelected(true);
						}else if (temp_table.getValueAt(selected_row, 4).toString().equalsIgnoreCase("Female")) {
							radio_female.setSelected(true);
						}
						
						txt_city.setText(temp_table.getValueAt(selected_row, 5).toString());
						txt_state.setText(temp_table.getValueAt(selected_row, 6).toString());
						txt_country.setText(temp_table.getValueAt(selected_row, 7).toString());
						txt_age.setText(temp_table.getValueAt(selected_row, 8).toString()); 
						txt_email.setText(temp_table.getValueAt(selected_row, 9).toString());
						txt_jobpost.setText(temp_table.getValueAt(selected_row, 10).toString());
						txt_aadharno.setText(temp_table.getValueAt(selected_row, 11).toString());	
						txt_pic_code.setText(temp_table.getValueAt(selected_row, 12).toString());
						
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
					frame.show_table_data();
					
				} catch (Exception e) {
					System.out.println("hello main");
					e.printStackTrace();
				}
			}
		});
	}
}







































