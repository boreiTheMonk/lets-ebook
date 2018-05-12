package model.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;
import javax.naming.InitialContext;

import model.persistance.FavouriteAuthor;
import model.persistance.Member;
import model.persistance.MessageMember;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import core_lib.HibernateUtil;

/**
 * Home object for domain model class FavouriteAuthor.
 * @see model.persistance.FavouriteAuthor
 * @author Hibernate Tools
 */
public class FavouriteAuthor_dao extends GenericDao implements Itf_favorite_author_dao{

	private static final Log log = LogFactory.getLog(FavouriteAuthor_dao.class);

	private final SessionFactory sessionFactory = null;

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

	public void persist(FavouriteAuthor transientInstance) {
		log.debug("persisting FavouriteAuthor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FavouriteAuthor instance) {
		log.debug("attaching dirty FavouriteAuthor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FavouriteAuthor instance) {
		log.debug("attaching clean FavouriteAuthor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FavouriteAuthor persistentInstance) {
		log.debug("deleting FavouriteAuthor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FavouriteAuthor merge(FavouriteAuthor detachedInstance) {
		log.debug("merging FavouriteAuthor instance");
		try {
			FavouriteAuthor result = (FavouriteAuthor) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FavouriteAuthor findById(int id) {
		log.debug("getting FavouriteAuthor instance with id: " + id);
		try {
			FavouriteAuthor instance = (FavouriteAuthor) sessionFactory
					.getCurrentSession().get(
							"model.persistance.FavouriteAuthor", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(FavouriteAuthor instance) {
		log.debug("finding FavouriteAuthor instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"model.persistance.FavouriteAuthor").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}



	@Override
	public List<FavouriteAuthor> findFavoriteAuthorByMemberId(int id) {
		Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("from FavouriteAuthor fa  where fa.member.idMember =:id");
    		q.setInteger("id", id);
    	    
		return (List<FavouriteAuthor>) q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
    	finally {
			session.close();
		}
	}

	@Override
	public boolean save(FavouriteAuthor transientInstance) {
		// TODO Auto-generated method stub
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                    //   Session s= HibernateUtil.getSession();

                     //   Transaction t = s.beginTransaction();
                        session.save(transientInstance);
                     //   t.commit();
                     //   s.close();
                        log.debug("save successful");
                        return true;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			
			return false;
		}
	}

	@Override
	public boolean deleteAllByMemberId(int id) {
		//Session session = HibernateUtil.getSession();
    	try {
		//	Transaction t =session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("Delete from FavouriteAuthor fa  where fa.member.idMember =:id");
    		q.setInteger("id", id);
    		q.executeUpdate();
    		//t.commit();
		return  true;
    	}catch (RuntimeException e) {
		if(t != null) t.rollback();
    		e.printStackTrace();
		return false;
    	}
    	finally {
			//session.close();
		}
	}

	@Override
	public boolean saveListFavAuth(List<FavouriteAuthor> transientInstance) {
		// TODO Auto-generated method stub
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                     //   Session s= HibernateUtil.getSession();

                      //  Transaction t = s.beginTransaction();
                        for(FavouriteAuthor fa:transientInstance)
                        	session.save(fa);
                        
                       // t.commit();
                       // s.close();
                        log.debug("save successful");
                        return true;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			return false;
		}
	}

}
