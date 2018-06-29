package com.neuedu.lvcity.service.impl;

import java.sql.Connection;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.UsersDao;
import com.neuedu.lvcity.dao.impl.UsersDaoImpl;
import com.neuedu.lvcity.model.Users;
import com.neuedu.lvcity.service.UsersService;

public class UsersServiceImpl implements UsersService{
/**
 * 构造方法私有化
 */
	private UsersServiceImpl(){
	
}
/**
 * 创建一个唯一的实例
 */
	private static UsersService Instance=new UsersServiceImpl();
	/**
	 * 提供一个对外访问的公共接口
	 * @return
	 */
	public static UsersService getInstance(){
		return Instance;
	}
	@Override
	public Users login(String username, String password) {
		//返回结果
		Users users=null;
		//声明连接
		Connection conn=null;
		//获取数据库连接
		try{
		conn=DBUtils.getConnection();
		UsersDao usersDao=new UsersDaoImpl(conn); 
		users=usersDao.login(username,password);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("登录查询用户是出现异常:"+e.getMessage());
		}finally{
			DBUtils.closeConnection(conn);
		}
		return users;
	}
}
