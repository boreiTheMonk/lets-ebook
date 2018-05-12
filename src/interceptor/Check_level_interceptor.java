package interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;

import model.dao.Itf_member_dao;
import model.dao.Member_dao;
import model.persistance.Member;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import constant.Application;

public class Check_level_interceptor extends AbstractInterceptor{

 private String decorator_name;
 
 	
 //private static final String USER_KEY = "my_member";
 //private static final String USER_COOKIE = "member_login";

	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map session = invocation.getInvocationContext().getSession();
		 Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		 String member_login;
		 String member_login_key;
		if(session.get(Application.USER_KEY) == null) {
			member_login=getCookieValue(cookies,Application.USER_COOKIE,null);
			member_login_key=getCookieValue(cookies,Application.USER_COOKIE_KEY,null);
			if ( (member_login) == null){
		//		addActionError(invocation, "You must be authenticated to access this page");
				System.out.println("found no member at all and error");
				session.remove(Application.SESSION_DECO);
				return "error_access_member";}
			else{
				Session s= HibernateSessionFactory.getNewSession();
				System.out.println("ee");
				//Itf_member_service memberserv = new Member_service();
				Member_dao memberserv= new Member_dao();
				memberserv.setSession(s);
				Member m =memberserv.findMemberByLogin(member_login);
				HibernateSessionFactory.closeSession(s);
				System.out.println(m+ " found member in cookie "+member_login);
				if (m!=null){
					if(Long.toString(m.getRegistrationDate().getTime())==member_login_key){
						session.put(Application.USER_KEY, m);
						session.put(Application.SESSION_DECO,"main_member");
					}
					else{
						return "error_access_member";
					}
				
				}
				else{
					return "error_access_member";
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
			  for(int i=0; i < cookies.length; i++) {
			    Cookie cookie = cookies[i];
			   // System.out.println(cookie.getName());
			    if(cookieName.equals(cookie.getName()))     
			       return(cookie.getValue());
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