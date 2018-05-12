package action.manage_profile;


import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.activation.MimetypesFileTypeMap;
import javax.imageio.ImageIO;

import model.persistance.ClassMember;
import model.persistance.FavouriteAuthor;
import model.persistance.FavouriteBook;
import model.persistance.Job;
import model.persistance.LevelMember;
import model.persistance.Member;
import model.service.ClassMember_service;
import model.service.FavouriteAuthor_service;
import model.service.FavouriteBook_service;
import model.service.Itf_class_member_service;
import model.service.Itf_favourite_author_service;
import model.service.Itf_favourite_book_service;
import model.service.Itf_level_member_service;
import model.service.Itf_member_service;
import model.service.Level_member_service;
import model.service.Member_service;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.Exp;
import core_lib.Image_op;



public class MyProfile extends ActionSupport implements SessionAware{
	Member me;
	private Map<String, Object> my_session;
	Itf_member_service service_member;
	Itf_level_member_service service_level;
	List<String> choice_gender;
	
	List<String> nameBook;
	List<String> nameAuthor;
	Itf_favourite_author_service fav_auths_serv =new FavouriteAuthor_service();
	Itf_favourite_book_service fav_book_serv =new FavouriteBook_service();
	List<FavouriteAuthor> lfavAuth;
	List<FavouriteBook> lfavBook;
	private File imageMember;//The image for the book
	   private String imageMemberFileName;
	   private String imageMemberContentType;
	  Itf_class_member_service service_class_mem;
	private List<ClassMember> classes;
	int idClass;
	private String srcImage;
	int x1,y1,x2,y2,w,h;
	
	   
	   
	 
	
	
public String getImageMemberContentType() {
		return imageMemberContentType;
	}

	public void setImageMemberContentType(String imageMemberContentType) {
		this.imageMemberContentType = imageMemberContentType;
	}

public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
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

public int getIdClass() {
		return idClass;
	}

	public void setIdClass(int idClass) {
		this.idClass = idClass;
	}

public List<ClassMember> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassMember> classes) {
		this.classes = classes;
	}

public File getImageMember() {
		return imageMember;
	}

	public void setImageMember(File imageMember) {
		this.imageMember = imageMember;
	}

	public String getImageMemberFileName() {
		return imageMemberFileName;
	}

	public void setImageMemberFileName(String imageMemberFileName) {
		this.imageMemberFileName = imageMemberFileName;
	}

public List<FavouriteBook> getLfavBook() {
		return lfavBook;
	}

	public void setLfavBook(List<FavouriteBook> lfavBook) {
		this.lfavBook = lfavBook;
	}

public List<FavouriteAuthor> getLfavAuth() {
		return lfavAuth;
	}

	public void setLfavAuth(List<FavouriteAuthor> lfavAuth) {
		this.lfavAuth = lfavAuth;
	}

public List<String> getNameBook() {
		return nameBook;
	}

	public void setNameBook(List<String> nameBook) {
		this.nameBook = nameBook;
	}

	public List<String> getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(List<String> nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

public Member getMe() {
		return me;
	}

	public void setMe(Member me) {
		this.me = me;
	}

	public List<String> getChoice_gender() {
		return choice_gender;
	}

	public void setChoice_gender(List<String> choice_gender) {
		this.choice_gender = choice_gender;
	}

public MyProfile() {
		super();
		// TODO Auto-generated constructor stub
		service_member= new Member_service();
		service_level=new Level_member_service();
		choice_gender=new ArrayList<String>();
		 service_class_mem = new ClassMember_service();
	}

public String show_profil(){
		
		//Member me= service_membre.findMemberByLogin(m.getLogin());

			 me= (Member) my_session.get("my_member");
			// me = new Member();
	//Class LocalizedTextUtil
			choice_gender.add("male");
			choice_gender.add("fem");
			//System.out.println(System.getProperty("user.dir"));
			///mylistbook=service_book.findBooksByMemberId(me.getIdMember());
			 lfavAuth= fav_auths_serv.findFavoriteAuthorByMemberId(me.getIdMember());
			 
			 
			 nameAuthor=new ArrayList<String>() ;
			 //nameAuthor=new ArrayList<String>() ;
			 
			 for( FavouriteAuthor fa:lfavAuth){
				 nameAuthor.add(fa.getAuthorName());
			 }
			 System.out.println("auteur "+nameAuthor);
			 lfavBook= fav_book_serv.findFavoriteBookByMemberId(me.getIdMember());
			 nameBook=new ArrayList<String>() ;
			 
			 for( FavouriteBook fb:lfavBook){
				 nameBook.add(fb.getBookName());
			 }
			 //System.out.println(lfavBook.size());
			 
			 //classes = service_class_mem.getAllClassMember();

			 return "success";
		
		
	}

public String updateUser(){
	 classes = service_class_mem.getAllClassMember();
	//Member me= service_membre.findMemberByLogin(m.getLogin());
	 System.out.println("gender"+me.getGender());
		 Member meSession= (Member) my_session.get("my_member");
		// me.setIdMember(meSession.getIdMember());
	meSession.setName(me.getName());
	meSession.setLastName(me.getLastName());
	
	if(!me.getPassword().equals(""))
	meSession.setPassword(me.getPassword());
	for (String s:nameAuthor){
		fav_auths_serv.save(new FavouriteAuthor(meSession,s,s));
	}
	meSession.setDescription(me.getDescription());
	meSession.setGender(me.getGender());
	meSession.setBirth(me.getBirth());
	meSession.setEmail(me.getEmail());
	
	
/*	ClassMember myClass = service_class_mem.findById(idClass);
	
	List<LevelMember> llm=service_level.getLevelMemberByIdMember(meSession.getIdMember());
	LevelMember level = null;
	if (llm.size()>0){
		 level=llm.get(0);
		 level.setClassMember(myClass);
		service_level.merge(level);
	}
	else {
		//start a new class
		Set<Job> jobs= myClass.getJobs();
		int exp=0;
		String jobname="débutant";
		for (Job j:jobs){
			// find a job for exp
			if(exp>=j.getExpMin()&& exp<j.getExpMax()){
				jobname=j.getName();
				break;
			}
			
		}
		level = new LevelMember(myClass, meSession, 0, 0, 0,jobname);
		service_level.save(level);
	
	}*/
	
		//service_member.merge(meSession);
		lfavAuth = new ArrayList<FavouriteAuthor>();
		lfavBook= new ArrayList<FavouriteBook>();
		System.out.println(nameBook.size()+"taille nambook");
		for (String s:nameBook){
			if (!s.trim().equals(""))
				lfavBook.add(new FavouriteBook(meSession,s,s));
		}
		
		System.out.println(nameAuthor.size()+"taille namauthor");
		for (String s:nameAuthor){
			if (!s.trim().equals(""))
				lfavAuth.add(new FavouriteAuthor(meSession,s,s));
		}
		fav_auths_serv.addOverrideFavouriteAuthor(meSession.getIdMember(),lfavAuth);
		fav_book_serv.addOverrideFavouriteBook(meSession.getIdMember(), lfavBook);
		meSession=service_member.merge(meSession);
		//System.out.println("toto"+meSession.getFavouriteAuthors());
		

		try {
			
			String directory=meSession.getLogin();
		
			if(imageMemberFileName!=null){
			String image_big= "big"+System.currentTimeMillis()+imageMemberFileName;
			String image_small= "small"+System.currentTimeMillis()+imageMemberFileName;
			
			BufferedImage imagebuffer=null;
			try {
/*				boolean search=false;
				for(int i=0;i<Image_op.MIME.length;i++){
					if(imageMemberContentType.equals(Image_op.MIME[i])){
						search=true;
						break;
						}
				}
				if(!search){
					return "input";
				}
*/				
				//MimetypesFileTypeMap type = new MimetypesFileTypeMap();
				//String mime=type.getContentType(imageMember);
				imagebuffer = ImageIO.read(imageMember);
				if (imagebuffer==null){
					addActionError("format de l'image incorrecte");
					return "input";
					
				}
/*			System.out.println(imageMemberContentType.equals(Image_op.MIME_PNG)+" a"+imageMemberContentType+"a");
			System.out.println(imageMemberContentType.equals(Image_op.MIME_JPEG)+" a"+imageMemberContentType+"a");
			System.out.println(imageMemberContentType.equals(Image_op.MIME_GIF)+" a"+imageMemberContentType+"a");*/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				addActionError("format de l'image doit etre en png, jpg, ou gif");
				e.printStackTrace();
				return "input";
				
			}
		
		//ajust image with to fit the result screen width (=550 pixels)
		if(imagebuffer.getWidth()> 600) {
		BufferedImage  resized= Image_op.resize(imagebuffer,
				new Dimension(600, imagebuffer.getHeight()*550/imagebuffer.getWidth()), Application.FOLDER_MEMBER_AVATAR+directory,
				Image_op.IMAGE_TYPE_PNG);
	
		Image_op.save_image(Application.FOLDER_MEMBER_AVATAR+directory,image_big,Image_op.IMAGE_TYPE_PNG ,resized);
		Image_op.save_image(Application.FOLDER_MEMBER_AVATAR+directory,image_small,Image_op.IMAGE_TYPE_PNG ,resized);
		System.out.println("save into "+Application.FOLDER_MEMBER_IMAGE_URL+directory);
		}
		else{
		Image_op.save_file(Application.FOLDER_MEMBER_AVATAR+directory, image_big,imageMember);
		Image_op.save_file(Application.FOLDER_MEMBER_AVATAR+directory, image_small,imageMember);
		System.out.println("save into "+Application.FOLDER_MEMBER_IMAGE_URL+directory);
		}
		//b.setLinkBook(directory+"/"+bookFileFileName);
		meSession.setAvatarUrl(directory+"/"+image_small);
		meSession.setAvatarUrlBig(directory+"/"+image_big);
		//meSession.setAvatarUrlSmall(avatarUrlSmall)(directory+"/"+imageMemberFileName);
		}//if image null
			else{
				my_session.put(Application.USER_KEY, meSession);
				return "success_no_img";
			}
			
		my_session.put(Application.USER_KEY, meSession);
		
		//Member m=(Member) my_session.get(Application.USER_KEY);
		try{
			meSession=new Exp().changeExp( meSession,Exp.PROFIL_REMPLI);
		
		 my_session.put(Application.USER_KEY, meSession);
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		
		//service_book.merge(b);
		//srcImage="/"+Application.FOLDER_MEMBER_AVATAR+"/"+ meSession.getAvatarUrl();
		//session.put("my_img_path",Application.FOLDER_BOOK_IMAGE+((Member)session.get("my_member")).getLogin()+"/"+b.getIdBook()+"/"+imageFileName);
	} catch (Exception e) {

		addActionError(e.getMessage());
		e.printStackTrace();
		return INPUT;

	}
		
		
		  return "success";

}

public StreamResult uploadFileAjax(){
	
	try {
		//System.out.println("toto"+imageMemberFileName+((Member)my_session.get("my_member")).getLogin());
	File directory_member  = new File("c:/image/members/aa");	
	if(! directory_member .isDirectory()) {
		directory_member .mkdirs();
   } 
	
	
	
	
	//String fullImageName =imageFileName;
	File theImage = new File(directory_member,imageMemberFileName);
	
	
		FileUtils.copyFile(imageMember, theImage);
		System.out.println("reussi");
	} catch (Exception e) {
		System.out.println("rate");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	

	return new StreamResult(new ByteArrayInputStream("success".getBytes()));

}

public String cropImage(){
	System.out.println(x1+" "+y1+" "+x2+" "+y2+" "+w+" "+" "+h);
	if(h>0){
	Member meSession= (Member) my_session.get("my_member");
	String sourceFileSmall="/"+Application.FOLDER_MEMBER_AVATAR+"/"+ meSession.getAvatarUrl();
	String sourceFileBig="/"+Application.FOLDER_MEMBER_AVATAR+"/"+ meSession.getAvatarUrlBig();

	//Get the buffered image reference
	File f=new File(sourceFileSmall);
	File f2=new File(sourceFileBig);
	System.out.println("name "+f.getName());
	System.out.println("fichier "+f.isFile());
	try {
		BufferedImage image=ImageIO.read(f);
		int width= image.getWidth();
		//x1
		//y1
		//Get the sub image
		BufferedImage out=image.getSubimage(x1,y1,w,h);

		BufferedImage outsmall=Image_op.resize(out, new Dimension(63, 63), null, Image_op.IMAGE_TYPE_PNG);
		BufferedImage outbig=Image_op.resize(out, new Dimension(120, 120), null, Image_op.IMAGE_TYPE_PNG);
		//... Find the position of the last dot.  Get extension.
		int dotPossmall = sourceFileSmall.lastIndexOf(".");
		String extensionsmall = sourceFileSmall.substring(dotPossmall+1);
		
		
		int dotPosbig = sourceFileBig.lastIndexOf(".");
		String extensionbig = sourceFileBig.substring(dotPosbig+1);
		//System.out.println("ext "+extension);
		//Store the image to a new file
		//File f2= new File("c:/toto.jpg");
		ImageIO.write(outsmall,extensionsmall,f);
		
		ImageIO.write(outbig,extensionbig,f2);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}// h is >0
	return "success";
}

@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	my_session=arg0;
}
}
