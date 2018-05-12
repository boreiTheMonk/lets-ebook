package core_lib;


import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.imageio.ImageIO;

import model.dao.Book_dao;
import model.persistance.Book;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BadPdfFormatException;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;

public class Image_op {
	
	public static boolean isPdf(File f){
		try {
			System.out.println(f.getAbsolutePath());
			 new PdfReader(f.getAbsolutePath());
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//save files
	
	public static String GenerateDemoBook(Set<Integer> nbPages,Book b){
		PdfReader reader = null;
		String linkDemoBook="";
		try {
			reader = new PdfReader(constant.Application.FOLDER_BOOK+b.getLinkBook());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document document = new Document(reader.getPageSizeWithRotation(1));
		PdfCopy copy = null;
		try {
			linkDemoBook=b.getMember().getLogin()+"/"+b.getIdBook()+"/"+System.currentTimeMillis()+"demo.pdf";
			copy = new PdfCopy(document,
			new FileOutputStream(constant.Application.FOLDER_BOOK+linkDemoBook));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.open();
		
		try {
			int nb=0;
			
			Iterator<Integer> it=nbPages.iterator();
			int nbpages = reader.getNumberOfPages();
			while(it.hasNext()){
				
				nb = it.next();
				if(nb>nbpages)
					break;
				copy.addPage(copy.getImportedPage(reader, nb));
			}
	
		
		} catch (BadPdfFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();

	
		
		
		return linkDemoBook;
	}

	  public static String  save_file(String directory, String fileName, File file) throws IOException{
		
		File directory_save  = new File(directory);
		if(! directory_save .isDirectory()) {
			directory_save .mkdirs();
       } 
		
		
		String fullFileName = fileName;
		File theFile = new File(directory_save,fullFileName);
		FileUtils.copyFile(file, theFile);
		
		return theFile.getAbsolutePath();
	}
	  
	  public static void save_image(String directory, String pictureName,String compressionType, BufferedImage image) throws IOException{
			
			File directory_save  = new File(directory);
			if(! directory_save .isDirectory()) {
				directory_save .mkdirs();
	       } 
			
			
			//String fullFileName = fileName;
			File theFile = new File(directory_save,pictureName);
			System.out.println(directory_save.getPath()+" "+pictureName);
				ImageIO.write(image, compressionType,theFile);
			
		}  

	// crop image

	//resize image

	public final static String IMAGE_TYPE_JPEG = "jpeg";

	public final static String IMAGE_TYPE_GIF = "gif";

	public final static String IMAGE_TYPE_PNG = "png";
	
	public final static String MIME_JPEG_IE = "image/pjpeg";

	public final static String MIME_GIF = "image/gif";

	public final static String MIME_PNG_IE = "image/x-png";
	
	public final static String MIME_JPEG = "image/jpeg";

	public final static String MIME_PNG = "image/png";
	
	public final static String[] MIME = {"image/png","image/jpeg","image/x-png","image/gif","image/pjpeg"};

	public static BufferedImage resize(BufferedImage img,
			Dimension finalDimension, String pictureName,
			String compressionType) {
		BufferedImage buf = null; // Notre capture d'écran originale
		BufferedImage bufFinal = null; // Notre capture d'écran redimensionnée


		// Création de la capture finale
		bufFinal = new BufferedImage(finalDimension.width,
				finalDimension.height, BufferedImage.TYPE_INT_RGB);
		// Redimensionnement de la capture originale
		Graphics2D g = (Graphics2D) bufFinal.getGraphics();
		/* g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_BILINEAR);*/
		g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
				RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g.drawImage(img, 0, 0, finalDimension.width,
				finalDimension.height, null);
		g.dispose();

		// Ecriture de notre capture d'écran redimensionnée
		/*try {
			ImageIO.write(bufFinal, compressionType, new File(pictureName));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return bufFinal;
	}

	public static void main(String[] args) {
	/*	File f=new File("C:/toto/profil.png");

		BufferedImage image=null;
		try {
			image = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image_op.resize(image,
				new Dimension(80, 80), "C:/toto/test.png",
				Image_op.IMAGE_TYPE_PNG);*/
		
Session s= HibernateSessionFactory.getNewSession();
		
		// TODO Auto-generated constructor stub
		//populate categories
		Book_dao b= new Book_dao();
		Book bk = b.findBookByid(361);
		Set<Integer> set=new TreeSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(4);
		set.add(13);
		System.out.println(GenerateDemoBook(set, bk));
	}
}
