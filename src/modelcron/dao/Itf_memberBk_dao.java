package modelcron.dao;

import java.util.List;


import modelcron.persistance.MemberBk;


public interface Itf_memberBk_dao {
	public static final String DATE_DESC = "m.registrationDate desc";
	
public boolean delete(MemberBk persistentInstance)	;
public void persist(MemberBk transientInstance) ;
public boolean save(MemberBk transientInstance) ;
public MemberBk findById(int id) ;
public void attachClean(MemberBk instance);
public MemberBk findMemberByLogin(String login);
public MemberBk merge(MemberBk detachedInstance);
public List<MemberBk> getMembers(int min, int max,String orderby);
public int countAllMembers();


}
