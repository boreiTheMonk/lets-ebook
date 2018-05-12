package model.service;

import java.util.List;

import model.dao.Itf_proof_doc_dao;
import model.dao.Proof_doc_dao;
import model.persistance.Proof_doc;

public class Proof_doc_service implements Itf_proof_doc_service {
	Itf_proof_doc_dao proof_dao=new Proof_doc_dao();
	
	@Override
	public boolean save(Proof_doc pr) {
		// TODO Auto-generated method stub
		return proof_dao.save(pr);
	}

	@Override
	public Proof_doc findById(int id) {
		// TODO Auto-generated method stub
		return proof_dao.findById(id);
	}

	@Override
	public Proof_doc merge(Proof_doc pr) {
		// TODO Auto-generated method stub
		return proof_dao.merge(pr);
	}

	@Override
	public List<Proof_doc> findByIdBook(int id) {
		// TODO Auto-generated method stub
		return proof_dao.findByIdBook(id);
	}

	@Override
	public boolean delete(Proof_doc persistentInstance) {
		// TODO Auto-generated method stub
		return proof_dao.delete(persistentInstance);
	}

}
