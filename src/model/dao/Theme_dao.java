package model.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.persistance.Theme;

import org.hibernate.Query;

public class Theme_dao extends GenericDao implements Itf_theme_dao {

	@Override
	public Theme findById(int id) {
		try {
			Theme instance = (Theme) session
					.get(Theme.class, id);
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
	}

	@Override
	public List<Theme> getAllThemes() {
		try{
		Query q = session.createQuery("from Theme");
	/*	Iterator<Theme> i =q.iterate();
		 Map<Integer, String> res = new HashMap<Integer, String>();
		while(i.hasNext()){
			Theme t = i.next();
			res.put(t.getIdTheme(), t.getName());
		}*/
	    
		return q.list();
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
	public boolean save(Theme th) {
		try {
            session.save(th);
     
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
