package model.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;

import javax.naming.InitialContext;

import model.persistance.MessageGroup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class MessageGroup.
 * @see model.persistance.MessageGroup
 * @author Hibernate Tools
 */
public class MessageGroupeHome {

	private static final Log log = LogFactory.getLog(MessageGroupeHome.class);

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

	public void persist(MessageGroup transientInstance) {
		log.debug("persisting MessageGroup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MessageGroup instance) {
		log.debug("attaching dirty MessageGroup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MessageGroup instance) {
		log.debug("attaching clean MessageGroup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MessageGroup persistentInstance) {
		log.debug("deleting MessageGroup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MessageGroup merge(MessageGroup detachedInstance) {
		log.debug("merging MessageGroup instance");
		try {
			MessageGroup result = (MessageGroup) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MessageGroup findById(int id) {
		log.debug("getting MessageGroup instance with id: " + id);
		try {
			MessageGroup instance = (MessageGroup) sessionFactory
					.getCurrentSession().get("model.persistance.MessageGroup",
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

	public List findByExample(MessageGroup instance) {
		log.debug("finding MessageGroup instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"model.persistance.MessageGroup").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
