package model.dao;

import java.util.List;

import org.hibernate.Query;

import model.persistance.LevelMember;
import model.persistance.Member;

public class LevelMember_dao extends GenericDao implements Itf_level_member_dao {

	@Override
	public boolean save(LevelMember lm) {
		try {
            session.save(lm);
     
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
	public LevelMember findByid(int id) {
		//Session session = HibernateUtil.getSession();
		try {
			//System.out.println("session dans inter"+ session);
			LevelMember instance = (LevelMember)session.get(
					LevelMember.class, id);
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

	@Override
	public List<LevelMember> getLevelMemberByIdMember(int idMember) {
		try {
			
    		Query q = session.createQuery("select lm from LevelMember as lm where lm.member.idMember=:idMember ");
    		q.setInteger("idMember", idMember);
    		
    	 
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
	public LevelMember merge(LevelMember level) {
try {
			
			
			// Member m=(Member)session.get(Member.class,1);
		     
		    
	level = (LevelMember) session.merge(
			level);
		
			
		//	 m.setName("toto");
			
			
			return level;
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			re.printStackTrace();
			
			return null;
		}
	}

	@Override
	public boolean delete(LevelMember persistentInstance) {
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
