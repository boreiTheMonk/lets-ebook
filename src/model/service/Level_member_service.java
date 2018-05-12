package model.service;

import java.util.List;

import model.dao.Itf_level_member_dao;
import model.dao.LevelMember_dao;
import model.persistance.LevelMember;

public class Level_member_service implements Itf_level_member_service {
	Itf_level_member_dao levelDao = new LevelMember_dao();
	
	@Override
	public LevelMember findByid(int id) {
		// TODO Auto-generated method stub
		return levelDao.findByid(id);
	}

	@Override
	public List<LevelMember> getLevelMemberByIdMember(int idMember) {
		// TODO Auto-generated method stub
		return levelDao.getLevelMemberByIdMember(idMember);
	}

	@Override
	public LevelMember merge(LevelMember level) {
		// TODO Auto-generated method stub
		return levelDao.merge(level);
	}

	@Override
	public boolean save(LevelMember lm) {
		// TODO Auto-generated method stub
		return levelDao.save(lm);
	}

	@Override
	public boolean delete(LevelMember persistentInstance) {
		// TODO Auto-generated method stub
		 return levelDao.delete(persistentInstance);
	}

}
