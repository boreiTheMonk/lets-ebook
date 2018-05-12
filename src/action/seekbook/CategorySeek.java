package action.seekbook;

import java.util.List;

import model.persistance.Book;
import model.persistance.Category;
import model.service.Book_service;
import model.service.Category_service;
import model.service.Itf_book_service;
import model.service.Itf_category_service;

public class CategorySeek {
	Itf_category_service categoryserv;
	List<Category>listCat;
	private Itf_book_service service_book;
	List<Book> resBooks;
	int nbBooks,id_category,min,max;
	Category category;
	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getNbBooks() {
		return nbBooks;
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


	public void setNbBooks(int nbBooks) {
		this.nbBooks = nbBooks;
	}


	public int getId_category() {
		return id_category;
	}


	public void setId_category(int id_category) {
		this.id_category = id_category;
	}


	public Itf_category_service getCategoryserv() {
		return categoryserv;
	}


	public void setCategoryserv(Itf_category_service categoryserv) {
		this.categoryserv = categoryserv;
	}


	public List<Book> getResBooks() {
		return resBooks;
	}


	public void setResBooks(List<Book> resBooks) {
		this.resBooks = resBooks;
	}


	public CategorySeek() {
		super();
		 categoryserv= new Category_service();
		 service_book=new Book_service();
	}


	public String showListCategories(){
		listCat= categoryserv.getAllCategories();
		
		for(Category c : listCat)
			System.out.println(c.getCategories());
		return "success";
	}

	
	public String showBooks_by_Category(){
		nbBooks=
			service_book.countFindBooksByCategory(id_category);
		//resBooks = service_book.findBooksByCategory(id_category,0,5);
		//System.out.println(resBooks.get(0));
		category= categoryserv.findById(id_category);
		
		//special for 2 categories :Billet d'humeur,Dessins satiriques
		
		return "success";
	}
	
	public String showCategoryPaginateBook(){
		resBooks = service_book.findBooksByCategory(id_category,min,max);
		System.out.println(min +" min"+max + " max ");
		System.out.println(resBooks);
	return "success";	
	}

	public List<Category> getListCat() {
		return listCat;
	}


	public void setListCat(List<Category> listCat) {
		this.listCat = listCat;
	}
	
	
	
}
