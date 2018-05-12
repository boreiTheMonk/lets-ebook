package interceptor;

import java.util.List;
import java.util.Map;

import model.dao.MessageEmail_dao;
import model.dao.RequestFriend_dao;
import model.persistance.Member;
import model.persistance.MessageEmail;

import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import constant.Application;

public class New_message_received_interceptor extends AbstractInterceptor{

 private String decorator_name;
 
 	
 //private static final String USER_KEY = "my_member";
 //private static final String USER_COOKIE = "member_login";

	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map session = invocation.getInvocationContext().getSession();
		Member m= (Member) session.get(Application.USER_KEY);
		
		if(m!=null){
		Session s= HibernateSessionFactory.getNewSession();
		
		RequestFriend_dao reqfDao = new RequestFriend_dao();
		reqfDao.setSession(s);
		MessageEmail_dao emailDao= new MessageEmail_dao();
		emailDao.setSession(s);
		int nbFriendReqNotRead = reqfDao.countRequestFriendNotReadByIdMember(m.getIdMember());
		int  nbEmailNotRead= emailDao.countMessageMailNotReadbyIdMember(m.getIdMember());
		List<MessageEmail> mmail=emailDao.findMessageMailNotReadbyIdMember(m.getIdMember());
		session.put(Application.SESSION_NB_FRIENDREQ_NOT_READ, nbFriendReqNotRead);
		session.put(Application.SESSION_NB_EMAIL_NOT_READ,nbEmailNotRead);
		
		HibernateSessionFactory.closeSession(s);
		System.out.println("en non lu "+m.getIdMember() +" "+nbEmailNotRead+" "+nbFriendReqNotRead);
		 for(MessageEmail mm:mmail){
			 System.out.println(mm.getIdMessage()+" message"+mm.getBody());
		 }
		}
		return invocation.invoke();
	}
	


	private void addActionError(ActionInvocation invocation, String message) {
		Object action = invocation.getAction();
	//	if(action instanceof ValidationAware) {
		//	((ValidationAware) action).addActionError(message);
		//}
	//}
  }
}