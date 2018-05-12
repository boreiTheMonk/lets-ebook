package model.service;

import model.dao.Itf_responseMessageBook_dao;
import model.dao.ResponseMessageBook_dao;
import model.persistance.ResponseMessageBook;
import model.persistance.ResponseMessageMember;

public class ResponseMessageBook_service implements Itf_responseMessageBook_service {

	 Itf_responseMessageBook_dao responseMessageBook_dao;
	
	public ResponseMessageBook_service() {
		super();
		// TODO Auto-generated constructor stub
		responseMessageBook_dao= new ResponseMessageBook_dao();
	}


	@Override
	public boolean save(ResponseMessageBook transientInstance) {
		// TODO Auto-generated method stub
		return responseMessageBook_dao.save(transientInstance);
	}





	

}
