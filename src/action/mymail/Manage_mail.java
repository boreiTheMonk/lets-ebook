package action.mymail;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.persistance.Member;
import model.persistance.MessageEmail;
import model.service.Itf_member_service;
import model.service.Itf_messageEmail_service;
import model.service.Member_service;
import model.service.MessageEmail_service;

import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.Exp;
import core_lib.WebSiteMessage;
import cron.Replace_null_email_messageRoots;

public class Manage_mail extends ActionSupport implements SessionAware{
	List<MessageEmail> resMessage;
	Itf_messageEmail_service serv_me= new MessageEmail_service();
	private Map<String, Object> my_session;
	MessageEmail mail;
	int min,max,idMessage,idMessageFollowee;
	private Member me;
	String msg_body;
	List<Member> friendList;
	Itf_member_service service_member;
	private int idMember;
	
	
	
	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	public int getIdMessageFollowee() {
		return idMessageFollowee;
	}
	public void setIdMessageFollowee(int idMessageFollowee) {
		this.idMessageFollowee = idMessageFollowee;
	}
	public Member getMe() {
		return me;
	}
	public void setMe(Member me) {
		this.me = me;
	}
	public List<Member> getFriendList() {
		return friendList;
	}
	public void setFriendList(List<Member> friendList) {
		this.friendList = friendList;
	}
	public Manage_mail() {
		super();
		service_member= new Member_service();
		// TODO Auto-generated constructor stub
	}
	public String getMsg_body() {
		return msg_body;
	}
	public void setMsg_body(String msgBody) {
		msg_body = msgBody;
	}
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public List<MessageEmail> getResMessage() {
		return resMessage;
	}
	public void setResMessage(List<MessageEmail> resMessage) {
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
	public String show_MyEmails(){
	
	
	return "success";
	}
	
	
	public MessageEmail getMail() {
		return mail;
	}
	public void setMail(MessageEmail mail) {
		this.mail = mail;
	}
	public String showWriteMail(){
		
		
		return "success";
	}
	public String listPaginateMyMails(){
		try{System.out.println("ajax");
		System.out.println(min +" min"+max + " max ");
		resMessage=serv_me.loadMyMessageMailbyIdMember(((Member) my_session.get(Application.USER_KEY)).getIdMember(), min, max, null);
		if(min>0){
			return "mail_next";	
		}
		else
			return "success";
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
	}
	public String listPaginateInbox(){
		try{System.out.println("ajax");
		System.out.println(min +" min"+max + " max ");
		resMessage=serv_me.loadMessageMailbyIdMember(((Member) my_session.get(Application.USER_KEY)).getIdMember(), min, max, null);
		
		if(min>0){
			return "mail_next";	
		}
		else
			return "success";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
	}
	
	
	public String showDetailMail(){
		try{System.out.println("ajax");
		System.out.println(min +" min"+max + " max ");
		mail=serv_me.findRootById(idMessage);
	//	int taille= mail.getMessageEmailsForIdMessageRoots().size();
		System.out.println(idMessage+ ""+mail);
		
		/*if(mail.getIsRead()==null){
			mail.setIsRead(true);	
		}
		if(mail.getIsRead()==false){
			mail.setIsRead(true);
			*/
		MessageEmail currmail=serv_me.findById(idMessage);
		Member m=(Member) my_session.get(Application.USER_KEY);	
		
		if(currmail.getIsRead()==null){
			int idMembertmp=currmail.getMemberByIdMemberSender().getIdMember();
			if(idMembertmp!=m.getIdMember())
			currmail.setIsRead(true);	
		}
		if(currmail.getIsRead()==false){
			
			int idMembertmp=currmail.getMemberByIdMemberSender().getIdMember();
			if(idMembertmp!=m.getIdMember())
			currmail.setIsRead(true);
		
		try{
		m=new Exp().changeExp( m,Exp.READ_MAIL);
		
		 my_session.put(Application.USER_KEY, m);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		
		}
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
	}
	
	public String deleteMail(){
		//mail=serv_me.findRootById(idMessage);
		System.out.println("delete message");
		mail=serv_me.findRootById(idMessage);
		Member m=(Member) my_session.get(Application.USER_KEY);	
		
		int id_member_recepee=mail.getMemberByIdMember().getIdMember();
		int id_member_sender=mail.getMemberByIdMemberSender().getIdMember();
		if(id_member_recepee==m.getIdMember()||id_member_sender==m.getIdMember())
			mail.getMemberDeleted().add(m);
		
		//serv_me.delete(idMessage);
		return "success";
	}
	
	
	
	public StreamResult addRespMessageEmailAjax(){
		mail=serv_me.findRootById(idMessage);
		MessageEmail followee = serv_me.findLastMessageByRootId(mail.getIdMessage());
		
		Member adressee=null;
		me=(Member)my_session.get(constant.Application.USER_KEY);
		int membId=mail.getMemberByIdMember().getIdMember();
		if(me.getIdMember()==membId)
			 adressee=mail.getMemberByIdMemberSender();
		else
			 adressee=mail.getMemberByIdMember();
			
			
		System.out.println(mail.getBody()+" destinataire "+adressee.getLogin());
		
		if(msg_body!=null){
			try {
				msg_body=new String(msg_body.getBytes("iso-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		MessageEmail m = new MessageEmail(mail,followee,adressee, me, null, new Date(), msg_body, mail.getSubject(),false,null, null);
		mail.getMemberDeleted().clear();
		
		Boolean res =serv_me.save(m);
		//System.out.println("envoi message");
		if(res ){
			
			
			WebSiteMessage aa= new WebSiteMessage();
			
			if(adressee!=null){
			 String send = null;
			try {
				send = "Bonjour, vous avez re&ccedil;u un message de "+me.getLogin()+"<br/><br/>"
				      
				 + "objet: "+new String(m.getSubject().getBytes("UTF-8"),"iso-8859-1")+"<br/>"
				 + new String(m.getBody().getBytes("UTF-8"),"iso-8859-1") +"<br/><br/>"
				    
				    
				    +  " connectez vous sur <a href='lets-ebook.com'>lets-ebook.com</a> pour lire le message<br/><br/>"
				    +  " cordialement<br/><br/>"
				     + "  L'&eacute;quipe lets-ebook<br/><br/>";
			
	       	aa.send(adressee.getEmail(), send,"lets-ebook - nouveau message de "+me.getLogin());
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		
		}
		
		try{
		me=new Exp().changeExp( me,Exp.ADD_MAIL);
		
		 my_session.put(Application.USER_KEY, me);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		
		return new StreamResult(new ByteArrayInputStream(res.toString().getBytes()));
		
	}
	
	public String showMailForm(){
		try{System.out.println("ajax form");
		me =(Member)my_session.get(constant.Application.USER_KEY);
		//me=service_member.merge(me);
		friendList = service_member.findFriendsById(me.getIdMember(), 0,-1, null);
	//	friendList=me.getMembersForIdMemberFriend();
		//mail=serv_me.findRootById(idMessage);
		//System.out.println(idMessage+ ""+mail);
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
		
		public String showWriteMailAuthorForm(){
			try{System.out.println("ajax form");
			me =service_member.findById(idMember);
			//me=service_member.merge(me);
		
			return "success";}
			catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
		
		
	}
	
	public StreamResult send_mail(){
		try{System.out.println("ajax mail");
		me =(Member)my_session.get(constant.Application.USER_KEY);
		Member rcpt=service_member.findById(idMember);
		if(mail.getSubject().trim().equals(""))
			mail.setSubject("pas de sujet");
		else
			mail.setSubject(new String(mail.getSubject().getBytes("iso-8859-1"),"UTF-8"));
		mail.setMemberByIdMemberSender(me);
		
		if(mail.getBody()!=null){
			mail.setBody(new String(mail.getBody().getBytes("iso-8859-1"),"UTF-8"));
			
		}
		mail.setMemberByIdMember(rcpt);
		mail.setPublishDate(new Date());
		
		
		
		mail.setIsRead(false);
		Boolean test=false;
		if(serv_me.persist(mail)){
			test=true;
			//new to fix delete mail change root
			mail.setMessageEmailByIdMessageRoots(mail);
			
			WebSiteMessage aa= new WebSiteMessage();
			
			if(rcpt!=null){
			 String send = "Bonjour, vous avez re&ccedil;u un message de "+me.getLogin()+"<br/><br/>"
			      
			 + "objet: "+new String(mail.getSubject().getBytes("UTF-8"),"iso-8859-1")+"<br/>"
			 + new String(mail.getBody().getBytes("UTF-8"),"iso-8859-1") +"<br/><br/>"
			    
			    
			    +  " connectez vous sur <a href='lets-ebook.com'>lets-ebook.com</a> pour lire le message<br/><br/>"
			    +  " cordialement<br/><br/>"
			     + "  L'&eacute;quipe lets-ebook<br/><br/>";
	       	aa.send(rcpt.getEmail(), send,"lets-ebook - nouveau message de "+me.getLogin());
			}
		
		}
		
		
		try{
		me=new Exp().changeExp( me,Exp.ADD_MAIL);
		
		 my_session.put(Application.USER_KEY, me);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return new StreamResult(new ByteArrayInputStream(test.toString().getBytes()));
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
			 return new StreamResult(new ByteArrayInputStream(e.getMessage().toString().getBytes()));
		}
		
		
	}
	
	
	public String task(){
	
		new Replace_null_email_messageRoots().execute();
		//me=service_member.merge(me);
	
		return "success";
	
		}
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		my_session=arg0;
	}
	
	
}
