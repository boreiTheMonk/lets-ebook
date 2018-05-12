package model.dao;

import java.util.List;

import org.hibernate.Query;

import model.persistance.Member;
import model.persistance.MessageRequest;

public class MessageRequest_dao extends GenericDao implements Itf_messageRequest_dao {

	@Override
	public boolean save(model.persistance.MessageRequest mr) {
		// TODO Auto-generated method stub
        try {
		session.save(mr);
        
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
	public List<MessageRequest> getMessageRequestByRequest(int idRequest,
			int min, int max, String orderby) {
		if(orderby==null)
			orderby="mr.publishDate";
			try {
			
	    		Query q = session.createQuery("select mr from MessageRequest as mr  where mr.request.idRequest=:idRequest order by "+orderby);
	    		q.setInteger("idRequest", idRequest);
	    		
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



	@Override
	public int countMessageRequestByRequest(int idRequest) {
		try {
    		Query q = session.createQuery("select count(mr.idMessage)  from MessageRequest as mr  where mr.request.idRequest=:idRequest ");
    		q.setInteger("idRequest", idRequest);
    		Long res = (Long) q.uniqueResult();
    	  
		return  res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}


}
