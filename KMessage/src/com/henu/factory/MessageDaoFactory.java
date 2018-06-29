package com.henu.factory;
import com.henu.dao.MessageDao;
import com.henu.impi.MessageDaoImpi;

public class MessageDaoFactory {
	public static MessageDao getMessageInstance()
	{
		return new MessageDaoImpi();
	}

}
