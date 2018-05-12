package model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import core_lib.HibernateUtil;
import model.persistance.ResponseMessageMember;

public class ResponseMessageMember_dao implements Itf_responseMessageMember_dao {

	@Override
	public boolean save(ResponseMessageMember transientInstance) {
		// TODO Auto-generated method stub
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                        Session s= HibernateUtil.getSession();

                        Transaction t = s.beginTransaction();
                        s.save(transientInstance);
                        //System.out.println(id+ " id");
                       // transientInstance.setIdBook(id);
                        t.commit();
                        //System.out.println(id+ " id2");
                        s.close();
                      
                        return true;
		} catch (RuntimeException re) {
			
			re.printStackTrace();
			 return false;
		}
	}

}
