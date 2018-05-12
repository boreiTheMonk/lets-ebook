package model.dao;

import java.util.List;

import model.persistance.Level;
import model.persistance.OrderCustomer;

public interface Itf_orderCustomer_dao {
	boolean save(OrderCustomer o);
	public OrderCustomer findById(int id);
	public OrderCustomer findOrderCustomerByrefOrder(String refOrder);
	public List<OrderCustomer>  findOrderCustomerBySeller(int memberId);
	public boolean isMemberBuyBook(int memberId, int bookId);
	
}
