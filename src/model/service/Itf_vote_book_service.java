package model.service;

import model.persistance.VoteBook;

public interface Itf_vote_book_service {
	boolean save(String remoteAddr,VoteBook v);
	long countVotebyIdBook(int idBook);
	boolean hasVoteByRemoteAddr(String remoteAddr, int idBook);
}
