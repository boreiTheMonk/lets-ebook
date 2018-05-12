package test;

import java.util.List;

import model.dao.FolderEmail_dao;
import model.dao.Job_dao;
import model.dao.Level_dao;
import model.dao.MessageRequest_dao;
import model.persistance.MessageEmail;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

public class UnPopulate {
	
	public UnPopulate() {
		super();
		Session s= HibernateSessionFactory.getNewSession();
		
		// TODO Auto-generated constructor stub
		//populate categories
		
		Transaction t = null;
		

		Query q = null;
		
		



//		abuse
		
		t = s.beginTransaction();
		
		t.commit();
		
		
//		folder email
		FolderEmail_dao fe= new FolderEmail_dao();
		fe.setSession(s);

		t = s.beginTransaction();
		 q =s.createQuery("delete from FolderEmail");
		 q.executeUpdate();
		t.commit();
		
//		messageemail	
		/*t = s.beginTransaction();
		MessageEmail mm = (MessageEmail) s.get(MessageEmail.class, 61);
		s.delete(mm);
		t.commit();*/
		t = s.beginTransaction();
		
		
		 q =s.createQuery(" from MessageEmail ");
		 List<MessageEmail> l=q.list();
		 for(MessageEmail mm:l)
			 s.delete(mm);
		 
		 t.commit();
		// q.executeUpdate();
		
		
//		messagerequest
		MessageRequest_dao mr = new MessageRequest_dao();
		mr.setSession(s);
		
		t = s.beginTransaction();
		 q =s.createQuery("delete from MessageRequest");
		 q.executeUpdate();
		t.commit();
		
		
		
//		orderbook		

		
		t = s.beginTransaction();
		 q =s.createQuery("delete from OrderBook");
		 q.executeUpdate();
		
		t.commit();
		
		
//		messagebook
	
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from MessageBook");
		 q.executeUpdate();
		
		t.commit();
		

		
		// dependency join table
		t = s.beginTransaction();
		
		 q =s.createSQLQuery("delete from associate_tag");
		 q.executeUpdate();
		t.commit();
		
		//vote book
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from VoteBook");
		 q.executeUpdate();
		t.commit();
		
		// dependency join table book and group
		t = s.beginTransaction();
		
		 q =s.createSQLQuery("delete from upload  ");
		 q.executeUpdate();
		t.commit();
		
//       book

		// dependency join table book and favourites
		t = s.beginTransaction();
		
		 q =s.createSQLQuery("delete from follow_book  ");
		 q.executeUpdate();
		t.commit();
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from Book");
		 q.executeUpdate();
		t.commit();
		
//		tagbook
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from TagBook");
		 q.executeUpdate();
		
		t.commit();
		
		
		
		//vote request
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from VoteRequest");
		 q.executeUpdate();
		t.commit();
		
//		request
		
		t = s.beginTransaction();
		 q =s.createQuery("delete from Request");
		 q.executeUpdate();
		t.commit();
		
//		message groupe
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from MessageGroup");
		 q.executeUpdate();
		
		
		t.commit();
		
		// dependency join table member and group
		t = s.beginTransaction();
		
		 q =s.createSQLQuery("delete from register");
		 q.executeUpdate();
		t.commit();
		
		// dependency join table theme and group
		t = s.beginTransaction();
		
		 q =s.createSQLQuery("delete from classify");
		 q.executeUpdate();
		t.commit();
		
//		groups (themegroup)

		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from ThemeGroup");
		 q.executeUpdate();
		t.commit();
		

//		messagemember	
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from MessageMember");
		 q.executeUpdate();
		
		
		t.commit();
		
//		adress		
		
		
		t = s.beginTransaction();
		 q =s.createQuery("delete from Adress");
		 q.executeUpdate();
		t.commit();
		
//		favouritebook
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from FavouriteBook");
		 q.executeUpdate();
		t.commit();
		
//		favouriteauthor
	
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from FavouriteAuthor");
		 q.executeUpdate();
		
		t.commit();
		

		
		//level
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from LevelMember");
			q.executeUpdate();
		
		t.commit();
		
		//populate request friend
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from RequestFriend");
			q.executeUpdate();
		
		t.commit();
		
		
		// dependency join table
		t = s.beginTransaction();
		
		 q =s.createSQLQuery("delete from is_friend");
		 q.executeUpdate();
		t.commit();
		
		// dependency join table
		t = s.beginTransaction();
		
		 q =s.createSQLQuery("delete from follows");
		 q.executeUpdate();
		t.commit();
		
		//populate members
		
		
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from Member");
			q.executeUpdate();
		
		t.commit();
		
//		theme		
		
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from Theme");
		 q.executeUpdate();
		t.commit();
		
		// dependency join table member and group
		t = s.beginTransaction();
		
		 q =s.createSQLQuery("delete from job_level ");
		 q.executeUpdate();
		t.commit();
		
//		job
		
		Job_dao j= new Job_dao();
		j.setSession(s);
		t = s.beginTransaction();

		 q =s.createQuery("delete from Job");
		 q.executeUpdate();
		
		t.commit();
		
//level
		
		Level_dao ldao=new Level_dao();
		 ldao.setSession(s);
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from Level");
		 q.executeUpdate();
		
		t.commit();
		
		
		//c.save(c);
//		class member
		
		t = s.beginTransaction();
		
		 q =s.createQuery("delete from ClassMember");
		 q.executeUpdate();
		t.commit();

		t = s.beginTransaction();
		q =s.createQuery("delete from Category ca where ca.category is not null");
		q.executeUpdate();
		t.commit();
		t = s.beginTransaction();
		q =s.createQuery("delete from Category c ");
		q.executeUpdate();
		t.commit();
		
		s.close();
	}

	public static void main(String[] arg0){
		
		new UnPopulate();
	}
}
