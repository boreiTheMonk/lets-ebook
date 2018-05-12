package model.dao;

import java.util.List;

import model.persistance.OrderCustomer;

import org.hibernate.Query;

public class OrderCustomer_dao extends GenericDao implements Itf_orderCustomer_dao  {

	@Override
	public boolean save(OrderCustomer o) {
		try {
            session.save(o);
     
         //   log.debug("save successful");
            return true;
		} catch (RuntimeException re) {
		//	log.error("savet failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			return false;
		}
	}

	@Override
	public OrderCustomer findById(int id) {
		try {
			//System.out.println("session dans inter"+ session);
			OrderCustomer instance = (OrderCustomer)session.get(
					OrderCustomer.class, id);
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
	}

	@Override
	public List<OrderCustomer> findOrderCustomerBySeller(int memberId) {
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = this.session.createQuery("Select o from OrderCustomer as o inner join o.orderBooks ob where ob.book.member.idMember=:memberId");
    		q.setInteger("memberId", memberId);
    		List<OrderCustomer>  o=(List<OrderCustomer> )  q.list();
    	    
    	    //get the class name and job name
    	   
    	    return o;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

	@Override
	public boolean isMemberBuyBook(int memberId, int bookId) {
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = this.session.createQuery("Select o from OrderCustomer as o inner join o.orderBooks ob where o.member.idMember=:memberId and ob.book.idBook=:bookId and o.isTreated=true");
    		q.setInteger("memberId", memberId);
    		q.setInteger("bookId", bookId);
    		
    		OrderCustomer o=(OrderCustomer)  q.uniqueResult();
    	    if(o==null)
    	    	return false;
    	    else
    	    	return true;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return false;
    	}
	}

	@Override
	public OrderCustomer findOrderCustomerByrefOrder(String refOrder) {
		//Session session = HibernateUtil.getSession();
    	try {
			//session.beginTransaction();
		//Query q = session.createSQLQuery("Select EVENT_ID, EVENT_DATE, title from events e where e.EVENT_ID =:eventId");
    		
    		Query q = this.session.createQuery("Select o from OrderCustomer as o where o.refOrder=:refOrder");
    		q.setString("refOrder", refOrder);
    	
    		
    		OrderCustomer o=(OrderCustomer)  q.uniqueResult();
    	
    	    	return o;
    	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return null;
    	}
	}

}
