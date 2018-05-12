package action.register;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import model.persistance.ClassMember;
import model.persistance.Job;
import model.persistance.Level;
import model.persistance.LevelMember;
import model.persistance.Member;
import model.service.ClassMember_service;
import model.service.Itf_class_member_service;
import model.service.Itf_level_member_service;
import model.service.Itf_level_service;
import model.service.Itf_member_service;
import model.service.Level_member_service;
import model.service.Level_service;
import model.service.Member_service;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import constant.Application;
import core_lib.Exp;
import core_lib.Image_op;
import core_lib.WebSiteMessage;


public class Register extends ActionSupport implements SessionAware{

	private Map<String, Object> my_session;
	String passwordConfirm;
	String emailConfirm;
	Member m;
	private File imageMember;//The image for the book
   private String imageMemberFileName;
   private String imageMemberContentType;
	int x1,y1,x2,y2,w,h;
	private List<ClassMember> classes;
	Itf_class_member_service service_class_mem; 
        Itf_member_service service_membre;
		private int idClass;
		Itf_level_member_service service_level;
		Itf_level_service serv_level;
		private String emails;
		private String subject;
		private String email;
		private String login;
		private String referee;

		
		
        
    public String getReferee() {
			return referee;
		}



		public void setReferee(String referee) {
			this.referee = referee;
		}



	public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getLogin() {
			return login;
		}



		public void setLogin(String login) {
			this.login = login;
		}



	public String getEmails() {
			return emails;
		}



		public void setEmails(String emails) {
			this.emails = emails;
		}



		public String getSubject() {
			return subject;
		}



		public void setSubject(String subject) {
			this.subject = subject;
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



	public Register() {
		service_level=new Level_member_service();
		service_class_mem = new ClassMember_service();
    service_membre= new Member_service();
    serv_level=new Level_service();
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



	public String getImageMemberContentType() {
		return imageMemberContentType;
	}



	public void setImageMemberContentType(String imageMemberContentType) {
		this.imageMemberContentType = imageMemberContentType;
	}



	public String getEmailConfirm() {
		return emailConfirm;
	}

	public void setEmailConfirm(String emailConfirm) {
		this.emailConfirm = emailConfirm;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Member getM() {
		return m;
	}

	public void setM(Member m) {
		this.m = m;
	}

	public String showRegisterForm(){
      //  try {
            Email email = new SimpleEmail();




            String authuser = "borei.eng@gmail.com";
            String authpwd = "Djidane41771";
           

//// Very Important, Don't use email.setAuthentication()
//email.setSmtpPort(465);
//email.setAuthenticator(new DefaultAuthenticator(authuser, authpwd));
//email.setDebug(true); // true if you want to debug
//email.setHostName("smtp.gmail.com");
//
//email.getMailSession().getProperties().put("mail.smtp.auth", "true");
//email.getMailSession().getProperties().put("mail.debug", "true");
//email.getMailSession().getProperties().put("mail.smtp.port", "465");
//email.getMailSession().getProperties().put("mail.smtp.socketFactory.port", "465");
//email.getMailSession().getProperties().put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//email.getMailSession().getProperties().put("mail.smtp.socketFactory.fallback", "false");
//email.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
//email.setFrom("toto@gmail.com", "SenderName");
//email.setSubject("TestMail");
//email.setMsg("This is a test mail?");
//email.addTo("japan44@hotmail.fr", "ToName");
//email.send();

            //marcha po
//            email.setDebug(true);
//email.setHostName("smtp.gmail.com");
// email.addTo("japan44@hotmail.fr", "ToName");
//email.setAuthentication(authuser, authpwd);
//email.setFrom("borei.eng@gmail.com", "The Web MASTER");
//email.setSubject("Some important stuff");
//email.setMsg("from gmail");
//email.getMailSession().getProperties().put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//email.getMailSession().getProperties().put("mail.smtp.socketFactory.fallback", "false");
//email.setTLS(true);
//email.setSmtpPort(465);
//email.setSslSmtpPort("465");
//email.send();
        
//            email.setHostName("smtp.free.fr");
//            email.setFrom("borei.eng@free.fr", "Moi Borei");
//            email.setSubject("TestMail");
//            email.setMsg("This is a test mail?");
//            email.addTo("japan44@hotmail.fr", "ToName");
//            email.send();

          //  new WebSiteMessage().send("japan44@hotmail.fr", "test message");

//        } catch (EmailException ex) {
//            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
//        }
            classes = service_class_mem.getAllClassMember();
            
	return "success";
        }

	public String checkRegister(){
		//insertDatabase
		//send email
              System.out.println("toto");
              m.setLoginReferer(referee);
              m.setRegistrationDate(new Date());
              m.setRating(0.0);
              m.setDescription("");
              if(service_membre.findMemberByLogin(m.getLogin())!=null){
            	  addActionError("le login existe déjà");
            	  return "input";
              }
            	  
                service_membre.persist(m);
            	ClassMember myClass = service_class_mem.findById(idClass);
            	
            	List<LevelMember> llm=service_level.getLevelMemberByIdMember(m.getIdMember());
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
            		Level l0=serv_level.findLevelByNumber(0);
            		level = new LevelMember(myClass, m,l0, 0, 0, 0,jobname);
            		service_level.save(level);
            	
            	}
                
                System.out.println("toto");
                String directory=m.getLogin();
            	String image_big= "big"+System.currentTimeMillis()+imageMemberFileName;
    			String image_small= "small"+System.currentTimeMillis()+imageMemberFileName;
    			String image_tmp= "tmp"+System.currentTimeMillis()+imageMemberFileName;
                
                if(imageMemberFileName!=null){
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
					        					service_level.delete(level);
					        					service_membre.delete(m);
					        					 classes = service_class_mem.getAllClassMember();
					        					return "input";
					        					
					        				}
					        /*			System.out.println(imageMemberContentType.equals(Image_op.MIME_PNG)+" a"+imageMemberContentType+"a");
					        			System.out.println(imageMemberContentType.equals(Image_op.MIME_JPEG)+" a"+imageMemberContentType+"a");
					        			System.out.println(imageMemberContentType.equals(Image_op.MIME_GIF)+" a"+imageMemberContentType+"a");*/
					        			} catch (Exception e) {
					        				// TODO Auto-generated catch block
					        				addActionError("format de l'image doit etre en png, jpg, ou gif");
					        				e.printStackTrace();
					        				service_level.delete(level);
				        					service_membre.delete(m);
				        					 classes = service_class_mem.getAllClassMember();
					        				return "input";
					        				
					        			}
					        		
					        		/*******************************************************************/
					        		/*******************************************************************/
					        			
					        			//ajust image with to fit the result screen width (=550 pixels)
					        		if(imagebuffer.getWidth()> 600) {
					        			BufferedImage  resized= Image_op.resize(imagebuffer,
					        			new Dimension(600, imagebuffer.getHeight()*550/imagebuffer.getWidth()), null,
					        				Image_op.IMAGE_TYPE_PNG);
					        	
					        	
					        			try {
						        			Image_op.save_image(Application.FOLDER_TMP_IMAGE+"/"+directory,image_tmp,Image_op.IMAGE_TYPE_PNG ,resized);
						        			
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
											addActionError("format de l'image doit etre en png, jpg, ou gif");
											service_level.delete(level);
				        					service_membre.delete(m);
				        					 classes = service_class_mem.getAllClassMember();
											return "input";
										}
						        		System.out.println("save into image temp resized"+Application.FOLDER_TMP_IMAGE+"/"+directory);
						        		
						        		}
						        		else{
						        		try {
											Image_op.save_file(Application.FOLDER_TMP_IMAGE+"/"+directory, image_tmp,imageMember);
											
						        		} catch (Exception e) {
											
											e.printStackTrace();
											addActionError("format de l'image doit etre en png, jpg, ou gif");
											service_level.delete(level);
				        					service_membre.delete(m);
				        					 classes = service_class_mem.getAllClassMember();
											return "input";
										}
						        		System.out.println("save into image temp no resized"+Application.FOLDER_TMP_IMAGE+"/"+directory);
						        		}
					        			
					        		
					        		// saving images big and small
					        		
					        	
					        		
					      
					        		try {
					        			BufferedImage image=imagebuffer;
					        			
					        			//Get the sub image
					        			BufferedImage out=image;

					        			BufferedImage outsmall=Image_op.resize(out, new Dimension(63, 63), null, Image_op.IMAGE_TYPE_PNG);
					        			BufferedImage outbig=Image_op.resize(out, new Dimension(120, 120), null, Image_op.IMAGE_TYPE_PNG);
					        			//... Find the position of the last dot.  Get extension.
					        			int dotPossmall = image_small.lastIndexOf(".");
					        			String extensionsmall = image_small.substring(dotPossmall+1);
					        			
					        			
					        			int dotPosbig = image_big.lastIndexOf(".");
					        			String extensionbig = image_big.substring(dotPosbig+1);
					        			//System.out.println("ext "+extension);
					        			//Store the image to a new file
					        			//File f2= new File("c:/toto.jpg");
					        			String sourceFileSmall="/"+Application.FOLDER_MEMBER_AVATAR+"/"+ directory+"/"+image_small;
					        			String sourceFileBig="/"+Application.FOLDER_MEMBER_AVATAR+"/"+ directory+"/"+image_big;
					        			
					        			//Get the buffered image reference
					        			File f=new File(sourceFileSmall);
					        			File f2=new File(sourceFileBig);
					        			

					        			if(! f .isDirectory()) {
					        				f .mkdirs();
					        	       } 
					        			if(! f2 .isDirectory()) {
					        				f2 .mkdirs();
					        	       } 
					        			ImageIO.write(outsmall,extensionsmall,f);
					        			ImageIO.write(outbig,extensionbig,f2);
					        			
					        		} catch (IOException e) {
					        			// TODO Auto-generated catch block
					        			e.printStackTrace();
					        			service_level.delete(level);
			        					service_membre.delete(m);
			        					 classes = service_class_mem.getAllClassMember();
					        		}
					        		
					        		
					        			
					        		/********************************************************************/	
					        		/********************************************************************/	
					        	
					        		
					        		
			/*		        		//ajust image with to fit the result screen width (=550 pixels)
					        		if(imagebuffer.getWidth()> 600) {
					        		BufferedImage  resized= Image_op.resize(imagebuffer,
					        				new Dimension(600, imagebuffer.getHeight()*550/imagebuffer.getWidth()), Application.FOLDER_MEMBER_AVATAR+directory,
					        				Image_op.IMAGE_TYPE_PNG);
					        	
					        		try {
					        			Image_op.save_image(Application.FOLDER_MEMBER_AVATAR+directory,image_big,Image_op.IMAGE_TYPE_PNG ,resized);
					        			Image_op.save_image(Application.FOLDER_MEMBER_AVATAR+directory,image_small,Image_op.IMAGE_TYPE_PNG ,resized);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										addActionError("format de l'image doit etre en png, jpg, ou gif");
										return "input";
									}
					        		System.out.println("save into "+Application.FOLDER_MEMBER_IMAGE_URL+directory);
					        		
					        		}
					        		else{
					        		try {
										Image_op.save_file(Application.FOLDER_MEMBER_AVATAR+directory, image_big,imageMember);
										Image_op.save_file(Application.FOLDER_MEMBER_AVATAR+directory, image_small,imageMember);
					        		} catch (Exception e) {
										
										e.printStackTrace();
										addActionError("format de l'image doit etre en png, jpg, ou gif");
										return "input";
									}
					        		System.out.println("save into "+Application.FOLDER_MEMBER_IMAGE_URL+directory);
					        		}
					        		//b.setLinkBook(directory+"/"+bookFileFileName);
					        		*/
					        		
					        		
					        		m.setAvatarUrl(directory+"/"+image_small);
					        		m.setAvatarUrlBig(directory+"/"+image_big);
					        		my_session.put(Application.USER_KEY_TEMP, m);
					        		my_session.put(Application.AVATAR_TEMP, directory+"/"+image_tmp);
					        		service_membre.merge(m);
                	
                } //end if
                else{
                	
                	//Member m=(Member) my_session.get(Application.USER_KEY);
            /*    	try{
                	
                		m=new Exp().changeExp( m,Exp.INSCRIPTION);
                		
                		 my_session.put(Application.USER_KEY, m);
                		}
                		catch(Exception e){
                			e.printStackTrace();
                		}*/
                	
                
                	
                	add_default_avatar( m);
                	
                	 String send = "Bonjour,<br><br>"
              		      +  "Merci de vous &ecirc;tre inscrit chez lets-ebook, veuillez cliquer sur le lien pour confirmer votre inscription<br>" 
              		   +" <br/><a href='http://www.lets-ebook.com/ebooksite/confirmRegister?login="+m.getLogin()+"'/>http://www.lets-ebook.com/ebooksite/confirmRegister?login="+m.getLogin()+"</a>"
              		    +  "<br><br><br><br><br><br> Cordialement<br><br>"
              		     + "  L'&eacute;quipe lets-ebook<br><br>";
              		WebSiteMessage aa= new WebSiteMessage();
                     	aa.send(m.getEmail(), send,"lets-ebook confirmation inscription");
                	
                	
    				return "success_no_img";
                	
                }
                
              /*  Member mexp=(Member) my_session.get(Application.USER_KEY);
               	try{
               		mexp=new Exp().changeExp( m,Exp.INSCRIPTION);
            		
            		 my_session.put(Application.USER_KEY, mexp);
            		}
            		catch(NullPointerException e){
            			e.printStackTrace();
            		}*/
               
           		 String send = "Bonjour,<br><br>"
           		      +  "Merci de vous &ecirc;tre inscrit chez lets-ebook, veuillez cliquer sur le lien pour confirmer votre inscription:<br>" 
           		   +" <br/><a href='http://www.lets-ebook.com/ebooksite/confirmRegister?login="+m.getLogin()+"'/>http://www.lets-ebook.com/ebooksite/confirmRegister?login="+m.getLogin()+"</a>"
           		    +  "<br><br><br><br><br><br> Cordialement<br><br>"
           		     + "  L'&eacute;quipe lets-ebook<br><br>";
           		WebSiteMessage aa= new WebSiteMessage();
                  	aa.send(m.getEmail(), send,"lets-ebook confirmation inscription");
                  	
                
		return "success";
	}
	
	public String resend_register(){
		 Member me= service_membre.findMemberByLogin(m.getLogin());
		 String send = "Bonjour,<br><br>"
  		      +  "merci de vous &ecirc;tre inscrit chez lets-ebook, veuillez cliquer sur le lien pour confirmer votre inscription:<br>" 
  		   +" <br/><a href='http://www.lets-ebook.com/ebooksite/confirmRegister?login="+me.getLogin()+"'/>http://www.lets-ebook.com/ebooksite/confirmRegister?login="+m.getLogin()+"</a>"
  		    +  "<br><br><br><br><br><br> cordialement<br><br>"
  		     + "  L'&eacute;quipe lets-ebook<br><br>";
  		WebSiteMessage aa= new WebSiteMessage();
         	aa.send(me.getEmail(), send,"lets-ebook confirmation inscription");
		
		return "success";
		
	}
	
	
	public String cropImageAvatar_register(){
		System.out.println(x1+" "+y1+" "+x2+" "+y2+" "+w+" "+" "+h);
		
		Member meSession= (Member) my_session.get(constant.Application.USER_KEY_TEMP);
		if(meSession==null){
			System.out.println("session detruite");
			return "input";
		}
		
		String sourceFileTmp=Application.FOLDER_TMP_IMAGE+"/"+my_session.get(Application.AVATAR_TEMP);
		String sourceFileSmall=Application.FOLDER_MEMBER_AVATAR+"/"+ meSession.getAvatarUrl();
		String sourceFileBig=Application.FOLDER_MEMBER_AVATAR+"/"+ meSession.getAvatarUrlBig();
		
		//Get the buffered image reference
		
		File fTmp=new File(sourceFileTmp);
		
		File f=new File(sourceFileSmall);
		File f2=new File(sourceFileBig);
		System.out.println("name "+f.getName());
		System.out.println("fichier "+f.isFile());
		try {
			BufferedImage image=ImageIO.read(fTmp);
			
			//x1
			//y1
			//Get the sub image
			BufferedImage out=null;
			if(h>0){
			out=image.getSubimage(x1,y1,w,h);
			}// h is >0
			else{
				out=image;
			}
			
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*String sourceFileSmall="/"+Application.FOLDER_MEMBER_AVATAR+"/"+ meSession.getAvatarUrl();
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
			BufferedImage out=null;
			if(h>0){
			out=image.getSubimage(x1,y1,w,h);
			}// h is >0
			else{
				out=image;
			}
			
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
		}*/

		
		
		
		
		
		
		return "success";
	}
	
	boolean add_default_avatar(Member m){
		
		String directory=m.getLogin();
		BufferedImage imagebuffersmall=null;
		BufferedImage imagebufferbig=null;
		try {
			File small=new File(constant.Application.DEFAULT_AVATAR_SMALL_PATH);
			File big=new File(constant.Application.DEFAULT_AVATAR_BIG_PATH);
		imagebuffersmall = ImageIO.read(small);
		imagebufferbig = ImageIO.read(big);
		
		Image_op.save_image(Application.FOLDER_MEMBER_AVATAR+directory,small.getName(),Image_op.IMAGE_TYPE_PNG ,imagebuffersmall);
		
		Image_op.save_image(Application.FOLDER_MEMBER_AVATAR+directory,big.getName(),Image_op.IMAGE_TYPE_PNG ,imagebufferbig);
		
		m.setAvatarUrl(directory+"/"+small.getName());
		m.setAvatarUrlBig(directory+"/"+big.getName());
		service_membre.merge(m);
		
		return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			addActionError("format de l'image doit etre en png, jpg, ou gif");
			e.printStackTrace();
			return false;
			
		}
	}
	
	public String save_register(){
		//insertDatabase
		//send email
                
		return "success";
	}
	
	
	public StreamResult send_mail(){
		//insertDatabase
		//send email
		WebSiteMessage aa= new WebSiteMessage();
		Boolean res = true;
    	try{
		aa.send("japan44@hotmail.fr", "test de send mail","srf");
    	 res = true;
    	}
    	catch (RuntimeException e) {
			// TODO: handle exception
    		res = false;
		}
    	return new StreamResult(new ByteArrayInputStream(res.toString().getBytes()));
	}
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		my_session=arg0;
	}
	
	public String show_referee(){
		//insertDatabase
		//send email
                
		return "success";
	}
	public String sendreferMail(){
		Member me=(Member) my_session.get("my_member");
		String login="";
		String name="";
		
		String last="";
	  if(me!=null){
		  login=me.getLogin();
	  name = me.getName();
	last = me.getLastName();}
		String send = core_lib.WebSiteMessage.INVIT;
	    send+=" <br/><a href='http://www.lets-ebook.com/ebooksite/show_inscription?referee="+login+"'>http://www.lets-ebook.com</a>";
	    send+=" <br/>"+ name+" "+last;
	    

	    
	    java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(emails, ",");

	    while ( tokenizer.hasMoreTokens() ) {
	       String mail= tokenizer.nextToken();
	       WebSiteMessage aa= new WebSiteMessage();
       	aa.send(mail, send,this.subject);
	    }
	    
                
		return "success";
	}
	

	
	
	
	public String sendLostPassword(){
		//Member m =service_membre.findMemberByemail(email);
		Member m =service_membre.findMemberByLogin(login);
		WebSiteMessage aa= new WebSiteMessage();
		
		if(m!=null){
		 String send = "Bonjour,<br/><br/>"
		      +  "voici vos identifiant et mot de passe associ&eacute;s &agrave; votre compte<br/>" 
		    + "login: "+m.getLogin()+"<br/> mot de passe: " +m.getPassword()+"<br/><br/>"
		    +  " cordialement<br/><br/>"
		     + "  L'équipe lets-ebook<br/><br/>";
       	aa.send(m.getEmail(), send,"lets-ebook perte d'identifiant");
		}
		return "success";
	}
	
	public String confirmRegister(){
		Member m =service_membre.findMemberByLogin(login);
		m.setSecretQuestion("ok");
		service_membre.merge(m);
		return "success";
	}
	

}
