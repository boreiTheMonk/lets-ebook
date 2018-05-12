package model.service;

import java.util.List;

import model.persistance.Book;
import model.persistance.Member;
import model.persistance.ThemeGroup;

public interface Itf_member_service {
	public enum ORDER { INTERNAL_ERROR,
		CONNEXION_ERROR,MD5_NOT_FOUND_ERROR};
		public  static final String DATE_DESC = "m.registrationDate desc";
		public  static final String ID_DESC = "m.idMember desc";
		
		public boolean delete(Member persistentInstance)	;
	public boolean insert(Member membre);
        public void persist(Member transientInstance);
        public Member findMemberByLogin(String login);
        public void attachClean(Member instance);
        public List<Member> findMemberByString(String searchWord);
        public int countFindMemberByString(String searchWord);
        public int countAllMembers();
        public Member merge(Member detachedInstance);
        public Member findById(int id) ;
        public List<Member> getMembers(int min, int max, String orderby);
        public boolean save(Member transientInstance) ;
    	public List<Member> findMembersByString(String searchWord, int min,int max, String orderby);
        
        public long countFriendsById(int id_member);
        public long countFollowersById(int id_member);
        public long countWatchersById(int id_member);

        public long countFriendsByLogin(String login);
        public long countFollowersByLogin(String login);
        public long countWatchersByLogin(String login);


        public List<Member> findFriendsById(int id_member, int min, int max,String orderby);
        public List<Member> findFollowersById(int id_member, int min, int max,String orderby);
        public List<Member> findWatchersById(int id_member, int min, int max,String orderby);

        public List<Member> findFriendsByLogin(String login, int min, int max,String orderby);
        public List<Member> findFollowersByLogin(String login, int min, int max,String orderby);
        public List<Member> findWatchersByLogin(String login, int min, int max,String orderby);

        public boolean isFriend(int id_friend1,int id_friend2);
        public boolean isFollow(int followee,int follower);
        
        public List<Member> findMemberByGroupId(int id_group, int min, int max,String orderby);
        public long countMemberByGroupId(int id_group);

        public Member findMemberByemail(String email);
        
        public int count_referree(String login);
}
