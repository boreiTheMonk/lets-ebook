package model.dao;

import java.util.List;


import model.persistance.Member;


public interface Itf_member_dao {
	public static final String DATE_DESC = "m.registrationDate desc";
	
public boolean delete(Member persistentInstance)	;
public void persist(Member transientInstance) ;
public boolean save(Member transientInstance) ;
public Member findById(int id) ;
public void attachClean(Member instance);
public Member findMemberByLogin(String login);
public Member merge(Member detachedInstance);
public List<Member> findMemberByString(String searchWord);
public int countFindMemberByString(String searchWord);
// orderby take a string which coresponds to an attribute
public List<Member> findMembersByString(String searchWord, int min, int max,String orderby);


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

public List<Member> getMembers(int min, int max,String orderby);

public boolean isFriend(int id_friend1,int id_friend2);
public boolean isFollow(int followee,int follower);

public List<Member> findMemberByGroupId(int id_group, int min, int max,String orderby);
public long countMemberByGroupId(int id_group);

public int countAllMembers();

public Member findMemberByemail(String email);

public int count_referree(String login);
}
