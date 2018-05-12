package model.dao;

import java.util.List;

import model.persistance.FavouriteAuthor;
import model.persistance.FavouriteBook;

public interface Itf_favorite_book_dao {
	public boolean save(FavouriteBook transientInstance);
	public boolean saveListFavBook(List<FavouriteBook> transientInstance);
	public List<FavouriteBook> findFavoriteBookByMemberId(int id);
	public boolean deleteAllByMemberId(int id);
	public FavouriteBook findById(int id);
}
