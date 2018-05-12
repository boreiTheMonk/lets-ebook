package model.service;

import java.util.List;

import model.dao.Itf_messageRequest_dao;

import model.dao.MessageRequest_dao;
import model.persistance.MessageRequest;

public class MessageRequest_service implements Itf_messageRequest_service {
	Itf_messageRequest_dao serv = new MessageRequest_dao();
	
	@Override
	public int countMessageRequestByRequest(int idRequest) {
		// TODO Auto-generated method stub
		return serv.countMessageRequestByRequest(idRequest);
	}

	@Override
	public List<MessageRequest> getMessageRequestByRequest(int idRequest,
			int min, int max, String orderby) {
		// TODO Auto-generated method stub
		return serv.getMessageRequestByRequest(idRequest, min, max, orderby);
	}

	@Override
	public boolean save(MessageRequest mr) {
		// TODO Auto-generated method stub
		return serv.save(mr);
	}

}
