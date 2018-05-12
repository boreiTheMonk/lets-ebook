package model.service;

import java.util.List;

import model.dao.Itf_group_dao;
import model.dao.ThemeGroup_dao;
import model.persistance.Book;
import model.persistance.ThemeGroup;

public class Group_service implements Itf_group_service {

	Itf_group_dao group_dao= new ThemeGroup_dao();
	
	@Override
	public List<ThemeGroup> findAllGroupByIdMember(int idMember) {
		// TODO Auto-generated method stub
		return group_dao.findAllGroupByIdMember(idMember);
	}

	@Override
	public ThemeGroup findById(int id) {
		// TODO Auto-generated method stub
		return group_dao.findById(id);
	}

	@Override
	public ThemeGroup merge(ThemeGroup detachedInstance) {
		// TODO Auto-generated method stub
		return group_dao.merge(detachedInstance);
	}

	@Override
	public boolean save(ThemeGroup theme) {
		// TODO Auto-generated method stub
		return group_dao.save(theme);
	}

	@Override
	public long countJoinGroupById(int idMember) {
		// TODO Auto-generated method stub
		return group_dao.countJoinGroupById(idMember);
	}

	@Override
	public long countJoinGroupByLogin(String login) {
		// TODO Auto-generated method stub
		return group_dao.countJoinGroupByLogin(login);
	}

	@Override
	public long countOwnGroupById(int idMember) {
		// TODO Auto-generated method stub
		return group_dao.countOwnGroupById(idMember);
	}

	@Override
	public long countOwnGroupByLogin(String login) {
		// TODO Auto-generated method stub
		return group_dao.countOwnGroupByLogin(login);
	}

	@Override
	public List<ThemeGroup> findJoinGroupById(int idMember, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return group_dao.findJoinGroupById(idMember, min, max, orderby);
	}

	@Override
	public List<ThemeGroup> findJoinGroupByLogin(String login, int min,
			int max, String orderby) {
		// TODO Auto-generated method stub
		return group_dao.findJoinGroupByLogin(login, min, max, orderby);
	}

	@Override
	public List<ThemeGroup> findOwnGroupById(int idMember, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return group_dao.findOwnGroupById(idMember, min, max, orderby);
	}

	@Override
	public List<ThemeGroup> findOwnGroupByLogin(String login, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return group_dao.findOwnGroupByLogin(login, min, max, orderby);
	}

	@Override
	public int countFindGroupByString(String searchWord) {
		// TODO Auto-generated method stub
		return group_dao.countFindGroupByString(searchWord);
	}

	@Override
	public List<ThemeGroup> findGroupByString(String searchWord, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return group_dao.findGroupByString(searchWord, min, max, orderby);
	}

	@Override
	public boolean isFollowGroup(int idMember, int idGroup) {
		// TODO Auto-generated method stub
		return group_dao.isFollowGroup(idMember, idGroup);
	}

	@Override
	public boolean isGroupOwner(int idMember, int idGroup) {
		// TODO Auto-generated method stub
		return group_dao.isGroupOwner(idMember, idGroup);
	}

}
