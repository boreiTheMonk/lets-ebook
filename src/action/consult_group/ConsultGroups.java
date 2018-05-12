package action.consult_group;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.persistance.Book;
import model.persistance.Member;
import model.persistance.MessageBook;
import model.persistance.MessageGroup;
import model.persistance.MessageRequest;
import model.persistance.Request;
import model.persistance.ResponseMessageGroup;
import model.persistance.ThemeGroup;
import model.service.Book_service;
import model.service.Group_service;
import model.service.Itf_book_service;
import model.service.Itf_group_service;
import model.service.Itf_member_service;
import model.service.Itf_messageGroup_service;
import model.service.Itf_messageRequest_service;
import model.service.Itf_request_service;
import model.service.Itf_responseMessageBook_service;
import model.service.Member_service;
import model.service.MessageGroup_service;
import model.service.MessageRequest_service;
import model.service.Request_service;

import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.Exp;
import core_lib.WebSiteMessage;


public class ConsultGroups extends ActionSupport implements SessionAware{
	MessageGroup mg;
	ResponseMessageGroup rmg;
	private Map<String, Object> my_session;
	private Itf_group_service service_group;
	private Itf_book_service service_book;
	private Itf_messageGroup_service service_mess_group;
	Itf_messageRequest_service service_mess_req;
	private Itf_responseMessageBook_service service_resp_mess_book;
	ThemeGroup  showGroup;
	Itf_member_service service_member;
	
	Book showBook;
	List<Book> books;
	int groupId,bookId,requestId;
	List<MessageGroup> resMessage;
	//id message for the response to add
	private int id_message_parent;
	int min,max;
	
	Request rq;
	Itf_request_service service_request= new Request_service();
	List<Request> requests;
	String msg_req;
	private List<Member> groupMembers;
	private long countMember;
	private long nbMemberGroup;
	private List<Member> resMember;
	private List<Book> myBooks;
	private boolean group_ok;
	private int nbBooks;
	private List<Book> resBooks;
	private List<Book> ownbook;
	private int id_mess_group;
	
	
	
	


	public int getId_mess_group() {
		return id_mess_group;
	}

	public void setId_mess_group(int idMessGroup) {
		id_mess_group = idMessGroup;
	}

	public List<Book> getOwnbook() {
		return ownbook;
	}

	public void setOwnbook(List<Book> ownbook) {
		this.ownbook = ownbook;
	}

	public List<Book> getResBooks() {
		return resBooks;
	}

	public void setResBooks(List<Book> resBooks) {
		this.resBooks = resBooks;
	}

	public boolean isGroup_ok() {
		return group_ok;
	}

	public void setGroup_ok(boolean groupOk) {
		group_ok = groupOk;
	}

	public List<Book> getMyBooks() {
		return myBooks;
	}

	public void setMyBooks(List<Book> myBooks) {
		this.myBooks = myBooks;
	}

	public long getNbMemberGroup() {
		return nbMemberGroup;
	}

	public void setNbMemberGroup(long nbMemberGroup) {
		this.nbMemberGroup = nbMemberGroup;
	}

	public List<Member> getResMember() {
		return resMember;
	}

	public void setResMember(List<Member> resMember) {
		this.resMember = resMember;
	}

	public long getCountMember() {
		return countMember;
	}

	public void setCountMember(long countMember) {
		this.countMember = countMember;
	}

	public List<Member> getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(List<Member> groupMember) {
		this.groupMembers = groupMember;
	}

	public MessageGroup getMg() {
		return mg;
	}

	public void setMg(MessageGroup mg) {
		this.mg = mg;
	}

	public ResponseMessageGroup getRmg() {
		return rmg;
	}

	public void setRmg(ResponseMessageGroup rmg) {
		this.rmg = rmg;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getMsg_req() {
		return msg_req;
	}

	public void setMsg_req(String msgReq) {
		msg_req = msgReq;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request getRq() {
		return rq;
	}

	public void setRq(Request rq) {
		this.rq = rq;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public ThemeGroup getShowGroup() {
		return showGroup;
	}

	public void setShowGroup(ThemeGroup showGroup) {
		this.showGroup = showGroup;
	}

	public List<MessageGroup> getResMessage() {
		return resMessage;
	}

	public void setResMessage(List<MessageGroup> resMessage) {
		this.resMessage = resMessage;
	}

	public int getId_message_parent() {
		return id_message_parent;
	}

	public void setId_message_parent(int id_message_parent) {
		this.id_message_parent = id_message_parent;
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

	public Book getShowBook() {
		return showBook;
	}

	public void setShowBook(Book showBook) {
		this.showBook = showBook;
	}


	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public ConsultGroups() {
		super();
		 service_book= new Book_service();
		 service_mess_group= new MessageGroup_service();
		 service_group= new Group_service();
		 service_mess_req= new MessageRequest_service();
		 service_member= new Member_service();
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		my_session=arg0;
	}
	
	public String show_home(){
    	showGroup=service_group.findById(groupId);
    	groupMembers = service_member.findMemberByGroupId(groupId, 0, 10, null);
    	countMember=service_member.countMemberByGroupId(groupId);
    	//System.out.println(books);
    	//showBook = service_book.findBookByid(bookId);
    	//showGroup=
    	//my_session.put(showBook.getIdBook().toString(),showBook);
    	return "success";
    }
	
    public String showGroup(){
    	Member me=(Member) my_session.get("my_member");
    	showGroup=service_group.findById(groupId);
    	boolean isOwner = service_group.isGroupOwner(me.getIdMember(), showGroup.getIdGroup());
    	
    	if(isOwner){
    		
    		return "owner";
    	}
    	books=service_book.getBooksByGroup(groupId, 0, 10, null);
    	ownbook=service_book.getBooksByMemberId(me.getIdMember(), 0,0, null);
    	myBooks=service_book.getBooksByMemberinGroup(groupId,me.getIdMember(), 0, 10, null);
    	setNbBooks(service_book.countFindBooksByGroup(groupId));
    	group_ok=service_group.isFollowGroup(me.getIdMember(), groupId);
    	if ( me != null){
    		myBooks=service_book.getBooksByMemberinGroup(groupId,me.getIdMember(), 0, 10, null);
    		/*myBooks=new ArrayList<Book>();
    		for(Book b:service_book.findBooksByMemberId(me.getIdMember())){
    			if(!books.contains(b)){
    				myBooks.add(b);
    			}
    			
    		}*/
    	}
    	System.out.println("taille mybooks " +myBooks.size());
    	
    	
    	
    	//System.out.println(books);
    	//showBook = service_book.findBookByid(bookId);
    	//showGroup=
    	//my_session.put(showBook.getIdBook().toString(),showBook);
    	return "success";
    }
    
    
 
    
    
    
  //save message and show in the screen with ajax
	public String addMessage_group(){
		try{System.out.println("ajax");
		Member m=(Member) my_session.get(Application.USER_KEY);
		
		if(mg.getBody()!=null){
			mg.setBody(new String(mg.getBody().getBytes("iso-8859-1"),"UTF-8"));
		}
		mg.setMember(m);
		//Book b = new book
		// mis book en session
		ThemeGroup group=service_group.findById(groupId);
		mg.setThemeGroup(group);
		//mb.setMemberByIdMember((Member) my_session.get("my_member"));
		mg.setPublishDate(new Date());
		service_mess_group.save(mg);
		
		Member ownerGrp=group.getMember();
		
		
		WebSiteMessage aa= new WebSiteMessage();
		if(group!=null){
			 String send = "Bonjour, vous avez re&ccedil;u un message de "+m.getLogin()+" sur votre groupe "+group.getName()+"<br/><br/>"
			      
			
			 + new String(mg.getBody().getBytes("UTF-8"),"iso-8859-1")  +"<br/><br/>"
			    
			    
			    +  " connectez vous sur <a href='lets-ebook.com'>lets-ebook.com</a> pour lire le message<br/><br/>"
			    +  " cordialement<br/><br/>"
			     + "  L'&eacute;quipe lets-ebook<br/><br/>";
	       	aa.send(ownerGrp.getEmail(), send,"lets-ebook - nouveau message de "+m.getLogin()+ " sur  votre groupe "+group.getName());
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
	
	//save message and show in the screen with ajax
	public String addResponseMessage_book(){
		/*try{
		//rmm.setMessageMember((Member) my_session.get("my_member"));
		rmb.setMember((Member) my_session.get("my_member"));
		rmb.setPublishDate(new Date());
		MessageBook messageBook=service_mess_book.findById(id_message_parent);
		//rmb.setMessageMember(messageMember);
		service_resp_mess_book.save(rmb);
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
			}*/
			return "temp";
	}

	
	
	public String loadMessage_group(){
		try{System.out.println("ajax");
		System.out.println(min +" min"+max + " max ");
		resMessage=service_mess_group.loadMessageGroup(groupId, min, max);
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public StreamResult addFollowGroup(){
		
		Member me=(Member) my_session.get(Application.USER_KEY);
		showGroup=service_group.findById(groupId);
		me= service_member.merge(me);
		me.getThemeGroups_1().add(showGroup);
		service_member.merge(me);
		Boolean res=true;
		
		
		try{
		me=new Exp().changeExp( me,Exp.ADD_GROUPE);
		
		 my_session.put(Application.USER_KEY, me);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	
	//Boolean res =true;
	return new StreamResult(new ByteArrayInputStream(res.toString().getBytes()));
}
	
	public String show_request(){
		requests= service_request.getRequestByGroup(groupId, 0, 10, null);
		return "success";
	}


	public String new_request(){
		showGroup = service_group.findById(groupId);
		return "success";
	}
	
	public String save_request(){
		showGroup = service_group.findById(groupId);
		rq.setThemeGroup(showGroup);
		rq.setMember((Member) my_session.get(Application.USER_KEY));
		service_request.save(rq);
		return "success";
	}
	
	
	public StreamResult add_message_req_ajax(){
		Request req= service_request.findById(requestId);
		System.out.println(" add_message_req_ajax");
		MessageRequest mreq= new MessageRequest(req,(Member) my_session.get(Application.USER_KEY),new Date(),msg_req);
		//mreq.setBody(body)
		Boolean res =service_mess_req.save( mreq);
		//Boolean res =true;
		return new StreamResult(new ByteArrayInputStream(res.toString().getBytes()));
	}
	
	public String show_groupMembers_full(){
		
		//Member me= service_membre.findMemberByLogin(m.getLogin());

			// me= (Member) my_session.get("my_member");
			 
			 
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			nbMemberGroup = service_member.countMemberByGroupId(groupId);
			 
			
			return "success";
	}

	public String listPaginategroupMembers(){
		 

		resMember=service_member.findMemberByGroupId(groupId, min,max, null);
		
		return "success";
	}
	
	
	public StreamResult add_book_group(){
		showBook = service_book.findBookByid(bookId);
		showGroup = service_group.findById(groupId);
		showGroup.getBooks().add(showBook);
		//showBook.getThemeGroups().add(showGroup);
		showBook =service_book.merge(showBook);
		
		Member m=(Member) my_session.get(Application.USER_KEY);
		try{
		m=new Exp().changeExp( m,Exp.ADD_BOOKGRP);
		
		my_session.put(Application.USER_KEY, m);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		Integer res= 0;
		
		if(showBook == null)
			res=1;
		return new StreamResult(new ByteArrayInputStream(res.toString().getBytes()));
	
	}
	
	public String listPaginateGroupBooks(){
		// me= (Member) session.get("my_member");
		// System.out.println(me +"toto");
		//showGroup = service_group.findById(groupId);
		resBooks=service_book.getBooksByGroup(groupId, min,max, null);
		System.out.println(resBooks.size());
		//System.out.println(resMember +"toto");
		return "success";
	}

	public String show_GroupBooks_full(){
		
		//Member me= service_membre.findMemberByLogin(m.getLogin());

			 //me= (Member) my_session.get("my_member");
			 
			 
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			nbBooks = service_book.countFindBooksByGroup(groupId);
			 
			
			return "success";
	}

	public String listPaginateMyGroupBooks(){
		Member me= (Member) my_session.get("my_member");
		// System.out.println(me +"toto");
		//showGroup = service_group.findById(groupId);
		resBooks=service_book.getBooksByMemberinGroup(groupId,me.getIdMember(), min,max, null);
		System.out.println(resBooks.size());
		//System.out.println(resMember +"toto");
		return "success";
	}

	public String show_MyGroupBooks_full(){
		
		//Member me= service_membre.findMemberByLogin(m.getLogin());
		Member me= (Member) my_session.get("my_member");
			 //me= (Member) my_session.get("my_member");
			 
			 
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			nbBooks = service_book.countFindBooksByMemberinGroup(groupId,me.getIdMember());
			 
			
			return "success";
	}
	
	/*
	 * delete a message in book only if the book  or the message belongs to the deleter
	 */
public String delete_message_Group(){
	Member me=(Member) my_session.get(Application.USER_KEY);
	if(me !=null){
		System.out.println("in suppr message");
		
		//MessageMember mm =service_mess_member.findById(id_mess_book);
		MessageGroup mg=service_mess_group.findById(id_mess_group);
		if( mg!=null){
			int id_member_mess=mg.getMember().getIdMember();
			int id_owner_group=mg.getThemeGroup().getMember().getIdMember();
			if(id_member_mess==me.getIdMember()||id_owner_group==me.getIdMember()){
				System.out.println("in suppr message del");
				mg.setDeleted(true);
				service_mess_group.merge(mg);
			}
		}
	}

	//Member me= service_membre.findMemberByLogin(m.getLogin());

			 //me= (Member) my_session.get("my_member");
			 
			 
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			//nbBooks = service_book.countFindFollowBooksByMemberId(((Member) session.get("my_member")).getIdMember());
			 
			
			return "success";
	}
	
	public void setNbBooks(int nbBooks) {
		this.nbBooks = nbBooks;
	}

	public int getNbBooks() {
		return nbBooks;
	}
	
}
