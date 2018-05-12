package model.service;

import java.util.List;

import model.persistance.Category;

public interface Itf_category_service {
	public List<Category> getAllCategories();
	public Category findById(int id);
}
