package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.UsersDao;
import com.neuedu.lvcity.model.*;

public class UsersDaoImpl implements UsersDao{
Connection connection=null;
     public UsersDaoImpl(Connection connection){
    System.out.println("进入一个连接");
	this.connection=connection;
}
@Override
public Users login(String username, String password) {
	// TODO Auto-generated method stub
	Users user = null;
	PreparedStatement pStatement=null;
	ResultSet rSet=null;	
	System.out.println("jinglailoglin");
	try{
		//通过连接建立预编译语句对象
		pStatement = connection.prepareStatement("select * from users where name=? and passwd=?");		
		pStatement.setString(1, username);
		pStatement.setString(2, password);
		//执行预编译SQL语句
		rSet=pStatement.executeQuery();
		//遍历结果集并取出结果集的内容放入user对象
		if(rSet.next()){
			System.out.println(rSet.getInt("id")+" ");
			user =new Users();
			user.setId(rSet.getInt("id"));
			user.setName(rSet.getString("name"));
			user.setPasswd(rSet.getString("passwd"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		DBUtils.closeStatement(rSet, pStatement);
	}
	return user;
}
}
