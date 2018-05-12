package model.service;

import model.dao.Itf_level_dao;
import model.dao.Level_dao;
import model.persistance.Level;

public class Level_service implements Itf_level_service {
	Itf_level_dao level_dao = new Level_dao() ;
	@Override
	public Level findById(int id) {
		// TODO Auto-generated method stub
		return level_dao.findById(id);
	}

	@Override
	public Level findLevelByNumber(int numb) {
		// TODO Auto-generated method stub
		return level_dao.findLevelByNumber(numb);
	}

	@Override
	public boolean save(Level l) {
		// TODO Auto-generated method stub
		return level_dao.save(l);
	}

	@Override
	public boolean delete(Level persistentInstance) {
		// TODO Auto-generated method stub
		return level_dao.delete(persistentInstance);
	}

}
