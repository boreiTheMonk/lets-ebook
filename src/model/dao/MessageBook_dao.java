package model.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;
import javax.naming.InitialContext;

import model.persistance.MessageBook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class MessageBook.
 * @see model.persistance.MessageBook
 * @author Hibernate Tools
 */
public class MessageBook_dao extends GenericDao implements Itf_messageBook_dao{

	private static final Log log = LogFactory.getLog(MessageBook_dao.class);

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

	public void persist(MessageBook transientInstance) {
		log.debug("persisting MessageBook instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MessageBook instance) {
		log.debug("attaching dirty MessageBook instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MessageBook instance) {
		log.debug("attaching clean MessageBook instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MessageBook persistentInstance) {
		log.debug("deleting MessageBook instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MessageBook merge(MessageBook detachedInstance) {
		log.debug("merging MessageBook instance");
		try {
			MessageBook result = (MessageBook) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			log.error("merge failed", re);
			throw re;
		}
	}

	public MessageBook findById(int id) {
		log.debug("getting MessageBook instance with id: " + id);
		try {
			MessageBook instance = (MessageBook) session.get(MessageBook.class,
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

	public List findByExample(MessageBook instance) {
		log.debug("finding MessageBook instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"model.persistance.MessageBook").add(
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
	public List<MessageBook> loadMessageBook(int idBook, int min, int max) {
		// TODO Auto-generated method stub
		try {
			/*Query q = session.createQuery("select mb from MessageMember mm inner join fetch mm.memberByIdMemberSender memb " +
    				"left join fetch mm.responseMessageMembers resp left join fetch resp.messageMember	 " +
    				"where memb.login=:login order by mm.publishDate desc");
			*/
    		Query q = session.createQuery("select mb from MessageBook mb" +
    				" where mb.book.idBook=:idBook  and mb.deleted=false order by mb.publishDate desc");

    		q.setInteger("idBook", idBook);
    		q.setFirstResult(min);
    	    q.setMaxResults(max);
		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

	@Override
	public boolean save(MessageBook transientInstance) {
		// TODO Auto-generated method stub
		try {
		
                        session.save(transientInstance);
               
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
