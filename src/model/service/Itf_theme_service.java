package model.service;

import java.util.List;

import model.persistance.Theme;

public interface Itf_theme_service {
	public List<Theme> getAllThemes();
	public Theme findById(int id);
}
