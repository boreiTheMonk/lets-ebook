package model.service;

import java.util.Date;
import java.util.List;

import model.dao.Itf_order_book_dao;
import model.dao.OrderBook_dao;
import model.persistance.Book;
import model.persistance.Member;
import model.persistance.OrderBook;

public class OrderBook_service implements Itf_order_book_service {
	Itf_order_book_dao dao_order_book= new OrderBook_dao() ;
	
	@Override
	public List<OrderBook> showOrderBydate(Member m, Date start, Date end) {
		// TODO Auto-generated method stub
		return dao_order_book.showOrderBydate(m, start, end);
	}

	@Override
	public double showTotalOrder(Member m) {
		// TODO Auto-generated method stub
		return dao_order_book.showTotalOrder(m);
	}

	@Override
	public double showPaidOrder(Member m) {
		// TODO Auto-generated method stub
		return dao_order_book.showPaidOrder(m);
	}

	@Override
	public double showDueOrder(Member m) {
		// TODO Auto-generated method stub
		return dao_order_book.showDueOrder(m);
	}

	@Override
	public boolean save(OrderBook or) {
		// TODO Auto-generated method stub
		return dao_order_book.save(or);
	}

	@Override
	public boolean isBookOrdered(Member m, Book b) {
		// TODO Auto-generated method stub
		return dao_order_book.isBookOrdered(m, b);
	}

	@Override
	public boolean isOrderBookCreated(Member m, Book b) {
		// TODO Auto-generated method stub
		return dao_order_book.isOrderBookCreated(m, b);
	}

	@Override
	public OrderBook getOrderBookCreatedNoPaid(Member m, Book b) {
		// TODO Auto-generated method stub
		return dao_order_book.getOrderBookCreatedNoPaid(m, b);
	}

	@Override
	public List<OrderBook> showBookOrderedByBuyer(Member m) {
		// TODO Auto-generated method stub
		return dao_order_book.showBookOrderedByBuyer(m);
	}

	@Override
	public OrderBook getOrderBookById(int  idOrderBook) {
		// TODO Auto-generated method stub
		return dao_order_book.getOrderBookById(idOrderBook);
	}

}
