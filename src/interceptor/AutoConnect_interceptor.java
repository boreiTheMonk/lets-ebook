package interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import model.dao.Book_dao;
import model.dao.Itf_member_dao;
import model.dao.Member_dao;
import model.persistance.Level;
import model.persistance.LevelMember;
import model.persistance.Member;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import constant.Application;

public class AutoConnect_interceptor extends AbstractInterceptor{

 private String decorator_name;
 
 	
 //private static final String USER_KEY = "my_member";
 //private static final String USER_COOKIE = "member_login";

	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		
		if(session.get("lastAction")==null){
			 session.put("lastAction", constant.Application.ACTION_DEFAULT_AFTER_LOGIN); 
			
		}  
		
		 Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		 String member_login;
		 String member_login_key;
		if(session.get(Application.USER_KEY) == null) {
			member_login=getCookieValue(cookies,Application.USER_COOKIE,null);
			member_login_key=getCookieValue(cookies,Application.USER_COOKIE_KEY,null);
			if ( (member_login) == null){
		//		addActionError(invocation, "You must be authenticated to access this page");
				System.out.println("found no member at all ");
				session.remove(Application.SESSION_DECO);
				}
			else{
			
				Session s= HibernateSessionFactory.getNewSession();
				System.out.println("ee");
				//Itf_member_service memberserv = new Member_service();
				Member_dao memberserv= new Member_dao();
				Book_dao bookserv= new Book_dao();
				memberserv.setSession(s);
				bookserv.setSession(s);
				Member m =memberserv.findMemberByLogin(member_login);
				
				System.out.println(m+ " found member in cookie "+member_login);
				if (m!=null){
					if(Long.toString(m.getRegistrationDate().getTime()).equals(member_login_key)){
						int l=((LevelMember)m.getLevelMembers().iterator().next()).getLevel().getNumbr();
						session.put(Application.USER_KEY, m);
						session.put(Application.SESSION_DECO,"main_member");
						int nbBooks=bookserv.countFindBooksByMemberId(m.getIdMember());
						session.put(Application.SESSION_NB_BOOK,nbBooks);
					}
					else{
						HibernateSessionFactory.closeSession(s);
						//clear all cookies same as logout
						HttpServletResponse response = ServletActionContext.getResponse();
						Cookie cook= new Cookie(Application.USER_COOKIE, "");
						cook.setMaxAge(0);
						response.addCookie(cook);
						Cookie cook_key= new Cookie(Application.USER_COOKIE_KEY, "");
						cook_key.setMaxAge(0);
						 response.addCookie(cook_key);
						// System.out.println("m" + m.getLogin() + member_login_key+ " "+member_login+" fin");
						
						return "error_access_member";
					}
					
					HibernateSessionFactory.closeSession(s);
				}
				
					
				
			}
		}
		else{
			//session.put("my_decorator","empty_inline2");
			System.out.println(" its ok here member in session before");
		}
		return invocation.invoke();
	}
	public static String getCookieValue(Cookie [] cookies, 
			String cookieName, String defaultValue) {
		System.out.println(cookies+"cooé");
			if (cookies!=null) {
				
			  
			for(int i=0; i < cookies.length; i++) {
			    Cookie cookie = cookies[i];
			   // System.out.println(cookie.getName());
			    if(cookieName.equals(cookie.getName()))     
			       return(cookie.getValue());
			  }
			}
			  return(defaultValue);
			  
			}


	private void addActionError(ActionInvocation invocation, String message) {
		Object action = invocation.getAction();
	//	if(action instanceof ValidationAware) {
		//	((ValidationAware) action).addActionError(message);
		//}
	//}
  }
}