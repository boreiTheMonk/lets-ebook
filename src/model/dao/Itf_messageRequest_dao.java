package model.dao;


import java.util.List;

import model.persistance.MessageRequest;
import model.persistance.Request;

public interface Itf_messageRequest_dao {
	boolean save(MessageRequest mr);
	public List<MessageRequest> getMessageRequestByRequest(int idRequest, int min, int max,String orderby);
	public int countMessageRequestByRequest(int id_request);
}
