package model.dao;

import java.util.List;

import model.persistance.ClassMember;

public interface Itf_class_member_dao {
	boolean save(ClassMember cm);
	List<ClassMember> getAllClassMember();
	int countClassMember();
	ClassMember findById(int id);
}
