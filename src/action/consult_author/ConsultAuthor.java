package action.consult_author;

import java.io.ByteArrayInputStream;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import model.persistance.Book;
import model.persistance.Member;
import model.persistance.MessageBook;
import model.persistance.MessageMember;
import model.persistance.RequestFriend;
import model.persistance.ResponseMessageMember;
import model.persistance.ThemeGroup;
import model.service.Book_service;
import model.service.Group_service;
import model.service.Itf_book_service;
import model.service.Itf_group_service;
import model.service.Itf_member_service;
import model.service.Itf_messageMember_service;
import model.service.Itf_request_friend_service;
import model.service.Itf_responseMessageMember_service;
import model.service.Member_service;
import model.service.MessageMember_service;
import model.service.RequestFriend_service;
import model.service.ResponseMessageMember_service;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.Exp;
import core_lib.WebSiteMessage;


public class ConsultAuthor extends ActionSupport implements SessionAware{
	MessageMember mm;
	ResponseMessageMember rmm;
	private Map<String, Object> my_session;
	Itf_messageMember_service messageMember_service = new MessageMember_service();
	Itf_responseMessageMember_service respMessageMember_service = new ResponseMessageMember_service();
	int min,max;
	List<MessageMember> resMessage;
	private int id_message_parent;
	Member me;
	Itf_member_service service_member;
	Itf_group_service service_group;
	Itf_request_friend_service service_requestF;
	 private Itf_book_service service_book;
	 private List<Book> mylistbook;
	 List<String> choice_gender;
	 List<Member>  resMember,watcherMembers,followMembers, friendMembers;
	 List<ThemeGroup> followGroups;
	 int idMember;
	 long nbfriends,nbwatcher,nbfollow,nbBooks;
	 boolean friend_ok,follow_ok,friendSent_ok;
	
	 List<Book> resBooks;
	 String login;
	private List<Book> myBooks;
	private int referee;
	private int id_mess_member;
	 
	
	 
	public int getId_mess_member() {
		return id_mess_member;
	}




	public void setId_mess_member(int idMessMember) {
		id_mess_member = idMessMember;
	}




	public int getReferee() {
		return referee;
	}




	public void setReferee(int referee) {
		this.referee = referee;
	}




	public List<Book> getMyBooks() {
		return myBooks;
	}




	public void setMyBooks(List<Book> myBooks) {
		this.myBooks = myBooks;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public boolean isFriend_ok() {
		return friend_ok;
	}




	public void setFriend_ok(boolean friendOk) {
		friend_ok = friendOk;
	}




	public boolean isFollow_ok() {
		return follow_ok;
	}




	public void setFollow_ok(boolean followOk) {
		follow_ok = followOk;
	}




	public boolean isFriendSent_ok() {
		return friendSent_ok;
	}




	public void setFriendSent_ok(boolean friendSentOk) {
		friendSent_ok = friendSentOk;
	}




	public List<Book> getResBooks() {
		return resBooks;
	}




	public void setResBooks(List<Book> resBooks) {
		this.resBooks = resBooks;
	}




	



	public long getNbBooks() {
		return nbBooks;
	}




	public void setNbBooks(long nbBooks) {
		this.nbBooks = nbBooks;
	}




	public List<Member> getResMember() {
		return resMember;
	}




	public void setResMember(List<Member> resMember) {
		this.resMember = resMember;
	}




	public long getNbfriends() {
		return nbfriends;
	}




	public void setNbfriends(long nbfriends) {
		this.nbfriends = nbfriends;
	}




	public long getNbwatcher() {
		return nbwatcher;
	}




	public void setNbwatcher(long nbwatcher) {
		this.nbwatcher = nbwatcher;
	}




	public long getNbfollow() {
		return nbfollow;
	}




	public void setNbfollow(long nbfollow) {
		this.nbfollow = nbfollow;
	}




	public ConsultAuthor() {
		super();
		service_member= new Member_service();
		service_book = new Book_service();
		choice_gender=new ArrayList<String>();
		service_group= new Group_service();
		service_requestF = new RequestFriend_service();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public int getIdMember() {
		return idMember;
	}




	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}




	public List<ThemeGroup> getFollowGroups() {
		return followGroups;
	}



	public void setFollowGroups(List<ThemeGroup> followGroups) {
		this.followGroups = followGroups;
	}



	public List<Member> getWatcherMembers() {
		return watcherMembers;
	}


	public void setWatcherMembers(List<Member> watcherMembers) {
		this.watcherMembers = watcherMembers;
	}


	public List<Member> getFollowMembers() {
		return followMembers;
	}


	public void setFollowMembers(List<Member> followMembers) {
		this.followMembers = followMembers;
	}


	public List<Member> getFriendMembers() {
		return friendMembers;
	}


	public void setFriendMembers(List<Member> friendMembers) {
		this.friendMembers = friendMembers;
	}


	public Member getMe() {
		return me;
	}

	public void setMe(Member me) {
		this.me = me;
	}
	
	
	
	
	public List<Book> getMylistbook() {
		return mylistbook;
	}

	public void setMylistbook(List<Book> mylistbook) {
		this.mylistbook = mylistbook;
	}

	public int getId_message_parent() {
		return id_message_parent;
	}

	public void setId_message_parent(int id_message_parent) {
		this.id_message_parent = id_message_parent;
	}

	public ResponseMessageMember getRmm() {
		return rmm;
	}

	public void setRmm(ResponseMessageMember rmm) {
		this.rmm = rmm;
	}

	public List<MessageMember> getResMessage() {
		return resMessage;
	}

	public void setResMessage(List<MessageMember> resMessage) {
		this.resMessage = resMessage;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public MessageMember getMm() {
		return mm;
	}

	public void setMm(MessageMember mm) {
		this.mm = mm;
	}

	public String delete_author_follow(){
		// me= (Member) session.get("my_member");
		// System.out.println(me +"toto");
		me=service_member.findById(idMember);
		Member m =(Member) my_session.get("my_member");
		m=service_member.merge(m);
		m.getMembersForIdMemberFollow().remove(me);
		service_member.merge(m);
		//System.out.println("fav book delete "+bookId);
		
		return "success";
	}
	//save message and show in the screen with ajax
	public String addMessage_auhor(){
		try{System.out.println("ajax ");
		Member m=(Member) my_session.get(Application.USER_KEY);
		if(mm.getBody()!=null){
			mm.setBody(new String(mm.getBody().getBytes("iso-8859-1"),"UTF-8"));
		}
		HttpServletRequest response = ServletActionContext.getRequest();
		System.out.println("body:"+mm.getBody());
		System.out.println("body:"+new String(mm.getBody().getBytes()));
		System.out.println(response.getCharacterEncoding()+"body2:"+new String(mm.getBody().getBytes(),"ISO-8859-1"));
		mm.setMemberByIdMemberSender(m);
		Member memberRecpt = service_member.findMemberByLogin(login);
		mm.setMemberByIdMember(memberRecpt);
		mm.setPublishDate(new Date());
		messageMember_service.save(mm);
		
		WebSiteMessage aa= new WebSiteMessage();
		if(m!=null){
			 String send = "Bonjour, vous avez re&ccedil;u un message de "+m.getLogin()+" sur votre wall<br/><br/>"
			      
			 + new String(mm.getBody().getBytes("UTF-8"),"iso-8859-1") +"<br/><br/>" 
			 //+ mm.getBody() +"<br/><br/>"
			    
			    
			    +  " connectez vous sur <a href='lets-ebook.com'>lets-ebook.com</a> pour lire le message<br/><br/>"
			    +  " cordialement<br/><br/>"
			     + "  L'&eacute;quipe lets-ebook<br/><br/>";
	       	aa.send(memberRecpt.getEmail(), send,"lets-ebook - nouveau message de "+m.getLogin()+ " sur votre wall");
			}
		
		try{
		m=new Exp().changeExp( m,Exp.POST_WALL);
		
		 my_session.put(Application.USER_KEY, m);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	public String addMessage(){
		try{System.out.println("ajax");
		//System.out.println("le message"+new String(mm.getBody().getBytes(),"UTF-8"));
		
/*		HttpServletRequest response = ServletActionContext.getRequest();
		System.out.println("bodyavant:"+response.getParameter("mm.body"));
		response.setCharacterEncoding("UTF-8");
		//HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println("bodyapres:"+response.getParameter("mm.body"));
		System.out.println("body:"+mm.getBody());
		System.out.println("body:"+new String(mm.getBody().getBytes()));
		System.out.println("bodya:"+new String(mm.getBody().getBytes("iso-8859-1"),"UTF-8"));
		System.out.println("bodyb:"+new String(mm.getBody().getBytes("UTF-8"),"iso-8859-1"));
		System.out.println("bodyc:"+new String(mm.getBody().getBytes("iso-8859-1"),"iso-8859-1"));
		System.out.println("bodyd:"+new String(mm.getBody().getBytes("UTF-8"),"UTF-8"));
		System.out.println("bodyh:"+new String("יי"));
		//CharsetEncoder encoder = Charset.forName("iso-8859-1").newEncoder();
		CharsetEncoder iso8859Encoder = Charset.forName("iso-8859-1")
		.newEncoder();
CharsetEncoder utf8Encoder = Charset.forName("UTF-8").newEncoder();
System.out.println("bodyf:"+iso8859Encoder.canEncode(mm.getBody()));
System.out.println("bodyg:"+utf8Encoder.canEncode(mm.getBody()));

String utf8S = new String(utf8Encoder.encode(
		CharBuffer.wrap(mm.getBody().toCharArray())).array());

System.out.println("bodye:"+utf8S);

System.out.println(iso8859Encoder.canEncode(utf8S));*/

		//System.out.println("body:"+encoder.canencode(mm.getBody()));
		
		
		if(mm.getBody()!=null){
			mm.setBody(new String(mm.getBody().getBytes("iso-8859-1"),"UTF-8"));
		}
		

		
		
		//System.out.println(response.getCharacterEncoding()+"body:"+new String(mm.getBody().getBytes(),"ISO-8859-1"));
		Member m=(Member) my_session.get(Application.USER_KEY);
		mm.setMemberByIdMemberSender(m);
		//Member me=(Member) my_session.get("my_member");
		mm.setMemberByIdMember(m);
		mm.setPublishDate(new Date());
		messageMember_service.save(mm);
		
		
		
		try{
		m=new Exp().changeExp( m,Exp.POST_WALL);
		
		 my_session.put(Application.USER_KEY, m);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	//save message and show in the screen with ajax
	public String addResponseMessage(){
		try{
		//rmm.setMessageMember((Member) my_session.get("my_member"));
		rmm.setMember((Member) my_session.get("my_member"));
		rmm.setPublishDate(new Date());
		MessageMember messageMember=messageMember_service.findById(id_message_parent);
		rmm.setMessageMember(messageMember);
		respMessageMember_service.save(rmm);
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
			}
	}

	public String loadMessage_member(){
		try{System.out.println("ajax");
		System.out.println(min +" min"+max + " max ");
		if(idMember==0){
			me=(Member)my_session.get("my_member");
		}
		else{
			me=service_member.findById(idMember);
			
		}
		resMessage=messageMember_service.loadMessageMember(me.getLogin(), min, max);
		
		
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String loadMessage_home(){
		try{System.out.println("ajax");
		System.out.println(min +" min"+max + " max ");
		if(idMember==0){
			me=(Member)my_session.get("my_member");
		}
		else{
			me=service_member.findById(idMember);
			
		}
		resMessage=messageMember_service.loadMessageMember(me.getLogin(), min, max);
		
		
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public List<String> getChoice_gender() {
		return choice_gender;
	}
	public void setChoice_gender(List<String> choice_gender) {
		this.choice_gender = choice_gender;
	}
	
	public String show_home(){
		
		//Member me= service_membre.findMemberByLogin(m.getLogin());

			 me= (Member) my_session.get("my_member");
			 
			 resMessage=messageMember_service.loadMessageMember(((Member)my_session.get("my_member")).getLogin(), 0, 5);
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			 watcherMembers=service_member.findWatchersById(me.getIdMember(), 0, 10, null);
			 followMembers=service_member.findFollowersById(me.getIdMember(), 0, 10, null);
			 friendMembers=service_member.findFriendsById(me.getIdMember(), 0,10, null);
			 followGroups=service_group.findJoinGroupById(me.getIdMember(), 0,6, null);
			 myBooks=service_book.getBooksByMemberId(me.getIdMember(), 0,10, null);
			 //followBooks=
			 me =service_member.merge(me);
			 System.out.println(me.getIdMember()+" "+watcherMembers);
			 referee=service_member.count_referree(me.getLogin());
			 try{
			 System.out.println( me.getBooks());
			// System.out.println(me.getThemeGroups());
}
catch(RuntimeException e){
	 e.printStackTrace();
}
			// mylistbook=service_book.findBooksByMemberId(me.getIdMember());
	/*	System.out.println("avant");
		System.out.println(me.getBooks().size());
		System.out.println("apres");*/
		// mylistbook=service_book.findBooksByMemberId(1);
	
			  return "success";
		
		
	}
	
public String show_author_home(){
		
		//Member me= service_membre.findMemberByLogin(m.getLogin());
	 Member me_session= (Member) my_session.get("my_member");
	 me_session=service_member.merge(me_session);
	 me= service_member.findById(idMember);
	 friendSent_ok= me_session.getMembersForIdMemberFriend().contains(me);
			
			 nbBooks=service_book.countFindBooksByMemberId(idMember);
			 follow_ok=service_member.isFollow(idMember, me_session.getIdMember());
			 resMessage=messageMember_service.loadMessageMember(((Member)my_session.get("my_member")).getLogin(), 0, 5);
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			 resBooks=service_book.getBooksByMemberId(idMember, 0,10, null);
			 friend_ok=service_member.isFriend(me_session.getIdMember(), me.getIdMember());
			
			 try{
			 System.out.println( me.getBooks());
			// System.out.println(me.getThemeGroups());
}
			 
			 
catch(RuntimeException e){
	 e.printStackTrace();
}
			// mylistbook=service_book.findBooksByMemberId(me.getIdMember());
	/*	System.out.println("avant");
		System.out.println(me.getBooks().size());
		System.out.println("apres");*/
		// mylistbook=service_book.findBooksByMemberId(1);
	
			  return "success";
		
		
	}

public String show_myFriends_full(){
	
	//Member me= service_membre.findMemberByLogin(m.getLogin());

		 me= (Member) my_session.get("my_member");
		 
		// me=	new Exp().changeExp( me,Exp.NAVIGUE);

		//	my_session.put(Application.USER_KEY, me);
		 
		 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
		nbfriends = service_member.countFriendsById(me.getIdMember());
		 
		
		return "success";
}

public String listPaginateFriends(){
	 me= (Member) my_session.get("my_member");

	resMember=service_member.findFriendsById(me.getIdMember(), min,max, null);
	
	return "success";
}


public String show_myFavouriteAuthor_full(){
	
	//Member me= service_membre.findMemberByLogin(m.getLogin());

		 me= (Member) my_session.get("my_member");
		 
		 
		 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
		nbfriends = service_member.countFollowersById(me.getIdMember());
		 
		
		return "success";
}

public String listPaginateFavouriteAuthors(){
	 me= (Member) my_session.get("my_member");
	// System.out.println(me +"toto");
	resMember=service_member.findFollowersById(me.getIdMember(), min,max, null);
	//System.out.println(resMember +"toto");
	return "success";
}

public String show_myWatchers_full(){
	
	//Member me= service_membre.findMemberByLogin(m.getLogin());

		 me= (Member) my_session.get("my_member");
		 
		 
		 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
		nbfriends = service_member.countWatchersById(me.getIdMember());
		 
		
		return "success";
}

public String listPaginateWatchers(){
	 me= (Member) my_session.get("my_member");
	 System.out.println(me +"toto");
	resMember=service_member.findWatchersById(me.getIdMember(), min,max, null);
	System.out.println(resMember +"toto");
	return "success";
}

public StreamResult sendFriendRequest(){
	 UUID idOne = UUID.randomUUID();
	 me= (Member) my_session.get(Application.USER_KEY);
	 Member memb2= service_member.findById(idMember);
	 Boolean res=false;
	 RequestFriend rf1=new RequestFriend( memb2,me,false,idOne.toString(),false,false);
	if(!service_requestF.isRequestSent(idMember, me.getIdMember()))
		res=service_requestF.save(rf1);
	
	if(res){
		me=service_member.merge(me);
		//me.getMembersForIdMemberFriend().add(memb2);
		//me=service_member.merge(me);
	}
	
	
	try{
	me=new Exp().changeExp( me,Exp.SEND_REQF);
	
	 my_session.put(Application.USER_KEY, me);
	}
	catch(NullPointerException e){
		e.printStackTrace();
	}
	
	return new StreamResult(new ByteArrayInputStream(res.toString().getBytes()));
}

public StreamResult  addFollow(){
	// UUID idOne = UUID.randomUUID();
	 me= (Member) my_session.get(Application.USER_KEY);
	 Member memb2= service_member.findById(idMember);
	 me=service_member.merge( me);
	me.getMembersForIdMemberFollow().add(memb2);
		me=service_member.merge(me);
		
		try{
		me=new Exp().changeExp( me,Exp.ADD_BOOKGRP);
		
		my_session.put(Application.USER_KEY, me);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		//me.getMembersForIdMemberFriend().add(memb2);
		//me=service_member.merge(me);
	
	return new StreamResult(new ByteArrayInputStream(new Boolean(true).toString().getBytes()));
}

/*
 * delete a message in member only if owner page or the message sender belongs to the deleter
 */
public String delete_message_member(){
Member me=(Member) my_session.get(Application.USER_KEY);
if(me !=null){
	System.out.println("in suppr message");
	//MessageMember mm =service_mess_member.findById(id_mess_book);
	MessageMember mm=messageMember_service.findById(id_mess_member);
	if( mm!=null){
		int id_member_mess=mm.getMemberByIdMemberSender().getIdMember();
		int id_owner_profil=mm.getMemberByIdMember().getIdMember();
		if(id_member_mess==me.getIdMember()||id_owner_profil==me.getIdMember()){
			System.out.println("in suppr message del member");
			mm.setDeleted(true);
			messageMember_service.merge(mm);
		}
	}
}

//Member me= service_membre.findMemberByLogin(m.getLogin());

		 //me= (Member) my_session.get("my_member");
		 
		 
		 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
		//nbBooks = service_book.countFindFollowBooksByMemberId(((Member) session.get("my_member")).getIdMember());
		 
		
		return "success";
}


	

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		my_session=arg0;
	}
	
}
