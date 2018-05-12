package model.dao;

// Generated 5 févr. 2010 00:51:10 by Hibernate Tools 3.2.4.GA

import java.util.List;
import javax.naming.InitialContext;

import model.persistance.Book;
import model.persistance.Member;
import model.persistance.ThemeGroup;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class ThemeGroup.
 * @see model.persistance.ThemeGroup
 * @author Hibernate Tools
 */
public class ThemeGroup_dao extends GenericDao implements Itf_group_dao {

	private static final Log log = LogFactory.getLog(ThemeGroup_dao.class);

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

	public void persist(ThemeGroup transientInstance) {
		log.debug("persisting ThemeGroup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ThemeGroup instance) {
		log.debug("attaching dirty ThemeGroup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ThemeGroup instance) {
		log.debug("attaching clean ThemeGroup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ThemeGroup persistentInstance) {
		log.debug("deleting ThemeGroup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ThemeGroup merge(ThemeGroup detachedInstance) {
		log.debug("merging ThemeGroup instance");
		try {
			ThemeGroup result = (ThemeGroup)session
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ThemeGroup findById(int id) {
		log.debug("getting ThemeGroup instance with id: " + id);
		try {
			ThemeGroup instance = (ThemeGroup) session.get(model.persistance.ThemeGroup.class, id);
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

	public List findByExample(ThemeGroup instance) {
		log.debug("finding ThemeGroup instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria(
					"model.persistance.ThemeGroup").add(
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
	public List<ThemeGroup> findAllGroupByIdMember(int idMember) {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		System.out.println("toto"+this.session);
    		Query q = this.session.createQuery("from ThemeGroup as g where g.member.idMember =:id_member and g.deleted=false");
    		q.setInteger("id_member", idMember);
    	    
		return (List<ThemeGroup>) q.list();
    	}catch (RuntimeException e) {
		//if(t != null) t.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

	@Override
	public boolean save(ThemeGroup group) {
		try {
                        session.save( group);
                 
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
	public long countJoinGroupById(int idMember) {
		try {
    		Query q = session.createQuery("select count(g.idGroup) from ThemeGroup g inner join g.members m  where m.idMember=:id and g.deleted=false");
    		q.setInteger("id", idMember);
    		Long res = (Long) q.uniqueResult();
    	  
		return  res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}


	@Override
	public long countJoinGroupByLogin(String login) {
		try {
    		Query q = session.createQuery("select count(g.idGroup) from ThemeGroup g inner join g.members m  where m.login=:login and g.deleted=false");
    		q.setString("login", login);
    		Long res = (Long) q.uniqueResult();
    	  
		return  res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public long countOwnGroupById(int idMember) {
		try {
    		Query q = session.createQuery("select count(g.idGroup) from ThemeGroup g inner join g.member m  where m.idMember=:id and g.deleted=false");
    		q.setInteger("id", idMember);
    		Long res = (Long) q.uniqueResult();
    	  
		return  res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public long countOwnGroupByLogin(String login) {
		try {
    		Query q = session.createQuery("select count(g.idGroup) from ThemeGroup g inner join g.member m  where m..login=:login and g.deleted=false");
    		q.setString("login", login);
    		Long res = (Long) q.uniqueResult();
    	  
		return  res.intValue();
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}

	@Override
	public List<ThemeGroup> findJoinGroupById(int idMember, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="g.idGroup";
		try {
		
    		Query q = session.createQuery("select g from ThemeGroup as g inner join g.members m  where m.idMember=:id and g.deleted=false order by "+orderby);
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
	public List<ThemeGroup> findJoinGroupByLogin(String login, int min,
			int max, String orderby) {
		if(orderby==null)
		orderby="g.idGroup";
		try {
		
    		Query q = session.createQuery("select g from ThemeGroup as g inner join g.members m  where m.login=:login and g.deleted=false order by "+orderby);
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
	public List<ThemeGroup> findOwnGroupById(int idMember, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="g.idGroup";
		try {
		
    		Query q = session.createQuery("select g from ThemeGroup as g inner join g.member m  where m.idMember=:id and g.deleted=false order by "+orderby);
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
	public List<ThemeGroup> findOwnGroupByLogin(String login, int min, int max,
			String orderby) {
		if(orderby==null)
			orderby="g.idGroup";
			try {
			
	    		Query q = session.createQuery("select g from ThemeGroup as g inner join g.member m  where m.login=:login and g.deleted=false order by "+orderby);
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
	public int countFindGroupByString(String searchWord) {
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		searchWord = "%" + searchWord + "%";
    		Query q = session.createQuery("select count(idGroup) from ThemeGroup as g where (g.name like :searchWord or g.description  like :searchWord) and g.deleted=false " );
    		
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
	}

	@Override
	public List<ThemeGroup> findGroupByString(String searchWord, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
			if(orderby==null)
				orderby="g.name asc";
    		searchWord = "%" + searchWord + "%";
    		//System.out.println("List<Book> findBooksByString(String searchWord, int min, int max) ");
    		
    		Query q = session.createQuery("from ThemeGroup as g where (g.name like :searchWord or g.description like :searchWord) and g.deleted=false order by "+orderby);
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
	public boolean isFollowGroup(int idMember, int idGroup) {
		try {
			
    		Query q = session.createQuery("select g from Member as m inner join m.themeGroups_1 as g where m.idMember=:idMember and g.idGroup=:idGroup and g.deleted=false");
    		q.setInteger("idMember", idMember);
    		q.setInteger("idGroup", idGroup);
    		
    	   
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
	public boolean isGroupOwner(int idMember, int idGroup) {
	try {
			
    		Query q = session.createQuery("select g from Member as m inner join m.themeGroups as g where m.idMember=:idMember and g.idGroup=:idGroup");
    		q.setInteger("idMember", idMember);
    		q.setInteger("idGroup", idGroup);
    		
    	   
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
}
