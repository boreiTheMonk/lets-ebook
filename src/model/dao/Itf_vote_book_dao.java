package model.dao;

import model.persistance.VoteBook;


public interface Itf_vote_book_dao {
	boolean save(VoteBook v);
	boolean hasVoteByRemoteAddr(String remoteAddr,int idBook);
	long countVotebyIdBook(int idBook);
}
