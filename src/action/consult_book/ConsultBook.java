package action.consult_book;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.persistance.Book;
import model.persistance.Member;
import model.persistance.MessageBook;
import model.persistance.ResponseMessageBook;
import model.persistance.VoteBook;
import model.service.Book_service;
import model.service.Itf_book_service;
import model.service.Itf_member_service;
import model.service.Itf_messageBook_service;
import model.service.Itf_orderCustomer_service;
import model.service.Itf_responseMessageBook_service;
import model.service.Itf_vote_book_service;
import model.service.Member_service;
import model.service.MessageBook_service;
import model.service.OrderCustomer_service;
import model.service.VoteBook_service;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.Exp;
import core_lib.WebSiteMessage;


public class ConsultBook extends ActionSupport implements SessionAware{
	MessageBook mb;
	ResponseMessageBook rmb;
	private Map<String, Object> my_session;
	private Itf_book_service service_book;
	private Itf_orderCustomer_service service_orderCustomer;
	private Itf_vote_book_service service_vote_book;
	private Itf_messageBook_service service_mess_book;
	private Itf_responseMessageBook_service service_resp_mess_book;
	Book showBook;
	int bookId;
	List<MessageBook> resMessage;
	//id message for the response to add
	private int id_message_parent;
	int min,max,nbBooks;
	double rating;
	int idMember;
	List<Book> resBooks;
	private boolean vote_ok;
	private long nbVotes;
	private int rate_b;
	Itf_member_service service_member;
	private boolean book_favourite_ok;
	String author;
	private String mime;
	private InputStream  myFile;
	private String filename;
	//Itf_messageBook_service service_mess_member; 
	private int id_mess_book;
	
	
	

	
	
	

	
	
	public int getId_mess_book() {
		return id_mess_book;
	}

	public void setId_mess_book(int idMessBook) {
		id_mess_book = idMessBook;
	}

	public String getMime() {
		return mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

	public InputStream getMyFile() {
		return myFile;
	}

	public void setMyFile(InputStream myFile) {
		this.myFile = myFile;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isBook_favourite_ok() {
		return book_favourite_ok;
	}

	public void setBook_favourite_ok(boolean bookFavouriteOk) {
		book_favourite_ok = bookFavouriteOk;
	}

	public int getRate_b() {
		return rate_b;
	}

	public void setRate_b(int rateB) {
		rate_b = rateB;
	}

	public boolean isVote_ok() {
		return vote_ok;
	}

	public void setVote_ok(boolean voteOk) {
		vote_ok = voteOk;
	}

	public long getNbVotes() {
		return nbVotes;
	}

	public void setNbVotes(long nbVotes) {
		this.nbVotes = nbVotes;
	}

	public ResponseMessageBook getRmb() {
		return rmb;
	}

	public void setRmb(ResponseMessageBook rmb) {
		this.rmb = rmb;
	}

	public int getNbBooks() {
		return nbBooks;
	}

	public void setNbBooks(int nbBooks) {
		this.nbBooks = nbBooks;
	}

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	public List<Book> getResBooks() {
		return resBooks;
	}

	public void setResBooks(List<Book> resBooks) {
		this.resBooks = resBooks;
	}

	public MessageBook getMb() {
		return mb;
	}

	public void setMb(MessageBook mb) {
		this.mb = mb;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<MessageBook> getResMessage() {
		return resMessage;
	}

	public void setResMessage(List<MessageBook> resMessage) {
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

	public ConsultBook() {
		super();
		 service_book= new Book_service();
		 service_mess_book= new MessageBook_service();
		 service_vote_book=new VoteBook_service();
		 service_member= new Member_service();
		 service_orderCustomer = new OrderCustomer_service();
		// service_mess_member=new MessageMember_service();
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		my_session=arg0;
	}
	
    public String showBook(){
    	showBook = service_book.findBookByid(bookId);
    	if(showBook==null){
    		return "illegal_access";
    	}
    	
    	long read=showBook.getNbRead()+1;
    	showBook.setNbRead(read);
    	service_book.merge(showBook);
    	my_session.put(showBook.getIdBook().toString(),showBook);
    	resMessage=service_mess_book.loadMessageBook(bookId, 0, 5);
    	vote_ok=service_vote_book.hasVoteByRemoteAddr(ServletActionContext.getRequest().getRemoteAddr(),bookId);
    	System.out.println(resMessage.size()+"ok "+ vote_ok);
    	nbVotes= service_vote_book.countVotebyIdBook(bookId);
    	double rate_bb=0;
    	if(showBook.getTotalRating()!=null)
    		rate_bb= showBook.getTotalRating();
    	rate_b=(int) Math.round(rate_bb);
    	if (nbVotes > 0 && rate_bb==0.0 )
    		rate_b=1;
    	if (nbVotes == 0 && rate_bb==0.0 )
    		rate_b=4;
    	if(rate_bb<1.0)
    		rate_b=1;
    	if(rate_bb>9.0 ||rate_b>9.0 )
    		rate_b=9;
    	;
    	if(showBook.getAuthor()==null )
    	author= showBook.getMember().getLogin();
    	else{
    		if(showBook.getAuthor().trim().equals(""))
    			author= showBook.getMember().getLogin();
    		else
    			author= showBook.getAuthor();
    	}
    		
    	
    	Member me=(Member) my_session.get(Application.USER_KEY);
    	if (me!=null){
    		me=service_member.merge(me);
    		if (me.getFavouriteBooks().contains(showBook))
    			book_favourite_ok=true;
    		else
    			book_favourite_ok=false;
    		
    		//check if the book is actualy saled and the member buyed the book
        	if(showBook.getIsSell()==false || 
        			service_orderCustomer.isMemberBuyBook(me.getIdMember(), showBook.getIdBook()))
        	
        	return "success";
        	else
        	return "success_demo";
    	}
    	else{
    	book_favourite_ok=true;
    	
    	
    	
    	}
    	return "success";
    	
    }
    
    public String showMyBook(){
    	showBook = service_book.findBookByid(bookId);
    	Member me=(Member) my_session.get(Application.USER_KEY);
    	if(showBook!=null){
    		int id_owner=showBook.getMember().getIdMember();
    		if(id_owner!=me.getIdMember()){
    			return "illegal_access";
    		}
    		
    	}
    	else
    		return "illegal_access";
    	
    	//my_session.put(showBook.getIdBook().toString(),showBook);
    	System.out.println("show my book "+bookId + showBook);
    	resMessage=service_mess_book.loadMessageBook(bookId, 0, 5);
    	System.out.println(resMessage.size());
    	
       	if(showBook.getAuthor()==null ){
        	author= showBook.getMember().getLogin();
       	}
        	else{
        		if(showBook.getAuthor().trim().equals("")){
        			author= showBook.getMember().getLogin();
        			System.out.println("in");	
        		}
        		else
        			author= showBook.getAuthor();
        			
        	}
        		
    	
    	double rate_bb=0;
    	if(showBook.getTotalRating()!=null)
    		rate_bb= showBook.getTotalRating();
    	
    	rate_b=(int) Math.round(rate_bb)-1;
    	if (nbVotes > 0 && rate_bb==0.0 )
    		rate_b=1;
    	if (nbVotes == 0 && rate_bb==0.0 )
    		rate_b=4;
    	if(rate_bb<1.0)
    		rate_b=1;
    	if(rate_bb>9.0 ||rate_b>9.0 )
    		rate_b=9;
    	;
    	return "success";
    }
    
    
  //save message and show in the screen with ajax
	public String addMessage_book(){
		try{System.out.println("ajax");
		Member m=(Member) my_session.get(Application.USER_KEY);
		if(mb.getBody()!=null){
			mb.setBody(new String(mb.getBody().getBytes("iso-8859-1"),"UTF-8"));
		}
		//System.out.println(mb.getBody());
		mb.setMember(m);
		Book b = service_book.findBookByid(bookId);
		// mis book en session
		mb.setBook(b);
		//mb.setMemberByIdMember((Member) my_session.get("my_member"));
		mb.setPublishDate(new Date());
		service_mess_book.save(mb);
		
		WebSiteMessage aa= new WebSiteMessage();
		if(b!=null){
			 String send = "Bonjour, vous avez re&ccedil;u un message de "+m.getLogin()+" sur votre livre "+b.getTitle()+"<br/><br/>"
			      
			
			 + new String(mb.getBody().getBytes("UTF-8"),"iso-8859-1")  +"<br/><br/>"
			    
			    
			    +  " connectez vous sur <a href='lets-ebook.com'>lets-ebook.com</a> pour lire le message<br/><br/>"
			    +  " cordialement<br/><br/>"
			     + "  L'&eacute;quipe lets-ebook<br/><br/>";
	       	aa.send(b.getMember().getEmail(), send,"lets-ebook - nouveau message de "+m.getLogin()+ " sur votre livre "+b.getTitle());
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
		try{
		//rmm.setMessageMember((Member) my_session.get("my_member"));
		rmb.setMember((Member) my_session.get(Application.USER_KEY));
		rmb.setPublishDate(new Date());
		MessageBook messageBook=service_mess_book.findById(id_message_parent);
		//rmb.setMessageMember(messageMember);
		service_resp_mess_book.save(rmb);
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
			}
	}

	
	
	public String loadMessage_book(){
		try{System.out.println("ajax");
		System.out.println(min +" min"+max + " max ");
		resMessage=service_mess_book.loadMessageBook(bookId, min, max);
		return "success";}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public StreamResult rate_book_ajax(){
		System.out.println("ajax");
		HttpServletRequest request = ServletActionContext.getRequest();
		Book b = service_book.findBookByid(bookId);
		Member m = (Member) my_session.get(Application.USER_KEY);
		idMember = 0;
		if(m!=null){
			idMember=m.getIdMember();
		}
		VoteBook vb= new VoteBook(b, request.getRemoteAddr(), rating,idMember);
		if (b.getTotalRating() == null)
			b.setTotalRating(0.0);
		nbVotes= service_vote_book.countVotebyIdBook(bookId);
		System.out.println("rating "+" "+ nbVotes+" "+rating +" "+" "+ b.getTotalRating());
		b.setTotalRating((b.getTotalRating()*nbVotes+rating)/(nbVotes+1));
		
		Boolean res =service_vote_book.save(request.getRemoteAddr(),vb);
		System.out.println("total rating "+" "+ nbVotes+" "+rating +" "+" "+ b.getTotalRating());
		return new StreamResult(new ByteArrayInputStream(res.toString().getBytes()));
		}
	
	
public StreamResult addFavouriteBook(){
		
		Member me=(Member) my_session.get(Application.USER_KEY);
		showBook=service_book.findBookByid(bookId);
		me= service_member.merge(me);
		me.getBooks().add(showBook);
		service_member.merge(me);
		
		try{
		me=new Exp().changeExp( me,Exp.ADD_FAVORIS_BOOK);
		
		my_session.put(Application.USER_KEY, me);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
	System.out.println("addFavouriteBook");
		Boolean res=true;
	
	//Boolean res =true;
	return new StreamResult(new ByteArrayInputStream(res.toString().getBytes()));
}

	
	public String listPaginateAuthorBooks(){
		// me= (Member) session.get("my_member");
		// System.out.println(me +"toto");
		resBooks=service_book.getBooksByMemberId(idMember, min,max, null);
		System.out.println(resBooks.size());
		//System.out.println(resMember +"toto");
		return "success";
	}

	public String show_AuthorBooks_full(){
		
		//Member me= service_membre.findMemberByLogin(m.getLogin());

			 //me= (Member) my_session.get("my_member");
			 
			 
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			nbBooks = service_book.countFindBooksByMemberId(idMember);
			 
			
			return "success";
	}
	
	
	/*
	 * delete a message in book only if the book  or the message belongs to the deleter
	 */
public String delete_message_Book(){
	Member me=(Member) my_session.get(Application.USER_KEY);
	if(me !=null){
		System.out.println("in suppr message");
		//MessageMember mm =service_mess_member.findById(id_mess_book);
		MessageBook mb=service_mess_book.findById(id_mess_book);
		if( mb!=null){
			int id_member_mess=mb.getMember().getIdMember();
			int id_owner_book=mb.getBook().getMember().getIdMember();
			if(id_member_mess==me.getIdMember()||id_owner_book==me.getIdMember()){
				System.out.println("in suppr message del");
				mb.setDeleted(true);
				service_mess_book.merge(mb);
			}
		}
	}

	//Member me= service_membre.findMemberByLogin(m.getLogin());

			 //me= (Member) my_session.get("my_member");
			 
			 
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			//nbBooks = service_book.countFindFollowBooksByMemberId(((Member) session.get("my_member")).getIdMember());
			 
			
			return "success";
	}
	
	
public String downloadBookDemo(){
	showBook = service_book.findBookByid(bookId);
	
	if(showBook==null ){
		return "illegal_access";
	}
	else{
		if(showBook.getIsSell()==false){
			return "illegal_access";
		}
		
	}
	
	//String directory=showBook.getMember().getLogin()+"/"+showBook.getIdBook();
	String linkbook = Application.FOLDER_BOOK+"/"+showBook.getLinkBookDemo();
	HttpServletResponse res = (HttpServletResponse) ServletActionContext.getResponse();
    res.setHeader("CACHE-CONTROL", "PRIVATE");

	 File f = new File(linkbook);  
	       try {
			 myFile = new FileInputStream(f);
			MimetypesFileTypeMap type = new MimetypesFileTypeMap();
			mime=type.getContentType(f);
			 FileNameMap fileNameMap = URLConnection.getFileNameMap();
			filename=f.getName();
			System.out.println(mime + filename);
			int nbDownload=showBook.getNbDownload();
			showBook.setNbDownload(nbDownload+1);
			return "success";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}  
		
}


	public String downloadBook(){
		showBook = service_book.findBookByid(bookId);
		
		Member m = (Member) my_session.get(Application.USER_KEY);
		//check if the book is sell, if yes, only buyer can buy
		
		if(showBook==null){
			return "illegal_access";
		}
		else{
			int idM=showBook.getMember().getIdMember();
			
				
			//look if we sell the book
			if(m!=null && showBook.getIsSell()==true){
				//look if its not our book
				if(idM != m.getIdMember()){
					//the member have the right to download
					if(!service_orderCustomer.isMemberBuyBook(m.getIdMember(), bookId)){
						return "error";
					}
				
				}
				
			}
		}
		
		
		
		
		//String directory=showBook.getMember().getLogin()+"/"+showBook.getIdBook();
		String linkbook = Application.FOLDER_BOOK+"/"+showBook.getLinkBook();
		HttpServletResponse res = (HttpServletResponse) ServletActionContext.getResponse();
        res.setHeader("CACHE-CONTROL", "PRIVATE");

		 File f = new File(linkbook);  
		       try {
				 myFile = new FileInputStream(f);
				MimetypesFileTypeMap type = new MimetypesFileTypeMap();
				mime=type.getContentType(f);
				 FileNameMap fileNameMap = URLConnection.getFileNameMap();
				 String mimeType = fileNameMap.getContentTypeFor("alert.gif");
				 System.out.println("mimeType="+ mimeType);
				filename=f.getName();
				System.out.println(mime + filename);
				int nbDownload=showBook.getNbDownload();
				showBook.setNbDownload(nbDownload+1);
				return "success";
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}  
			
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
