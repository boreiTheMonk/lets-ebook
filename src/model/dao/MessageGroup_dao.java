package model.dao;

import java.util.List;

import org.hibernate.Query;

import model.persistance.MessageBook;
import model.persistance.MessageGroup;


public class MessageGroup_dao extends GenericDao implements Itf_messageGroup_dao {

	@Override
	public boolean save(MessageGroup mg) {
		try {
			
            session.save(mg);
   
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
	public MessageGroup findById(int id) {
		
		try {
			MessageGroup instance = (MessageGroup) session.get(MessageGroup.class,
							id);
			if (instance == null) {
				
			} else {
				
			}
			return instance;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	@Override
	public List<MessageGroup> loadMessageGroup(int idGroup, int min, int max) {
		try {
			/*Query q = session.createQuery("select mb from MessageMember mm inner join fetch mm.memberByIdMemberSender memb " +
    				"left join fetch mm.responseMessageMembers resp left join fetch resp.messageMember	 " +
    				"where memb.login=:login order by mm.publishDate desc");
			*/
    		Query q = session.createQuery("select mg from MessageGroup mg" +
    				" where mg.themeGroup.idGroup=:idGroup  and mg.deleted=false order by mg.publishDate desc");

    		q.setInteger("idGroup", idGroup);
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
	public MessageGroup merge(MessageGroup detachedInstance) {
	
		try {
			MessageGroup result = (MessageGroup) session.merge(detachedInstance);
			
			return result;
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			
			throw re;
		}
	}



}
