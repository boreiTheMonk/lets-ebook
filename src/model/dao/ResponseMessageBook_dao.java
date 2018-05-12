package model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import core_lib.HibernateUtil;
import model.persistance.ResponseMessageBook;
import model.persistance.ResponseMessageMember;

public class ResponseMessageBook_dao extends GenericDao implements Itf_responseMessageBook_dao {

	
	@Override
	public boolean save(ResponseMessageBook transientInstance) {
		// TODO Auto-generated method stub
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                      

                      
                        session.save(transientInstance);
                        //System.out.println(id+ " id");
                       // transientInstance.setIdBook(id);
               
                      
                        return true;
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			re.printStackTrace();
			 return false;
		}
	}



}
