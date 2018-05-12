package model.service;

import java.util.List;

import model.dao.Itf_member_dao;
import model.dao.Itf_messageMember_dao;
import model.dao.Itf_responseMessageMember_dao;
import model.dao.Member_dao;
import model.dao.MessageMember_dao;
import model.dao.ResponseMessageMember_dao;
import model.persistance.Member;
import model.persistance.MessageMember;
import model.persistance.ResponseMessageMember;

public class ResponseMessageMember_service implements Itf_responseMessageMember_service {

	 Itf_responseMessageMember_dao responseMessageMember_dao;
	
	public ResponseMessageMember_service() {
		super();
		// TODO Auto-generated constructor stub
		responseMessageMember_dao= new ResponseMessageMember_dao();
	}



	@Override
	public boolean save(ResponseMessageMember transientInstance) {
		// TODO Auto-generated method stub
		return responseMessageMember_dao.save(transientInstance);
	}

	

}
