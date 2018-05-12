package model.dao;

import java.util.List;

import model.persistance.Theme;

public interface Itf_theme_dao {
	public List<Theme> getAllThemes();
	public Theme findById(int id);
	boolean save(Theme t);
}
