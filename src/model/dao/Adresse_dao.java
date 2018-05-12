package model.dao;

import model.persistance.Adress;

public class Adresse_dao extends GenericDao implements Itf_adress_dao {

	@Override
	public boolean save(Adress a) {
		try {
            session.save(a);
     
         //   log.debug("save successful");
            return true;
		} catch (RuntimeException re) {
		//	log.error("savet failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			return false;
		}
	}

}
