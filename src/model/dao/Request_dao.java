package model.dao;

import java.util.List;

import org.hibernate.Query;

import model.persistance.Request;

public class Request_dao extends GenericDao implements Itf_request_dao {

	@Override
	public boolean save(Request r) {
		try {
            session.save(r);
     
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
	public int countRequestByGroup(int idGroup) {
		try {
    		Query q = session.createQuery("select count(r.idRequest) from Request as r  where r.themeGroup.idGroup=:idGroup ");
    		q.setInteger("idGroup", idGroup);
    		Long res = (Long) q.uniqueResult();
    	  
		return  res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public List<Request> getRequestByGroup(int idGroup, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="r.idRequest";
			try {
			
	    		Query q = session.createQuery("select r from Request as r  where r.themeGroup.idGroup=:idGroup order by "+orderby);
	    		q.setInteger("idGroup", idGroup);
	    		
	    	    q.setFirstResult(min);
	    	    q.setMaxResults(max);
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

	public Request findById(int id) {
		//Session session = HibernateUtil.getSession();
		try {
			//System.out.println("session dans inter"+ session);
			 Request instance = ( Request)session.get(
					 Request.class, id);
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
