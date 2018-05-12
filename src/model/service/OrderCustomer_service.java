package model.service;

import java.util.List;

import model.dao.Itf_orderCustomer_dao;
import model.dao.OrderCustomer_dao;
import model.persistance.OrderCustomer;

public class OrderCustomer_service implements Itf_orderCustomer_service {
	Itf_orderCustomer_dao orderCustomer_dao=new OrderCustomer_dao();
	
	@Override
	public boolean save(OrderCustomer o) {
		// TODO Auto-generated method stub
		return orderCustomer_dao.save(o);
	}

	@Override
	public OrderCustomer findById(int id) {
		// TODO Auto-generated method stub
		return orderCustomer_dao.findById(id);
	}

	@Override
	public List<OrderCustomer> findOrderCustomerBySeller(int memberId) {
		// TODO Auto-generated method stub
		return orderCustomer_dao.findOrderCustomerBySeller(memberId);
	}

	@Override
	public boolean isMemberBuyBook(int memberId, int bookId) {
		// TODO Auto-generated method stub
		return orderCustomer_dao.isMemberBuyBook(memberId, bookId);
	}

	@Override
	public OrderCustomer findOrderCustomerByrefOrder(String refOrder) {
		// TODO Auto-generated method stub
		return orderCustomer_dao.findOrderCustomerByrefOrder(refOrder);
	}

}
