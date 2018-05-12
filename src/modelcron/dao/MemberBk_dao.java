package modelcron.dao;

// Generated 14 janv. 2010 03:18:48 by Hibernate Tools 3.2.4.GA

import java.util.List;

import javax.naming.InitialContext;


import modelcron.persistance.MemberBk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import core_lib.HibernateUtil;

/**
 * Home object for domain model class Member.
 * @see model.persistance.Member
 * @author Hibernate Tools
 */
public class MemberBk_dao extends GenericDao implements Itf_memberBk_dao{

	private static final Log log = LogFactory.getLog(MemberBk_dao.class);
	
	
	/*@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction t;*/
	
	private  SessionFactory sessionFactory ;

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MemberBk transientInstance) {
		log.debug("persisting Member instance");
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                        //Session s= HibernateUtil.getSession();

                       // Transaction t = s.beginTransaction();
                        session.persist(transientInstance);
                        //t.commit();
                        //s.close();
                        log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MemberBk instance) {
		log.debug("attaching dirty Member instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MemberBk instance) {
		log.debug("attaching clean Member instance");
		try {
			//sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			System.out.println(session.contains(instance));
			session.clear();
			session.lock(instance, LockMode.NONE);
		//	session.buildLockRequest(LockMode).lock(entityName, object)
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			System.out.println("attachClean error");
			re.printStackTrace();
			throw re;
		}
	}

	public boolean delete(MemberBk persistentInstance) {
		log.debug("deleting Member instance");
		try {
			session.delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			log.error("delete failed", re);
			re.printStackTrace();
			return false;
		}
		return true;
	}

	public MemberBk merge(MemberBk detachedInstance) {
		log.debug("merging Member instance");
		
		try {
			
			
			// Member m=(Member)session.get(Member.class,1);
		     
		    
			 detachedInstance = (MemberBk) session.merge(
					detachedInstance);
		
			
		//	 m.setName("toto");
			
			log.debug("merge successful");
			return detachedInstance;
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			re.printStackTrace();
			log.error("merge failed", re);
			return null;
		}
	}

	@Override
	public MemberBk findById(int id) {
		//Session session = HibernateUtil.getSession();
		try {
			//System.out.println("session dans inter"+ session);
			MemberBk instance = (MemberBk)session.get(
					MemberBk.class, id);
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
	public MemberBk findMemberByLogin(String login) {
	 	//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		System.out.println("toto"+this.session);
    		Query q = this.session.createQuery("from MemberBk as m where m.login =:monLogin ");
    		q.setString("monLogin", login);
    	    MemberBk m =(MemberBk)  q.uniqueResult();
    	
    	   
    	    return m;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
    	finally {
			//session.close();
		}
	}
	
	


	public List findByExample(MemberBk instance) {
		log.debug("finding Member instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"src.Member").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	

	@Override
	public List<MemberBk> getMembers(int min, int max, String orderby) {
		// TODO Auto-generated method stub
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		//System.out.println("List<Book> findBooksByString(String searchWord, int min, int max) ");
    		
    		Query q = session.createQuery("from MemberBk m  order by "+orderby);
    		
    		//q.setString("order", orderby);
    	    q.setFirstResult(min);
    	    
    	    if(max>=0)
    	    q.setMaxResults(max);
		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

	@Override
	public int countAllMembers() {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		//System.out.println("List<Book> findBooksByString(String searchWord, int min, int max) ");
    		
    		Query q = session.createQuery("select count(m.idMember) from MemberBk as m    ");
    		
    		Long res = (Long) q.uniqueResult();
    	  
		return  res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public boolean save(MemberBk transientInstance) {
		try {
			
            session.save(transientInstance);
   
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
