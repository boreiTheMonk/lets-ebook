package action.manage_friends;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.persistance.Member;
import model.persistance.RequestFriend;
import model.service.Itf_member_service;
import model.service.Itf_request_friend_service;
import model.service.Member_service;
import model.service.RequestFriend_service;

import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.Exp;

public class MyFriends extends ActionSupport implements SessionAware {
	private Map<String, Object> my_session;
	Itf_member_service service_member;
	Itf_request_friend_service service_reqF;
	Member myFriend,me;
	private int idMember,idRequestF;
	List<RequestFriend> reqF;
	boolean okFriend;
	String login_friend;
	
	
	public int getIdRequestF() {
		return idRequestF;
	}


	public void setIdRequestF(int idRequestF) {
		this.idRequestF = idRequestF;
	}


	public boolean isOkFriend() {
		return okFriend;
	}


	public void setOkFriend(boolean okFriend) {
		this.okFriend = okFriend;
	}


	public String getLogin_friend() {
		return login_friend;
	}


	public void setLogin_friend(String loginFriend) {
		login_friend = loginFriend;
	}


	public int getIdMember() {
		return idMember;
	}


	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}


	public List<RequestFriend> getReqF() {
		return reqF;
	}


	public void setReqF(List<RequestFriend> reqF) {
		this.reqF = reqF;
	}


	public MyFriends() {
		service_member= new Member_service();
		service_reqF = new RequestFriend_service();
		// TODO Auto-generated constructor stub
	}
	

	public Member getMyFriend() {
		return myFriend;
	}


	public void setMyFriend(Member myFriend) {
		this.myFriend = myFriend;
	}


	public Member getMe() {
		return me;
	}


	public void setMe(Member me) {
		this.me = me;
	}


	public String show_friend_request(){
		Member mine = (Member) my_session.get("my_member");
		reqF=service_reqF.getRequestFriendByIdMember(mine.getIdMember());
		for(RequestFriend r:reqF){
			r.setIsRead(true);
		}
		return "success";
	}
	
/*	public String sendFriendRequest(){
		
		 myFriend = service_member.findById(idMember);
		 me= (Member) my_session.get("my_member");
		 System.out.println(me +"toto");
		 UUID idsecu = UUID.randomUUID();
		 RequestFriend reqf = new RequestFriend(myFriend, me,false,idsecu.toString());
		 boolean ok = service_reqF.save(reqf);
		 if(ok){
			 //send email
			 
		 }
		//System.out.println(resMember +"toto");
		return "success";
	}*/
	
	public StreamResult confirm_friend(){
		me= (Member) my_session.get(Application.USER_KEY);
		if(okFriend){
			RequestFriend rf=service_reqF.findById(idRequestF);
			rf.setTreated(true);
			rf.setIsOk(true);
			rf = service_reqF.merge( rf);
			Member myFriend= service_member.findMemberByLogin(login_friend);
			me=service_member.merge(me);
			myFriend.getMembersForIdMemberFriend().add(me);
		
			me.getMembersForIdMemberFriend().add(myFriend);
			service_member.merge(me);
			myFriend =service_member.merge(myFriend);
			System.out.println("amis : "+me.getLogin()+" "+myFriend.getLogin());
			if(myFriend==null||rf==null)
				return new StreamResult(new ByteArrayInputStream("false".getBytes()));
		}
		else{
			RequestFriend rf=service_reqF.findById(idRequestF);
			
			service_reqF.delete( rf);
			Member myFriend= service_member.findMemberByLogin(login_friend);
			me=service_member.merge(me);
			System.out.println("before"+me.getMembersForIdMemberFriend().size());
			me.getMembersForIdMemberFriend().remove(myFriend);
			System.out.println("after"+me.getMembersForIdMemberFriend().size());
			if(me==null||rf==null)
				return new StreamResult(new ByteArrayInputStream("false".getBytes()));
			
			
		}
		
		//Member m=(Member) my_session.get(Application.USER_KEY);
		try{
		me=new Exp().changeExp( me,Exp.ACCEPT_REQF);
	
		 my_session.put(Application.USER_KEY, me);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return new StreamResult(new ByteArrayInputStream("true".getBytes()));
			
	
		
	}

	public StreamResult  delete_friends(){
		System.out.println("delete friends");
		
		me= (Member) my_session.get(Application.USER_KEY);
		Member myFriend= service_member.findById(idMember);
		me=service_member.merge(me);
		
		me.getMembersForIdMemberFriend().remove(myFriend);
		myFriend.getMembersForIdMemberFriend().remove(me);
		
		service_reqF.deleteRequestFriendByFriends(me.getIdMember(), myFriend.getIdMember());

		try{
			me=new Exp().changeExp( me,Exp.DELETE_FRIEND);
			
			 my_session.put(Application.USER_KEY, me);
			}
			catch(NullPointerException e){
				e.printStackTrace();
			}
		
		return new StreamResult(new ByteArrayInputStream("true".getBytes()));
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		my_session=arg0;

	}
	
	

}
