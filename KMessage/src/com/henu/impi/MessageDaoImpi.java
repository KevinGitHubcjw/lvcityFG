package com.henu.impi;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.sql.PreparedStatement;
import com.henu.bean.Message;
import com.henu.dao.MessageDao;
import com.henu.util.DbcpConnectionPool;




public class MessageDaoImpi implements MessageDao {

	@Override
	public int save(Message meg) {
		// TODO Auto-generated method stub
		String sql="insert into message(message,username,submitTime) values(?,?,?)";
		int result=0;
		try {
			PreparedStatement ps=DbcpConnectionPool.executePreparedStatement(sql);
			ps.setString(1, meg.getMessage());
			ps.setString(2, meg.getUsername());
			ps.setString(3, meg.getSubmitTime());
			result=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(String username) {
		// TODO Auto-generated method stub
		String sql="delete from message where username='"+username+"'";
		int result=0;
		result=DbcpConnectionPool.executeUpdate(sql);
		DbcpConnectionPool.close();
		return result;
	}

	@Override
	public int update(String username, Message meg) {
		// TODO Auto-generated method stub
		String sql="update message set message=? where username=?";
		int result=0;
		PreparedStatement ps=DbcpConnectionPool.executePreparedStatement(sql);
		try {
			ps.setString(1, meg.getMessage());
			ps.setString(2, username);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Message>findAll() {
		// TODO Auto-generated method stub
		String sql="select * from message";
		List<Message> list=new ArrayList<Message>();
		ResultSet rs=DbcpConnectionPool.executeQuery(sql);
		System.out.println("****************");
		try {
			while(rs.next())
			{
				System.out.println("****************");
				Message meg=new Message();
				meg.setId(rs.getString("id"));
				meg.setMessage(rs.getString("message"));
				meg.setUsername(rs.getString("username"));
				meg.setSubmitTime(rs.getString("submitTime"));
				list.add(meg);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpConnectionPool.close();
		return list;
	}

	@Override
	public Message findByUsername(String username) {
		// TODO Auto-generated method stub
		String sql="select * from message where username='"+username+"'";
		Message meg=new Message();
		ResultSet rs=DbcpConnectionPool.executeQuery(sql);
		try {
			if(rs.next())
			{
				meg.setId(rs.getString("id"));
				meg.setMessage(rs.getString("message"));
				meg.setUsername(rs.getString("username"));
				meg.setSubmitTime(rs.getString("submitTime"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		DbcpConnectionPool.close();
		return meg;
	}
	

}
