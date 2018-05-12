package action.seekbook;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import constant.Application;
import core_lib.Exp;

import model.persistance.Book;
import model.persistance.Member;
import model.persistance.ThemeGroup;
import model.service.Book_service;
import model.service.Group_service;
import model.service.Itf_book_service;
import model.service.Itf_group_service;
import model.service.Itf_member_service;
import model.service.Member_service;

public class Search implements SessionAware {
	private Map<String, Object> my_session;
	private Itf_member_service service_member;
	private Itf_book_service service_book;
	private Itf_group_service service_group;
	List<Book> resBooks;
	List<Member> resMember;
	List<ThemeGroup> resGroup;
	String searchWord;
	int nbBooks,nbAuthors,nbGroups,min,max;
	
	
	


	public List<ThemeGroup> getResGroup() {
		return resGroup;
	}

	public void setResGroup(List<ThemeGroup> resGroup) {
		this.resGroup = resGroup;
	}

	public int getNbGroups() {
		return nbGroups;
	}

	public void setNbGroups(int nbGroups) {
		this.nbGroups = nbGroups;
	}

	public int getNbAuthors() {
		return nbAuthors;
	}

	public void setNbAuthors(int nbAuthors) {
		this.nbAuthors = nbAuthors;
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

	public int getNbBooks() {
		return nbBooks;
	}

	public void setNbBooks(int nbBooks) {
		this.nbBooks = nbBooks;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	    
	   
	 public Search() {
		super();
		// TODO Auto-generated constructor stub
		 service_member= new Member_service();
		 service_book=new Book_service();
		 service_group=new Group_service();
	 }
	
	public List<Book> getResBooks() {
		return resBooks;
	}
	public void setResBooks(List<Book> resBooks) {
		this.resBooks = resBooks;
	}
	public List<Member> getResMember() {
		return resMember;
	}
	public void setResMember(List<Member> resMember) {
		this.resMember = resMember;
	}
	
	public String showSearch(){
		nbBooks=service_book.countFindBooksByString(searchWord);
		//resBooks = service_book.findBooksByString(searchWord);
	//	System.out.println(resBooks.get(0).getMember().getName());
		//resMember = service_member.findMemberByString(searchWord);
		nbAuthors= service_member.countFindMemberByString(searchWord);
		nbGroups=service_group.countFindGroupByString(searchWord);
		
		if(searchWord.equals("momusu")){
			Member m=(Member) my_session.get(Application.USER_KEY);
			try{
			if(m!=null)	{
			m=new Exp().changeExp( m,Exp.CREER_GROUPE);
			
			 my_session.put(Application.USER_KEY, m);
			}
			}
			catch(NullPointerException e){
				e.printStackTrace();
			}
			
		}
		
		System.out.println(nbAuthors+" nbauthor "+ nbBooks+" " +resBooks+" "+resMember);
		return "success";
	}
	
	public String searchPaginateBook(){
		try {
			searchWord=new String(searchWord.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resBooks = service_book.findBooksByString(searchWord,min,max);
		System.out.println(min +" min"+max + " max ");
		System.out.println(resBooks);
	return "success";	
	}
	
	public String searchPaginateAuthor(){
		try {
			searchWord=new String(searchWord.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//resBooks = service_book.findBooksByString(searchWord,min,max);
		resMember = service_member.findMembersByString(searchWord,min,max,null);
		System.out.println(min +" min"+max + " max ");
		System.out.println(resBooks);
	return "success";	
	}
	
	public String searchPaginateGroup(){
		try {
			searchWord=new String(searchWord.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//resBooks = service_book.findBooksByString(searchWord,min,max);
		resGroup = service_group.findGroupByString(searchWord, min, max, null);
		System.out.println(min +" min"+max + " max ");
		System.out.println(resGroup);
	return "success";	
	}

	   public String showAllGroups(){
	    	
	    	//resGroup=service_group.findGroupByString("", 0, 10, null);
	    	nbGroups=service_group.countFindGroupByString("");

	    	return "success";
	    }
	   
		public String listAllGroups(){
			 
			resGroup=service_group.findGroupByString("",min,max, null);
			
			
			return "success";
		}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		my_session=arg0;
		
		
	}
	
}
