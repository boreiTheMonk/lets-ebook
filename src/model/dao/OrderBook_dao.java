package model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import model.persistance.Book;
import model.persistance.Member;
import model.persistance.MessageEmail;
import model.persistance.OrderBook;

public class OrderBook_dao extends GenericDao implements Itf_order_book_dao {
//for orders, we treated when we pay the sellers
//change to is_seller_paid
	
	
	@Override
	public double showDueOrder(Member m) {
		// TODO Auto-generated method stub
		try{
		Query q = session.createQuery("select sum(price) from OrderBook as ob  where ob.book.member.login=:login and ob.isTreated=false and ob.orderCustomer.isTreated=true ");
		q.setString("login", m.getLogin());
	
		return  Double.parseDouble(q.uniqueResult().toString());
		}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
			e.printStackTrace();
		return 0.0;
	}
		
	}

	@Override
	public List<OrderBook> showOrderBydate(Member m, Date start, Date end) {
		//// TODO Auto-generated method stub
		try{
			
			
			Query q = null;
			if(start!=null && end !=null){
				q=session.createQuery("select ob from OrderBook as ob  where ob.book.member.login=:login and ob.orderCustomer.isTreated=true and (ob.orderCustomer.dateOrder between :start and :end)  ");
				q.setString("login", m.getLogin());
				q.setDate("start", start);
				q.setDate("end", end);
			}
			else{
				q=session.createQuery("select ob from OrderBook as ob  where ob.book.member.login=:login and ob.orderCustomer.isTreated=true   ");
				q.setString("login", m.getLogin());
			}
				
		return  q.list();
		}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
			e.printStackTrace();
		return null;
		}
		
	
	}

	@Override
	public double showPaidOrder(Member m) {
		// TODO Auto-generated method stub
		try{
		Query q = session.createQuery("select sum(price) from OrderBook as ob  where ob.book.member.login=:login and ob.isTreated=true  ");
		q.setString("login", m.getLogin());
	
	return  Double.parseDouble(q.uniqueResult().toString());
	}catch (RuntimeException e) {
	//if(tx != null) tx.rollback();
		e.printStackTrace();
	return 0;
	}
		
	}

	@Override
	public double showTotalOrder(Member m) {
		// TODO Auto-generated method stub
		try{
		Query q = session.createQuery("select sum(prize) from OrderBook as ob  where ob.member.login=:login   ");
		q.setString("login", m.getLogin());
	
	return  Double.parseDouble(q.uniqueResult().toString());
	}catch (RuntimeException e) {
	//if(tx != null) tx.rollback();
		e.printStackTrace();
	return 0.0;
	}
	}

	@Override
	public boolean save(OrderBook or) {
		try {
            session.save(or);
     
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
	public List<OrderBook> findOrderBookBySeller(int idMember) {
		// TODO Auto-generated method stub
		try{
		Query q = session.createQuery("select ob from OrderBook as ob  where ob.book.member.idMember=:idMember and ob.orderCustomer.isTreated=true  ");
		q.setInteger("idMember", idMember);
	
	return  q.list();
	}catch (RuntimeException e) {
	//if(tx != null) tx.rollback();
		e.printStackTrace();
	return null;
	}
	}

	@Override
	public boolean isBookOrdered(Member m, Book b) {
		//while a book b is associated in a bookOrder from customer order treated of the member m
		// TODO Auto-generated method stub
		try{
		Query q = session.createQuery("select ob from  OrderBook as ob  where ob.orderCustomer.member.idMember=:idMember and ob.book.idBook=:idBook and ob.orderCustomer.isTreated=true  ");
		q.setInteger("idMember", m.getIdMember());
		q.setInteger("idBook", b.getIdBook());
		List res=q.list();
		if(res.size()==0){
			return false;
		}
		
	return true ;
	}catch (RuntimeException e) {
	//if(tx != null) tx.rollback();
		e.printStackTrace();
	return false;
	}
	}

	@Override
	public boolean isOrderBookCreated(Member m, Book b) {
		//while a book b is associated in a bookOrder from customer order treated of the member m
		// TODO Auto-generated method stub
		try{
		Query q = session.createQuery("select ob from OrderBook as ob  where ob.orderCustomer.member.idMember=:idMember and ob.book.idBook=:idBook and ob.orderCustomer.isTreated=false  ");
		q.setInteger("idMember", m.getIdMember());
		q.setInteger("idBook", b.getIdBook());
		List res=q.list();
		if(res.size()==0){
			return false;
		}
		
	return true ;
	}catch (RuntimeException e) {
	//if(tx != null) tx.rollback();
		e.printStackTrace();
	return false;
	}
	}

	@Override
	public OrderBook getOrderBookCreatedNoPaid(Member m, Book b) {
		////while a book b is associated in a bookOrder from customer order treated of the member m
		// TODO Auto-generated method stub
		try{
		Query q = session.createQuery("select ob from  OrderBook as ob  where ob.orderCustomer.member.idMember=:idMember and ob.book.idBook=:idBook and ob.orderCustomer.isTreated=false  ");
		q.setInteger("idMember", m.getIdMember());
		q.setInteger("idBook", b.getIdBook());
		List<OrderBook> res=q.list();
		if(res.size()==0){
			return null;
		}
		
	return res.get(0) ;
	}catch (RuntimeException e) {
	//if(tx != null) tx.rollback();
		e.printStackTrace();
	return null;
	}
	}

	@Override
	public List<OrderBook> showBookOrderedByBuyer(Member m) {
		// TODO Auto-generated method stub
		try{
		Query q = session.createQuery("select ob from OrderBook as ob  where ob.orderCustomer.member.idMember=:idMember and ob.orderCustomer.isTreated=true  ");
		q.setInteger("idMember", m.getIdMember());
	
	return  q.list();
	}catch (RuntimeException e) {
	//if(tx != null) tx.rollback();
		e.printStackTrace();
	return null;
	}
	}

	@Override
	public OrderBook getOrderBookById(int  idOrderBook) {
		try {
			OrderBook getOb = (OrderBook) session.get(OrderBook.class,idOrderBook);

			
			
			
		/*	if(mail==null){
				Query q = session.createQuery("select me from MessageEmail me inner join me.messageEmails myMails" +
				" where me.idMessage=:idMember and me.messageEmail is  null ");
				
			}*/
			
			return getOb;
		} catch (RuntimeException re) {
			
			 re.printStackTrace();
			 return null;
		}
	}

}
