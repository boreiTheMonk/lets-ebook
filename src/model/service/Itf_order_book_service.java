package model.service;

import java.util.Date;
import java.util.List;

import model.persistance.Adress;
import model.persistance.Book;
import model.persistance.Member;
import model.persistance.OrderBook;

public interface Itf_order_book_service {

public List<OrderBook> showBookOrderedByBuyer(Member m);	
	
public List<OrderBook> showOrderBydate(Member m,Date start,Date end);
/*
 * total sell for 1 member
 */
public double showTotalOrder(Member m);
/*
 * total paid for 1 member
 */
public double showPaidOrder(Member m);
/*
 * total reward for 1 member
 */
public double showDueOrder(Member m);

boolean save(OrderBook or);

public boolean isBookOrdered(Member m,Book b);

public boolean isOrderBookCreated(Member m,Book b);

public OrderBook getOrderBookCreatedNoPaid(Member m,Book b);

public OrderBook getOrderBookById(int  idOrderBook);

}
