package model.service;

import java.util.List;

import model.dao.Itf_request_dao;
import model.dao.Request_dao;
import model.persistance.Request;

public class Request_service implements Itf_request_service {
	Itf_request_dao serv = new Request_dao();
	@Override
	public int countRequestByGroup(int idGroup) {
		// TODO Auto-generated method stub
		return serv.countRequestByGroup(idGroup);
	}

	@Override
	public List<Request> getRequestByGroup(int idGroup, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return serv.getRequestByGroup(idGroup, min, max, orderby);
	}

	@Override
	public boolean save(Request r) {
		// TODO Auto-generated method stub
		return serv.save(r);
	}

	@Override
	public Request findById(int id) {
		// TODO Auto-generated method stub
		return serv.findById(id);
	}

}
