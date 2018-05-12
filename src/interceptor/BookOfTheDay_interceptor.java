package interceptor;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletContext;

import model.dao.Book_dao;
import model.dao.Category_dao;
import model.dao.Theme_dao;
import model.persistance.Book;
import model.service.Category_service;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import constant.Application;

public class BookOfTheDay_interceptor extends AbstractInterceptor{


	public String intercept(ActionInvocation invocation) throws Exception {
		//application scope
		ServletContext appli = ServletActionContext.getServletContext();
		
		Category_dao categoryserv= new Category_dao();
		Session s= HibernateSessionFactory.getNewSession();
		categoryserv.setSession(s);
		

		appli.setAttribute(constant.Application.APPLICATION_CATE,categoryserv.getAllCategories() );
		
		Theme_dao themedao = new Theme_dao();
		themedao.setSession(s);
		
		appli.setAttribute(constant.Application.APPLICATION_THEME,themedao.getAllThemes() );
		
		
		HibernateSessionFactory.closeSession(s);
		//System.out.println("interceptor "+appli.getAttribute("catList"));
		
		
		GregorianCalendar time= (GregorianCalendar) appli.getAttribute("beforeDate");
		if (time == null){
			//set the current day without hours
			time =new GregorianCalendar();
			time.set(time.get(GregorianCalendar.YEAR), time.get(GregorianCalendar.MONTH), time.get(GregorianCalendar.DAY_OF_MONTH),0,0);
			//System.out.println("time" + time.getTime().toString());
			appli.setAttribute("beforeDate",time );
			//we update the book of the day
			update_bookoftheday(appli);
		}
		else{
			GregorianCalendar time2= new GregorianCalendar(time.getTimeZone());
			time2.add(Calendar.DATE,+1);
			if(new GregorianCalendar().after(time2)){
				// new day we update the book of the day
				update_bookoftheday(appli);
		}
		

		
		}
		return invocation.invoke();
	}
	
		
		
		private void update_bookoftheday(ServletContext appli){
			//System.out.println("go to update_bookoftheday");
			Session s= HibernateSessionFactory.getNewSession();
			Book_dao bookserv= new Book_dao();
			bookserv.setSession(s);
			Book b =bookserv.findBookOfTheDay();
			
			HibernateSessionFactory.closeSession(s);
			if ( b !=null){
			appli.setAttribute("bookoftheday", b);
			appli.setAttribute("bookofthedaylink", Application.FOLDER_BOOK_IMAGE_URL+"/"+b.getLinkImage());
			}
			else{
				b=new Book();
				b.setTitle("pas de book");
				appli.setAttribute("bookoftheday", b);
				appli.setAttribute("bookofthedaylink", "");
			}
			}

	
  
}