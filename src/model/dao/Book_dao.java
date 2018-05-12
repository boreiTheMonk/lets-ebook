package model.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;

import javax.naming.InitialContext;

import model.persistance.Book;
import model.persistance.ThemeGroup;

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
public class Book_dao extends GenericDao implements Itf_book_dao{

	
	
	private static final Log log = LogFactory.getLog(Book_dao.class);

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

	public void persist(Book transientInstance) {
		log.debug("persisting Book instance");
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                       // Session s= HibernateUtil.getSession();

                       // Transaction t = s.beginTransaction();
                        session.persist(transientInstance);
                       // t.commit();
                        //session.close();
                        log.debug("persist successful");
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			log.error("persist failed", re);
			throw re;
		}
	}
	
	public boolean save(Book transientInstance) {
		log.debug("persisting Book instance");
		try {
			//sessionFactory.getCurrentSession().persist(transientInstance);
                       // Session s= HibernateUtil.getSession();

                       // Transaction t = s.beginTransaction();
                        session.save(transientInstance);
                        //System.out.println(id+ " id");
                       // transientInstance.setIdBook(id);
                        //t.commit();
                        //System.out.println(id+ " id2");
                        //session.close();
                        log.debug("save successful");
                        return true;
		} catch (RuntimeException re) {
			if(t != null) t.rollback();
			log.error("persist failed", re);
			re.printStackTrace();
			 return false;
		}
	}

	public void attachDirty(Book instance) {
		log.debug("attaching dirty Book instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Book instance) {
		log.debug("attaching clean Book instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Book persistentInstance) {
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

	public Book merge(Book detachedInstance) {
		log.debug("merging Book instance");
	//	Session session = HibernateUtil.getSession();
		try {
			
	//		Transaction t = session.beginTransaction();
			Book result = (Book) session.merge(
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

	public Book findById(int id) {
		log.debug("getting Book instance with id: " + id);
		try {
			Book instance = (Book) sessionFactory.getCurrentSession().get(
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

	public List findByExample(Book instance) {
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
	public List<Book> findBooksByMemberId(int memberId) {
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = session.createQuery("from Book as b where b.member.idMember =:memberId and b.deleted=false");
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
	public Book findBookByid( int bookId) {
		//Session session = HibernateUtil.getSession();
		log.debug("look Book instance");
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		System.out.println("titi"+ this.session);
    		Query q = this.session.createQuery("select distinct b from Book as b  where b.idBook=:bookId ");
    		
    		q.setInteger("bookId", bookId);
    	    
		return (Book) q.uniqueResult();
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
	public List<Book> findBooksByString(String searchWord) {
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		System.out.println("List<Book> findBooksByString(String searchWord)");
    		searchWord = "%" + searchWord + "%";

    		
    		Query q = session.createQuery("from Book as b  where (b.description like :searchWord or b.title like :searchWord)  and b.deleted=false");
    		q.setString("searchWord", searchWord);
    	    
		return  q.list();
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
	public int countFindBooksByString(String searchWord) {
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		searchWord = "%" + searchWord + "%";
    		
    		
    		Query q = session.createQuery("select count(b.idBook) from Book b where (b.description like :searchWord or b.title like :searchWord  or b.author like :searchWord)  and b.deleted=false");
    		q.setString("searchWord", searchWord);
    	    
    		try {
    			Long res=(Long) q.uniqueResult();
    			//System.out.println("toto "+res.intValue());
    			return res.intValue();
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    			return 0;
			}
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
    	finally {
			//session.close();
		}
	}

	@Override
	public List<Book> findBooksByString(String searchWord, int min, int max, String orderby) {
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		searchWord = "%" + searchWord + "%";
    		System.out.println("List<Book> findBooksByString(String searchWord, int min, int max) ");
    		
    		Query q = session.createQuery("from Book as b inner join fetch b.member where (b.description like :searchWord or b.title like :searchWord or b.author like :searchWord) and b.deleted=false order by :order  ");
    		q.setString("searchWord", searchWord);
    		q.setString("order", orderby);
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

	@Override
	public int countFindBooksByCategory(int id_category) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
	//	Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    	
    		//Query q = session.createQuery("select count(b.idBook) from Book as b inner join fetch b.category as c inner join fetch c.category as parentC  where c.idCategory =:id_category or parentC.idCategory =:id_category   ");
    		Query q = session.createQuery("select count(b.idBook) from Book as b inner join  b.category as c left join  c.category as parentC  where (c.idCategory =:id_category or parentC.idCategory =:id_category)   and b.deleted=false");
    		
    		q.setInteger("id_category",id_category);
    		//int i=(Integer) session.iterate("select count(*) from ....").next() ).intValue();

    		int i=((Long) q.uniqueResult()).intValue();
    		System.out.println(i);
    		return  i ;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
    	finally {
		//	session.close();
		}
	}

	@Override
	public List<Book> findBooksByCategory(int id_category, int min, int max) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		

    		
    		Query q = session.createQuery("select b from Book as b inner join fetch b.category as c inner join fetch c.category as parentC  where (c.idCategory =:id_category or parentC.idCategory =:id_category)  and b.deleted=false");
    		q.setInteger("id_category",id_category);
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

	@Override
	public List<Book> findSellBooksByLogin(String login, int min,
			int max, String orderby) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		
    		
    		Query q = session.createQuery("from Book as b inner join fetch b.member where b.member.login=:login b.isSell=true  order by :order");
    		q.setString("login", login);
    		q.setString("order", orderby);
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

	@Override
	public List<Book> findBuyBooksByLogin(String login, int min, int max,
			String orderby) {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		
    		
    		Query q = session.createQuery("from Book as b  where b.orderBooks.member.login=:login b.isSell=true  order by :order");
    		q.setString("login", login);
    		q.setString("order", orderby);
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
	public Book findBookOfTheDay() {
		// TODO Auto-generated method stub
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
			//book of the day
			//nb download
			//nb read
			//nb message
			//rating
			//book came last week in priority
			
    		
    		
    		
    		Query q = session.createQuery("select distinct b from Book as b inner join fetch b.member   where (week(b.publishingDate) = week(now())-1 ) and b.deleted=false  and b.nbRead=(SELECT max(bb.nbRead) FROM Book as bb where( week(bb.publishingDate) = week(now())-1 ) and bb.deleted=false )   ");
    		//q.setString("login", login);
    		//q.setString("order", orderby);
    	    //q.setFirstResult(min);
    	   // q.setMaxResults(max);
    		List<Book> l= q.list();
    		if (l.size()==0)
    		{
    			q = session.createQuery("from Book as b inner join fetch b.member where b.deleted=false and b.nbRead>0");
    			l= q.list();
    		}
    		if (l.size()==0)
    		{
    			return null;
    		}
		return l.get(0);
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
	public int countAllBooks() {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		
    		
    		Query q = session.createQuery("select count(b.idBook) from Book as b  where b.deleted=false");
    		 Long res = (Long) q.uniqueResult();
		return res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public List<Book> getBooks(int min, int max, String orderby) {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		//System.out.println("List<Book> findBooksByString(String searchWord, int min, int max) ");
    		
    		Query q = session.createQuery("from Book as b  where b.deleted=false order by "+orderby);
    		
    		//q.setString("order", orderby);
    	    q.setFirstResult(min);
    	   
    	    if(max>0)
    	    q.setMaxResults(max);
		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

	@Override
	public int countFindBooksByGroup(int idGroup) {
		try {

    		Query q = session.createQuery("select g.books.size from ThemeGroup as g inner join g.books b where g.idGroup=:idGroup  and b.deleted=false");
    		 q.setInteger("idGroup", idGroup);
    		 Integer res = (Integer) q.uniqueResult();
    		 if(res==null)
    			 return 0;
		return res;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public List<Book> getBooksByGroup(int idGroup, int min, int max,
			String orderby) {
		if(orderby==null){
			orderby ="b.idBook";
		}
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

    		Query q = session.createQuery("Select b from ThemeGroup as th inner join th.books as b  where th.idGroup=:id   and b.deleted=false order by "+orderby);
    		q.setInteger("id", idGroup);
    		
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

    		Query q = session.createQuery("select count(b.idBook) from Book as b where b.member.idMember=:id and b.deleted=false  ");
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
	public List<Book> getBooksByMemberId(int idMember, int min, int max,
			String orderby) {
		if(orderby==null){
			orderby ="b.idBook";
		}
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

    		Query q = session.createQuery("Select b from Book as b  where b.member.idMember=:id  and b.deleted=false   order by "+orderby);
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

	@Override
	public int countFindFollowBooksByMemberId(int idMember) {
		try {

    		Query q = session.createQuery("select count(b.idBook) from Book as b inner join b.members as m where m.idMember=:id   and b.deleted=false ");
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
	public List<Book> getFollowBooksByMemberId(int idMember, int min, int max,
			String orderby) {
		if(orderby==null){
			orderby ="b.idBook";
		}
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

    		Query q = session.createQuery("Select b from Book as b  inner join b.members as m where m.idMember=:id   and b.deleted=false order by "+orderby);
    		q.setInteger("id", idMember);
    		
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
	public int countFindBooksByMemberinGroup(int idGroup, int idMember) {
		try {

    		Query q = session.createQuery("select count(b.idBook) from ThemeGroup as th inner join th.books as b inner join b.member m  where th.idGroup=:id and m.idMember=:idMember  and b.deleted=false");
    		 q.setInteger("id", idGroup);
    		 q.setInteger("idMember", idMember);
    		 Long res = (Long) q.uniqueResult();
    		 if(res==null)
    			 return 0;
		return res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public List<Book> getBooksByMemberinGroup(int idGroup, int idMember,
			int min, int max, String orderby) {
		if(orderby==null){
			orderby ="b.idBook";
		}
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");

    		Query q = session.createQuery("Select b from ThemeGroup as th inner join th.books as b inner join b.member m  where th.idGroup=:id and m.idMember=:idMember  and b.deleted=false order by "+orderby);
    		q.setInteger("id", idGroup);
    		q.setInteger("idMember", idMember);
    		
    	    q.setFirstResult(min);
    	    q.setMaxResults(max);
		return  q.list();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

	
		
}
