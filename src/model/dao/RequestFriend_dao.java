package model.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import model.persistance.Member;
import model.persistance.Request;
import model.persistance.RequestFriend;

public class RequestFriend_dao extends GenericDao implements Itf_request_friend_dao {

	@Override
	public boolean save(RequestFriend reqf) {
		try {
            session.save(reqf);
     
         //   log.debug("save successful");
            return true;
		} catch (RuntimeException re) {
		//	log.error("savet failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			return false;
		}
	}

	@Override
	public int countRequestFriendByIdMember(int idMember) {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    	
    		//Query q = session.createQuery("select count(b.idBook) from Book as b inner join fetch b.category as c inner join fetch c.category as parentC  where c.idCategory =:id_category or parentC.idCategory =:id_category   ");
    		Query q = session.createQuery("select count(rf.idRequestFriend) from RequestFriend  as rf where rf.memberByIdMemberRecipient.idMember =:memberId  ");
    		
    		q.setInteger("memberId", idMember);
    		//int i=(Integer) session.iterate("select count(*) from ....").next() ).intValue();

    		int i=((Long) q.uniqueResult()).intValue();
    		System.out.println(i);
    		return  i ;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public boolean delete(RequestFriend reqf) {
		try {
			reqf=  (RequestFriend) session.load(RequestFriend.class, reqf.getIdRequestFriend());
			session.delete(reqf);
         //   log.debug("save successful");
            return true;
		} catch (RuntimeException re) {
		//	log.error("savet failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			return false;
		}
	
	}

	//show all request for member with treated = false
	//we delete request when friend decline
	@Override
	public List<RequestFriend> getRequestFriendByIdMember(int idMember) {
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("from RequestFriend  as rf where rf.memberByIdMemberRecipient.idMember =:memberId and rf.treated=false");
    		q.setInteger("memberId", idMember);
    	    
		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
    	finally {
		//	session.close();
		}
	}

	@Override
	public RequestFriend findById(int id) {
		try {
			//System.out.println("session dans inter"+ session);
			RequestFriend  instance = ( RequestFriend )session.get(
					RequestFriend .class, id);
			if (instance == null) {
				//log.debug("get successful, no instance found");
			} else {
				//log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			//log.error("get failed", re);
			return null;
		}
		finally {
		//	session.close();
		}
	}

	@Override
	public RequestFriend merge(RequestFriend reqf) {
	
		
		try {
			
			
			// Member m=(Member)session.get(Member.class,1);
		     
		    
			reqf = (RequestFriend) session.merge(
					reqf);
		
			
		//	 m.setName("toto");
			
			
			return reqf;
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			re.printStackTrace();
			
			return null;
		}
	}

	@Override
	public int countRequestFriendNotReadByIdMember(int idMember) {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    	
    		//Query q = session.createQuery("select count(b.idBook) from Book as b inner join fetch b.category as c inner join fetch c.category as parentC  where c.idCategory =:id_category or parentC.idCategory =:id_category   ");
    		Query q = session.createQuery("select count(rf.idRequestFriend) from RequestFriend  as rf where rf.memberByIdMemberRecipient.idMember =:memberId and rf.isRead=false ");
    		
    		q.setInteger("memberId", idMember);
    		//int i=(Integer) session.iterate("select count(*) from ....").next() ).intValue();

    		int i=((Long) q.uniqueResult()).intValue();
    		System.out.println(i);
    		return  i ;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public boolean isRequestSent(int idMember, int idMemberFriend) {
		try {
			
    		Query q = session.createQuery("select rf from RequestFriend  as rf where (rf.memberByIdMemberRecipient.idMember=:idMember and rf.memberByIdMember=:idMemberFriend) or (rf.memberByIdMemberRecipient.idMember=:idMemberFriend and rf.memberByIdMember=:idMember)");
    		q.setInteger("idMember", idMember);
    		q.setInteger("idMemberFriend", idMemberFriend);
    		
    	   
		List res=  q.list();
		if(res.size()>0)
			return true;
		else
			return false;
		
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return false;
    	}
    	finally {
		//	session.close();
		}
	}



	@Override
	public boolean deleteRequestFriendByFriends(int friends1, int friends2) {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("from RequestFriend  as rf where (rf.memberByIdMemberRecipient.idMember =:friends1 and rf.memberByIdMember.idMember=:friends2) or (rf.memberByIdMemberRecipient.idMember =:friends2 and rf.memberByIdMember.idMember=:friends1) ");
    		q.setInteger("friends1", friends1);
    		q.setInteger("friends2", friends2);
    		List<RequestFriend> res = q.list();
    		
    		for(RequestFriend rf:res){
    			session.delete(rf);
    		}
    		
    		
    			return true;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return false;
    	}
    	finally {
		//	session.close();
		}
	}



}
