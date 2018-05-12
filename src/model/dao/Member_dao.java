package model.dao;

// Generated 14 janv. 2010 03:18:48 by Hibernate Tools 3.2.4.GA

import java.util.List;

import javax.naming.InitialContext;

import model.persistance.LevelMember;
import model.persistance.Member;

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
public class Member_dao extends GenericDao implements Itf_member_dao{

	private static final Log log = LogFactory.getLog(Member_dao.class);
	
	
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

	public void persist(Member transientInstance) {
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

	public void attachDirty(Member instance) {
		log.debug("attaching dirty Member instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Member instance) {
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

	public boolean delete(Member persistentInstance) {
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

	public Member merge(Member detachedInstance) {
		log.debug("merging Member instance");
		
		try {
			
			
			// Member m=(Member)session.get(Member.class,1);
		     
		    
			 detachedInstance = (Member) session.merge(
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
	public Member findById(int id) {
		//Session session = HibernateUtil.getSession();
		try {
			//System.out.println("session dans inter"+ session);
			Member instance = (Member)session.get(
					Member.class, id);
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
	public Member findMemberByLogin(String login) {
	 	//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		System.out.println("toto"+this.session);
    		Query q = this.session.createQuery("from Member as m where m.login =:monLogin and m.deleted=false");
    		q.setString("monLogin", login);
    	    Member m =(Member)  q.uniqueResult();
    	    
    	    //get the class name and job name
    	    try{
    	    Hibernate.initialize(((LevelMember)m.getLevelMembers().iterator().next()).getClassMember().getJobs().iterator().next());
    	    }
    	    catch (RuntimeException e) {
				// TODO: handle exception
    	    	return m;
			}
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
	
	


	public List findByExample(Member instance) {
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
	public List<Member> findMemberByString(String searchWord) {
	 	Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		searchWord = "%" + searchWord + "%";
    		Query q = session.createQuery("from Member as m where m.login like :searchWord or m.name like :searchWord or  m.lastName like :searchWord or m.description like :searchWord and m.deleted=false" );
    		
    		q.setString("searchWord", searchWord);
		return (List<Member>) q.list();
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
	public int countFindMemberByString(String searchWord) {
	 	//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		searchWord = "%" + searchWord + "%";
    		Query q = session.createQuery("select count(idMember) from Member as m where m.login like :searchWord and m.deleted=false" );
    		
    		q.setString("searchWord", searchWord);
    		try {
    			return ((Long) q.uniqueResult()).intValue();
    			
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
	public List<Member> findMembersByString(String searchWord, int min,
			int max, String orderby) {
		// TODO Auto-generated method stub
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
			if(orderby==null)
				orderby="m.login asc";
    		searchWord = "%" + searchWord + "%";
    		//System.out.println("List<Book> findBooksByString(String searchWord, int min, int max) ");
    		
    		Query q = session.createQuery("from Member as m where m.login like :searchWord and m.deleted=false order by "+orderby);
    		q.setString("searchWord", searchWord);
    		//q.setString("order", orderby);
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
	public List<Member> getMembers(int min, int max, String orderby) {
		// TODO Auto-generated method stub
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		
    		//System.out.println("List<Book> findBooksByString(String searchWord, int min, int max) ");
    		
    		Query q = session.createQuery("from Member m where  m.deleted=false order by "+orderby);
    		
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
    		
    		Query q = session.createQuery("select count(m.idMember) from Member as m where  m.deleted=false ");
    		
    		Long res = (Long) q.uniqueResult();
    	  
		return  res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public boolean save(Member transientInstance) {
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

	@Override
	public List<Member> findFollowersById(int idMember, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="m.idMember";
		try {
		
    		Query q = session.createQuery("select f from Member as m inner join m.membersForIdMemberFollow as f where m.idMember=:id and m.deleted=false order by "+orderby);
    		q.setInteger("id", idMember);
    		
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
	public List<Member> findFollowersByLogin(String login, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="m.idMember";
		try {
		
    		Query q = session.createQuery("select f from Member as m inner join m.membersForIdMemberFollow as f where m.login=:login and m.deleted=false order by "+orderby);
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

	@Override
	public List<Member> findFriendsById(int idMember, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="m.idMember asc";
		
		try {
		
    		Query q = session.createQuery("select f from Member as m inner join m.membersForIdMemberFriend as f where m.idMember=:id and m.deleted=false order by "+orderby);
		//	Query q = session.createQuery("select f from RequestFriend rf inner join Member as m inner join m.membersForIdMemberFriend as f where m.idMember=:id order by "+orderby);
    		q.setInteger("id", idMember);
    		
    	    q.setFirstResult(min);
    	    if (max!=-1)
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
	public List<Member> findFriendsByLogin(String login, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="m.idMember";
		try {
		
    		Query q = session.createQuery("select f from Member as m inner join m.membersForIdMember_1 as f where m.login=:login and m.deleted=false order by "+orderby);
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

	@Override
	public List<Member> findWatchersById(int idMember, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="m.idMember";
		try {
		
    		Query q = session.createQuery("select f from Member as m inner join m.membersForIdMember_1 as f  where m.idMember=:id  and m.deleted=false order  by "+orderby);
    		q.setInteger("id", idMember);
    	
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
	public List<Member> findWatchersByLogin(String login, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="m.idMember";
		try {
		
    		Query q = session.createQuery("select f from Member as m inner join m.membersForIdMember_1 as f where m.login=:login and m.deleted=false order by "+orderby);
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

	@Override
	public long countFollowersById(int idMember) {
		try {
		
    		Query q = session.createQuery("select m.membersForIdMemberFollow.size from Member as m where m.idMember=:id and m.deleted=false");
    		q.setInteger("id", idMember);
    		int res = (Integer) q.uniqueResult();
    	  
		return  res;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public long countFollowersByLogin(String login) {
		try {
			
    		Query q = session.createQuery("select m.membersForIdMemberFollow.size from Member as m where m.login=:login and m.deleted=false ");
    		q.setString("login", login);
    		Long res = (Long) q.uniqueResult();
    	  
		return  res;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public long countFriendsById(int idMember) {
		try {
			
    		Query q = session.createQuery("select m.membersForIdMemberFriend.size from Member as m where m.idMember=:id and m.deleted=false");
    		q.setInteger("id", idMember);
    		int res = (Integer) q.uniqueResult();
    	  
		return  res;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public long countFriendsByLogin(String login) {
	try {
			
    		Query q = session.createQuery("select m.membersForIdMemberFriend.size from Member as m where m.login=:login and m.deleted=false");
    		q.setString("login", login);
    		int res = (Integer)  q.uniqueResult();
    	  
		return  res;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public long countWatchersById(int idMember) {
		try {
			
    		Query q = session.createQuery("select m.membersForIdMember_1.size from Member as m where m.idMember=:id and m.deleted=false");
    		q.setInteger("id", idMember);
    		int res = (Integer)  q.uniqueResult();
    	  
		return  res;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public long countWatchersByLogin(String login) {
		try {
			
    		Query q = session.createQuery("select m.membersForIdMember_1.size from Member as m where m.login=:login and m.deleted=false");
    		q.setString("login", login);
    		Long res = (Long) q.uniqueResult();
    	  
		return  res;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public boolean isFollow(int followee, int follower) {
		try {
		
    		Query q = session.createQuery("select m from Member as m inner join m.membersForIdMemberFollow as f where m.idMember=:follower and f.idMember=:followee and m.deleted=false");
    		q.setInteger("followee", followee);
    		q.setInteger("follower", follower);
    		
    	   
		List res=  q.list();
		if(res.size()>0)
			return true;
		else
			return false;
		
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
	public boolean isFriend(int idFriend1, int idFriend2) {
		try {
			
    		Query q = session.createQuery("select m from Member as m inner join m.membersForIdMemberFriend as friends inner join friends.membersForIdMemberFriend as friendsOfFriends where m.idMember=:idFriend1 and friends.idMember=:idFriend2 and friendsOfFriends.idMember=:idFriend1 and m.deleted=false");
    		q.setInteger("idFriend1", idFriend1);
    		q.setInteger("idFriend2", idFriend2);
    		
    	   
		List res=  q.list();
		if(res.size()>0)
			return true;
		else
			return false;
		
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
	public long countMemberByGroupId(int idGroup) {
	try {
			
		Query q = session.createQuery("select count(m.idMember) from ThemeGroup as g inner join g.members as m  where g.idGroup=:idGroup and m.deleted=false");
		q.setInteger("idGroup", idGroup);
    		Long res = (Long) q.uniqueResult();
    	  
		return  res;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public List<Member> findMemberByGroupId(int idGroup, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="m.idMember";
		try {
		
    		Query q = session.createQuery("select m from ThemeGroup as g inner join g.members as m  where g.idGroup=:idGroup and m.deleted=false order by "+orderby);
    		q.setInteger("idGroup", idGroup);
    		
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
	public Member findMemberByemail(String email) {
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		System.out.println("toto"+this.session);
    		Query q = this.session.createQuery("from Member as m where m.email =:email and m.deleted=false");
    		q.setString("email",email);
    	    List <Member> m =  q.list();
    	    if(m!=null){
    	    	 if(m.size()>0){
    	    		 return m.get(0);
    	    		 }
    	    }
    	    
    	    
    	    return null;
    	    //get the class name and job name
    	    
    	    
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
	public int count_referree(String login) {
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    	
    		Query q = session.createQuery("select count(idMember) from Member as m where m.loginReferer=:login and m.deleted=false" );
    		
    		q.setString("login", login);
    		try {
    			return ((Long) q.uniqueResult()).intValue();
    			
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

	

}
