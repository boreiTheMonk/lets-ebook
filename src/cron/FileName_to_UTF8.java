package cron;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import model.dao.Book_dao;
import model.dao.Member_dao;
import model.persistance.Book;
import model.persistance.Member;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sun.security.action.GetLongAction;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

import constant.Application;

import core_lib.Hasher;

public class FileName_to_UTF8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
  /*File f = new File("c:/backup/images/member/cc/profilesmall.gif");
 
		try {
			System.out.println("sha1 destination "+new Hasher().hashToString(f));
			try {
				test("c:/backup/images/book/borei/22/cover.png");
				test("c:/images/book/borei/22/cover.png");
				test("c:/images/member/cc/profilesmall.gif");
				test("c:/images/member/cc/profilebig.jpg");
				test("c:/backup/images/member/cc/profilesmall.gif");
				test("c:/backup/images/member/cc/profilebig.jpg");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(f.getName());
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
		
		HibernateSessionFactory.setConfigFiles("/hibernate.cfg.xml");
		Session s= HibernateSessionFactory.getNewSession();
		//renameMember(s);
		Transaction t=s.beginTransaction();
		renameBook(s);
		t.commit();
		s.close();
		
	}
	
	public static void renameMember(Session s){
		Member_dao mdao = new Member_dao();
		mdao.setSession(s);
		List<Member> lm=mdao.getMembers(0, -1, null);
		
		for (Member memb:lm){
			String limg=memb.getAvatarUrl();
			// login/id/namefile
			String bimg=memb.getAvatarUrlBig();
			StringTokenizer st=null;
			
			if(limg!=null){
				st=new StringTokenizer(limg,"/");
				try{
					
					List<String> part=new ArrayList<String>();
					while(st.hasMoreTokens())
						part.add(st.nextToken());
				 
			
				 
					 try {
						 //enc and replace the last part
						 String change= URLEncoder.encode(part.get(part.size()-1), "UTF-8");
							part.remove(part.size()-1);
							part.add(change  );
						
						//b.setLinkImage(p1+"/"+p2+"/"+p3);
						
						//System.out.println("change "+ b.getLinkImage());
						String res="";
						for(int i=0;i<part.size();i++){
							res = res+part.get(i);
							if(i!=part.size()-1)
								res +="/";
						}
						
						//rename files
						//Obtain the reference of the existing file
						File oldFile = new File(Application.FOLDER_MEMBER_AVATAR+memb.getAvatarUrl()); 
						memb.setAvatarUrl(res);
						//Now invoke the renameTo() method on the reference, oldFile in this case
						if(oldFile.exists())
							oldFile.renameTo(new File(Application.FOLDER_MEMBER_AVATAR+res));
						System.out.println("size "+part.size()+" change "+ res+" "+oldFile.exists());
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				catch (NoSuchElementException e) {
					e.printStackTrace();
				}
				
			}
			
			if(bimg!=null){
				st=new StringTokenizer(bimg,"/");
				try{
					
					List<String> part=new ArrayList<String>();
					while(st.hasMoreTokens())
						part.add(st.nextToken());
				 
			
				 
					 try {
						 //enc and replace the last part
						 String change= URLEncoder.encode(part.get(part.size()-1), "UTF-8");
							part.remove(part.size()-1);
							part.add(change  );
						
						//b.setLinkImage(p1+"/"+p2+"/"+p3);
						
						//System.out.println("change "+ b.getLinkImage());
						String res="";
						for(int i=0;i<part.size();i++){
							res = res+part.get(i);
							if(i!=part.size()-1)
								res +="/";
						}
						
						//rename files
						//Obtain the reference of the existing file
						File oldFile = new File(Application.FOLDER_MEMBER_AVATAR+memb.getAvatarUrlBig()); 
						memb.setAvatarUrlBig(res);
						//Now invoke the renameTo() method on the reference, oldFile in this case
						System.out.println("before size "+part.size()+" change "+ res+" "+oldFile.exists());
						if(oldFile.exists())
							oldFile.renameTo(new File(Application.FOLDER_MEMBER_AVATAR+res));
						System.out.println("after size "+part.size()+" change "+ res+" "+oldFile.exists());
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				catch (NoSuchElementException e) {
					e.printStackTrace();
				}
				
			}
			
		}//end for each member
	}
	
	public static void renameBook(Session s){
		Book_dao bdao = new Book_dao();
		bdao.setSession(s);
		
		List<Book> lb=bdao.getBooks(0, -1, null);
		
		for(Book b:lb){
			//rename image small, big
			//rename book also with url encoder
			
		String limg=b.getLinkImage();
		// login/id/namefile
		String bimg=b.getLinkImageBig();
		// style login/id/namefile
		String link_book=b.getLinkBook();	
		
		StringTokenizer st=null;
		String p1=null;
		String p2=null;
		String p3=null;
		if(limg!=null){
			st=new StringTokenizer(limg,"/");
			try{
				
				List<String> part=new ArrayList<String>();
				while(st.hasMoreTokens())
					part.add(st.nextToken());
			 
		
			 
				 try {
					 //enc and replace the last part
					 String change= URLEncoder.encode(part.get(part.size()-1), "UTF-8");
						part.remove(part.size()-1);
						part.add(change  );
					
					//b.setLinkImage(p1+"/"+p2+"/"+p3);
					
					//System.out.println("change "+ b.getLinkImage());
					String res="";
					for(int i=0;i<part.size();i++){
						res = res+part.get(i);
						if(i!=part.size()-1)
							res +="/";
					}
					
					//rename files
					//Obtain the reference of the existing file
					File oldFile = new File(Application.FOLDER_BOOK_IMAGE+b.getLinkImage()); 
					//System.out.println(b.getLinkImage());
					b.setLinkImage(res);
					//Now invoke the renameTo() method on the reference, oldFile in this case
					if(oldFile.exists())
						oldFile.renameTo(new File(Application.FOLDER_BOOK_IMAGE+res));
					System.out.println("size "+part.size()+" change "+ res+" "+" open "+oldFile.getAbsolutePath()+oldFile.exists());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			
		}
		
		if(bimg!=null){
			st=new StringTokenizer(bimg,"/");
			try{
				
				List<String> part=new ArrayList<String>();
				while(st.hasMoreTokens())
					part.add(st.nextToken());
			 
		
			 
				 try {
					 //enc and replace the last part
					 //System.out.println(part+" "+part.size());
					String change= URLEncoder.encode(part.get(part.size()-1), "UTF-8");
					part.remove(part.size()-1);
					part.add(change  );
					 //System.out.println(part+" "+part.size());
					//b.setLinkImage(p1+"/"+p2+"/"+p3);
					
					
					
					
					
					//System.out.println("change "+ b.getLinkImage());
					String res="";
					for(int i=0;i<part.size();i++){
						res = res+part.get(i);
						if(i!=part.size()-1)
							res +="/";
					}
					
					//rename files
					//Obtain the reference of the existing file
					File oldFile = new File(Application.FOLDER_BOOK_IMAGE+b.getLinkImageBig()); 
					b.setLinkImageBig(res);
					//Now invoke the renameTo() method on the reference, oldFile in this case
					if(oldFile.exists())
						oldFile.renameTo(new File(Application.FOLDER_BOOK_IMAGE+res));
					
					
					System.out.println("size "+part.size()+" change "+ res+" "+oldFile.exists());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			
		}
		
		if(link_book!=null){
			st=new StringTokenizer(link_book,"/");
			try{
				
				List<String> part=new ArrayList<String>();
				while(st.hasMoreTokens())
					part.add(st.nextToken());
			 
		
			 
				 try {
					 //enc and replace the last part
					 String change= URLEncoder.encode(part.get(part.size()-1), "UTF-8");
						part.remove(part.size()-1);
						part.add(change  );
					
					//b.setLinkImage(p1+"/"+p2+"/"+p3);
					
					//System.out.println("change "+ b.getLinkImage());
					String res="";
					for(int i=0;i<part.size();i++){
						res = res+part.get(i);
						if(i!=part.size()-1)
							res +="/";
					}
					
					//rename files
					//Obtain the reference of the existing file
					File oldFile = new File(Application.FOLDER_BOOK+b.getLinkBook()); 
					b.setLinkBook(res);
					//Now invoke the renameTo() method on the reference, oldFile in this case
					if(oldFile.exists())
						oldFile.renameTo(new File(Application.FOLDER_BOOK_IMAGE+res));
					
					
					System.out.println("size "+part.size()+" change "+ res+" "+oldFile.exists());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			
		}
		
	}//end for all books
		
	}
	
	
	
	public static void renameBookbackup(Session s){
		Book_dao bdao = new Book_dao();
		bdao.setSession(s);
		
		List<Book> lb=bdao.getBooks(0, -1, null);
		
		for(Book b:lb){
			//rename image small, big
			//rename book also with url encoder
			
		String limg=b.getLinkImage();
		// login/id/namefile
		String bimg=b.getLinkImageBig();
		// style login/id/namefile
		String link_book=b.getLinkBook();	
		
		StringTokenizer st=null;
		String p1=null;
		String p2=null;
		String p3=null;
		if(limg!=null){
			st=new StringTokenizer(limg,"/");
			try{
				
				List<String> part=new ArrayList<String>();
				while(st.hasMoreTokens())
					part.add(st.nextToken());
			 
		
			 
				 try {
					 //enc and replace the last part
					 String change= URLDecoder.decode(part.get(part.size()-1), "UTF-8");
						part.remove(part.size()-1);
						part.add(change  );
					
					
					
					//System.out.println("change "+ b.getLinkImage());
					String res="";
					for(int i=0;i<part.size();i++){
						res = res+part.get(i);
						if(i!=part.size()-1)
							res +="/";
					}
					
					//rename files
					//Obtain the reference of the existing file
					File oldFile = new File(Application.FOLDER_BOOK_IMAGE+b.getLinkImage()); 
					b.setLinkImage(res);
					//Now invoke the renameTo() method on the reference, oldFile in this case
					if(oldFile.exists())
						oldFile.renameTo(new File(Application.FOLDER_BOOK_IMAGE+res));
					System.out.println("size "+part.size()+" change "+ res+" "+" open "+oldFile.getAbsolutePath()+oldFile.exists());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			
		}
		
		if(bimg!=null){
			st=new StringTokenizer(bimg,"/");
			try{
				
				List<String> part=new ArrayList<String>();
				while(st.hasMoreTokens())
					part.add(st.nextToken());
			 
		
			 
				 try {
					 //enc and replace the last part
					 //System.out.println(part+" "+part.size());
					String change= URLDecoder.decode(part.get(part.size()-1), "UTF-8");
					part.remove(part.size()-1);
					part.add(change  );
					 //System.out.println(part+" "+part.size());
					//b.setLinkImage(p1+"/"+p2+"/"+p3);
					
					
					
					
					
					//System.out.println("change "+ b.getLinkImage());
					String res="";
					for(int i=0;i<part.size();i++){
						res = res+part.get(i);
						if(i!=part.size()-1)
							res +="/";
					}
					
					//rename files
					//Obtain the reference of the existing file
					File oldFile = new File(Application.FOLDER_BOOK_IMAGE+b.getLinkImageBig()); 
					b.setLinkImageBig(res);
					//Now invoke the renameTo() method on the reference, oldFile in this case
					if(oldFile.exists())
						oldFile.renameTo(new File(Application.FOLDER_BOOK_IMAGE+res));
					
					System.out.println("size "+part.size()+" change "+ res+" "+oldFile.exists());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			
		}
		
		if(link_book!=null){
			st=new StringTokenizer(link_book,"/");
			try{
				
				List<String> part=new ArrayList<String>();
				while(st.hasMoreTokens())
					part.add(st.nextToken());
			 
		
			 
				 try {
					 //enc and replace the last part
					 String change= URLDecoder.decode(part.get(part.size()-1), "UTF-8");
						part.remove(part.size()-1);
						part.add(change  );
					
					//b.setLinkImage(p1+"/"+p2+"/"+p3);
					
					//System.out.println("change "+ b.getLinkImage());
					String res="";
					for(int i=0;i<part.size();i++){
						res = res+part.get(i);
						if(i!=part.size()-1)
							res +="/";
					}
					
					//rename files
					//Obtain the reference of the existing file
					File oldFile = new File(Application.FOLDER_BOOK+b.getLinkBook()); 
					b.setLinkBook(res);
					//Now invoke the renameTo() method on the reference, oldFile in this case
					if(oldFile.exists())
						oldFile.renameTo(new File(Application.FOLDER_BOOK_IMAGE+res));
					
					System.out.println("size "+part.size()+" change "+ res+" "+oldFile.exists());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			
		}
		
	}//end for all books
		
	}
	
	
	public static void test(String txt) throws Exception{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
	    FileInputStream fis = new FileInputStream(txt);

	    byte[] dataBytes = new byte[1024];

	    int nread = 0; 
	    while ((nread = fis.read(dataBytes)) != -1) {
	      md.update(dataBytes, 0, nread);
	    };
	    byte[] mdbytes = md.digest();

	    //convert the byte to hex format method 1
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < mdbytes.length; i++) {
	      sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	    }

	    System.out.println("Hex format : " + sb.toString());

	   //convert the byte to hex format method 2
	    StringBuffer hexString = new StringBuffer();
		for (int i=0;i<mdbytes.length;i++) {
		  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
		}

		System.out.println("Hex format : " + hexString.toString());
	}
	
	public static void renameMemberbackup(Session s){
		Member_dao mdao = new Member_dao();
		mdao.setSession(s);
		List<Member> lm=mdao.getMembers(0, -1, null);
		
		for (Member memb:lm){
			String limg=memb.getAvatarUrl();
			// login/id/namefile
			String bimg=memb.getAvatarUrlBig();
			StringTokenizer st=null;
			
			if(limg!=null){
				st=new StringTokenizer(limg,"/");
				try{
					
					List<String> part=new ArrayList<String>();
					while(st.hasMoreTokens())
						part.add(st.nextToken());
				 
			
				 
					 try {
						 //enc and replace the last part
						 String change= URLDecoder.decode(part.get(part.size()-1), "UTF-8");
							part.remove(part.size()-1);
							part.add(change  );
						
						//b.setLinkImage(p1+"/"+p2+"/"+p3);
						
						//System.out.println("change "+ b.getLinkImage());
						String res="";
						for(int i=0;i<part.size();i++){
							res = res+part.get(i);
							if(i!=part.size()-1)
								res +="/";
						}
						
						//rename files
						//Obtain the reference of the existing file
						File oldFile = new File(Application.FOLDER_MEMBER_AVATAR+memb.getAvatarUrl()); 
						memb.setAvatarUrl(res);
						//Now invoke the renameTo() method on the reference, oldFile in this case
						if(oldFile.exists())
							oldFile.renameTo(new File(Application.FOLDER_MEMBER_AVATAR+res));
						System.out.println("size "+part.size()+" change "+ res+" "+oldFile.exists());
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				catch (NoSuchElementException e) {
					e.printStackTrace();
				}
				
			}
			
			if(bimg!=null){
				st=new StringTokenizer(bimg,"/");
				try{
					
					List<String> part=new ArrayList<String>();
					while(st.hasMoreTokens())
						part.add(st.nextToken());
				 
			
				 
					 try {
						 //enc and replace the last part
						 String change= URLDecoder.decode(part.get(part.size()-1), "UTF-8");
							part.remove(part.size()-1);
							part.add(change  );
						
						//b.setLinkImage(p1+"/"+p2+"/"+p3);
						
						//System.out.println("change "+ b.getLinkImage());
						String res="";
						for(int i=0;i<part.size();i++){
							res = res+part.get(i);
							if(i!=part.size()-1)
								res +="/";
						}
						
						//rename files
						//Obtain the reference of the existing file
						File oldFile = new File(Application.FOLDER_MEMBER_AVATAR+memb.getAvatarUrlBig()); 
						memb.setAvatarUrlBig(res);
						//Now invoke the renameTo() method on the reference, oldFile in this case
						if(oldFile.exists())
							oldFile.renameTo(new File(Application.FOLDER_MEMBER_AVATAR+res));
						System.out.println("size "+part.size()+" change "+ res+" "+oldFile.exists());
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				catch (NoSuchElementException e) {
					e.printStackTrace();
				}
				
			}
			
		}//end for each member
	}
	
	
	}

