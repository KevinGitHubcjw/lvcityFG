package com.henu.dao;


import java.util.List;

import com.henu.bean.Message;

public interface MessageDao {
	public int save(Message meg);
	public int delete(String username);
	public int update(String username,Message meg);
	public List<Message>findAll();
	public Message findByUsername(String username);
	
}
