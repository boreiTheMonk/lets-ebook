package modelcron.services;

import java.util.List;

import modelcron.dao.Itf_memberBk_dao;
import modelcron.dao.MemberBk_dao;
import modelcron.persistance.MemberBk;


public class MemberBk_service implements Itf_memberBk_service {
	
	
	
       Itf_memberBk_dao member_dao= new MemberBk_dao();


	public MemberBk_service() {
		super();
		// TODO Auto-generated constructor stub
	}



    @Override
    public void persist(MemberBk transientInstance) {
         System.out.println("");
            member_dao.persist(transientInstance);
    }

	@Override
	public MemberBk findMemberByLogin(String login) {
		// TODO Auto-generated method stub
		return member_dao.findMemberByLogin(login);
	}

	

	@Override
	public MemberBk merge(MemberBk detachedInstance) {
		// TODO Auto-generated method stub
		return member_dao.merge(detachedInstance);
	}

	@Override
	public MemberBk findById(int id) {
		// TODO Auto-generated method stub
		return member_dao.findById(id);
	}

	@Override
	public void attachClean(MemberBk instance) {
		 member_dao.attachClean(instance);
		
	}

	@Override
	public List<MemberBk> getMembers(int min, int max, String orderby) {
		// TODO Auto-generated method stub
		return member_dao.getMembers(min, max, orderby);
	}

	@Override
	public int countAllMembers() {
		// TODO Auto-generated method stub
		return member_dao.countAllMembers();
	}

	
	

	

	

	

	@Override
	public boolean save(MemberBk transientInstance) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean delete(MemberBk persistentInstance) {
		return member_dao.delete(persistentInstance);
		
	}



}
