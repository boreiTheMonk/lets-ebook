package model.service;

import java.util.List;
import java.util.Map;

import model.dao.Itf_theme_dao;
import model.dao.Theme_dao;
import model.persistance.Theme;

public class Theme_services implements Itf_theme_service {
	Itf_theme_dao theme_dao = new Theme_dao();
	
	@Override
	public Theme findById(int id) {
		// TODO Auto-generated method stub
		
		return theme_dao.findById(id);
	}

	@Override
	public List<Theme> getAllThemes() {
		// TODO Auto-generated method stub
		return theme_dao.getAllThemes();
	}

}
