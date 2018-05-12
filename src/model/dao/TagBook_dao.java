package model.dao;

import model.persistance.TagBook;

public class TagBook_dao extends GenericDao implements Itf_tagBook_dao {

	@Override
	public boolean save(TagBook tb) {
		try {
            session.save(tb);
     
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
