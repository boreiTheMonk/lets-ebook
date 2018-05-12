package model.dao;

import model.persistance.FolderEmail;

public class FolderEmail_dao extends GenericDao implements Itf_folder_email_dao {

	@Override
	public boolean save(FolderEmail fe) {
        try{
    		session.save(fe);
            
            // log.debug("save successful");
             return true;
    		} catch (RuntimeException re) {
    			//log.error("savet failed", re);
    			if(t != null) t.rollback();
    				re.printStackTrace();
    				return false;
    }
	}

}
