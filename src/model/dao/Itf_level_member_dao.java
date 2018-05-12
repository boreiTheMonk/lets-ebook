package model.dao;

import java.util.List;

import model.persistance.Adress;
import model.persistance.Job;
import model.persistance.Level;
import model.persistance.LevelMember;

public interface Itf_level_member_dao {
	boolean save(LevelMember lm);
	LevelMember findByid(int id);
	List<LevelMember> getLevelMemberByIdMember(int idMember);
	LevelMember merge(LevelMember level);
	public boolean delete(LevelMember persistentInstance);
}
