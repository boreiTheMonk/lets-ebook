package action.myebook;


import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.management.RuntimeErrorException;

import model.persistance.Book;
import model.persistance.Category;
import model.persistance.Member;
import model.persistance.Proof_doc;
import model.persistance.ThemeGroup;
import model.service.Book_service;
import model.service.Category_service;
import model.service.Group_service;
import model.service.Itf_book_service;
import model.service.Itf_category_service;
import model.service.Itf_group_service;
import model.service.Itf_member_service;
import model.service.Itf_messageMember_service;
import model.service.Itf_proof_doc_service;
import model.service.Member_service;
import model.service.MessageMember_service;
import model.service.Proof_doc_service;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.Exp;
import core_lib.Image_op;
import core_lib.WebSiteMessage;

public class MyEbook extends ActionSupport implements SessionAware{
	Book b;
		//Member me;
		
	private File bookFile;//The actual file

	private String bookFileContentType; //The content type of the file

	private String bookFileFileName; //The uploaded file name

	private File image;//The image for the book
	private String imageFileName;
	private String srcImage;
	private String nameAction;
	
	
	
	public String getNameAction() {
		return nameAction;
	}
	public void setNameAction(String nameAction) {
		this.nameAction = nameAction;
	}




	private List<Proof_doc> uploadedDoc;//The actual file
	
	/* list doc proof */
	private List<File> doc;//The actual file


	private List<String> docFileName; //The uploaded file name

	
	/** list doc proof **/
	
	int x1,y1,x2,y2,w,h;
	private Itf_book_service service_book;
	Map<String, Object> session;
	private int bookId,min,max,nbBooks;
	private Book editBook;
	Itf_category_service categoryserv;
	List<Category>listCat;
	private int id_category;
	List<Book> resBooks;
	Itf_member_service service_member;
	Itf_messageMember_service service_mess_member; 
	Itf_proof_doc_service service_proof_doc;
	private int enfant;
	private Itf_group_service service_group;

	private int parent;
	private ThemeGroup showGroup;

	private int groupId;

	

	public ThemeGroup getShowGroup() {
		return showGroup;
	}
	public void setShowGroup(ThemeGroup showGroup) {
		this.showGroup = showGroup;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getEnfant() {
		return enfant;
	}
	public void setEnfant(int enfant) {
		this.enfant = enfant;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
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
	public List<Book> getResBooks() {
		return resBooks;
	}
	public void setResBooks(List<Book> resBooks) {
		this.resBooks = resBooks;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public String getSrcImage() {
		return srcImage;
	}
	public void setSrcImage(String srcImage) {
		this.srcImage = srcImage;
	}
	

	public int getId_category() {
		return id_category;
	}
	public void setId_category(int id_category) {
		this.id_category = id_category;
	}
	public List<Category> getListCat() {
		return listCat;
	}
	public void setListCat(List<Category> listCat) {
		this.listCat = listCat;
	}




	public List<Proof_doc> getUploadedDoc() {
		return uploadedDoc;
	}
	public void setUploadedDoc(List<Proof_doc> uploadedDoc) {
		this.uploadedDoc = uploadedDoc;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}

	

	public List<File> getDoc() {
		return doc;
	}
	public void setDoc(List<File> doc) {
		this.doc = doc;
	}
	public List<String> getDocFileName() {
		return docFileName;
	}
	public void setDocFileName(List<String> docFileName) {
		this.docFileName = docFileName;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}




	public String getBookFileContentType() {
		return bookFileContentType;
	}
	public void setBookFileContentType(String bookFileContentType) {
		this.bookFileContentType = bookFileContentType;
	}
	public Book getEditBook() {
		return editBook;
	}
	public void setEditBook(Book editBook) {
		this.editBook = editBook;
	}
	public MyEbook() {
		super();
		// TODO Auto-generated constructor stub
		service_book=new Book_service();
		categoryserv= new Category_service();
		service_member= new Member_service();
		 service_group= new Group_service();
		 service_mess_member=new MessageMember_service();
		 service_proof_doc=new Proof_doc_service();
	}
	public File getBookFile() {
		return bookFile;
	}
	public void setBookFile(File bookFile) {
		this.bookFile = bookFile;
	}




	public String getBookFileFileName() {
		return bookFileFileName;
	}
	public void setBookFileFileName(String bookFileFileName) {
		this.bookFileFileName = bookFileFileName;
	}
	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	public String showAddEbook(){
		//listCat= categoryserv.getAllCategories();
		return "success";

	}
	
	/**
	 * show selling form from book : error if you are not the book owner
	 * 
	 * 
	 * */
	public String show_info_sell_form(){
		Member me=(Member) session.get(Application.USER_KEY);
		editBook= service_book.findBookByid(bookId);
		b=editBook;
		uploadedDoc=service_proof_doc.findByIdBook(editBook.getIdBook());
		System.out.println(uploadedDoc.size()+"size");
		if(editBook!=null){
    		int id_owner=editBook.getMember().getIdMember();
    		if(id_owner==me.getIdMember()){
    			return "success";
    		}
    		
    		
    	}
		return "illegal_access";
		
	}
	
	/**
	 * save parametter sales
	 * 
	 * 
	 * */
	
	public String valid_info_sell(){
		double oldPrice = 0;
		String oldExplain = null ;
		String  oldDemoPage = null;
		String  oldLink= null;
		//if variables above is used this bool will be turned true 
		boolean used = false;
		uploadedDoc=new ArrayList<Proof_doc>();
		try{
		Member me=(Member) session.get(Application.USER_KEY);
		b= service_book.findBookByid(bookId);
		if(b!=null){
    		int id_owner=b.getMember().getIdMember();
    		if(id_owner!=me.getIdMember()){
    			return "illegal_access";
    		}
    
    	}
		//build the demo page list
		String pattern="^(([1-9][0-9]*)|([1-9][0-9]*-[1-9][0-9]*))(,([1-9][0-9]*)|,([1-9][0-9]*-[1-9][0-9]*))*";
		String linkDemoBook="";
		if(editBook.getDemoPage().matches(pattern)){
			String[] pages=editBook.getDemoPage().split(",");
			Set<Integer> tab=new TreeSet<Integer>();
			for(String numb:pages){
				if(!numb.contains("-")){
					tab.add(new Integer(numb));
				}
				else{
					// treat list of number
					String range[]=numb.split("-");
					if (range.length>=2){
						//
						int start=new Integer(range[0]);
						int end=new Integer(range[range.length-1]);
						
						if(end>start){
							for(int i = start;i<=end;i++){
								tab.add(i);
							}
						}
					}
				}
			}//end loop each pages in pattern
			//generate and save demobook
			linkDemoBook=core_lib.Image_op.GenerateDemoBook(tab, b);
		}//end check pattern
		
		
		
		
		//save files doc
		String directory=b.getMember().getLogin()+"/"+b.getIdBook();
		try {
			Proof_doc proof=null;
			if(doc!=null){
				
				for(int i=0;i<doc.size();i++){
					
						String path =Image_op.save_file(Application.FOLDER_BOOK+directory, docFileName.get(i),doc.get(i));
						proof = new Proof_doc();
						proof.setName(docFileName.get(i));
						proof.setMyBook(b);
						
						proof.setPublishingDate(new Date());
						proof.setUrl_doc(path);
						service_proof_doc.save(proof);
						uploadedDoc.add(proof);
				}
			}
			
		} catch (IOException e) {
			// go to the global rollback exception
			e.printStackTrace();
			throw new Exception(e);
		}
		
		
		if( editBook.getDemoPage().matches(pattern)){
		oldPrice=b.getPrice();
		oldExplain = b.getProofExplain();
		oldDemoPage= b.getDemoPage();
		oldLink=b.getLinkBookDemo();
		used =true;
		
		b.setPrice(editBook.getPrice());
		b.setProofExplain(editBook.getProofExplain());
		b.setDemoPage(editBook.getDemoPage());
		b.setLinkBookDemo(linkDemoBook);
		b.setIsSell(true);
		
		//send a mail to us if its the first sales from the book
		if(b.getIsValid()==false){
			send_validation_to_admin(b);
			    return "confirm_admin";
		}
		
		}
		return "success";
		
		}
		catch (Exception e) {
			//true if variable have correct value
			if(used){
				b.setPrice(oldPrice);
				b.setProofExplain(oldExplain);
				b.setDemoPage(oldDemoPage);
				b.setLinkBookDemo(oldLink);
			}
			for(Proof_doc p :uploadedDoc){
				service_proof_doc.delete(p);
				
			}
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		    e.printStackTrace(pw);
		    
		    
		    WebSiteMessage w = new WebSiteMessage();
		    w.send("contact@multidb.fr", sw.toString(), e.getMessage());
		    addActionError("erreur de traitement, l'administrateur sera notifié, n'hésitez pas à le signaler si le problème persiste.");
		    return "error";
		    
		}
	}
	
	private void send_validation_to_admin(Book b){
		  WebSiteMessage w = new WebSiteMessage();
		    w.send("contact@multidb.fr", "envoi de requete pour le livre de "+b.getMember().getLogin(), "Donnez votre avis: le livre en question (id "+b.getIdBook()+"): http://lets-ebook.com/"+constant.Application.FOLDER_BOOK_URL+"/"+b.getLinkBook());
		    w.send("borei.eng@gmail.com",  "Donnez votre avis:"+b.getTitle()+"<br/>  le livre en question (id "+b.getIdBook()+"): http://lets-ebook.com/"+constant.Application.FOLDER_BOOK_URL+"/"+b.getLinkBook(),"envoi de requete pour le livre de "+b.getMember().getLogin());
		    w.send("cream.db@gmail.com", "envoi de requete pour le livre de "+b.getMember().getLogin(), "Donnez votre avis: le livre en question (id "+b.getIdBook()+"): http://lets-ebook.com/"+constant.Application.FOLDER_BOOK_URL+"/"+b.getLinkBook());
		    w.send("damien.rimbault@hotmail.fr", "envoi de requete pour le livre de "+b.getMember().getLogin(), "Donnez votre avis: "+b.getTitle()+"<br/> le livre en question (id "+b.getIdBook()+"): http://lets-ebook.com/"+constant.Application.FOLDER_BOOK_URL+"/"+b.getLinkBook());
		
	}
	

	//action if member chose to sell
	//show the sell windows after crop the image or after if no image
	//if sell true, use first page for demo

	public String addEbook(){
		
		if(!bookFileContentType.contains("pdf")){
			addActionError("le format du document doit être en pdf");
			System.out.println(bookFileContentType);
			return INPUT;
		}

		System.out.println( session.get("my_member")+ " ok" + b.getTitle());
		Member m=(Member) session.get(Application.USER_KEY);
		b.setMember(m);
		b.setLinkBook(bookFileFileName);
		b.setLinkImage(imageFileName);
		Category c = categoryserv.findById(id_category);
		b.setCategory(c);
		b.setNbDownload(0);
		b.setPublishingDate(new Date());
		if(b.getAuthor()==null){
			b.setAuthor("");
		}
		//if(b.getIsMine()==null){
		//	b.setIsMine(false);
		//}
		//service_book.save(b);
		service_book.persist(b);
		bookId = b.getIdBook();
		System.out.println("id de Book "+b.getIdBook());
		try {
			
				if(!Image_op.isPdf(bookFile)){
					addActionError("le document soit etre un pdf");
					return "input";
				}
				String directory=b.getMember().getLogin()+"/"+b.getIdBook();
			
				System.out.println("dir "+Application.FOLDER_BOOK+directory+" "+bookFileFileName);
				Image_op.save_file(Application.FOLDER_BOOK+directory, bookFileFileName,bookFile);
				b.setLinkBook(directory+"/"+bookFileFileName);
				
				//add 5 pages to demo by default
				if(b.getIsSell()==true){
				Set nb= new TreeSet<Integer>();
				nb.add(1);
				nb.add(2);
				nb.add(3);
				nb.add(4);
				nb.add(5);
				b.setDemoPage("1-5");
				String linkDemoBook=Image_op.GenerateDemoBook(nb, b);
				b.setLinkBookDemo(linkDemoBook);
				}
				
				if(image !=null){
				BufferedImage imagebuffer=null;
				try {
					imagebuffer = ImageIO.read(image);
					if (imagebuffer==null){
						addActionError("format de l'image incorrecte");
						service_book.delete(b);
						return "input";
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					addActionError("format de l'image incorrecte");
					e.printStackTrace();
					service_book.delete(b);
					return "input";
					
				}
				String image_big= "big"+System.currentTimeMillis()+imageFileName;
    			String image_small= "small"+System.currentTimeMillis()+imageFileName;
				
				//ajust image with to fit the result screen width (=550 pixels)
				if(imagebuffer.getWidth()> 600) {
				BufferedImage  resized= Image_op.resize(imagebuffer,
						new Dimension(600, imagebuffer.getHeight()*550/imagebuffer.getWidth()), Application.FOLDER_BOOK_IMAGE+directory,
						Image_op.IMAGE_TYPE_PNG);
			
				Image_op.save_image(Application.FOLDER_BOOK_IMAGE+directory,image_big,Image_op.IMAGE_TYPE_PNG ,resized);
				Image_op.save_image(Application.FOLDER_BOOK_IMAGE+directory,image_small,Image_op.IMAGE_TYPE_PNG ,resized);
				}
				else{
				Image_op.save_file(Application.FOLDER_BOOK_IMAGE+directory, image_big,image);
				Image_op.save_file(Application.FOLDER_BOOK_IMAGE+directory, image_small,image);
				}
				b.setLinkImage(directory+"/"+image_small);
				b.setLinkImageBig(directory+"/"+image_big);
			}
			else{
				
				 add_default_image(b);
				 
					
					try{
					m=new Exp().changeExp( m,Exp.ADD_BOOK);
					
					 session.put(Application.USER_KEY, m);
					}
					catch(NullPointerException e){
						e.printStackTrace();
						
					}
				if(b.getIsSell()==true)	{
					return "sell_ok";
				}
				else{	
				 return "no_img";
				}
			}
				
				
				//service_book.merge(b);
				
				
				try{
				m=new Exp().changeExp( m,Exp.ADD_BOOK);
				
				 session.put(Application.USER_KEY, m);
				}
				catch(NullPointerException e){
					e.printStackTrace();
				}
			
			//String path = ServletActionContext.getServletContext().getRealPath("/");
			//System.out.println(path);
		
				
	/*			File directory_book  = new File(Application.FOLDER_BOOK+((Member)session.get("my_member")).getLogin()+"/"+b.getIdBook());
			if(! directory_book .isDirectory()) {
				directory_book .mkdirs();
			} 
			File directory_img  = new File(Application.FOLDER_BOOK_IMAGE+((Member)session.get("my_member")).getLogin()+"/"+b.getIdBook());
			if(! directory_img .isDirectory()) {
				directory_img .mkdirs();
			} 
			String fullFileName = bookFileFileName;
			File theFile = new File(directory_book,fullFileName);
			FileUtils.copyFile(bookFile, theFile);


			String fullImageName =imageFileName;
			File theImage = new File(directory_img,fullImageName);

			FileUtils.copyFile(image, theImage);*/
			
			
			srcImage="/"+Application.FOLDER_BOOK_IMAGE_URL+"/"+ b.getLinkImage();
			session.put("my_img_path",Application.FOLDER_BOOK_IMAGE+((Member)session.get("my_member")).getLogin()+"/"+b.getIdBook()+"/"+imageFileName);
		} catch (Exception e) {

			addActionError(e.getMessage());
			e.printStackTrace();
			return INPUT;

		}
		
		
		nameAction=ActionContext.getContext().getName();
		System.out.println(nameAction);
		return "success";

	}

	
boolean add_default_image(Book b){
		
	String directory=b.getMember().getLogin()+"/"+b.getIdBook();
		BufferedImage imagebuffersmall=null;
		BufferedImage imagebufferbig=null;
		try {
			File small=new File(constant.Application.DEFAULT_IMGBOOK_SMALL_PATH);
			File big=new File(constant.Application.DEFAULT_IMGBOOK_BIG_PATH);
		imagebuffersmall = ImageIO.read(small);
		imagebufferbig = ImageIO.read(big);
		
		Image_op.save_image(Application.FOLDER_BOOK_IMAGE+directory,small.getName(),Image_op.IMAGE_TYPE_PNG ,imagebuffersmall);
		
		Image_op.save_image(Application.FOLDER_BOOK_IMAGE+directory,big.getName(),Image_op.IMAGE_TYPE_PNG ,imagebufferbig);
		
		b.setLinkImage(directory+"/"+small.getName());
		b.setLinkImageBig(directory+"/"+big.getName());
		service_book.merge(b);
		
		
		
		return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			addActionError("format de l'image doit etre en png, jpg, ou gif");
			e.printStackTrace();
			return false;
			
		}
	}
	
	
	
	
	
	public String showEditBook(){
		//int id_owner=((Member)session.get("my_member")).getIdMember();
		Member me=(Member) session.get(Application.USER_KEY);
		b= service_book.findBookByid(bookId);
		if(b!=null){
    		int id_owner=b.getMember().getIdMember();
    		if(id_owner!=me.getIdMember()){
    			return "illegal_access";
    		}
    		System.out.println(b.getDescription());
    		session.put("my_book_update",b);
    		enfant=b.getCategory().getIdCategory();
    		if(b.getCategory().getCategory()!=null){
    		parent=b.getCategory().getCategory().getIdCategory();
    		System.out.println("parent");
    		}
    		return "success";
    	}
		//System.out.println(bookId);
	
		//b= service_book.findBookByid(bookId);

		return "illegal_access";
	}
	
	public String showEditUploadBook(){
		//System.out.println(((Member)session.get("my_member")).getIdMember());
		System.out.println(bookId);
		Member me=(Member) session.get(Application.USER_KEY);
		b= service_book.findBookByid(bookId);
		
	
		if(b!=null){
    		int id_owner=b.getMember().getIdMember();
    		if(id_owner!=me.getIdMember()){
    			return "illegal_access";
    		}
    		
    	}
		//System.out.println(b.getDescription());
		//session.put("my_book_update",b);
		return "success";

	}
	
	

	public String validModifBook(){
		System.out.println(((Member)session.get("my_member")).getIdMember());
		System.out.println(bookId);
		System.out.println("bousin0"+b.getTitle());
		//b= service_book.findBookByid(((Member)session.get("my_member")).getIdMember(),bookId);
		
		//Book my_book_update = (Book) session.get("my_book_update");
		Book my_book_update = service_book.findBookByid(bookId);
		Category c = categoryserv.findById(id_category);
		my_book_update.setCategory(c);
		System.out.println("update"+b.getDescription());
		my_book_update.setDescription(b.getDescription());
		System.out.println("update2"+my_book_update.getDescription());
		//my_book_update.setLinkBook(linkBook)
		my_book_update.setNbPages(b.getNbPages());
		my_book_update.setTitle(b.getTitle());
		my_book_update.setAuthor(b.getAuthor());
		//System.out.println(b.getIsMine());
		if(b.getIsMine()!=false){
			my_book_update.setAuthor("");
		}
			
		my_book_update.setIsMine(b.getIsMine());
		
		service_book.merge(my_book_update);

		return "success";

	}

	public String validUploadModifBook(){
		System.out.println(((Member)session.get("my_member")).getIdMember());
		System.out.println(bookId);

		//b= service_book.findBookByid(((Member)session.get("my_member")).getIdMember(),bookId);

		//Book my_book_update = (Book) session.get("my_book_update");
		Book b = service_book.findBookByid(bookId);

		
		try {
			
			
			String directory=b.getMember().getLogin()+"/"+b.getIdBook();
		
			
			
			if(imageFileName!=null){
			BufferedImage imagebuffer=null;
			try {
				System.out.println("before read img "+imageFileName);
				imagebuffer = ImageIO.read(image);
				System.out.println("after read img "+imagebuffer);
				
				if (imagebuffer==null){
					addActionError("format de l'image incorrecte");
					return "input";
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				addActionError("format de l'image incorrecte");
				e.printStackTrace();
				return "input";
				
			}
			catch (IllegalArgumentException e){
				// TODO Auto-generated catch block
				addActionError("format de l'image incorrecte");
				e.printStackTrace();
				return "input";
			}
			
			if(imagebuffer!=null){
			
				
				String image_big= "big"+System.currentTimeMillis()+imageFileName;
    			String image_small= "small"+System.currentTimeMillis()+imageFileName;
				
				//ajust image with to fit the result screen width (=550 pixels)
				if(imagebuffer.getWidth()> 600) {
				BufferedImage  resized= Image_op.resize(imagebuffer,
						new Dimension(600, imagebuffer.getHeight()*550/imagebuffer.getWidth()), Application.FOLDER_BOOK_IMAGE+directory,
						Image_op.IMAGE_TYPE_PNG);
			
				Image_op.save_image(Application.FOLDER_BOOK_IMAGE+directory,image_big,Image_op.IMAGE_TYPE_PNG ,resized);
				Image_op.save_image(Application.FOLDER_BOOK_IMAGE+directory,image_small,Image_op.IMAGE_TYPE_PNG ,resized);
				}
				else{
				Image_op.save_file(Application.FOLDER_BOOK_IMAGE+directory, image_big,image);
				Image_op.save_file(Application.FOLDER_BOOK_IMAGE+directory, image_small,image);
				}
				b.setLinkImage(directory+"/"+image_small);
				b.setLinkImageBig(directory+"/"+image_big);
				
				
				
/*				//ajust image with to fit the result screen width (=550 pixels)
				if(imagebuffer.getWidth()> 600) {
				BufferedImage  resized= Image_op.resize(imagebuffer,
						new Dimension(600, imagebuffer.getHeight()*550/imagebuffer.getWidth()), Application.FOLDER_BOOK_IMAGE+directory,
						Image_op.IMAGE_TYPE_PNG);
			
				Image_op.save_image(Application.FOLDER_BOOK_IMAGE+directory,imageFileName,Image_op.IMAGE_TYPE_PNG ,resized);
				}
				else
				Image_op.save_file(Application.FOLDER_BOOK_IMAGE+directory, imageFileName,image);*/
				
				
				
				
				
				
			}
		
			//b.setLinkImage(directory+"/"+imageFileName);
			}//end if filename (upload img exists)
		
			
			if(bookFileFileName!=null){
				if(!Image_op.isPdf(bookFile)){
					addActionError("le document soit etre un pdf");
					return "input";
				}
				
			Image_op.save_file(Application.FOLDER_BOOK+directory, bookFileFileName,bookFile);
			b.setLinkBook(directory+"/"+bookFileFileName);
			
			//regenerate demo
			String[] pages=b.getDemoPage().split(",");
			Set<Integer> tab=new TreeSet<Integer>();
			for(String numb:pages){
				if(!numb.contains("-")){
					tab.add(new Integer(numb));
				}
				else{
					// treat list of number
					String range[]=numb.split("-");
					if (range.length>=2){
						//
						int start=new Integer(range[0]);
						int end=new Integer(range[range.length-1]);
						
						if(end>start){
							for(int i = start;i<=end;i++){
								tab.add(i);
							}
						}
					}
				}
			}//end loop each pages in pattern
			//generate and save demobook
			String linkDemoBook=core_lib.Image_op.GenerateDemoBook(tab, b);
			b.setLinkBookDemo(linkDemoBook);
			
			
			
			//book update = recheck book for us
			b.setIsValid(false);
			send_validation_to_admin(b);
			
			}
			service_book.merge(b);
		

		
		
		srcImage="/"+Application.FOLDER_BOOK_IMAGE_URL+"/"+ b.getLinkImage();
		session.put("my_img_path",Application.FOLDER_BOOK_IMAGE+((Member)session.get("my_member")).getLogin()+"/"+b.getIdBook()+"/"+imageFileName);
	
		if(imageFileName==null){
		return "success_noimg";
		}
		
		} catch (Exception e) {

		addActionError(e.getMessage());
		e.printStackTrace();
		return INPUT;

	}
	
	return "success";

	}
	
	
	public String supprBook(){
		System.out.println(((Member)session.get("my_member")).getIdMember());
		System.out.println(bookId);

		//b= service_book.findBookByid(((Member)session.get("my_member")).getIdMember(),bookId);

		b= service_book.findBookByid(bookId);
		service_book.delete(b);

		return "success";

	}

	public String cropImage(){
		System.out.println(x1+" "+y1+" "+x2+" "+y2+" "+w+" "+" "+h);

		editBook = service_book.findBookByid(bookId);
		//String sourceFile=(String) session.get("my_img_path");
		String big = Application.FOLDER_BOOK_IMAGE+"/"+editBook.getLinkImageBig();
		String small = Application.FOLDER_BOOK_IMAGE+"/"+editBook.getLinkImage();
		
		//Get the buffered image reference
		File f1=new File(small);
		File f2=new File( big);
		//System.out.println("name "+f.getName());
		//System.out.println("fichier "+f.isFile());
		try {
			
			BufferedImage image=ImageIO.read(f1);
			//BufferedImage imagebig=ImageIO.read(f2);
			
			//int width= image.getWidth();
			//x1
			//y1
			//Get the sub image
			BufferedImage out=null;
			if(h>0){
			out=image.getSubimage(x1,y1,w,h);
			//BufferedImage out2=imagebig.getSubimage(x1,y1,w,h);
			}// h is >0
			else{
				out=image;
			}
			
			BufferedImage outsmall=Image_op.resize(out, new Dimension(93, 112), null, Image_op.IMAGE_TYPE_PNG);
			BufferedImage outbig=Image_op.resize(out, new Dimension(215, 260), null, Image_op.IMAGE_TYPE_PNG);
			
			//... Find the position of the last dot.  Get extension.
			int dotPoss = small.lastIndexOf(".");
			String extension = small.substring(dotPoss+1);
			
			int dotPosb = big.lastIndexOf(".");
			String extension2 = big.substring(dotPosb+1);
			
			
			//System.out.println("ext "+extension);
			//Store the image to a new file
			//File f2= new File("c:/toto.jpg");
			ImageIO.write(outsmall,extension,f1);
			ImageIO.write(outbig,extension,f2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nameAction);
		if(editBook.getIsSell()==true){
			if("addbook".equals(nameAction)){
				return "sell_ok";
			}
		}
		
		return "success";
	}
	
	
	public String delete_mybook_group(){
		// me= (Member) session.get("my_member");
		// System.out.println(me +"toto");
		b=service_book.findBookByid(bookId);
		showGroup=service_group.findById(groupId);
		Member m =(Member) session.get("my_member");
		int memberid =b.getMember().getIdMember();
		if(memberid==m.getIdMember()){
			showGroup.getBooks().remove(b);
			
		}
		System.out.println("group book delete "+bookId);
		
		return "success";
	}
	
	public String delete_book_follow(){
		// me= (Member) session.get("my_member");
		// System.out.println(me +"toto");
		b=service_book.findBookByid(bookId);
		Member m =(Member) session.get("my_member");
		m=service_member.merge(m);
		
		int memberid =b.getMember().getIdMember();
		if(memberid==m.getIdMember()){
			m.getBooks().remove(b);
			service_member.merge(m);
		}
		System.out.println("fav book delete "+bookId);
		
		return "success";
	}
	
	public String delete_Mybook(){
		 Member me= (Member) session.get(Application.USER_KEY);
		// System.out.println(me +"toto");
		b=service_book.findBookByid(bookId);
		//Member m =(Member) session.get("my_member");
		//m=service_member.merge(m);
		//if(b.getMember()==m){
		int memberid =b.getMember().getIdMember();
		if(memberid==me.getIdMember()){
		
		
		
			Set<Member> lmemb=b.getMembers();
			if(lmemb!=null){
				for(Member m:lmemb){
					m.getBooks().remove(b);
				}
			}
			Set<ThemeGroup> s= b.getThemeGroups();
			for(ThemeGroup th: s)
				
				th.getBooks().remove(b);
			
			//service_book.delete(b);
			//service_member.merge(m);
			b.setDeleted(true);
			service_book.merge(b);
			System.out.println("fav book delete "+bookId);
		}
	//}
	
	return "success";
	}
	
	public String listPaginateMyBooks(){
		// me= (Member) session.get("my_member");
		// System.out.println(me +"toto");
		resBooks=service_book.getBooksByMemberId(((Member) session.get("my_member")).getIdMember(), min,max, null);
		System.out.println(resBooks.size());
		//System.out.println(resMember +"toto");
		return "success";
	}

	public String show_MyBooks_full(){
		
		//Member me= service_membre.findMemberByLogin(m.getLogin());

			 //me= (Member) my_session.get("my_member");
			 
			 
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			nbBooks = service_book.countFindBooksByMemberId(((Member) session.get("my_member")).getIdMember());
			 
			
			return "success";
	}
	
	public String listPaginateMyFollowBooks(){
		// me= (Member) session.get("my_member");
		// System.out.println(me +"toto");
		resBooks=service_book.getFollowBooksByMemberId(((Member) session.get("my_member")).getIdMember(), min,max, null);
		System.out.println(resBooks.size());
		//System.out.println(resMember +"toto");
		return "success";
	}
	
	public String show_MyFollowBooks_full(){
		
		//Member me= service_membre.findMemberByLogin(m.getLogin());

			 //me= (Member) my_session.get("my_member");
			 
			 
			 //System.out.println("name sender"+ resMessage.get(0).getMemberByIdMemberSender().getLogin());
			nbBooks = service_book.countFindFollowBooksByMemberId(((Member) session.get("my_member")).getIdMember());
			 
			
			return "success";
	}
	

public String valide(){
		
	b=service_book.findBookByid(bookId);
	if(b!=null)
	b.setIsValid(true);
			 
			
			return "success";
			
			
	}
	


	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}
}
