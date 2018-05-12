package model.service;

import java.util.List;

import model.persistance.FavouriteBook;

public interface Itf_favourite_book_service {
	
	

	public boolean save(FavouriteBook transientInstance);
	public List<FavouriteBook> findFavoriteBookByMemberId(int id);
	public boolean addOverrideFavouriteBook(int idMember,List<FavouriteBook> lfavAuth);
	public FavouriteBook findById(int id);
}
