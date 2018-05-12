package constant;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import model.service.Category_service;
import model.service.Itf_category_service;

public class Application {

	//use in session check interceptor in order ro save the previous parametter
	public static final String INPUT_PARAMS = "input_params";
	
	
	/*
	public static final String FOLDER_MEMBER_AVATAR = "c:/images/member/";
	public static final String FOLDER_BOOK_IMAGE = "c:/images/book/";
	public static final String FOLDER_TMP_IMAGE ="c:/images/tempimg";
	public static final String FOLDER_BOOK_IMAGE_URL = "imagebook";
	public static final String FOLDER_MEMBER_IMAGE_URL = "avatarmember";
	public static final String FOLDER_TMP_IMAGE_URL ="tempimg";
	public static final String FOLDER_BOOK_URL="book";
	public static final String FOLDER_BOOK = "c:/book/";
	public static final String DEFAULT_AVATAR_SMALL_PATH = "C:/toto/profilesmall.gif";
	public static final String DEFAULT_AVATAR_BIG_PATH = "C:/toto/profilebig.jpg";
	public static final String DEFAULT_IMGBOOK_SMALL_PATH ="C:/toto/livre.png";
	public static final String DEFAULT_IMGBOOK_BIG_PATH = "C:/toto/livre_big.png";
	*/
	
	public static final String FOLDER_MEMBER_AVATAR = "/usr/letsebook/images/member/";
	public static final String FOLDER_BOOK_IMAGE = "/usr/letsebook/images/book/";
	public static final String FOLDER_TMP_IMAGE ="/usr/letsebook/images/tempimg";
	public static final String FOLDER_BOOK_IMAGE_URL = "imagebook";
	public static final String FOLDER_MEMBER_IMAGE_URL = "avatarmember";
	public static final String FOLDER_TMP_IMAGE_URL ="tempimg";
	public static final String FOLDER_BOOK_URL="book";
	public static final String FOLDER_BOOK = "/usr/letsebook/book/";
	public static final String DEFAULT_AVATAR_SMALL_PATH = "/usr/letsebook/defaultImg/profilesmall.gif";
	public static final String DEFAULT_AVATAR_BIG_PATH = "/usr/letsebook/defaultImg/profilebig.jpg";
	public static final String DEFAULT_IMGBOOK_SMALL_PATH ="/usr/letsebook/defaultImg/livre.png";
	public static final String DEFAULT_IMGBOOK_BIG_PATH = "/usr/letsebook/defaultImg/livre_big.png";
	
	
	
	// find a folder book for member FOLDER_BOOK+memb.getLogin()+"/"+b.getIdBook()"
	
	public static final String USER_KEY = "my_member";
	public static final String USER_COOKIE = "member_login";
	public static final String USER_COOKIE_KEY = "member_login_key";
	
	public static final String SESSION_NB_EMAIL_NOT_READ = "nb_email_not_read";
	public static final String SESSION_NB_FRIENDREQ_NOT_READ = "nb_friend_req_not_read";
	public static final String SESSION_DECO = "my_decorator";
	public static final String SESSION_DECO_VALUE_MEMBER = "main_member";
	
	public static final String APPLICATION_CATE = "catList";
	public static final String APPLICATION_THEME = "themeList";
	

	
	public static final String USER_KEY_TEMP = "my_member_temp";
	public static final String SESSION_NB_BOOK = "nb_books";
	public static final String AVATAR_TEMP = "imgtmpinscription";

	
	public final static String ACTION_VERIF_LOGIN ="verifLogin";
	public final static String ACTION_DEFAULT_AFTER_LOGIN ="show_home";
	public final static String ACTION_LOGOUT ="logout";
	
	
	

}
