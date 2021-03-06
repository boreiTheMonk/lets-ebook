package model.service;

import java.util.List;

import model.persistance.Job;
import model.persistance.Request;
import model.persistance.RequestFriend;

public interface Itf_request_friend_service {
	boolean save(RequestFriend reqf);
	boolean delete(RequestFriend reqf);
	public List<RequestFriend> getRequestFriendByIdMember(int idMember);
	public int countRequestFriendByIdMember(int idMember);
	public RequestFriend findById(int id);
	public RequestFriend  merge(RequestFriend reqf);
	boolean isRequestSent(int idMember,int idMemberFriend);
	public boolean deleteRequestFriendByFriends(int friends1, int friends2) ;
}
