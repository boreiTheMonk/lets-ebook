package modelcron.services;

import java.util.List;


import modelcron.persistance.MemberBk;

public interface Itf_memberBk_service {
	public enum ORDER { INTERNAL_ERROR,
		CONNEXION_ERROR,MD5_NOT_FOUND_ERROR};
		public  static final String DATE_DESC = "m.registrationDate desc";
	
		
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
