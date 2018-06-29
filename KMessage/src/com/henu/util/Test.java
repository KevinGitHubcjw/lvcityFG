package com.henu.util;

import java.util.ArrayList;
import java.util.List;

import com.henu.bean.Message;
import com.henu.factory.MessageDaoFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Message> meglist=new ArrayList<Message>();
		meglist=MessageDaoFactory.getMessageInstance().findAll();
		for(Message megs:meglist)
		{
			System.out.println(megs);
		}
		
		/*MessageDaoFactory.getMessageInstance().delete("html");*/
		

	}

}
