package model.dao;

import java.util.List;

import model.persistance.Category;

public interface Itf_category_dao {
	public List<Category> getAllCategories();
	public Category findById(int id);
	public boolean save(Category c);
}
