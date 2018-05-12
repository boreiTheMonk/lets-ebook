package cron;

import java.util.List;

import model.dao.MessageEmail_dao;
import model.persistance.MessageEmail;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

public class Replace_null_email_messageRoots {

	public void execute(){
		
		Session s= HibernateSessionFactory.getNewSession();
		Session s_bak=HibernateSessionFactory.getNewSession();
		
Transaction t = s.beginTransaction();
		
		MessageEmail_dao me= new MessageEmail_dao();
		me.setSession(s);
		
		List<MessageEmail> lme= me.getAllMessageMail();
		int i=0;
		for(MessageEmail m:lme){
			if(m.getMessageEmailByIdMessageRoots()==null){
				m.setMessageEmailByIdMessageRoots(m);
			System.out.println("replace "+m.getIdMessage());
			i++;
			}
		}
		System.out.println(i+ "row treat");
		
		
		t.commit();
	
	}
	
}
