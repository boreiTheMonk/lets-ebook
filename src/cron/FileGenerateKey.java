package cron;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import sun.security.action.GetLongAction;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

import constant.Application;

import core_lib.Hasher;

public class FileGenerateKey {

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
		keyBook(s);
		s.close();
		
	}
	
	public static void keyMember(Session s){
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

	
						//rename files
						//Obtain the reference of the existing file
						File oldFile = new File(Application.FOLDER_MEMBER_AVATAR+memb.getAvatarUrl()); 
						
						//Now generate Key
						if(oldFile.exists())
							try {
								System.out.println("sha1 destination "+new Hasher().hashToString(oldFile));
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						else
							System.out.println(Application.FOLDER_MEMBER_AVATAR+memb.getAvatarUrl()+" not exists");
						
						System.out.println(oldFile.exists());
					
				
			}
			
			if(bimg!=null){
				st=new StringTokenizer(limg,"/");

				
				//rename files
				//Obtain the reference of the existing file
				File oldFile = new File(Application.FOLDER_MEMBER_AVATAR+memb.getAvatarUrlBig()); 
				
				//Now generate Key
				if(oldFile.exists())
					try {
						System.out.println("sha1 destination "+new Hasher().hashToString(oldFile));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				else
					System.out.println(Application.FOLDER_MEMBER_AVATAR+memb.getAvatarUrl()+" not exists");
				
				System.out.println(oldFile.exists());
			}
			
		}//end for each member
	}
	
	public static void keyBook(Session s){
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
		
	
	
		if(limg!=null){
			

			
			//rename files
			//Obtain the reference of the existing file
			File oldFile = new File(Application.FOLDER_BOOK_IMAGE+b.getLinkImage()); 
			
			//Now generate Key
			if(oldFile.exists())
				try {
					System.out.println("sha1 destination "+new Hasher().hashToString(oldFile));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				System.out.println(Application.FOLDER_MEMBER_AVATAR+b.getLinkImage()+" not exists");
			
			System.out.println(oldFile.exists());
		}
		
		if(bimg!=null){
			//rename files
			//Obtain the reference of the existing file
			File oldFile = new File(Application.FOLDER_BOOK_IMAGE+b.getLinkImageBig()); 
			
			//Now generate Key
			if(oldFile.exists())
				try {
					System.out.println("sha1 destination "+new Hasher().hashToString(oldFile));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				System.out.println(Application.FOLDER_BOOK_IMAGE+b.getLinkImageBig()+" not exists");
			
			System.out.println(oldFile.exists());
			
		}
		
		if(link_book!=null){
			//rename files
			//Obtain the reference of the existing file
			File oldFile = new File(Application.FOLDER_BOOK+b.getLinkBook()); 
			
			//Now generate Key
			if(oldFile.exists())
				try {
					System.out.println("sha1 destination "+new Hasher().hashToString(oldFile));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				System.out.println(Application.FOLDER_BOOK+b.getLinkBook()+" not exists");
			
			System.out.println(oldFile.exists());
			
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
	}

