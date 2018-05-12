package model.service;

import java.util.List;

import model.dao.Category_dao;
import model.dao.Itf_category_dao;
import model.persistance.Category;

public class Category_service implements Itf_category_service {
	Itf_category_dao mydao= new Category_dao();
	
	public List<Category> getAllCategories(){
		
		return mydao.getAllCategories();
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return mydao.findById(id);
	}
}
