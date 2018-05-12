package model.dao;

import model.persistance.Job;
import model.persistance.ThemeGroup;

public interface Itf_job_dao {
	boolean save(Job j);
	public Job findById(int id);
	public Job findJobByLevelClass(int idLevel,int idClassMember);
}
