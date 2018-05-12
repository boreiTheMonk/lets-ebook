package model.service;

import java.util.List;

import model.persistance.Book;
import model.persistance.FavouriteAuthor;
import model.persistance.Member;

public interface Itf_favourite_author_service {
	
	

	public boolean save(FavouriteAuthor transientInstance);
	public List<FavouriteAuthor> findFavoriteAuthorByMemberId(int id);
	public boolean addOverrideFavouriteAuthor(int idMember,List<FavouriteAuthor> lfavAuth);
	public FavouriteAuthor findById(int id);
}
