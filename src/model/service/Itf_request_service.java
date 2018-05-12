package model.service;


import java.util.List;


import model.persistance.Request;

public interface Itf_request_service {
	boolean save(Request r);
	public List<Request> getRequestByGroup(int idGroup, int min, int max,String orderby);
	public int countRequestByGroup(int id_group);
	public Request findById(int id);
}
