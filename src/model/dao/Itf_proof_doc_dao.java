package model.dao;

import java.util.List;

import model.persistance.Job;
import model.persistance.Member;
import model.persistance.Proof_doc;
import model.persistance.ThemeGroup;

public interface Itf_proof_doc_dao {
	boolean save(Proof_doc pr);
	public Proof_doc findById(int id);
	public Proof_doc merge(Proof_doc pr);
	public List<Proof_doc> findByIdBook(int id);
	boolean delete(Proof_doc persistentInstance);
}
