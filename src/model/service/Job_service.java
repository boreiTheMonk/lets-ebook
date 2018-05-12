package model.service;

import model.dao.Itf_job_dao;
import model.dao.Job_dao;
import model.persistance.Job;

public class Job_service implements Itf_job_service {
	Itf_job_dao job_dao=new Job_dao();
	@Override
	public Job findById(int id) {
		// TODO Auto-generated method stub
		return job_dao.findById(id);
	}

	@Override
	public Job findJobByLevelClass(int idLevel, int idClassMember) {
		// TODO Auto-generated method stub
		return job_dao.findJobByLevelClass(idLevel, idClassMember);
	}

	@Override
	public boolean save(Job j) {
		// TODO Auto-generated method stub
		return job_dao.save(j);
	}

}
