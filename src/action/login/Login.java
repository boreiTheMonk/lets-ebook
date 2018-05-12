package action.login;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.persistance.Book;
import model.persistance.LevelMember;
import model.persistance.Member;
import model.service.Book_service;
import model.service.Itf_book_service;
import model.service.Itf_member_service;
import model.service.Member_service;

import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.WebSiteMessage;


//sevlet request is for showing path
public class Login extends ActionSupport implements SessionAware,ServletRequestAware,CookiesAware, ServletResponseAware {
	private Map<String, Object> my_session;
	private Map<String, String> my_cookies;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private List<Member> newMember;
	private int nbMembers,nbBooks;
	Itf_member_service service_member;
	 private Itf_book_service service_book;
	 private List<Book> mylistbook;
	private String email="15556";
	private String abuse_msg;
	int idMessageAbuse;
	
	



	//true > set the cookie, false remove
	boolean stay;

	
	
	public boolean isStay() {
		return stay;
	}


	public void setStay(boolean stay) {
		this.stay = stay;
	}


	public String getAbuse_msg() {
		return abuse_msg;
	}


	public void setAbuse_msg(String abuseMsg) {
		abuse_msg = abuseMsg;
	}


	public int getIdMessageAbuse() {
		return idMessageAbuse;
	}


	public void setIdMessageAbuse(int idMessageAbuse) {
		this.idMessageAbuse = idMessageAbuse;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	Member m,me;
	 public Member getMe() {
		return me;
	}


	public int getNbMembers() {
		return nbMembers;
	}


	public void setNbMembers(int nbMembers) {
		this.nbMembers = nbMembers;
	}


	public int getNbBooks() {
		return nbBooks;
	}


	public void setNbBooks(int nbBooks) {
		this.nbBooks = nbBooks;
	}


	public void setMe(Member me) {
		this.me = me;
	}


	
	 
	public Login() {
		super();
		service_member= new Member_service();
		service_book = new Book_service();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Member> getNewMember() {
		return newMember;
	}


	public void setNewMember(List<Member> newMember) {
		this.newMember = newMember;
	}


	public List<Book> getMylistbook() {
		return mylistbook;
	}


	public void setMylistbook(List<Book> mylistbook) {
		this.mylistbook = mylistbook;
	}


	public Map<String, Object> getMy_session() {
		return my_session;
	}
	public void setMy_session(Map<String, Object> my_session) {
		this.my_session = my_session;
	}
	public Member getM() {
		return m;
	}
	public void setM(Member m) {
		this.m = m;
	}
	
	public String showMain(){
		 newMember =service_member.getMembers(0, 6, Itf_member_service.ID_DESC);
		 nbMembers = service_member.countAllMembers();
		 nbBooks=service_book.countAllBooks();
		 mylistbook=service_book.getBooks(0, 10, Itf_book_service.DATE_DESC);
		return "success";
	}
	
	public String checkUser(){
	
		System.out.println(my_session.get("lastAction"));
		 me= service_member.findMemberByLogin(m.getLogin());

		 /*in order to do action chaining
		 eg : show member => interceptor check connected save parametter and show login form
		      => we  load parametters here and chain to the last action (look at this action result in struts.xml)
		 */
		 ActionContext context = ActionContext.getContext(); 
		 Map<String, Object> params=(Map<String, Object>) my_session.get(Application.INPUT_PARAMS);
		 if(params!=null){
			 context.setParameters(params);
		 }
		if(me!=null){
		  if(me.getPassword().equals(m.getPassword())){
			  if(me.getSecretQuestion()==null)
			   return "noconfirm";
			 // session.put("login", u.getLogin());
				my_session.put(Application.USER_KEY,me);
				my_session.put(Application.SESSION_DECO,"main_member");
				int nbBooks=service_book.countFindBooksByMemberId(me.getIdMember());
				
				//my_cookies.put("member_id", me.getIdMember().toString());
				if (this.stay){
				Cookie cook= new Cookie(Application.USER_COOKIE, me.getLogin());
				cook.setMaxAge(3600*24*30*2);
				response.addCookie(cook);
				 Cookie cook_key= new Cookie(Application.USER_COOKIE_KEY, Long.toString(me.getRegistrationDate().getTime()));
				 cook_key.setMaxAge(3600*24*30*2);
			     response.addCookie(cook_key); 
				}
				else{
					 Cookie cook= new Cookie(Application.USER_COOKIE, null);
					 cook.setMaxAge(0);
					 response.addCookie(cook);
					 Cookie cook_key= new Cookie(Application.USER_COOKIE_KEY, null);
					 cook_key.setMaxAge(0);
				     response.addCookie(cook_key);
					
				}
				mylistbook=service_book.findBooksByMemberId(me.getIdMember());
				my_session.put(Application.SESSION_NB_BOOK,nbBooks);
				System.out.println("list size: " +mylistbook.size());
				System.out.println(request.getRealPath("/"));
				System.out.println("host:"+request.getServerName());
				int l=((LevelMember)me.getLevelMembers().iterator().next()).getLevel().getNumbr();
				/*Member m=(Member) my_session.get(Application.USER_KEY);
				 m=new Exp().changeExp( m,Exp.INSCRIPTION);

		    		my_session.put(Application.USER_KEY, m);*/
//				System.out.println(ActionContext.getContext().getParameters());
			//	ActionContext ac=ActionContext.getContext();
			//	System.out.println(ActionContext.getContext().getName());
			//	Set<String> aa=ActionContext.getContext().getParameters().keySet();
			//	ActionContext.getContext().getParameters().
				return "success";
		  }
		}
		this.addActionError("arrete ya erreur");
		System.out.println(request.getRealPath("/"));
		return "error";
	}
	
	public String logout(){
		my_session.remove(Application.USER_KEY);
		my_session.remove(Application.SESSION_DECO);
		Cookie cook= new Cookie(Application.USER_COOKIE, "");
		cook.setMaxAge(0);
		response.addCookie(cook);
		Cookie cook_key= new Cookie(Application.USER_COOKIE_KEY, "");
		cook_key.setMaxAge(0);
		 response.addCookie(cook_key);
		return "success";
		
	}
	
	
	public StreamResult sendAbuse(){
		
		   String send = idMessageAbuse+abuse_msg; 
		   System.out.println(send);
		   WebSiteMessage aa= new WebSiteMessage();
        	aa.send("contact@multidb.fr", send,"abus " +idMessageAbuse);
        	return new StreamResult(new ByteArrayInputStream(new String("true").getBytes()));
		
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		my_session=arg0;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		request=arg0;
	}


	@Override
	public void setCookiesMap(Map<String, String> arg0) {
		my_cookies=arg0;
		
	}


	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		response=arg0;
	}
}
