package model.dao;

import java.util.List;

import org.hibernate.Query;

import model.persistance.ClassMember;
import model.persistance.Member;

public class ClassMember_dao extends GenericDao implements Itf_class_member_dao {

	@Override
	public boolean save(ClassMember cm) {
		try {
            session.save( cm);
     
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
	public int countClassMember() {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    	
    		//Query q = session.createQuery("select count(b.idBook) from Book as b inner join fetch b.category as c inner join fetch c.category as parentC  where c.idCategory =:id_category or parentC.idCategory =:id_category   ");
    		Query q = session.createQuery("select count(cm.idClass) from ClassMember  as cm  ");
    		
    		
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
	public List<ClassMember> getAllClassMember() {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("from ClassMember  as cm ");
    		
    	    
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
	public ClassMember findById(int id) {
		//Session session = HibernateUtil.getSession();
		try {
			//System.out.println("session dans inter"+ session);
			ClassMember instance = (ClassMember)session.get(
					ClassMember.class, id);
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
	

}
