package model.service;

import java.util.List;

import model.dao.FavouriteBook_dao;
import model.dao.Itf_favorite_book_dao;

import model.persistance.FavouriteBook;

public class FavouriteBook_service implements Itf_favourite_book_service {

	

		Itf_favorite_book_dao fav_book_dao= new FavouriteBook_dao();
		


		@Override
		public model.persistance.FavouriteBook findById(int id) {
			// TODO Auto-generated method stub
			return fav_book_dao.findById(id);
		}

		@Override
		public List<model.persistance.FavouriteBook> findFavoriteBookByMemberId(
				int id) {
			// TODO Auto-generated method stub
			return fav_book_dao.findFavoriteBookByMemberId(id);
		}


		

		@Override
		public boolean save(model.persistance.FavouriteBook transientInstance) {
			// TODO Auto-generated method stub
			return fav_book_dao.save(transientInstance);
		}

		@Override
		public boolean addOverrideFavouriteBook(int idMember,List<FavouriteBook> lfavAuth) {
			// TODO Auto-generated method stub
			fav_book_dao.deleteAllByMemberId(idMember);
			fav_book_dao.saveListFavBook(lfavAuth);
			return true;
		}

	

		


}
