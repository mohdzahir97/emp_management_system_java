package com.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.crud.database.CP;
import com.crud.model.Model;

public class EmployeeDao {
	Connection con;
	
//	deleteAllData
	
	
	public boolean deleteAllData() {
		boolean flag=false;
		try {
			con=CP.conProvider();
			String quString="truncate table emp";
			PreparedStatement pst=con.prepareStatement(quString);	
		    int i =pst.executeUpdate();
		    if (i==0) {
				flag=true;
			}else {
				flag=false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return flag;
	}
	
	public boolean checkEmilExits(Model m) {
		boolean flag=false;
		try {
			con=CP.conProvider();
			String email=m.getEemail();
			
			String quString="select * from emp where email=?";
			PreparedStatement pst=con.prepareStatement(quString);
			pst.setString(1, email);
		    ResultSet set =pst.executeQuery();
		    if (set.next()) {
				flag=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	
	public boolean insertEmpRecord(Model m) {
		boolean flag=false;
		try {
			con=CP.conProvider();
			String name=m.getEname();
			String phone=m.getEphone();
			String address=m.getEaddress();
			String gender=m.getEgender();
			String city=m.getEcity();
			String state=m.getEstate();
			String country=m.getEcountry();
			String age=m.getEage();
			String email=m.getEemail();
			String jobpost=m.getEjob();
			String aadhar=m.getEaadhar();
			String pin_code=m.getEpic_code();
			
			
			
				
				String query="insert into emp(name,phone,address,gender,city,state,country,age,email,jobpost,aadharno,pin_code)values(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setString(2, phone);
				pstmt.setString(3, address);
				pstmt.setString(4, gender);
				pstmt.setString(5, city);
				pstmt.setString(6, state);
				pstmt.setString(7, country);
				pstmt.setString(8,age );
				pstmt.setString(9, email);
				pstmt.setString(10, jobpost);
				pstmt.setString(11, aadhar);
				pstmt.setString(12, pin_code);
							
				int i=pstmt.executeUpdate();
				if (i!=0) {
					flag=true;
				}else {
					flag=false;
				}
							
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}
	
	public boolean validAdmin(Model m) {
		boolean flag=false;
		try {
			con=CP.conProvider();
			
			String uname=m.getAdminname();
			String upass=m.getAdminpass();
			
			String q="select * from user where username=? and password=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, uname);
			pst.setString(2, upass);
			ResultSet set=pst.executeQuery();
			if (set.next()) {
				flag=true;
			}else {
				flag=false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public boolean delelteEmpData(Model m) {
		boolean flag=false;
		try {
			con=CP.conProvider();
			String emp_id=m.getEmp_id();
	
			String q="delete from emp where id=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, emp_id);
			int i=pst.executeUpdate();
			if (i!=0) {
				flag=true;
			}else {
				flag=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag; 
	}

	public boolean updateEmpData(Model m) {
		boolean flag=false;
		try {
			con=CP.conProvider();
			String name=m.getEname();
			String phone=m.getEphone();
			String address=m.getEaddress();
			String gender=m.getEgender();
			String city=m.getEcity();
			String state=m.getEstate();
			String country=m.getEcountry();
			String age=m.getEage();
			String email=m.getEemail();
			String jobpost=m.getEjob();
			String aadhar=m.getEaadhar();
			String pin_code=m.getEpic_code();
			String emp_id=m.getEmp_id();
			
			String query="update emp set name=?,phone=?,address=?,gender=?,city=?,state=?,country=?,age=?,email=?,jobpost=?,aadharno=?,pin_code=? where id=?";
			
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, gender);
			pstmt.setString(5, city);
			pstmt.setString(6, state);
			pstmt.setString(7, country);
			pstmt.setString(8,age );
			pstmt.setString(9, email);
			pstmt.setString(10, jobpost);
			pstmt.setString(11, aadhar);
			pstmt.setString(12, pin_code);
			pstmt.setString(13, emp_id);
						
			int i=pstmt.executeUpdate();
			if (i!=0) {
				flag=true;
			}else {
				flag=false;
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return flag;
	}
	
	
	

	
//	public ResultSet show_table_data() {
//		ResultSet set = null;
//		try {
//			Connection con=CP.conProvider();
//			String q="select * from emp";
//			PreparedStatement pst=con.prepareStatement(q);
//			set=pst.executeQuery();
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return set;
//	}
//	
	
	
	
}


//String query="select * from emp";
//Statement st=con.createStatement();
//st.executeQuery(query);