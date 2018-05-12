package model.service;

import java.util.List;

import model.persistance.Level;
import model.persistance.OrderCustomer;

public interface Itf_orderCustomer_service {
	boolean save(OrderCustomer o);
	public OrderCustomer findById(int id);
	public List<OrderCustomer>  findOrderCustomerBySeller(int memberId);
	public OrderCustomer findOrderCustomerByrefOrder(String refOrder);
	public boolean isMemberBuyBook(int memberId, int bookId);
	
}
