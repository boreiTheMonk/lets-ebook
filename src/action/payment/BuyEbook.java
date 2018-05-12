package action.payment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.WebSiteMessage;
import model.persistance.Book;
import model.persistance.Member;
import model.persistance.OrderBook;
import model.persistance.OrderCustomer;
import model.service.Book_service;
import model.service.Itf_book_service;
import model.service.Itf_member_service;
import model.service.Itf_orderCustomer_service;
import model.service.Itf_order_book_service;
import model.service.Member_service;
import model.service.OrderBook_service;
import model.service.OrderCustomer_service;

public class BuyEbook extends ActionSupport implements SessionAware{
	private Itf_book_service service_book;
	private Itf_member_service service_member;
	private Itf_orderCustomer_service service_order_customer;
	private Itf_order_book_service service_order_book;
	private Map<String, Object> my_session;
	private int bookId;
	private String email;
	private String refOrder;
	Book showBook;
	private int price;
	int idMember;
	int test;
	List<OrderBook> myBuyedBook;
	int idOrderBook;
	OrderCustomer myorderCustomer;
	private String mime;
	private InputStream  myFile;
	private String filename;
	//Itf_messageBook_service service_mess_member; 
	private int id_mess_book;
	private String urlPath;
	
	
	
	
	
	
	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public OrderCustomer getMyorderCustomer() {
		return myorderCustomer;
	}

	public void setMyorderCustomer(OrderCustomer myorderCustomer) {
		this.myorderCustomer = myorderCustomer;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getId_mess_book() {
		return id_mess_book;
	}

	public void setId_mess_book(int id_mess_book) {
		this.id_mess_book = id_mess_book;
	}

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	public int getIdOrderBook() {
		return idOrderBook;
	}

	public void setIdOrderBook(int idOrderBook) {
		this.idOrderBook = idOrderBook;
	}

	public List<OrderBook> getMyBuyedBook() {
		return myBuyedBook;
	}

	public void setMyBuyedBook(List<OrderBook> myBuyedBook) {
		this.myBuyedBook = myBuyedBook;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRefOrder() {
		return refOrder;
	}

	public void setRefOrder(String refOrder) {
		this.refOrder = refOrder;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Book getShowBook() {
		return showBook;
	}

	public void setShowBook(Book showBook) {
		this.showBook = showBook;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public BuyEbook() {
		 service_book= new Book_service();
		 service_member= new Member_service();
		 service_order_customer=new OrderCustomer_service();
		 service_order_book=new OrderBook_service();
	}

	public String showPayment(){
		HttpServletRequest request= ServletActionContext.getRequest();
		String path = request.getContextPath();
		  String getProtocol=request.getScheme();
		  String getDomain=request.getServerName();
		  String getPort=Integer.toString(request.getServerPort());
		  
		  urlPath = getProtocol+"://"+getDomain+path+"/";
		 System.out.println(urlPath);
		showBook=service_book.findBookByid(bookId);
		Member me=(Member) my_session.get(Application.USER_KEY);
		refOrder="";
    	//service_book.merge(showBook);

    	
		/*
		 * create income
		 * add book properties into bookOrder
		 * create customerOrder with bookOrder
		 * save bookOrder in db
		 * save customerOrder in db
		 */

    	//service_book.merge(showBook);
		//check si le livre peux etre vendu
    	if(showBook!=null){
    		if(showBook.getIsValid()==true){
    			//check if order already exists
    			OrderBook ob =service_order_book.getOrderBookCreatedNoPaid(me, showBook);
    			refOrder=bookId+"ref"+me.getIdMember();
        		price = new Double(showBook.getPrice()*100).intValue();
        		email = me.getEmail();
    			if(ob==null){
    				
    		OrderCustomer oc= new OrderCustomer(me, new Date(), OrderCustomer.CB, new Integer(price).doubleValue()/100, refOrder, false, null, "", OrderCustomer.TVA);
    		ob = new OrderBook(showBook, oc, showBook.getPrice(), false, showBook.getLinkBook(), showBook.getTitle(), "");
    		ob.setLinkImageOrder(showBook.getLinkImage());
    		service_order_customer.save(oc);
    		service_order_book.save(ob);
    			}
    			else{
    				ob.getOrderCustomer().setPrice(new Integer(price).doubleValue()/100);
    				//ob.getOrderCustomer().setRefOrder(bookId+"ref"+me.getIdMember()+System.currentTimeMillis());
    				ob.getOrderCustomer().setDateOrder(new Date());
    				refOrder=ob.getOrderCustomer().getRefOrder();
    				ob.setPrice(showBook.getPrice());
    				ob.setName(showBook.getTitle());
    				ob.setLinkFileOrder(showBook.getLinkBook());
    				ob.setLinkImageOrder(showBook.getLinkImage());
    			}
    				
    			//refOrder=bookId+"ref"+me.getIdMember()+System.currentTimeMillis();
    		System.out.println(ServletActionContext.getRequest().getRemoteHost());
    		System.out.println(ServletActionContext.getRequest().getServerName());
    		return "success";
    		}
    		else
    			//prevent hack
    		return "error_access";
    	}
    	
    	
		//workflow
		
		/*
		 * check si non conecté, va se connecter et regarde s'il y a pas d'erreur au montant
		 * 
		 * 1 on regarde si on est connecté :ok
		 * 	fenetre de login: ok
		 *  on se rensigne pour recuperer l'etat de la fenetre (l'url + request.parameter):ok
		 * 
		 * 		fenetre inscription
		 * 		paiement :ok
		 *  	
		 *  
		 *  fenetre de paiement
		 *  process
		 *  fin retour a la page de telechargement
		 *  
		 *  dans le login rajouter un champ livre => pour y retrouver la reference
		 *  
		 *  pour le paiement on a besoin : 
		 *  de l'id uilisateur
		 *  le no de commande sera une concat de l'id login de ref puis de l id livre
		 *  
		 * */
		
		//listCat= categoryserv.getAllCategories();
		return "success";
	}
	
	public String processPayment(){
		//insert into orderCustommer and OrderBook
		//create facture en pdf
		OrderCustomer oc = service_order_customer.findOrderCustomerByrefOrder(refOrder);
		
		Member me=(Member) my_session.get(Application.USER_KEY);
		//showBook=service_book.findBookByid(bookId);
		//autoconnect
		if(me==null && oc!=null){
			my_session.put(Application.USER_KEY, oc.getMember());
			
			my_session.put(Application.SESSION_DECO,Application.SESSION_DECO_VALUE_MEMBER);
			me=oc.getMember();
		}
			
    	if (me!=null && oc!=null){
    		// on compare d'id de me avec le notre 
    		int idM=oc.getMember().getIdMember();
    		if(me.getIdMember()==idM){
    			
    			if(oc.getIsTreated()==false){
	    			oc.setIsTreated(true);
	    			/*Set<OrderBook> ob= oc.getOrderBooks();
	    			for(OrderBook o:ob){
	    				o.setLinkFileOrder(o.getBook().getLinkBook());
	    				o.setLinkImageOrder(o.getBook().getLinkImage());
	    			
	    			}*/
	    			bookId=((OrderBook)oc.getOrderBooks().iterator().next()).getBook().getIdBook();
	    			
	    			WebSiteMessage aa= new WebSiteMessage();
	    			
	    				 String send = "Bonjour, merci pour votre achat et pour votre confiance. <br/> voici le lien pour la consultation de votre facture, pour la commande  no "+oc.getRefOrder()+" <br/><br/>"
	    				      
	    				 +  "http://lets-ebook.com/ebooksite/showInvoice?refOrder="+oc.getRefOrder()+"<br/><br/>" 
	    				 //+ mm.getBody() +"<br/><br/>"
	    				    
	    				    
	    				  +  " nous restons à votre disposition pour d'éventuelles questions<br/><br/>"
	    				    +  " cordialement<br/><br/>"
	    				     + "  L'&eacute;quipe lets-ebook<br/><br/>";
	    		       	aa.send(me.getEmail(), send,"lets-ebook - facturation commande no "+oc.getRefOrder());
	    		    	aa.send("borei.eng@gmail.com", send,"lets-ebook - facturation commande no "+oc.getRefOrder());
    			}
    		    	
    		    	
    			
    			return "success";
    		}
    	}
		
		return "error_pay";
	}
	
	public String showListBuyEbook(){
		Member me=(Member) my_session.get(Application.USER_KEY);
		
		if(me!=null)
			myBuyedBook= service_order_book.showBookOrderedByBuyer(me);

		return "success";

	}
	
	public String cancelOrder(){
		
		OrderCustomer oc = service_order_customer.findOrderCustomerByrefOrder(refOrder);
		
		if (oc!=null){
    			bookId=((OrderBook)oc.getOrderBooks().iterator().next()).getBook().getIdBook();
    			return "success";
		}
		return "error_pay";
    			
    			
    		
		}
	
	//test paiement refuse fausse carte
	//test paiement annulé
	//test paiement erreur
	
public String refusedOrder(){
		
		OrderCustomer oc = service_order_customer.findOrderCustomerByrefOrder(refOrder);
		
		if (oc!=null){
    			bookId=((OrderBook)oc.getOrderBooks().iterator().next()).getBook().getIdBook();
    			return "success";
		}
		return "error_pay";
    			
    			
    		
		}
	

public String showInvoice(){
	
	//OrderBook ob=service_order_book.getOrderBookById(idOrderBook);
	
	myorderCustomer=service_order_customer.findOrderCustomerByrefOrder(refOrder);
	
		if (myorderCustomer!=null){
		//	myorderCustomer=ob.getOrderCustomer();
				return "success";
		}
		return "error";

	}

public String downloadBuyBook(){
	OrderBook ob=service_order_book.getOrderBookById(idOrderBook);
	//String directory=showBook.getMember().getLogin()+"/"+showBook.getIdBook();
	String linkbook = Application.FOLDER_BOOK+"/"+ob.getLinkFileOrder();
	HttpServletResponse res = (HttpServletResponse) ServletActionContext.getResponse();
    res.setHeader("CACHE-CONTROL", "PRIVATE");

	 File f = new File(linkbook);  
	       try {
			 myFile = new FileInputStream(f);
			MimetypesFileTypeMap type = new MimetypesFileTypeMap();
			mime=type.getContentType(f);
			 FileNameMap fileNameMap = URLConnection.getFileNameMap();

			filename=f.getName();
		
			return "success";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}  
		
}
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		my_session=arg0;
	}
}
