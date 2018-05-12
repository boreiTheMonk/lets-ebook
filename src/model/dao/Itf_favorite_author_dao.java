package model.dao;

import java.util.List;

import model.persistance.Book;
import model.persistance.Category;
import model.persistance.FavouriteAuthor;
import model.persistance.Member;
import model.persistance.MessageMember;

public interface Itf_favorite_author_dao {
	public boolean save(FavouriteAuthor transientInstance);
	public boolean saveListFavAuth(List<FavouriteAuthor> transientInstance);
	public List<FavouriteAuthor> findFavoriteAuthorByMemberId(int id);
	public boolean deleteAllByMemberId(int id);
	public FavouriteAuthor findById(int id);
}
