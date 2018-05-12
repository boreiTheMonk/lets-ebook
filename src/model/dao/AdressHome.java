package model.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;
import javax.naming.InitialContext;

import model.persistance.Adress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Adress.
 * @see model.persistance.Adress
 * @author Hibernate Tools
 */
public class AdressHome {

	private static final Log log = LogFactory.getLog(AdressHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

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

	public void persist(Adress transientInstance) {
		log.debug("persisting Adress instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Adress instance) {
		log.debug("attaching dirty Adress instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Adress instance) {
		log.debug("attaching clean Adress instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Adress persistentInstance) {
		log.debug("deleting Adress instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Adress merge(Adress detachedInstance) {
		log.debug("merging Adress instance");
		try {
			Adress result = (Adress) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Adress findById(int id) {
		log.debug("getting Adress instance with id: " + id);
		try {
			Adress instance = (Adress) sessionFactory.getCurrentSession().get(
					"model.persistance.Adress", id);
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

	public List findByExample(Adress instance) {
		log.debug("finding Adress instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"model.persistance.Adress").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
