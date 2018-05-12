package model.service;

import java.util.List;

import model.dao.Itf_member_dao;
import model.dao.Member_dao;
import model.persistance.Member;
import model.persistance.ThemeGroup;

public class Member_service implements Itf_member_service {
	
	
	
       Itf_member_dao member_dao= new Member_dao();


	public Member_service() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(Member membere) {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public void persist(Member transientInstance) {
         System.out.println("");
            member_dao.persist(transientInstance);
    }

	@Override
	public Member findMemberByLogin(String login) {
		// TODO Auto-generated method stub
		return member_dao.findMemberByLogin(login);
	}

	@Override
	public List<Member> findMemberByString(String searchWord) {
		// TODO Auto-generated method stub
		return member_dao.findMemberByString(searchWord);
	}

	@Override
	public int countFindMemberByString(String searchWord) {
		// TODO Auto-generated method stub
		return member_dao.countFindMemberByString(searchWord);
	}

	@Override
	public Member merge(Member detachedInstance) {
		// TODO Auto-generated method stub
		return member_dao.merge(detachedInstance);
	}

	@Override
	public Member findById(int id) {
		// TODO Auto-generated method stub
		return member_dao.findById(id);
	}

	@Override
	public void attachClean(Member instance) {
		 member_dao.attachClean(instance);
		
	}

	@Override
	public List<Member> getMembers(int min, int max, String orderby) {
		// TODO Auto-generated method stub
		return member_dao.getMembers(min, max, orderby);
	}

	@Override
	public int countAllMembers() {
		// TODO Auto-generated method stub
		return member_dao.countAllMembers();
	}

	@Override
	public long countFollowersById(int idMember) {
		// TODO Auto-generated method stub
		 return member_dao.countFollowersById(idMember);
	}

	@Override
	public long countFollowersByLogin(String login) {
		// TODO Auto-generated method stub
		 return member_dao.countFollowersByLogin(login);
	}

	@Override
	public long countFriendsById(int idMember) {
		// TODO Auto-generated method stub
		 return member_dao.countFriendsById(idMember);
	}

	@Override
	public long countFriendsByLogin(String login) {
		// TODO Auto-generated method stub
		 return member_dao.countFriendsByLogin(login);
	}

	@Override
	public long countWatchersById(int idMember) {
		// TODO Auto-generated method stub
		 return member_dao.countWatchersById(idMember);
	}

	@Override
	public long countWatchersByLogin(String login) {
		// TODO Auto-generated method stub
		 return member_dao.countWatchersByLogin(login);
	}

	@Override
	public List<Member> findFollowersById(int idMember, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		 return member_dao.findFollowersById(idMember, min, max, orderby);
	}

	@Override
	public List<Member> findFollowersByLogin(String login, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		 return member_dao.findFollowersByLogin(login, min, max, orderby);
	}

	@Override
	public List<Member> findFriendsById(int idMember, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		 return member_dao.findFriendsById(idMember, min, max, orderby);
	}

	@Override
	public List<Member> findFriendsByLogin(String login, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		 return member_dao.findFriendsByLogin(login, min, max, orderby);
	}

	@Override
	public List<Member> findWatchersById(int idMember, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		 return member_dao.findWatchersById(idMember, min, max, orderby);
	}

	@Override
	public List<Member> findWatchersByLogin(String login, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		 return member_dao.findWatchersByLogin(login, min, max, orderby);
	}

	@Override
	public boolean isFollow(int followee, int follower) {
		// TODO Auto-generated method stub
		return member_dao.isFollow(followee, follower);
	}

	@Override
	public boolean isFriend(int idFriend1, int idFriend2) {
		// TODO Auto-generated method stub
		return member_dao.isFriend(idFriend1, idFriend2);
	}

	@Override
	public long countMemberByGroupId(int idGroup) {
		// TODO Auto-generated method stub
		return member_dao.countMemberByGroupId(idGroup);
	}

	@Override
	public List<Member> findMemberByGroupId(int idGroup, int min, int max,
			String orderby) {
		// TODO Auto-generated method stub
		return member_dao.findMemberByGroupId(idGroup, min, max, orderby);
	}

	@Override
	public boolean save(Member transientInstance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member findMemberByemail(String email) {
		// TODO Auto-generated method stub
		return member_dao.findMemberByemail(email);
	}

	@Override
	public int count_referree(String login) {
		// TODO Auto-generated method stub
		return member_dao.count_referree(login);
	}

	@Override
	public boolean delete(Member persistentInstance) {
		return member_dao.delete(persistentInstance);
		
	}

	@Override
	public List<Member> findMembersByString(String searchWord, int min,
			int max, String orderby) {
		return member_dao.findMembersByString(searchWord, min, max, orderby);
		
	}



}
