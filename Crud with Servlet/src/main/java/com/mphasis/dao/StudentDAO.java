package com.mphasis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.dbutil.dbUtil;
import mphasis.com.pojo.Student;


public class StudentDAO {
	
	public int insert(Student student) throws ClassNotFoundException, SQLException {
		Connection con=dbUtil.getConn();
		if(con==null) {
			System.out.println("connection failed");
		}
		else {
			System.out.println("connection successfull");
		}
		
		String sql="insert into student values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,student.getSid());
		ps.setString(2, student.getSname());
		ps.setString(3,student.getSemail());
		return ps.executeUpdate();
	}
	
	
	public List<Student> displaystudent() throws ClassNotFoundException, SQLException {
		Connection con=dbUtil.getConn();
		if(con==null) {
			System.out.println("connection failed");
		}
		else {
			System.out.println("connection successfull");
		}
		
		String sql="select * from  student";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		List<Student> list=new ArrayList();
		while(rs.next()) {
			Student student=new Student();
			student.setSid(rs.getString("sid"));
			student.setSname(rs.getString("sname"));
			student.setSemail(rs.getString("semail"));
			list.add(student);
		}
		return list;
		
		
	}
	
	public List<Student> deletestudent(String id) throws SQLException, ClassNotFoundException{
		Connection con=dbUtil.getConn();
		if(con==null) {
			System.out.println("connection failed");
		}
		else {
			System.out.println("connection successfull");
		}
		
		String sql="delete from  student where sid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
		ps.close();
		return displaystudent();
		
	}
	
	
	public List<Student> updatestudent(String id,String name) throws SQLException, ClassNotFoundException{
		Connection con=dbUtil.getConn();
		if(con==null) {
			System.out.println("connection failed");
		}
		else {
			System.out.println("connection successfull");
		}
		System.out.println(id+" "+name);
		String sql="update student set sname=? where sid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, id);
		ps.executeUpdate();
		ps.close();
		return displaystudent();
		
	}
	

}

