package model.service;

import model.persistance.Job;
import model.persistance.Level;
import model.persistance.ThemeGroup;

public interface Itf_level_service {
	boolean save(Level l);
	public Level findById(int id);
	public Level findLevelByNumber(int numb);
	public boolean delete(Level persistentInstance);
}
