package model.dao;

import org.hibernate.Query;


import model.persistance.VoteBook;

public class VoteBook_dao extends GenericDao implements Itf_vote_book_dao {

	@Override
	public boolean save(VoteBook vb) {
		try {
            session.save(vb);
     
         //   log.debug("save successful");
            return true;
		} catch (RuntimeException re) {
		//	log.error("savet failed", re);
			if(t != null) t.rollback();
			re.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean hasVoteByRemoteAddr(String remoteAddr,int idBook) {
		// TODO Auto-generated method stub
		Query q = session.createQuery("select count(vb.idVoteBook) from VoteBook as vb  where vb.ip=:ip and vb.book.idBook=:idBook");
		q.setInteger("idBook", idBook);
		q.setString("ip", remoteAddr);
		Long res= (Long) q.uniqueResult();
		if(res>0)
		return true;
		
		else return false;
	}

	@Override
	public long countVotebyIdBook(int idBook) {
		try{ Query q = session.createQuery("select count(vb.idVoteBook) from VoteBook as vb  where vb.book.idBook=:idBook ");
		q.setInteger("idBook", idBook);
		Long res= (Long) q.uniqueResult();
		return res;
	}catch (RuntimeException e) {
		//if(tx != null) tx.rollback();
    		e.printStackTrace();
		return 0;
    	}
	}



}
