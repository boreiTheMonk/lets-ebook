package action.mygroups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.persistance.Book;
import model.persistance.Member;
import model.persistance.Theme;
import model.persistance.ThemeGroup;
import model.service.Book_service;
import model.service.Group_service;
import model.service.Itf_book_service;
import model.service.Itf_group_service;
import model.service.Itf_member_service;
import model.service.Itf_theme_service;
import model.service.Member_service;
import model.service.MessageGroup_service;
import model.service.MessageRequest_service;
import model.service.Theme_services;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.Exp;

public class Manage_groups extends ActionSupport implements SessionAware {
	private Itf_group_service service_group;
	Itf_theme_service theme_service ;
	List<ThemeGroup> myGroups,resGroup;
	Map<String, Object> my_session;
	Map <Integer,String> themes;
	//from the select form
	int theme_id,min,max;
	long nbGroups;
	List<Book> books;
	int groupId,bookId,requestId;
	private Itf_book_service service_book;
	private int nbBooks;
	private List<Book> myBooks;
	private boolean group_ok;
	ThemeGroup  showGroup;
	Itf_member_service service_member;
	
	
	
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

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getNbBooks() {
		return nbBooks;
	}

	public void setNbBooks(int nbBooks) {
		this.nbBooks = nbBooks;
	}

	public List<Book> getMyBooks() {
		return myBooks;
	}

	public void setMyBooks(List<Book> myBooks) {
		this.myBooks = myBooks;
	}

	public boolean isGroup_ok() {
		return group_ok;
	}

	public void setGroup_ok(boolean groupOk) {
		group_ok = groupOk;
	}

	public ThemeGroup getShowGroup() {
		return showGroup;
	}

	public void setShowGroup(ThemeGroup showGroup) {
		this.showGroup = showGroup;
	}

	public List<ThemeGroup> getResGroup() {
		return resGroup;
	}

	public void setResGroup(List<ThemeGroup> resGroup) {
		this.resGroup = resGroup;
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

	public long getNbGroups() {
		return nbGroups;
	}

	public void setNbGroups(long nbGroups) {
		this.nbGroups = nbGroups;
	}

	public int getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(int theme_id) {
		this.theme_id = theme_id;
	}

	public Map<Integer, String> getThemes() {
		return themes;
	}

	public void setThemes(Map<Integer, String> themes) {
		this.themes = themes;
	}

	ThemeGroup g;
	private int themeGroup;
	
	
	//Itf_group_service groupserv
	
	public int getThemeGroup() {
		return themeGroup;
	}

	public void setThemeGroup(int themeGroup) {
		this.themeGroup = themeGroup;
	}

	public List<ThemeGroup> getMyGroups() {
		return myGroups;
	}

	public void setMyGroups(List<ThemeGroup> myGroups) {
		this.myGroups = myGroups;
	}

	public ThemeGroup getG() {
		return g;
	}

	public void setG(ThemeGroup g) {
		this.g = g;
	}

	public Manage_groups() {
		super();
		service_group=new Group_service();
		theme_service = new Theme_services();
		 service_book= new Book_service();
		
		 service_member= new Member_service();
		// TODO Auto-generated constructor stub
	}

	public String show_my_groups(){
		service_group.findAllGroupByIdMember(((Member)my_session.get(constant.Application.USER_KEY)).getIdMember());
		return "success";
	}
	
	public String show_new_group(){
		//themes =theme_service.getAllThemes();
		return "success";
	}
	
	
	
	
	public String save_new_group(){
		//themes =theme_service.getAllThemes();
		Member m=(Member) my_session.get(Application.USER_KEY);
		g.setMember(m);
		Theme myTheme =theme_service.findById(theme_id);
		g.getThemes().add(myTheme);
		service_group.save(g);
		
		
		try{
		m=new Exp().changeExp( m,Exp.CREER_GROUPE);
		
		 my_session.put(Application.USER_KEY, m);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
    		
    		
		return "success";
	}
	
	
	public String show_edit_group(){
		//themes =theme_service.getAllThemes();
		g=service_group.findById(groupId);
		themeGroup = ((Theme)g.getThemes().iterator().next()).getIdTheme();
		return "success";
	}
	
	
	
	public String insertGroup(){
		Theme t =theme_service.findById(theme_id);
		Set<Theme> themeList = new HashSet<Theme>();
		themeList.add(t);
		System.out.println(t+"theme "+theme_id);
		g.setThemes(themeList);
		g.setMember((Member)my_session.get(Application.USER_KEY));
		service_group.save(g);
		return "success";
	}
	
	public String show_admin_group(){
		Member me=(Member) my_session.get(Application.USER_KEY);
		me = service_member.merge(me);
    	books=service_book.getBooksByGroup(groupId, 0, 10, null);
    	setNbBooks(service_book.countFindBooksByGroup(groupId));
    	group_ok=service_group.isFollowGroup(me.getIdMember(), groupId);
    	if ( me != null){
    		
    		myBooks=new ArrayList<Book>();
    		for(Book b:service_book.findBooksByMemberId(me.getIdMember())){
    			if(!books.contains(b)){
    				myBooks.add(b);
    			}
    			
    		}
    	}
    	showGroup=service_group.findById(groupId);
    	
    	if(showGroup.getMember()!=me){
    		return "error";
    	}
    	//System.out.println(books);
    	//showBook = service_book.findBookByid(bookId);
    	//showGroup=
    	//my_session.put(showBook.getIdBook().toString(),showBook);
    	return "success";
	}
	
public String update_group(){
	Member me=(Member) my_session.get(Application.USER_KEY);
	//themes =theme_service.getAllThemes();
	showGroup=service_group.findById(groupId);
	System.out.println(showGroup.getMember().getIdMember()+" "+me.getIdMember());
	int membid=showGroup.getMember().getIdMember();
	if(membid==me.getIdMember()){
		showGroup.setDescription(g.getDescription());
		showGroup.setName(g.getName());
	Theme myTheme =theme_service.findById(theme_id);
	showGroup.getThemes().clear();
	showGroup.getThemes().add(myTheme);
	service_group.merge(showGroup);
	
	
	}
	else
		return "error";
		
	return "success";
	}

public String delete_group(){
	//
	
	Member me=(Member) my_session.get(Application.USER_KEY);
	showGroup=service_group.findById(groupId);
	int idmember_owner=showGroup.getMember().getIdMember();
	if(me.getIdMember()==idmember_owner){
		
		//delete books
		System.out.println("in delete own group"+showGroup);
		showGroup.getBooks().clear();
		
		Set<Member> lmemb=showGroup.getMembers();
		
		if(lmemb!=null){
			for(Member m:lmemb){
				m.getThemeGroups_1().remove(showGroup);
			}
		}
		showGroup.setDeleted(true);
		service_group.merge(showGroup);
	}
	return "success";
}

public String delete_joined_group(){
	// me= (Member) session.get("my_member");
	// System.out.println(me +"toto");
	showGroup=service_group.findById(groupId);
	Member m =(Member) my_session.get("my_member");
	m=service_member.merge(m);
	m.getThemeGroups_1().remove(showGroup);
	//service_member.merge(m);
	System.out.println("joined_group delete "+showGroup);
	
	try{
		m=new Exp().changeExp( m,Exp.LEAVE_GROUP);
		
		 my_session.put(Application.USER_KEY, m);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	
	return "success";
}

public String show_MyJoinedGroup(){
	
	//Member me= service_membre.findMemberByLogin(m.getLogin());

		 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
		 nbGroups = service_group.countJoinGroupById(((Member) my_session.get("my_member")).getIdMember());
		 System.out.println(nbGroups);
		
		return "success";
}

public String show_MyOwnGroup(){
	
	//Member me= service_membre.findMemberByLogin(m.getLogin());

		 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
		 nbGroups = service_group.countOwnGroupById(((Member) my_session.get("my_member")).getIdMember());
		 System.out.println(nbGroups);
		
		return "success";
}

public String listPaginateMyOwnGroups(){
	 
	 //System.out.println(me +"toto");
	resGroup=service_group.findOwnGroupById(((Member) my_session.get("my_member")).getIdMember(), min,max, null);
	System.out.println(resGroup +"toto");
	return "success";
}

public String listPaginateMyGroups(){
	 
	 //System.out.println(me +"toto");
	resGroup=service_group.findJoinGroupById(((Member) my_session.get("my_member")).getIdMember(), min,max, null);
	System.out.println(resGroup +"toto");
	return "success";
}


@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	my_session=arg0;
}
	
}
