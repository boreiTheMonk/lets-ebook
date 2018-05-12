package model.service;

import java.util.List;

import model.persistance.Book;
import model.persistance.ThemeGroup;

public interface Itf_group_service {
	List<ThemeGroup> findAllGroupByIdMember(int idMember);
	boolean save(ThemeGroup theme);
	public ThemeGroup merge(ThemeGroup detachedInstance);
	public ThemeGroup findById(int id);
	
	public long countJoinGroupById(int id_member);
	public long countJoinGroupByLogin(String login);
	public long countOwnGroupById(int id_member);
	public long countOwnGroupByLogin(String login);
	
	public List<ThemeGroup> findJoinGroupById(int id_member, int min, int max,String orderby);
	public List<ThemeGroup> findJoinGroupByLogin(String login, int min, int max,String orderby);
	public List<ThemeGroup> findOwnGroupById(int id_member, int min, int max,String orderby);
	public List<ThemeGroup> findOwnGroupByLogin(String login, int min, int max,String orderby);

	public int countFindGroupByString(String searchWord);
	public List<ThemeGroup> findGroupByString(String searchWord, int min, int max, String orderby);

	boolean isFollowGroup(int idMember,int idGroup);
	boolean isGroupOwner(int idMember,int idGroup);
}
