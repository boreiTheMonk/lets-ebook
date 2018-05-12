package modelcron.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class GenericDao {
	@SessionTarget
	protected Session session;
	
	@TransactionTarget
	protected Transaction t;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Transaction getT() {
		return t;
	}

	public void setT(Transaction t) {
		this.t = t;
	}

	public GenericDao() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("dans constructeur");
		this.session = com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory.getSession();
		if(session.isOpen() ){
			t=session.getTransaction();
		}
	}

	public GenericDao(Session session, Transaction t) {
		super();
		this.session = session;
		this.t = t;
	}
	

	
}
