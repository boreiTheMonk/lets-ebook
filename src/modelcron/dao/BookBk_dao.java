package modelcron.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;

import javax.naming.InitialContext;

import modelcron.persistance.BookBk;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import core_lib.HibernateUtil;

/**
 * Home object for domain model class Book.
 * @see model.persistance.Book
 * @author Hibernate Tools
 */
public class BookBk_dao extends GenericDao implements Itf_bookBk_dao{

	
	
	private static final Log log = LogFactory.getLog(BookBk_dao.class);

	private final SessionFactory sessionFactory =null;

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

	public void persist(BookBk transientInstance) {
		log.debug("persisting Book instance");
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                        Session s= HibernateUtil.getSession();

                        Transaction t = s.beginTransaction();
                        s.persist(transientInstance);
                        t.commit();
                        s.close();
                        log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	
	public boolean save(BookBk transientInstance) {
		log.debug("persisting Book instance");
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                        Session s= HibernateUtil.getSession();

                        Transaction t = s.beginTransaction();
                        s.save(transientInstance);
                        //System.out.println(id+ " id");
                       // transientInstance.setIdBook(id);
                        t.commit();
                        //System.out.println(id+ " id2");
                        s.close();
                        log.debug("save successful");
                        return true;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			re.printStackTrace();
			 return false;
		}
	}

	public void attachDirty(BookBk instance) {
		log.debug("attaching dirty Book instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BookBk instance) {
		log.debug("attaching clean Book instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BookBk persistentInstance) {
		log.debug("deleting Book instance");

		
		//Session session = HibernateUtil.getSession();
		try {
			
			//Transaction t = session.beginTransaction();
			 session.delete(
					persistentInstance);
			   t.commit();
			log.debug("delete successful");
			System.out.println("delete ok");
			
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			log.error("delete failed", re);
			re.printStackTrace();
			throw re;
		}
	}

	public BookBk merge(BookBk detachedInstance) {
		log.debug("merging Book instance");
	//	Session session = HibernateUtil.getSession();
		try {
			
	//		Transaction t = session.beginTransaction();
			BookBk result = (BookBk) session.merge(
					detachedInstance);
			//   t.commit();
			log.debug("merge successful");
			System.out.println("merge ok");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			re.printStackTrace();
			throw re;
		}
	}

	public BookBk findById(int id) {
		log.debug("getting Book instance with id: " + id);
		try {
			BookBk instance = (BookBk) sessionFactory.getCurrentSession().get(
					"model.persistance.Book", id);
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

	public List findByExample(BookBk instance) {
		log.debug("finding Book instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"model.persistance.Book").add(Example.create(instance))
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
	public List<BookBk> findBooksByMemberId(int memberId) {
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("from BookBk as b where b.member.idMember =:memberId ");
    		q.setInteger("memberId", memberId);
    	    
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

/*	@Override
	public Book findBookByid(int memberId, int bookId) {
		Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("from Book as b where b.idBook=:bookId and b.member.idMember=:memberId");
    		q.setInteger("memberId", memberId);
    		q.setInteger("bookId", bookId);
    	    
		return (Book) q.uniqueResult();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
    	finally {
			session.close();
		}
	}
*/
	
	@Override
	public BookBk findBookByid( int bookId) {
		//Session session = HibernateUtil.getSession();
		log.debug("look Book instance");
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		System.out.println("titi"+ this.session);
    		Query q = this.session.createQuery("select distinct b from BookBk as b  where b.idBook=:bookId ");
    		
    		q.setInteger("bookId", bookId);
    	    
		return (BookBk) q.uniqueResult();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
    	finally {
			//session.close();
		}
	}
	
	
	

	@Override
	public int countAllBooks() {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		
    		
    		Query q = session.createQuery("select count(b.idBook) from BookBk as b  where b.deleted=false");
    		 Long res = (Long) q.uniqueResult();
		return res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public List<BookBk> getBooks(int min, int max, String orderby) {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		//System.out.println("List<Book> findBooksByString(String searchWord, int min, int max) ");
    		
    		Query q = session.createQuery("from BookBk as b   order by "+orderby);
    		
    		//q.setString("order", orderby);
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
	public int countFindBooksByMemberId(int idMember) {
		try {

    		Query q = session.createQuery("select count(b.idBook) from BookBk as b where b.member.idMember=:id and b.deleted=false  ");
    		q.setInteger("id", idMember); 
    		Long res = (Long) q.uniqueResult();
		return res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public List<BookBk> getBooksByMemberId(int idMember, int min, int max,
			String orderby) {
		if(orderby==null){
			orderby ="b.idBook";
		}
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

    		Query q = session.createQuery("Select b from BookBk as b  where b.member.idMember=:id  and b.deleted=false   order by "+orderby);
    		q.setInteger("id", idMember);
    		
    	    q.setFirstResult(min);
    	    if(max!=0)
    	    q.setMaxResults(max);
		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}
		
}
