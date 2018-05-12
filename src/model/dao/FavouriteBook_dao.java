package model.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;
import javax.naming.InitialContext;

import model.persistance.FavouriteAuthor;
import model.persistance.FavouriteBook;

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
 * Home object for domain model class FavouriteBook.
 * @see model.persistance.FavouriteBook
 * @author Hibernate Tools
 */
public class FavouriteBook_dao extends GenericDao implements Itf_favorite_book_dao {

	private static final Log log = LogFactory.getLog(FavouriteBook_dao.class);

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

	public void persist(FavouriteBook transientInstance) {
		log.debug("persisting FavouriteBook instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FavouriteBook instance) {
		log.debug("attaching dirty FavouriteBook instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FavouriteBook instance) {
		log.debug("attaching clean FavouriteBook instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FavouriteBook persistentInstance) {
		log.debug("deleting FavouriteBook instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FavouriteBook merge(FavouriteBook detachedInstance) {
		log.debug("merging FavouriteBook instance");
		try {
			FavouriteBook result = (FavouriteBook) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FavouriteBook findById(int id) {
		log.debug("getting FavouriteBook instance with id: " + id);
		try {
			FavouriteBook instance = (FavouriteBook) sessionFactory
					.getCurrentSession().get("model.persistance.FavouriteBook",
							id);
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

	public List findByExample(FavouriteBook instance) {
		log.debug("finding FavouriteBook instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"model.persistance.FavouriteBook").add(
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
	public boolean deleteAllByMemberId(int id) {
	//	Session session = HibernateUtil.getSession();
    	try {
		//	Transaction t =session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("Delete from FavouriteBook fb  where fb.member.idMember =:id");
    		q.setInteger("id", id);
    		q.executeUpdate();
    		//t.commit();
		return  true;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return false;
    	}
    	finally {
		//	session.close();
		}
	}

	@Override
	public List<FavouriteBook> findFavoriteBookByMemberId(int id) {
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("from FavouriteBook fb  where fb.member.idMember =:id");
    		q.setInteger("id", id);
    	    
		return (List<FavouriteBook>) q.list();
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
	public boolean save(FavouriteBook transientInstance) {
		// TODO Auto-generated method stub
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                      //  Session s= HibernateUtil.getSession();

                     //   Transaction t = s.beginTransaction();
                        session.save(transientInstance);
                       
                      //  t.commit();
                      //  s.close();
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
	public boolean saveListFavBook(List<FavouriteBook> transientInstance) {
		// TODO Auto-generated method stub
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                      //  Session s= HibernateUtil.getSession();

                      //  Transaction t = s.beginTransaction();
                        for(FavouriteBook fb:transientInstance){
                        	session.save(fb);
                        	 System.out.println(fb.getMember().getLogin()+" "+fb.getBookName()+" "+fb.getIdLivre());
                        }
                        
                       // t.commit();
                       // s.close();
                        log.debug("save successful");
                        return true;
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			log.error("persist failed", re);
			re.printStackTrace();
			
			return false;
		}
	}
}
