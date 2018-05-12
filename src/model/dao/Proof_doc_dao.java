package model.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;

import model.persistance.Job;
import model.persistance.LevelMember;
import model.persistance.Member;
import model.persistance.Proof_doc;
import model.persistance.ThemeGroup;

public class Proof_doc_dao extends GenericDao implements Itf_proof_doc_dao {

	@Override
	public boolean save(Proof_doc pr) {
		try {
            session.save(pr);
     
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
	public Proof_doc findById(int id) {
		try {
			//System.out.println("session dans inter"+ session);
			Proof_doc instance = (Proof_doc)session.get(
					Member.class, id);
		
			return instance;
		} catch (RuntimeException re) {
			//log.error("get failed", re);
			return null;
		}
	}

	@Override
	public Proof_doc merge(Proof_doc detachedInstance) {
try {
			
			
			// Member m=(Member)session.get(Member.class,1);
		     
		    
			 detachedInstance = (Proof_doc) session.merge(
					detachedInstance);
		
			
		//	 m.setName("toto");
			
			//log.debug("merge successful");
			return detachedInstance;
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			re.printStackTrace();
			//log.error("merge failed", re);
			return null;
		}
	}

	@Override
	public List<Proof_doc> findByIdBook(int id) {

		try {

    		Query q = this.session.createQuery("from Proof_doc as p where p.myBook.idBook =:monId");
    		q.setInteger("monId", id);
    		List<Proof_doc> p =(List<Proof_doc>)  q.list();
    	    
    	   
    	    return p;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}
	
	@Override
	public boolean delete(Proof_doc persistentInstance) {
		
		try {
			session.delete(persistentInstance);
			
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			
			re.printStackTrace();
			return false;
		}
		return true;
	}
	
}
