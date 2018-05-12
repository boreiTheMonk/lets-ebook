package model.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;
import javax.naming.InitialContext;

import model.persistance.Book;
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
 * Home object for domain model class MessageMember.
 * @see model.persistance.MessageMember
 * @author Hibernate Tools
 */
public class MessageMember_dao extends GenericDao implements Itf_messageMember_dao {

	private static final Log log = LogFactory.getLog(MessageMember_dao.class);

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

	public void persist(MessageMember transientInstance) {
		log.debug("persisting MessageMember instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MessageMember instance) {
		log.debug("attaching dirty MessageMember instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MessageMember instance) {
		log.debug("attaching clean MessageMember instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MessageMember persistentInstance) {
		log.debug("deleting MessageMember instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MessageMember merge(MessageMember detachedInstance) {
		log.debug("merging MessageMember instance");
		try {
			MessageMember result = (MessageMember) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			if(t != null) t.rollback();
			throw re;
		}
	}

	public MessageMember findById(int id) {
		log.debug("getting MessageMember instance with id: " + id);
		Session session = HibernateUtil.getSession();
		try {
			MessageMember instance = (MessageMember) session.get("model.persistance.MessageMember",
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
    	finally {
			session.close();
		}
	}

	public List findByExample(MessageMember instance) {
		log.debug("finding MessageMember instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"model.persistance.MessageMember").add(
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
	public List<MessageMember> findMessageMemberByLogin(String login) {
		Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("from MessageMember as mm inner join fetch mm.memberByIdMemberSender as owner inner join where mm.memberByIdMember.login=:login and b.member.idMember=:memberId and mm.deleted=false");
    		q.setString("login",login);
    		
    	    
		return (List<MessageMember>) q.list();
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
	public boolean save(MessageMember transientInstance) {
		log.debug("save MessageMember instance");
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
               //         Session s= HibernateUtil.getSession();

                     //   Transaction t = s.beginTransaction();
                        session.save(transientInstance);
                        //System.out.println(id+ " id");
                       // transientInstance.setIdBook(id);
                      //  t.commit();
                        //System.out.println(id+ " id2");
                       // s.close();
                        log.debug("save successful");
                        return true;
		} catch (RuntimeException re) {
			log.error("savet failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			 return false;
		}
	}
	
	@Override
	public List<MessageMember> loadMessageMember(String login, int min, int max) {
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		Query q = session.createQuery("select mm from MessageMember mm inner join  mm.memberByIdMember memb " +
    				"left join  mm.responseMessageMembers resp left join resp.messageMember	 " +
    				"where memb.login=:login and  mm.deleted=false order by mm.publishDate desc");
    		
    		/*Query q = session.createQuery("select mm from MessageMember mm inner join fetch mm.memberByIdMemberSender memb " +
    				"left join fetch mm.responseMessageMembers resp left join fetch resp.messageMember	 " +
    				"where memb.login=:login order by mm.publishDate desc");*/
    		q.setString("login", login);
    		q.setFirstResult(min);
    	    q.setMaxResults(max);
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
}
