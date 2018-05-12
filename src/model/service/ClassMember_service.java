package model.service;

import java.util.List;

import model.dao.ClassMember_dao;
import model.dao.Itf_class_member_dao;
import model.persistance.ClassMember;

public class ClassMember_service implements Itf_class_member_service {
	Itf_class_member_dao cdao=new ClassMember_dao();
	
	@Override
	public int countClassMember() {
		// TODO Auto-generated method stub
		return cdao.countClassMember();
	}

	@Override
	public List<ClassMember> getAllClassMember() {
		// TODO Auto-generated method stub
		return cdao.getAllClassMember();
	}

	@Override
	public boolean save(ClassMember cm) {
		// TODO Auto-generated method stub
		return cdao.save(cm);
	}

	@Override
	public ClassMember findById(int id) {
		// TODO Auto-generated method stub
		return cdao.findById(id);
	}

}
