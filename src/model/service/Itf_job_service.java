package model.service;

import model.persistance.Job;
import model.persistance.ThemeGroup;

public interface Itf_job_service {
	boolean save(Job j);
	public Job findById(int id);
	public Job findJobByLevelClass(int idLevel,int idClassMember);
}
