package model.dao;

import org.hibernate.Query;

import model.persistance.Job;
import model.persistance.Member;

public class Job_dao extends GenericDao implements Itf_job_dao {

	@Override
	public boolean save(Job j) {
		try {
            session.save(j);
     
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
	public Job findById(int id) {
		try {
			//System.out.println("session dans inter"+ session);
			Job instance = (Job)session.get(
					Job.class, id);
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
	public Job findJobByLevelClass(int idLevel, int idClassMember) {
		// TODO Auto-generated method stub
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    	
    		Query q = session.createQuery("select j from Job as j inner join j.levels l where j.classMember.idClass=:idClassMember and l.idLevel=:idLevel");
    		q.setInteger("idClassMember", idClassMember);
    		q.setInteger("idLevel", idLevel);

		return  (Job) q.uniqueResult();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
    	finally {
		//	session.close();
		}
	}

}
