package model.dao;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import model.persistance.Job;
import model.persistance.Level;
import model.persistance.LevelMember;
import model.persistance.Member;

public class Level_dao extends GenericDao implements Itf_level_dao  {

	@Override
	public boolean save(Level l) {
		try {
            session.save(l);
     
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
	public Level findById(int id) {
		try {
			//System.out.println("session dans inter"+ session);
			Level instance = (Level)session.get(
					Level.class, id);
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
	public Level findLevelByNumber(int numb) {
	 	//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = this.session.createQuery("from Level as l where l.numbr=:numb");
    		q.setInteger("numb", numb);
    		Level l =(Level)  q.uniqueResult();
    	    
    	    //get the class name and job name
    	   
    	    return l;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
    	finally {
			//session.close();
		}
	}

	@Override
	public boolean delete(Level persistentInstance) {
		
		try {
			session.delete(persistentInstance);
			
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			
			re.printStackTrace();
			return false;
		}
		return true;
	}

}
