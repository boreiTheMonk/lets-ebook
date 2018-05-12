package model.dao;

import model.persistance.Job;
import model.persistance.Level;
import model.persistance.Member;
import model.persistance.ThemeGroup;

public interface Itf_level_dao {
	boolean save(Level l);
	public Level findById(int id);
	public Level findLevelByNumber(int numb);
	public boolean delete(Level persistentInstance);
}
