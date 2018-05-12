package action.payment;

import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.persistance.Member;
import model.persistance.OrderBook;
import model.service.Book_service;
import model.service.Itf_book_service;
import model.service.Itf_member_service;
import model.service.Itf_orderCustomer_service;
import model.service.Itf_order_book_service;
import model.service.Member_service;
import model.service.OrderBook_service;
import model.service.OrderCustomer_service;

import org.apache.struts2.dispatcher.StreamResult;
import org.apache.struts2.interceptor.SessionAware;

import constant.Application;
import core_lib.Date_utils;

public class SellEbook implements SessionAware {
	public static final int CURRENT_WEEK=3;
	public static final int YESTERDAY=2;
	public static final int LAST_WEEK=4;
	public static final int LAST_MONTH=1;
	public static final int TOTAL=5;
	public static final int PERIOD=6;
	
	private Map<String, Object> my_session;
	private Itf_book_service service_book;
	private Itf_member_service service_member;
	private Itf_orderCustomer_service service_order_customer;
	private Itf_order_book_service service_order_book;
	private Date start_period;
	private Date end_period;
	private int option_choice;
	List<OrderBook> orderbooks;
	private Date start;
	private Date end;
	private double total_paid;
	private double total_due;
	
	
	
	
   public double getTotal_paid() {
		return total_paid;
	}

	public void setTotal_paid(double total_paid) {
		this.total_paid = total_paid;
	}

	public double getTotal_due() {
		return total_due;
	}

	public void setTotal_due(int total_due) {
		this.total_due = total_due;
	}

public List<OrderBook> getOrderbooks() {
		return orderbooks;
	}

	public void setOrderbooks(List<OrderBook> orderbooks) {
		this.orderbooks = orderbooks;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

public SellEbook() {
		super();
		service_book=new Book_service();
		service_member=new Member_service();
		service_order_customer=new OrderCustomer_service();
		service_order_book=new OrderBook_service();
		// TODO Auto-generated constructor stub
	}

public Date getStart_period() {
		return start_period;
	}

	public void setStart_period(Date start_period) {
		this.start_period = start_period;
	}

	public Date getEnd_period() {
		return end_period;
	}

	public void setEnd_period(Date end_period) {
		this.end_period = end_period;
	}

	public int getOption_choice() {
		return option_choice;
	}

	public void setOption_choice(int option_choice) {
		this.option_choice = option_choice;
	}

public String showSales(){
	   //find all sales in this month
	 Member me=(Member) my_session.get(Application.USER_KEY);
		total_paid = service_order_book.showPaidOrder(me);
		total_due=service_order_book.showDueOrder(me);
		//nbBook_sell=serv
		//CA total
		//ca period
	   
	   return "success";
   } 
   
   public String showPeriodSales(){
	   boolean res = false;
	   Member me=(Member) my_session.get(Application.USER_KEY);
	   Date_utils date_utils= new Date_utils("yyyy-MM-dd");
	   Calendar c = Calendar.getInstance();
	   c.setTime(new Date());
	   Date[] inter=null;
	   switch(option_choice){
	   case  CURRENT_WEEK:
		   inter=date_utils.getWeekInterval(c);
		   orderbooks= service_order_book.showOrderBydate(me, inter[0], inter[1]);
		   return "success";
	   case  YESTERDAY:
		   Date yest=date_utils.getYesterday(c);
		   orderbooks= service_order_book.showOrderBydate(me, yest, yest);
		   return "success";   
	   case  LAST_WEEK:
		   inter=date_utils.getLastWeekInterval(c);
		   orderbooks= service_order_book.showOrderBydate(me, inter[0], inter[1]);
		   return "success";
	   case  LAST_MONTH:
		   inter=date_utils.getMonthInterval(c);
		   orderbooks= service_order_book.showOrderBydate(me, inter[0], inter[1]);
		   return "success";
	   case  TOTAL:
		   orderbooks= service_order_book.showOrderBydate(me,null, null);
		   return "success";
	   case  PERIOD:   
		   orderbooks= service_order_book.showOrderBydate(me,start, end);
		   return "success";
	   
	   default:
		   return "error";
	   }
	   
	   //return new StreamResult(new ByteArrayInputStream(Boolean.valueOf(res).toString().getBytes()));
   }

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		my_session=arg0;
	}
}
