package cron;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import model.dao.Book_dao;
import model.dao.Member_dao;
import model.persistance.Book;
import model.persistance.Member;
import modelcron.dao.BookBk_dao;
import modelcron.dao.MemberBk_dao;
import modelcron.persistance.BookBk;
import modelcron.persistance.MemberBk;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

import constant.Application;
import core_lib.Hasher;

/*
 * for each new member we copy all the data (avatar small and big). normally, all the belonged book 
 * will be treat. we compare next the keys from the servers and from local. display a message if not equals,
 * save a boolean ok if equals (to prevent to not copy if data damage in the bd ) 
 * 
 * for existing member, backup only if file change (we keep old files) and key different.
 * if the file is the same and the key is different, we check our boolean ok. if ok false
 * we redownload the doc if ok true means pb in the website.
 * for books we check too if the book is new if yes, do same as first time. if not new do same as 
 * member
 * 
 * test : 
 * member new and book => new insert member and book
 * member new and book not new => error big message
 *
 * member old no change and book new 
 * member old avatar change name and book old no change
 * member old avatarbig change name and book old no change
 * member old no change and book old change avatar
 * member old no change and book old change book file
 * 
 * member old no change keyavatar change and old book
 * member old no change keyavatarurl change and old book
 * member old no change  and old book keyimage change
 * member old no change  and old book keyimagebig change
 * member old no change  and old book keyimagebig change
 * 
 */

public class CopyResources {

	/**
	 * @param args
	 */
    URL u;
    InputStream is = null;
    DataInputStream dis;
    String s;

    public static final String FOLDER_MEMBER_AVATAR = "c:/backup/images/member/";
    public static final String FOLDER_BOOK_IMAGE = "c:/backup/images/book/";
    public static final String FOLDER_BOOK = "c:/backup/book/";
  //  public static final String WEB="http://lets-ebook.com/ebooksite";
    public static final String WEB="http://localhost";
   // public static final String FOLDER;
	
	
	public static void main(String[] args) {
		new CopyResources().execute();
	}
	
	
	public void execute(){
		// TODO Auto-generated method stub
		HibernateSessionFactory.setConfigFiles("/hibernate.cfg.xml,/hibernate_bk_ebooksite.cfg.xml");
		Session s= HibernateSessionFactory.getNewSession();
		Session s_bak=HibernateSessionFactory.getNewSession("bak_ebooksite");
		
		MemberBk_dao m_bak=new MemberBk_dao();
		m_bak.setSession(s_bak);
		
		BookBk_dao b_bak= new BookBk_dao();
		b_bak.setSession(s);
//gerer mD5
//copie images membres
		//get membre
		Member_dao m= new Member_dao();
		m.setSession(s);
		Book_dao b= new Book_dao();
		b.setSession(s);
		//Transaction t = s.beginTransaction();
		//t = s.beginTransaction();
		Set<Book> lb=null;
		List<Member> lm= m.getMembers(0, -1, null);
		//list member and list mymember
		//if no member
		//save new member in mymember
		
		//compare  sha1 and continue
		//else member here
		//check if file name !=
		//upload again and update db
		//compare  sha1 and continue
		//if file name ==
		//log if sha1 =!
		
		for(Member memb:lm){
			String lurl= memb.getAvatarUrl();
			String burl=memb.getAvatarUrlBig();
			
			String lurl_name="";
			String burl_name="";
			//copy the 2 pictures with sha1 and name into db
			String directory=FOLDER_MEMBER_AVATAR+"/"+memb.getLogin();
			String url=WEB+"/"+Application.FOLDER_MEMBER_IMAGE_URL+"/";
			
			File directory_save  = new File(directory);
			if(! directory_save .isDirectory()) {
				directory_save .mkdirs();
	       } 
			StringTokenizer st=null;
			MemberBk localMember=m_bak.findMemberByLogin(memb.getLogin());
			
			//always save all if new member appears
			if(localMember==null){
			 System.out.println("add new member "+memb.getLogin());
			 MemberBk mbk=new MemberBk();
			 
				if(lurl!=null){
					st=new StringTokenizer(lurl,"/");
				 
				 while(st.hasMoreTokens())
					 lurl_name=st.nextToken();
				
				 //save the file
				 String key= getFilebyURL(directory_save,lurl_name,url+lurl);
				 //compare now the 2 keys : display message
				 if(!memb.getKey_avatarUrl().equals(key))
					 System.out.println("failed copy "+url+lurl+" : key is not the same");
				 else
					 mbk.setOkL(true);
				 
				 mbk.setAvatarUrl(lurl);
				 mbk.setKeyAvatar(key);
				}
				else
					System.out.println(memb.getLogin()+" has no little avatar");			 
	            
				if(burl!=null){
				st=new StringTokenizer(burl,"/");
				 
				 while(st.hasMoreTokens())
					 burl_name=st.nextToken();
				 
				 String key= getFilebyURL(directory_save,burl_name,url+burl);
				 
				 if(!memb.getKey_avatarUrlBig().equals(key))
					 System.out.println("failed copy "+url+burl+" : key is not the same");
				 else
					 mbk.setOkB(true);
				 
				 mbk.setAvatarUrlBig(burl);
				 mbk.setKeyAvatarbig(key);
				 
				}
				else
					System.out.println(memb.getLogin()+" has no big avatar");	
			
				//save member in new database
				m_bak.save(mbk);
				
				//copie images small des livres
				//copie images big des livres
				//copie livres big des livres
				lb=memb.getBooks_1();
				for(Book book:lb){
					
					
					String lurlbook= book.getLinkImage();
					String burlbook=book.getLinkImageBig();
					String myurlbook=book.getLinkBook();
					BookBk booktreat=b_bak.findBookByid(book.getIdBook());
					
					
					if(booktreat==null){
						BookBk bbk=new BookBk();
						
					System.out.println("treat "+memb.getLogin()+" and his book "+book.getIdBook());
					
					String lurlbook_name="";
					String burlbook_name="";
					String myurlbook_name="";
					
					String directoryBook=FOLDER_BOOK_IMAGE+"/"+memb.getLogin()+"/"+book.getIdBook();
					String urlBookImg=WEB+"/"+Application.FOLDER_BOOK_IMAGE_URL+"/";
					String urlBook=WEB+"/"+Application.FOLDER_BOOK_URL+"/";
					
					File directory_book_save  = new File(directoryBook);
					if(! directory_book_save .isDirectory()) {
						directory_book_save .mkdirs();
			       } 
					//StringTokenizer st=null;
					if(lurlbook!=null){
						st=new StringTokenizer(lurlbook,"/");
					 
					 while(st.hasMoreTokens())
						 lurlbook_name=st.nextToken();
					
					
						
							//System.out.println(lurlbook_name.replace(" ", "%20"));
						String key=	getFilebyURL(directory_book_save,lurlbook_name,urlBookImg+book.getLinkImage());
						
						 if(!book.getKey_linkBook().equals(key))
							 System.out.println("failed copy "+urlBookImg+book.getLinkImage()+" : key is not the same");
						 else
							 bbk.setOkL(true);
					;
					
					}
					
					else
						System.out.println(memb.getLogin()+" "+book.getTitle()+" has no little image");			 
		            
					if(burlbook!=null){
					st=new StringTokenizer(burlbook,"/");
					 
					 while(st.hasMoreTokens())
						 burlbook_name=st.nextToken();
					 
						
								String key=	getFilebyURL(directory_book_save,lurlbook_name,urlBookImg+book.getLinkImageBig());
								
								 if(!book.getKey_linkImageBig().equals(key))
									 System.out.println("failed copy "+urlBookImg+book.getLinkImageBig()+" : key is not the same");
								 else
									 bbk.setOkB(true);
						
					}
					else
						System.out.println(memb.getLogin()+" "+book.getTitle()+" has no big image");		
					
					
					if(myurlbook!=null){
						st=new StringTokenizer(myurlbook,"/");
						 
						 while(st.hasMoreTokens())
							 myurlbook_name=st.nextToken();
						 
							
									String key=	getFilebyURL(directory_book_save,lurlbook_name,urlBook+book.getLinkBook());
									
									 if(!book.getKey_linkBook().equals(key))
										 System.out.println("failed copy "+urlBook+book.getLinkBook()+" : key is not the same");
									 else
										 bbk.setOkImg(true);
						
							
						}
						else
							System.out.println(memb.getLogin()+" "+book.getTitle()+" has no big image");
					}//end if booktreat is null (book is here)
					else{
						System.out.println("error book "+book.getIdBook()+" "+book.getTitle()+" exist but not his owner member "+memb.getLogin());
					}
				}//end for books
				 
				 
			 }//end if no member
			 
			
			/************************
			 * //member exists
			 * ********************** 
			 ************************  */
			
			else{ 
				
				 System.out.println("member exists treat "+memb.getLogin());
				 MemberBk mbk=new MemberBk();
				 
					if(lurl!=null){
						st=new StringTokenizer(lurl,"/");
					 
					 while(st.hasMoreTokens())
						 lurl_name=st.nextToken();
					
					 //check link image
					 if(!localMember.getAvatarUrl().equals(memb.getAvatarUrl())){
						 
						 //go there if the file is not the same
						
						 
						 //save the file
						 String key= getFilebyURL(directory_save,lurl_name,url+lurl);
						 //compare now the 2 keys : display message
						 if(!memb.getKey_avatarUrl().equals(key))
							 System.out.println("failed copy "+url+lurl+" : key is not the same");
						 else
							 mbk.setOkL(true);
						 
						 mbk.setAvatarUrl(lurl);
						 mbk.setKeyAvatar(key);
					 }
					 else{
						 //treat only if we had a bad transfert (file name same but key never had same)
						 //if key != and bool isok 0 we upload  otherwise we add error
						 //maybe error file
						 if(localMember.getKeyAvatar().equals(memb.getKey_avatarUrl()) && !localMember.getOkL()){
							 //save the file
							 String key= getFilebyURL(directory_save,lurl_name,url+lurl);
							 //compare now the 2 keys : display message
							 if(!memb.getKey_avatarUrl().equals(key))
								 System.out.println("failed copy "+url+lurl+" : key is not the same");
							 else
								 mbk.setOkL(true);
							 
							 mbk.setAvatarUrl(lurl);
							 mbk.setKeyAvatar(key);
						 }
						 else{
							 //if we are here, means someone change the key manualy in server
							 System.out.println("error, file "+lurl+" become broken");
						 }
						
					 }
			
					}
					else
						System.out.println(memb.getLogin()+" has no little avatar");			 
		            
					if(burl!=null){
					st=new StringTokenizer(burl,"/");
					 
					 while(st.hasMoreTokens())
						 burl_name=st.nextToken();
					 
					 if(!localMember.getAvatarUrlBig().equals(memb.getAvatarUrlBig())){
						 String key= getFilebyURL(directory_save,burl_name,url+burl);
						 
						 if(!memb.getKey_avatarUrlBig().equals(key))
							 System.out.println("failed copy "+url+burl+" : key is not the same");
						 else
							 mbk.setOkB(true);
						 
						 mbk.setAvatarUrlBig(burl);
						 mbk.setKeyAvatarbig(key);
					 }
					 else {
						 if(localMember.getKeyAvatarbig().equals(memb.getKey_avatarUrlBig()) && !localMember.getOkB()){
							 String key= getFilebyURL(directory_save,burl_name,url+burl);
							 
							 if(!memb.getKey_avatarUrlBig().equals(key))
								 System.out.println("failed copy "+url+burl+" : key is not the same");
							 else
								 mbk.setOkB(true);
							 
							 mbk.setAvatarUrlBig(burl);
							 mbk.setKeyAvatarbig(key);
						 }
						 
					 }
					 
		
					 
					}
					else
						System.out.println(memb.getLogin()+" has no big avatar");	
				
					//save member in new database
					m_bak.save(mbk);
					
					//copie images small des livres
					//copie images big des livres
					//copie livres big des livres
					lb=memb.getBooks_1();
					for(Book book:lb){
						
						
						String lurlbook= book.getLinkImage();
						String burlbook=book.getLinkImageBig();
						String myurlbook=book.getLinkBook();
						BookBk booktreat=b_bak.findBookByid(book.getIdBook());
						if(booktreat!=null){
							
						System.out.println("treat "+memb.getLogin()+" and his book "+book.getIdBook());
						
						String lurlbook_name="";
						String burlbook_name="";
						String myurlbook_name="";
						
						String directoryBook=FOLDER_BOOK_IMAGE+"/"+memb.getLogin()+"/"+book.getIdBook();
						String urlBookImg=WEB+"/"+Application.FOLDER_BOOK_IMAGE_URL+"/";
						String urlBook=WEB+"/"+Application.FOLDER_BOOK_URL+"/";
						
						File directory_book_save  = new File(directoryBook);
						if(! directory_book_save .isDirectory()) {
							directory_book_save .mkdirs();
				       } 
						
						//find existing book
						
						//StringTokenizer st=null;
						if(lurlbook!=null){
							st=new StringTokenizer(lurlbook,"/");
						 
						 while(st.hasMoreTokens())
							 lurlbook_name=st.nextToken();
						
						
							
								//System.out.println(lurlbook_name.replace(" ", "%20"));
							String key=	getFilebyURL(directory_book_save,lurlbook_name,urlBookImg+book.getLinkImage());
							
							 if(!book.getKey_linkBook().equals(key))
								 System.out.println("failed copy "+urlBookImg+book.getLinkImage()+" : key is not the same");
						
						}
						
						else
							System.out.println(memb.getLogin()+" "+book.getTitle()+" has no little image");			 
			            
						if(burlbook!=null){
						st=new StringTokenizer(burlbook,"/");
						 
						 while(st.hasMoreTokens())
							 burlbook_name=st.nextToken();
						 
							
									String key=	getFilebyURL(directory_book_save,lurlbook_name,urlBookImg+book.getLinkImageBig());
									
									 if(!book.getKey_linkImageBig().equals(key))
										 System.out.println("failed copy "+urlBookImg+book.getLinkImageBig()+" : key is not the same");
						
							
						}
						else
							System.out.println(memb.getLogin()+" "+book.getTitle()+" has no big image");		
						
						
						if(myurlbook!=null){
							st=new StringTokenizer(myurlbook,"/");
							 
							 while(st.hasMoreTokens())
								 myurlbook_name=st.nextToken();
							 
								
										String key=	getFilebyURL(directory_book_save,lurlbook_name,urlBook+book.getLinkBook());
										
										 if(!book.getKey_linkBook().equals(key))
											 System.out.println("failed copy "+urlBook+book.getLinkBook()+" : key is not the same");
							
								
							}
							else
								System.out.println(memb.getLogin()+" "+book.getTitle()+" has no big image");
						}//end if booktreat is null (book is here)
						else{
							System.out.println("error book "+book.getIdBook()+" "+book.getTitle()+" exist but not his owner member "+memb.getLogin());
						}
					}//end for books
					 
				
			}

			
		}// end for each member
		
		

		
		
		
		
		s.close();
	}
	
	
public void treatMember(Member m){
	
	
}
	
	
	

public  String getFilebyURL (File directory,String out,String url){

System.out.println("save in "+directory.getName()+"/"+out);
System.out.println("with utl "+url);
      //-----------------------------------------------------//
      //  Step 1:  Start creating a few objects we'll need.
      //-----------------------------------------------------//

  
      BufferedOutputStream dos=null;
      File destination = new File(directory,out);
	
      /*      try {
		try {
			System.out.println("sha1 destination "+new Hasher(Hasher.MD5).hashToString(destination));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}*/


         try {
        	 
             //------------------------------------------------------------//
             // Step 2:  Create the URL.                                   //
             //------------------------------------------------------------//
             // Note: Put your real URL here, or better yet, read it as a  //
             // command-line arg, or read it from a file.                  //
             //------------------------------------------------------------//

        	
    			u = new URL(url);
    		

             //----------------------------------------------//
             // Step 3:  Open an input stream from the url.  //
             //----------------------------------------------//
			is = u.openStream();
		     // throws an IOException

         //-------------------------------------------------------------//
         // Step 4:                                                     //
         //-------------------------------------------------------------//
         // Convert the InputStream to a buffered DataInputStream.      //
         // Buffering the stream makes the reading faster; the          //
         // readLine() method of the DataInputStream makes the reading  //
         // easier.                                                     //
         //-------------------------------------------------------------//

         dis = new DataInputStream(new BufferedInputStream(is));
        // dis.reset();
         /*try {
			System.out.println("sha1 début "+new Hasher(Hasher.MD5).hashToString(dis));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         dis.close();
         dis = new DataInputStream(new BufferedInputStream(is));*/
         //------------------------------------------------------------//
         // Step 5:                                                    //
         //------------------------------------------------------------//
         // Now just read each record of the input stream, and print   //
         // it out.  Note that it's assumed that this problem is run   //
         // from a command-line, not from an application or applet.    //
         //------------------------------------------------------------//

         try {
			dos = new BufferedOutputStream( new FileOutputStream(
			         destination ) );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

           int i;
           try {
			while ((i = dis.read()) != -1)
			   {
			      dos.write( i );
			   }
			String hash=new Hasher().hashToString(destination);
			System.out.println("sha1 destination "+hash);
				return hash;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
	} 
         catch (MalformedURLException e1) {
     		// TODO Auto-generated catch block
     		e1.printStackTrace();
     	}
         catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}    
	
        finally
        {
           if (dis != null)
              try
              {
                 dis.close();
              }
              catch (IOException ioe)
              {
                 ioe.printStackTrace();
              }
           if (dos != null)
              try
              {
            	
                 dos.close();
                 
 				
 				
                
              }
              catch (IOException ioe)
              {
                 ioe.printStackTrace();
              }
        }
     
        return "";
}


         
         
public  String getFilebyURL2 (File directory,String out,String url){
	
	File destination = new File(directory,out);
			System.out.println("get "+out+ " in "+url+ " saved in "+directory.getAbsolutePath());
			String hash="";
			try {
				hash=new Hasher().hashToString(destination);
				System.out.println("sha1 destination "+hash);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return hash;
} 
         


} // end of class definition



	

