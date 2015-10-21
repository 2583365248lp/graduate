package org.leadfar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.leadfar.model.User;



public class UserDao {

	
	public void save(User user){
		String sql="insert into t_user (name,sex,birthday,reg_time) values(?,?,?,now())";
		
		Connection conn=DB.getConn();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getSex());
			//java.util.Date  > java.sql.Date 
			pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			pstmt.executeUpdate();
			
			DB.commit(conn);
			
		} catch (SQLException e) {
			DB.rollback(conn);
			e.printStackTrace();
		}finally{
			DB.close(pstmt);
			DB.commit(conn);
		}
		
	}
	public void update(User user){
		String sql="update t_user set name=?,sex=?,birthday=? where id=?";
		
		Connection conn=DB.getConn();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getSex());
			//java.util.Date  > java.sql.Date 
			pstmt.setDate(3,new java.sql.Date(user.getBirthday().getTime()));
			pstmt.setInt(4, user.getId());
			pstmt.executeUpdate();
			
			DB.commit(conn);
			
		} catch (SQLException e) {
			DB.rollback(conn);
			e.printStackTrace();
		}finally{
			DB.close(pstmt);
			DB.commit(conn);
		}
		
	}
	public void delete(int id){
		String sql="delete from  t_user  where id=?";
		
		Connection conn=DB.getConn();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			DB.commit(conn);
			
		} catch (SQLException e) {
			DB.rollback(conn);
			e.printStackTrace();
		}finally{
			DB.close(pstmt);
			DB.commit(conn);
		}
		
	}
	//单查
	public User get(int id){
		String sql="select * from t_user where id=?";
		
		Connection conn=DB.getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User user=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				 user=new User();
				 user.setName( rs.getString("name"));
				user.setSex( rs.getString("sex"));
				user.setId( rs.getInt("id"));
				 user.setBirthday(rs.getDate("birthday"));
				 user.setRegTime(rs.getTimestamp("reg_time"));
			}
			DB.commit(conn);
			
		} catch (SQLException e) {
			DB.rollback(conn);
			e.printStackTrace();
		}finally{
			DB.close(pstmt);
			DB.commit(conn);
		}
		return user;
		
	}
	//多查
	public List<User> query(){
		String sql="select * from t_user";
		
		Connection conn=DB.getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<User> users=new ArrayList<User>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				User user=new User();
				 user.setName( rs.getString("name"));
				user.setSex( rs.getString("sex"));
				user.setId( rs.getInt("id"));
				 user.setBirthday(rs.getDate("birthday"));
				 user.setRegTime(rs.getTimestamp("reg_time"));
				 users.add(user);
			}
			DB.commit(conn);
			
		} catch (SQLException e) {
			DB.rollback(conn);
			e.printStackTrace();
		}finally{
			DB.close(pstmt);
			DB.commit(conn);
		}
		return users;
		
	}
}
