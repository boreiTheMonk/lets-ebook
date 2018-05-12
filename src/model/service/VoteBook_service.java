package model.service;

import model.dao.Itf_vote_book_dao;
import model.dao.VoteBook_dao;
import model.persistance.VoteBook;

public class VoteBook_service implements Itf_vote_book_service{
	Itf_vote_book_dao votebook_dao= new VoteBook_dao();
	
	@Override
	public boolean save(String remoteAddr,VoteBook v) {
		// check if already vote
		if(!votebook_dao.hasVoteByRemoteAddr(remoteAddr,  v.getBook().getIdBook()))
		return votebook_dao.save(v);
		
		else return false;
	}

	@Override
	public long countVotebyIdBook(int idBook) {
		// TODO Auto-generated method stub
		return votebook_dao.countVotebyIdBook(idBook);
	}

	@Override
	public boolean hasVoteByRemoteAddr(String remoteAddr, int idBook) {
		// TODO Auto-generated method stub
		return votebook_dao.hasVoteByRemoteAddr(remoteAddr,idBook);
	}

}
