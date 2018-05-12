package model.service;

import java.util.List;

import model.dao.FavouriteAuthor_dao;
import model.dao.Itf_favorite_author_dao;
import model.persistance.FavouriteAuthor;
import model.persistance.Member;

public class FavouriteAuthor_service implements Itf_favourite_author_service {

	Itf_favorite_author_dao fav_auths_dao= new FavouriteAuthor_dao();
	


	@Override
	public model.persistance.FavouriteAuthor findById(int id) {
		// TODO Auto-generated method stub
		return fav_auths_dao.findById(id);
	}

	@Override
	public List<model.persistance.FavouriteAuthor> findFavoriteAuthorByMemberId(
			int id) {
		// TODO Auto-generated method stub
		return fav_auths_dao.findFavoriteAuthorByMemberId(id);
	}


	

	@Override
	public boolean save(model.persistance.FavouriteAuthor transientInstance) {
		// TODO Auto-generated method stub
		return fav_auths_dao.save(transientInstance);
	}

	@Override
	public boolean addOverrideFavouriteAuthor(int idMember,List<FavouriteAuthor> lfavAuth) {
		// TODO Auto-generated method stub
		fav_auths_dao.deleteAllByMemberId(idMember);
		fav_auths_dao.saveListFavAuth(lfavAuth);
		return true;
	}

	

}
