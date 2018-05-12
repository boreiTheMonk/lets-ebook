package model.dao;


import java.util.List;



import model.persistance.MessageEmail;
import model.persistance.MessageGroup;


public interface Itf_messageEmail_dao {
	boolean save(MessageEmail me);
	public List<MessageEmail> loadMessageMailbyIdMember(int idMember, int min, int max, String orderBy);
	int countMessageMailbyIdMember(int idMember);
	
	public List<MessageEmail> loadMyMessageMailbyIdMember(int idMember, int min, int max, String orderBy);
	int countMyMessageMailbyIdMember(int idMember);
	public MessageEmail findById(int id);
	public MessageEmail findRootById(int id);
	public boolean delete(int id);
	public MessageEmail findLastMessageByRootId(int id);

	int countMessageMailNotReadbyIdMember(int idMember);
	List<MessageEmail> findMessageMailNotReadbyIdMember(int idMember);
	boolean persist(MessageEmail me);
	
	public List<MessageEmail> getAllMessageMail();
	
}
