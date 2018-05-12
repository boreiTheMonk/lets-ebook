package model.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;
import javax.naming.InitialContext;

import model.persistance.Category;
import model.persistance.Member;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import core_lib.HibernateUtil;

/**
 * Home object for domain model class Category.
 * @see model.persistance.Category
 * @author Hibernate Tools
 */
public class Category_dao extends GenericDao implements Itf_category_dao {

	private static final Log log = LogFactory.getLog(Category_dao.class);

	private final SessionFactory sessionFactory=null ;

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

	public void persist(Category transientInstance) {
		log.debug("persisting Category instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Category instance) {
		log.debug("attaching dirty Category instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Category instance) {
		log.debug("attaching clean Category instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Category persistentInstance) {
		log.debug("deleting Category instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Category merge(Category detachedInstance) {
		log.debug("merging Category instance");
		try {
			Category result = (Category) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Category findById(int id) {
		log.debug("getting Category instance with id: " + id);
		Session session = HibernateUtil.getSession();
		try {
			Category instance = (Category) session
					.get("model.persistance.Category", id);
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
	
	public List<Category> getAllCategories() {
	 	//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("select distinct c from Category c left join  fetch c.categories as sc left join fetch sc.categories where c.category is NULL order by c.idCategory");
    		
    	    
		return (List<Category>) q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
    	finally {
		//	session.close();
		}
	}

	public List findByExample(Category instance) {
		log.debug("finding Category instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"model.persistance.Category").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public boolean save(Category c) {
		try {
            session.save( c);
     
            log.debug("save successful");
            return true;
		} catch (RuntimeException re) {
			log.error("savet failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			return false;
		}
	}
}
