package model.dao;

import java.util.List;

import org.hibernate.Query;

import model.persistance.Book;
import model.persistance.MessageBook;
import model.persistance.MessageEmail;

public class MessageEmail_dao extends GenericDao implements Itf_messageEmail_dao {

	@Override
	public boolean save(MessageEmail me) {
        try{
		session.save(me);
        
        // log.debug("save successful");
         return true;
		} catch (RuntimeException re) {
			//log.error("savet failed", re);
			if(t != null) t.rollback();
				re.printStackTrace();
				return false;
}
	}
	
	
	@Override
	public boolean persist(MessageEmail me) {
        try{
		session.persist(me);
        
        // log.debug("save successful");
         return true;
		} catch (RuntimeException re) {
			//log.error("savet failed", re);
			if(t != null) t.rollback();
				re.printStackTrace();
				return false;
}
	}

	//not call
	@Override
	public int countMessageMailbyIdMember(int idMember) {
		try {
			Query q =session.createQuery("select select count(me.idMessage) from MessageEmail me left join me.messageEmailsForIdMessageFollow myFollower "+
					"where (me.memberByIdMemberSender.idMember=:idMember and me.messageEmailByIdMessageRoots is not null and myFollower is null) "+
					"or( me.memberByIdMember.idMember=:idMember  and myFollower is null) order by  me.publishDate desc");
			

	q.setInteger("idMember", idMember);
    		 Long res = (Long) q.uniqueResult();
		return res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public boolean delete(int id) {
		MessageEmail mail =findById(id);
		session.delete(mail);
		return false;
	}

	@Override
	public MessageEmail findById(int id) {
		try {
			MessageEmail mail = (MessageEmail) session.get(MessageEmail.class, id);

			
			
			
		/*	if(mail==null){
				Query q = session.createQuery("select me from MessageEmail me inner join me.messageEmails myMails" +
				" where me.idMessage=:idMember and me.messageEmail is  null ");
				
			}*/
			
			return  mail;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
	//load my mails received in inbox
	@Override				
	public List<MessageEmail> loadMessageMailbyIdMember(int idMember, int min,
			int max, String orderBy) {
		try {
			/*Query q = session.createQuery("select mb from MessageMember mm inner join fetch mm.memberByIdMemberSender memb " +
    				"left join fetch mm.responseMessageMembers resp left join fetch resp.messageMember	 " +
    				"where memb.login=:login order by mm.publishDate desc");
			*/
			//left join because eg dont select message if no memberdeleted
			Query q =session.createQuery("select me from MessageEmail me left join me.messageEmailsForIdMessageFollow myFollower " +
			//"left join me.messageEmailByIdMessageRoots.memberDeleted deleted "+
					"where " +
					
					" (me.memberByIdMemberSender.idMember=:idMember and me.messageEmailByIdMessageRoots !=me and me.messageEmailByIdMessageRoots is not null and myFollower is null and me.memberByIdMemberSender not in elements(me.messageEmailByIdMessageRoots.memberDeleted))          "+
					"or( me.memberByIdMember.idMember=:idMember  and myFollower is null and me.messageEmailByIdMessageRoots is not null and me.memberByIdMember not in elements(me.messageEmailByIdMessageRoots.memberDeleted))"+
					
					
					
			/*"where (me.memberByIdMemberSender.idMember=:idMember and me.messageEmailByIdMessageRoots is not null and myFollower is null and me.memberByIdMemberSender not in elements(me.messageEmailByIdMessageRoots.memberDeleted))          "+
			"or( me.memberByIdMember.idMember=:idMember  and myFollower is null and me.messageEmailByIdMessageRoots is not null and me.memberByIdMember not in elements(me.messageEmailByIdMessageRoots.memberDeleted)) " +
			"or( me.memberByIdMember.idMember=:idMember  and myFollower is null and me.messageEmailByIdMessageRoots is  null and me.memberByIdMember not in elements(me.memberDeleted) ) " +*/
			//"and deleted.idMember !=:idMember " +
			"order by  me.publishDate desc");
    		
    		 
    		q.setInteger("idMember", idMember);
    		q.setFirstResult(min);
    	    q.setMaxResults(max);
		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

	//not call
	@Override
	public int countMyMessageMailbyIdMember(int idMember) {
		try {

			Query q = session.createQuery("select count(me.idMessage) from MessageEmail " +
    				" where (me.memberByIdMemberSender.idMember=:idMember ) and me.messageEmail is null");

	q.setInteger("idMember", idMember);
    		 Long res = (Long) q.uniqueResult();
		return res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	//load my mails sent and not inbox
	@Override
	public List<MessageEmail> loadMyMessageMailbyIdMember(int idMember,
			int min, int max, String orderBy) {
		try {
			/*Query q = session.createQuery("select mb from MessageMember mm inner join fetch mm.memberByIdMemberSender memb " +
    				"left join fetch mm.responseMessageMembers resp left join fetch resp.messageMember	 " +
    				"where memb.login=:login order by mm.publishDate desc");
			*/
//    		Query q = session.createQuery("select me from MessageEmail me" +
//    				" where (me.memberByIdMemberSender.idMember=:idMember )  and me.messageEmailsForIdMessageFollow is null order by  me.publishDate desc");
    		Query q = session.createQuery("select me from MessageEmail me" +
			" where (me.memberByIdMemberSender.idMember=:idMember ) and me.messageEmailByIdMessageRoots = me and me.memberByIdMemberSender not in elements(me.messageEmailByIdMessageRoots.memberDeleted) order by  me.publishDate desc");
    		q.setInteger("idMember", idMember);
    		q.setFirstResult(min);
    	    q.setMaxResults(max);
		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

	@Override
	public MessageEmail findRootById(int id) {
		try {
			//Query q = session.createQuery("select me from MessageEmail me left join me.messageEmailsForIdMessageRoots myMails" +
			//" where (myMails.idMessage=:idMember or me.idMessage=:idMember) and me.messageEmailByIdMessageRoots = me ");

			Query q = session.createQuery("select myMails from MessageEmail me inner join me.messageEmailByIdMessageRoots myMails" +
			" where ( me.idMessage=:idMember)");

			q.setInteger("idMember", id);
			
			q.setMaxResults(1);
			
			MessageEmail mail= (MessageEmail) q.uniqueResult();
		/*	if(mail==null){
				Query q = session.createQuery("select me from MessageEmail me inner join me.messageEmails myMails" +
				" where me.idMessage=:idMember and me.messageEmail is  null ");
				
			}*/
			
			return  mail;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public MessageEmail findLastMessageByRootId(int id) {
		try {
			Query q = session.createQuery("select me from MessageEmail me left join me.messageEmailsForIdMessageFollow myNexts" +
			" where (me.messageEmailByIdMessageRoots.idMessage=:idMessage or me.idMessage=:idMessage )  and myNexts is  null ");

			q.setInteger("idMessage", id);
			
			q.setMaxResults(1);
			
			MessageEmail mail= (MessageEmail) q.uniqueResult();
		/*	if(mail==null){
				Query q = session.createQuery("select me from MessageEmail me inner join me.messageEmails myMails" +
				" where me.idMessage=:idMember and me.messageEmail is  null ");
				
			}*/
			
			return  mail;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	@Override
	public int countMessageMailNotReadbyIdMember(int idMember) {
		try {
			Query q = session.createQuery("select count(me.idMessage) from MessageEmail me left join me.messageEmailsForIdMessageFollow myFollower "+
			"where ( me.memberByIdMember.idMember=:idMember  and myFollower is null and me.memberByIdMember not in elements(me.messageEmailByIdMessageRoots.memberDeleted)  and   me.isRead = false) ") ;

			

	q.setInteger("idMember", idMember);
    		 Long res = (Long) q.uniqueResult();
		return res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public List<MessageEmail> findMessageMailNotReadbyIdMember(int idMember) {
		try {
			Query q = session.createQuery("select me from MessageEmail me left join me.messageEmailsForIdMessageFollow myFollower "+
			"where ( me.memberByIdMember.idMember=:idMember  and myFollower is null  and   me.isRead = false) ") ;
			q.setInteger("idMember", idMember);
		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}


	@Override
	public List<MessageEmail> getAllMessageMail() {
		try {

			Query q =session.createQuery("select me from MessageEmail me ");

		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

}
