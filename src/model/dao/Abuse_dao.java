package model.dao;

import model.persistance.Abuse;

public class Abuse_dao extends GenericDao implements Itf_abuse_dao  {

	@Override
	public boolean sendAbuse(Abuse a) {
		try {
			
            session.save(a);
   
            //log.debug("save successful");
            return true;
		} catch (RuntimeException re) {
			//log.error("abuse save failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			return false;
}
	}

}
